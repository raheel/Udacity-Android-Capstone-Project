package com.datarak.vehiclemaintenancereminder.presenter;

import com.datarak.vehiclemaintenancereminder.VehicleDao;
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
    VehicleDao vehicleDao;


    @Inject
    public AddVehicleInfoPresenter() {
    }

    public void bindView(AddVehicleInfoView view){
        this.view = view;
    }

    public void unbind(){
        this.view = null;
    }

    public void saveVehicle(int vehicleId, String year, String make, String model, int lastRecordedMileage, int monthlyMileage){
        System.out.println("AddVehicleInfoPresenter.saveVehicle 1");
        System.out.println("vehicleId = [" + vehicleId + "], year = [" + year + "], make = [" + make + "], model = [" + model + "], lastRecordedMileage = [" + lastRecordedMileage + "], monthlyMileage = [" + monthlyMileage + "]");
        vehicleDao.addVehicle(vehicleId, year, make, model, lastRecordedMileage, monthlyMileage);
    }
}
