package com.datarak.vehiclemaintenancereminder.presenter;

import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;
import com.datarak.vehiclemaintenancereminder.model.Maintenance;
import com.datarak.vehiclemaintenancereminder.model.Makes;
import com.datarak.vehiclemaintenancereminder.scheduler.AndroidScheduler;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleView;
import com.datarak.vehiclemaintenancereminder.views.ShowMaintenanceScheduleView;

import rx.Subscriber;

/**
 * Created by raheel on 5/19/16.
 */
public class ShowMaintenanceSchedulePresenter {
    private ShowMaintenanceScheduleView view;
    final EdmundsApiService apiService;
    final AndroidScheduler scheduler;

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

    public void showSchedule(int vehicleId){
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
                        System.out.println("ShowMaintenanceScheduleFragment.onNext " + maintenance);
                    }
                });
    }

}
