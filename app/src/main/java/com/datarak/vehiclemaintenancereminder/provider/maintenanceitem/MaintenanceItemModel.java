package com.datarak.vehiclemaintenancereminder.provider.maintenanceitem;

import com.datarak.vehiclemaintenancereminder.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code maintenance_item} table.
 */
public interface MaintenanceItemModel extends BaseModel {

    /**
     * Get the {@code engine_code} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEngineCode();

    /**
     * Get the {@code transmission_code} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTransmissionCode();

    /**
     * Get the {@code interval_mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIntervalMileage();

    /**
     * Get the {@code frequency} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getFrequency();

    /**
     * Get the {@code action_item} value.
     * Can be {@code null}.
     */
    @Nullable
    String getActionItem();

    /**
     * Get the {@code item} value.
     * Can be {@code null}.
     */
    @Nullable
    String getItem();

    /**
     * Get the {@code item_description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getItemDescription();

    /**
     * Get the {@code labor_units} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getLaborUnits();

    /**
     * Get the {@code part_units} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getPartUnits();

    /**
     * Get the {@code drive_type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDriveType();

    /**
     * Get the {@code model_year} value.
     * Can be {@code null}.
     */
    @Nullable
    String getModelYear();

    /**
     * Get the {@code part_cost_per_unit} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getPartCostPerUnit();

    /**
     * Get the {@code interval_month} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIntervalMonth();

    /**
     * Get the {@code note1} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNote1();

    /**
     * Get the {@code is_scheduled} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getIsScheduled();

    /**
     * Get the {@code vehicle_id} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getVehicleId();

    /**
     * Get the {@code maintenance_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getMaintenanceDate();
}
