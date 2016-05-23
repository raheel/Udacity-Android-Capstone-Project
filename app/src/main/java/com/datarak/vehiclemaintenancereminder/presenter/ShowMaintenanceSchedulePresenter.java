package com.datarak.vehiclemaintenancereminder.presenter;

import com.datarak.vehiclemaintenancereminder.VehicleDao;
import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;
import com.datarak.vehiclemaintenancereminder.model.ActionHolder;
import com.datarak.vehiclemaintenancereminder.model.Maintenance;
import com.datarak.vehiclemaintenancereminder.model.MaintenanceItem;
import com.datarak.vehiclemaintenancereminder.model.Makes;
import com.datarak.vehiclemaintenancereminder.scheduler.AndroidScheduler;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleView;
import com.datarak.vehiclemaintenancereminder.views.ShowMaintenanceScheduleView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    VehicleDao vehicleDao;

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

    public void showSchedule(long vehicleId, final int currentMileage, final long monthlyMileage){
        List<MaintenanceItem> items = vehicleDao.getAllMaintenance();

        if (!items.isEmpty()) {
            view.displayItems(items);
            return;
        }

        apiService.getVehicleMaintenance(vehicleId)
            .subscribeOn(scheduler.getNewThread())
            .observeOn(scheduler.getMainThread())
            .subscribe(new Subscriber<Maintenance>() {
                @Override
                public void onCompleted() {
                    System.out.println("ShowMaintenanceScheduleFragment.onCompleted");
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println("ShowMaintenanceScheduleFragment.onError");
                }

                @Override
                public void onNext(Maintenance maintenance) {
                    vehicleDao.getAllMaintenance();
                    System.out.println("1234___ShowMaintenanceScheduleFragment.onNext " + maintenance);
                    for (ActionHolder actionHolder : maintenance.getActionHolder()) {
                        //if an item is repeat, then add one record for every occurrence
                        if (actionHolder.isRepeat()){
                            long interval = actionHolder.getIntervalMileage();
                            for (long miles = interval; miles < 300000; miles = miles + interval){
                                long milesRemaining = miles - currentMileage;
                                if (milesRemaining > 0){
                                    int days =  (int)(milesRemaining / (monthlyMileage/30));
                                    actionHolder.setMaintenanceDate(addDays(days));
                                    actionHolder.setIntervalMileage(miles);
                                    vehicleDao.addMaintenance(actionHolder.getMaintenanceItem());
                                }
                            }
                        }
                        else {
                            long mileage = actionHolder.getIntervalMileage();
                            if (mileage > currentMileage){
                                long milesRemaining = mileage - currentMileage;
                                int days =  (int)(milesRemaining / (monthlyMileage/30));
                                actionHolder.setMaintenanceDate(addDays(days));
                                vehicleDao.addMaintenance(actionHolder.getMaintenanceItem());
                            }
                        }
                    }
                    List<MaintenanceItem> items = vehicleDao.getAllMaintenance();
                    view.displayItems(items);

                }
            });
        }

        private static long addDays(int numberOfDays){
            System.out.println("addDays.numberOfDays = " + numberOfDays);
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, numberOfDays);
            System.out.println("c.getTime() = " + c.getTime());
            return c.getTimeInMillis();
        }
}
