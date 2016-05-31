package com.datarak.vehiclemaintenancereminder.job;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemCursor;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemSelection;
import com.datarak.vehiclemaintenancereminder.views.MainActivity;
import com.evernote.android.job.Job;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by raheel on 5/23/16.
 */
public class MaintenanceJob extends Job{
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static final String TAG = "maintenance_job_tag";


    public MaintenanceJob() {
        MaintenanceApp.getInstance().getComponent().inject(this);
    }

    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        MaintenanceItemSelection selection = new MaintenanceItemSelection();

        selection.isScheduled(Boolean.TRUE);
        selection.and();
        selection.maintenanceDateAfterEq(getDate(new Date()));
        selection.and();
        selection.maintenanceDateBefore(getDate(DateUtils.addDays(new Date(), 1)));

        MaintenanceItemCursor cursor = selection.query(getContext().getContentResolver());

        int size = cursor.getCount();
        int i = 0;
        String text = "";
        while(cursor.moveToNext()){
            text += cursor.getDisplayableAction();
            if (i!=size-1){
                text += ", ";
            }
            i++;
        }

        if (size!=0) {
            showNotification(text);
        }

        cursor.close();

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

    private static Date getDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        new Date();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
