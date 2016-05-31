package com.datarak.vehiclemaintenancereminder.presenter;

import android.database.Cursor;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.provider.MaintenanceProvider;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemColumns;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleColumns;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleContentValues;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleCursor;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleSelection;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleInfoView;

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

    public void saveVehicle(int vehicleId, String year, String make, String model, int lastRecordedMileage, int monthlyMileage){
        VehicleContentValues values = new VehicleContentValues();
        values.putVehicleId(vehicleId)
                .putVehicleYear(year)
                .putVehicleMake(make)
                .putVehicleModel(model)
                .putLastRecordedMileage(lastRecordedMileage)
                .putMonthyMileage(monthlyMileage);

        MaintenanceApp.getInstance().getContentResolver().insert(VehicleColumns.CONTENT_URI, values.values());
    }

    public void checkStatus() {
        VehicleCursor cursor = new VehicleSelection().query(MaintenanceApp.getInstance().getContentResolver());
        if (cursor!=null && cursor.getCount()>0){
            view.hasVehicle(cursor.getId(), cursor.getLastRecordedMileage(), cursor.getMonthyMileage());
        }
    }

}
