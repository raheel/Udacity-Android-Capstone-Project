package com.datarak.vehiclemaintenancereminder.job;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.VehicleDao;
import com.datarak.vehiclemaintenancereminder.model.MaintenanceItem;
import com.datarak.vehiclemaintenancereminder.views.MainActivity;
import com.evernote.android.job.Job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by raheel on 5/23/16.
 */
public class MaintenanceJob extends Job{
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static final String TAG = "maintenance_job_tag";

    @Inject
    VehicleDao vehicleDao;

    public MaintenanceJob() {
        MaintenanceApp.getInstance().getComponent().inject(this);
    }

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        String date = DATE_FORMAT.format(new Date());

        List<MaintenanceItem> list = vehicleDao.getAllMaintenance(date);

        String text = "";
        for (int i=0; i<list.size(); i++){
            text += list.get(i).displayableAction();
            if (i!=list.size()-1){
                text += ", ";
            }
        }

        if (list.size()==0) {
            showNotification(text);
        }

        return Result.SUCCESS;
    }

    private void showNotification(String text){
        Context context = MaintenanceApp.getInstance().getApplicationContext();
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

        Notification n  = new NotificationCompat.Builder(context)
                .setContentTitle(context.getString(R.string.app_name))
                .setTicker(context.getString(R.string.app_name)).setWhen(0)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                .setContentText(text)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build();


        NotificationManager notificationManager =
                (NotificationManager) ((Context) context).getSystemService(context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);

    }
}
