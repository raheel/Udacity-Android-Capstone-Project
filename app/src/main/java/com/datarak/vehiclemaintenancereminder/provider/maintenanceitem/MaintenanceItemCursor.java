package com.datarak.vehiclemaintenancereminder.provider.maintenanceitem;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.datarak.vehiclemaintenancereminder.provider.base.AbstractCursor;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.*;

/**
 * Cursor wrapper for the {@code maintenance_item} table.
 */
public class MaintenanceItemCursor extends AbstractCursor implements MaintenanceItemModel {
    public MaintenanceItemCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
                Long res = getLongOrNull(MaintenanceItemColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code engine_code} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getEngineCode() {
        String res = getStringOrNull(MaintenanceItemColumns.ENGINE_CODE);
        return res;
    }

    /**
     * Get the {@code transmission_code} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTransmissionCode() {
        String res = getStringOrNull(MaintenanceItemColumns.TRANSMISSION_CODE);
        return res;
    }

    /**
     * Get the {@code interval_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getIntervalMileage() {
        Integer res = getIntegerOrNull(MaintenanceItemColumns.INTERVAL_MILEAGE);
        return res;
    }

    /**
     * Get the {@code frequency} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getFrequency() {
        Integer res = getIntegerOrNull(MaintenanceItemColumns.FREQUENCY);
        return res;
    }

    /**
     * Get the {@code action_item} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getActionItem() {
        String res = getStringOrNull(MaintenanceItemColumns.ACTION_ITEM);
        return res;
    }

    /**
     * Get the {@code item} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getItem() {
        String res = getStringOrNull(MaintenanceItemColumns.ITEM);
        return res;
    }

    /**
     * Get the {@code item_description} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getItemDescription() {
        String res = getStringOrNull(MaintenanceItemColumns.ITEM_DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code labor_units} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getLaborUnits() {
        Double res = getDoubleOrNull(MaintenanceItemColumns.LABOR_UNITS);
        return res;
    }

    /**
     * Get the {@code part_units} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getPartUnits() {
        Integer res = getIntegerOrNull(MaintenanceItemColumns.PART_UNITS);
        return res;
    }

    /**
     * Get the {@code drive_type} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDriveType() {
        String res = getStringOrNull(MaintenanceItemColumns.DRIVE_TYPE);
        return res;
    }

    /**
     * Get the {@code model_year} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getModelYear() {
        String res = getStringOrNull(MaintenanceItemColumns.MODEL_YEAR);
        return res;
    }

    /**
     * Get the {@code part_cost_per_unit} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPartCostPerUnit() {
        Double res = getDoubleOrNull(MaintenanceItemColumns.PART_COST_PER_UNIT);
        return res;
    }

    /**
     * Get the {@code interval_month} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getIntervalMonth() {
        Integer res = getIntegerOrNull(MaintenanceItemColumns.INTERVAL_MONTH);
        return res;
    }

    /**
     * Get the {@code note1} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNote1() {
        String res = getStringOrNull(MaintenanceItemColumns.NOTE1);
        return res;
    }

    /**
     * Get the {@code is_scheduled} value.
     * Can be {@code null}.
     */
    @Nullable
    public Boolean getIsScheduled() {
        Boolean res = getBooleanOrNull(MaintenanceItemColumns.IS_SCHEDULED);
        return res;
    }

    /**
     * Get the {@code vehicle_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVehicleId() {
        Integer res = getIntegerOrNull(MaintenanceItemColumns.VEHICLE_ID);
        return res;
    }

    /**
     * Get the {@code vehicle_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVehicleVehicleId() {
        Integer res = getIntegerOrNull(VehicleColumns.VEHICLE_ID);
        return res;
    }

    /**
     * Get the {@code vehicle_year} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleVehicleYear() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_YEAR);
        return res;
    }

    /**
     * Get the {@code vehicle_make} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleVehicleMake() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_MAKE);
        return res;
    }

    /**
     * Get the {@code vehicle_model} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleVehicleModel() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_MODEL);
        return res;
    }

    /**
     * Get the {@code last_recorded_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVehicleLastRecordedMileage() {
        Integer res = getIntegerOrNull(VehicleColumns.LAST_RECORDED_MILEAGE);
        return res;
    }

    /**
     * Get the {@code monthy_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVehicleMonthyMileage() {
        Integer res = getIntegerOrNull(VehicleColumns.MONTHY_MILEAGE);
        return res;
    }

    /**
     * Get the {@code maintenance_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getMaintenanceDate() {
        Date res = getDateOrNull(MaintenanceItemColumns.MAINTENANCE_DATE);
        return res;
    }

    public String getDisplayableAction(){
        return getActionItem().trim() + " " +  getItem();
    }


}
