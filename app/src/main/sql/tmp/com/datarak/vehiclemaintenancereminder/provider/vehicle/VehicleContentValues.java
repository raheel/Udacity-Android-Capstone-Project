package com.datarak.vehiclemaintenancereminder.provider.vehicle;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.datarak.vehiclemaintenancereminder.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code vehicle} table.
 */
public class VehicleContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return VehicleColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable VehicleSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable VehicleSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public VehicleContentValues putVehicleId(@Nullable Integer value) {
        mContentValues.put(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleContentValues putVehicleIdNull() {
        mContentValues.putNull(VehicleColumns.VEHICLE_ID);
        return this;
    }

    public VehicleContentValues putVehicleYear(@Nullable String value) {
        mContentValues.put(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleContentValues putVehicleYearNull() {
        mContentValues.putNull(VehicleColumns.VEHICLE_YEAR);
        return this;
    }

    public VehicleContentValues putVehicleMake(@Nullable String value) {
        mContentValues.put(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleContentValues putVehicleMakeNull() {
        mContentValues.putNull(VehicleColumns.VEHICLE_MAKE);
        return this;
    }

    public VehicleContentValues putVehicleModel(@Nullable String value) {
        mContentValues.put(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleContentValues putVehicleModelNull() {
        mContentValues.putNull(VehicleColumns.VEHICLE_MODEL);
        return this;
    }

    public VehicleContentValues putLastRecordedMileage(@Nullable Integer value) {
        mContentValues.put(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleContentValues putLastRecordedMileageNull() {
        mContentValues.putNull(VehicleColumns.LAST_RECORDED_MILEAGE);
        return this;
    }

    public VehicleContentValues putMonthyMileage(@Nullable Integer value) {
        mContentValues.put(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleContentValues putMonthyMileageNull() {
        mContentValues.putNull(VehicleColumns.MONTHY_MILEAGE);
        return this;
    }
}
