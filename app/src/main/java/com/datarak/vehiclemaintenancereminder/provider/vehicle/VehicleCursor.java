package com.datarak.vehiclemaintenancereminder.provider.vehicle;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.datarak.vehiclemaintenancereminder.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code vehicle} table.
 */
public class VehicleCursor extends AbstractCursor implements VehicleModel {
    public VehicleCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(VehicleColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code vehicle_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVehicleId() {
        Integer res = getIntegerOrNull(VehicleColumns.VEHICLE_ID);
        return res;
    }

    /**
     * Get the {@code vehicle_year} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleYear() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_YEAR);
        return res;
    }

    /**
     * Get the {@code vehicle_make} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleMake() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_MAKE);
        return res;
    }

    /**
     * Get the {@code vehicle_model} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleModel() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_MODEL);
        return res;
    }

    /**
     * Get the {@code last_recorded_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getLastRecordedMileage() {
        Integer res = getIntegerOrNull(VehicleColumns.LAST_RECORDED_MILEAGE);
        return res;
    }

    /**
     * Get the {@code monthy_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getMonthyMileage() {
        Integer res = getIntegerOrNull(VehicleColumns.MONTHY_MILEAGE);
        return res;
    }
}
