package com.datarak.vehiclemaintenancereminder.presenter;

import android.database.Cursor;
import android.net.Uri;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;
import com.datarak.vehiclemaintenancereminder.model.ActionHolder;
import com.datarak.vehiclemaintenancereminder.model.Maintenance;
import com.datarak.vehiclemaintenancereminder.provider.MaintenanceProvider;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemColumns;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemContentValues;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemSelection;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleCursor;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleSelection;
import com.datarak.vehiclemaintenancereminder.scheduler.AndroidScheduler;
import com.datarak.vehiclemaintenancereminder.views.ShowMaintenanceScheduleView;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by raheel on 5/19/16.
 */
public class ShowMaintenanceSchedulePresenter {
    private ShowMaintenanceScheduleView view;
    final EdmundsApiService apiService;
    final AndroidScheduler scheduler;

    @Inject
    public ShowMaintenanceSchedulePresenter(EdmundsApiService apiService, AndroidScheduler scheduler) {
        this.apiService = apiService;
        this.scheduler = scheduler;
    }

    public void bindView(ShowMaintenanceScheduleView view){
        this.view = view;
    }

    public void unbind(){
        this.view = null;
    }

    public void showSchedule(final long vehicleId, final int currentMileage, final long monthlyMileage){
        MaintenanceItemSelection selection = new MaintenanceItemSelection();
        Cursor cursor = selection.query(MaintenanceApp.getInstance().getContentResolver());

        if (cursor!=null && cursor.getCount() >0){
            view.displayItems();
            return;
        }

        VehicleSelection vehicleSelection = new VehicleSelection();
        final VehicleCursor vehicleCursor = vehicleSelection.query(MaintenanceApp.getInstance().getContentResolver());

        if (!vehicleCursor.moveToNext()){
            view.noVehicles();
        }

        apiService.getVehicleMaintenance(vehicleCursor.getVehicleId())
            .subscribeOn(scheduler.getNewThread())
            .observeOn(scheduler.getNewThread())
            .subscribe(new Subscriber<Maintenance>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                                                            e.printStackTrace();
                }

                @Override
                public void onNext(Maintenance maintenance) {
                    for (ActionHolder actionHolder : maintenance.getActionHolder()) {
                                                //if an item is repeat, then add one record for every occurrence
                        if (actionHolder.isRepeat()){
                            int interval = actionHolder.getIntervalMileage();
                            if (interval <= 1000){
                                interval = 10000;
                            }
                            for (int miles = interval; miles < 300000; miles = miles + interval){
                                int milesRemaining = miles - currentMileage;
                                if (milesRemaining > 0){
                                    int days =  (int)(milesRemaining / (monthlyMileage/30));
                                    actionHolder.setMaintenanceDate(addDays(days));
                                    actionHolder.setIntervalMileage(miles);

                                    Uri uri = MaintenanceApp.getInstance().getContentResolver().insert(MaintenanceItemColumns.CONTENT_URI, actionHolder.getMaintenanceItemContentValues(vehicleCursor.getId()));
                                }
                            }
                        }
                        else {
                            long mileage = actionHolder.getIntervalMileage();
                            if (mileage > currentMileage){
                                long milesRemaining = mileage - currentMileage;
                                int days =  (int)(milesRemaining / (monthlyMileage/30));
                                actionHolder.setMaintenanceDate(addDays(days));
                                Uri uri = MaintenanceApp.getInstance().getContentResolver().insert(MaintenanceItemColumns.CONTENT_URI, actionHolder.getMaintenanceItemContentValues(vehicleCursor.getId()));
                            }
                        }
                    }
                    view.displayItems();

                }
            });
        }


    public void scheduleItem(long id, boolean on){
        MaintenanceItemContentValues contentValues = new MaintenanceItemContentValues();
        contentValues.putIsScheduled(on);

        MaintenanceApp.getInstance().getContentResolver().update(MaintenanceItemColumns.CONTENT_URI,
                contentValues.values(),
                MaintenanceItemColumns._ID + "=?",new String[] {String.valueOf(id)});
    }


    private static Date addDays(int numberOfDays){
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, numberOfDays);
            return c.getTime();
    }

    public void checkStatus() {
        VehicleCursor cursor = new VehicleSelection().query(MaintenanceApp.getInstance().getContentResolver());
        if (cursor==null || cursor.getCount()==0){
            view.noVehicles();
        }
    }
}
