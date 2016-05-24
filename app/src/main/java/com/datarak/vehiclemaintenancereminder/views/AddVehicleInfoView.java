package com.datarak.vehiclemaintenancereminder.views;

/**
 * Created by raheel on 5/19/16.
 */
public interface AddVehicleInfoView {
    void showMaintenanceSchedule();
    void hasVehicle(long vehicleId, long currentMileage, long monthlyMileage);
}
