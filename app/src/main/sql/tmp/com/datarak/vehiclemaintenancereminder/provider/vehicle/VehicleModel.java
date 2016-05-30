package com.datarak.vehiclemaintenancereminder.provider.vehicle;

import com.datarak.vehiclemaintenancereminder.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code vehicle} table.
 */
public interface VehicleModel extends BaseModel {

    /**
     * Get the {@code vehicle_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getVehicleId();

    /**
     * Get the {@code vehicle_year} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleYear();

    /**
     * Get the {@code vehicle_make} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleMake();

    /**
     * Get the {@code vehicle_model} value.
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleModel();

    /**
     * Get the {@code last_recorded_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getLastRecordedMileage();

    /**
     * Get the {@code monthy_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getMonthyMileage();
}
