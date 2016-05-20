package com.datarak.vehiclemaintenancereminder.presenter;

import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;
import com.datarak.vehiclemaintenancereminder.scheduler.AndroidScheduler;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleInfoView;
import com.datarak.vehiclemaintenancereminder.views.ShowMaintenanceScheduleView;

import javax.inject.Inject;

/**
 * Created by raheel on 5/19/16.
 */
public class AddVehicleInfoPresenter {
    private AddVehicleInfoView view;

    @Inject
    public AddVehicleInfoPresenter() {
    }

    public void bindView(AddVehicleInfoView view){
        this.view = view;
    }

    public void unbind(){
        this.view = null;
    }
}
