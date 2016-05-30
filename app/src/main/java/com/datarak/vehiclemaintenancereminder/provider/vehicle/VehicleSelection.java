package com.datarak.vehiclemaintenancereminder.provider.vehicle;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.datarak.vehiclemaintenancereminder.provider.base.AbstractSelection;

/**
 * Selection for the {@code vehicle} table.
 */
public class VehicleSelection extends AbstractSelection<VehicleSelection> {
    @Override
    protected Uri baseUri() {
        return VehicleColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VehicleCursor} object, which is positioned before the first entry, or null.
     */
    public VehicleCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VehicleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public VehicleCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VehicleCursor} object, which is positioned before the first entry, or null.
     */
    public VehicleCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VehicleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public VehicleCursor query(Context context) {
        return query(context, null);
    }


    public VehicleSelection id(long... value) {
        addEquals("vehicle." + VehicleColumns._ID, toObjectArray(value));
        return this;
    }

    public VehicleSelection idNot(long... value) {
        addNotEquals("vehicle." + VehicleColumns._ID, toObjectArray(value));
        return this;
    }

    public VehicleSelection orderById(boolean desc) {
        orderBy("vehicle." + VehicleColumns._ID, desc);
        return this;
    }

    public VehicleSelection orderById() {
        return orderById(false);
    }

    public VehicleSelection vehicleId(Integer... value) {
        addEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleSelection vehicleIdNot(Integer... value) {
        addNotEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleSelection vehicleIdGt(int value) {
        addGreaterThan(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleSelection vehicleIdGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleSelection vehicleIdLt(int value) {
        addLessThan(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleSelection vehicleIdLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public VehicleSelection orderByVehicleId(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_ID, desc);
        return this;
    }

    public VehicleSelection orderByVehicleId() {
        orderBy(VehicleColumns.VEHICLE_ID, false);
        return this;
    }

    public VehicleSelection vehicleYear(String... value) {
        addEquals(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleSelection vehicleYearNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleSelection vehicleYearLike(String... value) {
        addLike(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleSelection vehicleYearContains(String... value) {
        addContains(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleSelection vehicleYearStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleSelection vehicleYearEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public VehicleSelection orderByVehicleYear(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_YEAR, desc);
        return this;
    }

    public VehicleSelection orderByVehicleYear() {
        orderBy(VehicleColumns.VEHICLE_YEAR, false);
        return this;
    }

    public VehicleSelection vehicleMake(String... value) {
        addEquals(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleSelection vehicleMakeNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleSelection vehicleMakeLike(String... value) {
        addLike(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleSelection vehicleMakeContains(String... value) {
        addContains(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleSelection vehicleMakeStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleSelection vehicleMakeEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public VehicleSelection orderByVehicleMake(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_MAKE, desc);
        return this;
    }

    public VehicleSelection orderByVehicleMake() {
        orderBy(VehicleColumns.VEHICLE_MAKE, false);
        return this;
    }

    public VehicleSelection vehicleModel(String... value) {
        addEquals(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleSelection vehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleSelection vehicleModelLike(String... value) {
        addLike(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleSelection vehicleModelContains(String... value) {
        addContains(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleSelection vehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleSelection vehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public VehicleSelection orderByVehicleModel(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_MODEL, desc);
        return this;
    }

    public VehicleSelection orderByVehicleModel() {
        orderBy(VehicleColumns.VEHICLE_MODEL, false);
        return this;
    }

    public VehicleSelection lastRecordedMileage(Integer... value) {
        addEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleSelection lastRecordedMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleSelection lastRecordedMileageGt(int value) {
        addGreaterThan(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleSelection lastRecordedMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleSelection lastRecordedMileageLt(int value) {
        addLessThan(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleSelection lastRecordedMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public VehicleSelection orderByLastRecordedMileage(boolean desc) {
        orderBy(VehicleColumns.LAST_RECORDED_MILEAGE, desc);
        return this;
    }

    public VehicleSelection orderByLastRecordedMileage() {
        orderBy(VehicleColumns.LAST_RECORDED_MILEAGE, false);
        return this;
    }

    public VehicleSelection monthyMileage(Integer... value) {
        addEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleSelection monthyMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleSelection monthyMileageGt(int value) {
        addGreaterThan(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleSelection monthyMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleSelection monthyMileageLt(int value) {
        addLessThan(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleSelection monthyMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public VehicleSelection orderByMonthyMileage(boolean desc) {
        orderBy(VehicleColumns.MONTHY_MILEAGE, desc);
        return this;
    }

    public VehicleSelection orderByMonthyMileage() {
        orderBy(VehicleColumns.MONTHY_MILEAGE, false);
        return this;
    }
}
