package com.datarak.vehiclemaintenancereminder.provider.maintenanceitem;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.datarak.vehiclemaintenancereminder.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code maintenance_item} table.
 */
public class MaintenanceItemContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MaintenanceItemColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MaintenanceItemSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MaintenanceItemSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MaintenanceItemContentValues putEngineCode(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemContentValues putEngineCodeNull() {
        mContentValues.putNull(MaintenanceItemColumns.ENGINE_CODE);
        return this;
    }

    public MaintenanceItemContentValues putTransmissionCode(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemContentValues putTransmissionCodeNull() {
        mContentValues.putNull(MaintenanceItemColumns.TRANSMISSION_CODE);
        return this;
    }

    public MaintenanceItemContentValues putIntervalMileage(@Nullable Integer value) {
        mContentValues.put(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemContentValues putIntervalMileageNull() {
        mContentValues.putNull(MaintenanceItemColumns.INTERVAL_MILEAGE);
        return this;
    }

    public MaintenanceItemContentValues putFrequency(@Nullable Integer value) {
        mContentValues.put(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemContentValues putFrequencyNull() {
        mContentValues.putNull(MaintenanceItemColumns.FREQUENCY);
        return this;
    }

    public MaintenanceItemContentValues putActionItem(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemContentValues putActionItemNull() {
        mContentValues.putNull(MaintenanceItemColumns.ACTION_ITEM);
        return this;
    }

    public MaintenanceItemContentValues putItem(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemContentValues putItemNull() {
        mContentValues.putNull(MaintenanceItemColumns.ITEM);
        return this;
    }

    public MaintenanceItemContentValues putItemDescription(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemContentValues putItemDescriptionNull() {
        mContentValues.putNull(MaintenanceItemColumns.ITEM_DESCRIPTION);
        return this;
    }

    public MaintenanceItemContentValues putLaborUnits(@Nullable Double value) {
        mContentValues.put(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemContentValues putLaborUnitsNull() {
        mContentValues.putNull(MaintenanceItemColumns.LABOR_UNITS);
        return this;
    }

    public MaintenanceItemContentValues putPartUnits(@Nullable Double value) {
        mContentValues.put(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemContentValues putPartUnitsNull() {
        mContentValues.putNull(MaintenanceItemColumns.PART_UNITS);
        return this;
    }

    public MaintenanceItemContentValues putDriveType(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemContentValues putDriveTypeNull() {
        mContentValues.putNull(MaintenanceItemColumns.DRIVE_TYPE);
        return this;
    }

    public MaintenanceItemContentValues putModelYear(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemContentValues putModelYearNull() {
        mContentValues.putNull(MaintenanceItemColumns.MODEL_YEAR);
        return this;
    }

    public MaintenanceItemContentValues putPartCostPerUnit(@Nullable Double value) {
        mContentValues.put(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemContentValues putPartCostPerUnitNull() {
        mContentValues.putNull(MaintenanceItemColumns.PART_COST_PER_UNIT);
        return this;
    }

    public MaintenanceItemContentValues putIntervalMonth(@Nullable Integer value) {
        mContentValues.put(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemContentValues putIntervalMonthNull() {
        mContentValues.putNull(MaintenanceItemColumns.INTERVAL_MONTH);
        return this;
    }

    public MaintenanceItemContentValues putNote1(@Nullable String value) {
        mContentValues.put(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemContentValues putNote1Null() {
        mContentValues.putNull(MaintenanceItemColumns.NOTE1);
        return this;
    }

    public MaintenanceItemContentValues putIsScheduled(@Nullable Boolean value) {
        mContentValues.put(MaintenanceItemColumns.IS_SCHEDULED, value);
        return this;
    }

    public MaintenanceItemContentValues putIsScheduledNull() {
        mContentValues.putNull(MaintenanceItemColumns.IS_SCHEDULED);
        return this;
    }

    public MaintenanceItemContentValues putVehicleId(@Nullable Long value) {
        mContentValues.put(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemContentValues putVehicleIdNull() {
        mContentValues.putNull(MaintenanceItemColumns.VEHICLE_ID);
        return this;
    }

    public MaintenanceItemContentValues putMaintenanceDate(@Nullable Date value) {
        mContentValues.put(MaintenanceItemColumns.MAINTENANCE_DATE, value == null ? null : value.getTime());
        return this;
    }

    public MaintenanceItemContentValues putMaintenanceDateNull() {
        mContentValues.putNull(MaintenanceItemColumns.MAINTENANCE_DATE);
        return this;
    }

    public MaintenanceItemContentValues putMaintenanceDate(@Nullable Long value) {
        mContentValues.put(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }
}
