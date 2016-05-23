package com.datarak.vehiclemaintenancereminder.model;

import com.google.auto.value.AutoValue;

import java.util.Calendar;

/**
 * Created by raheel on 5/21/16.
 */
@AutoValue
public abstract class MaintenanceItem implements MaintenanceItemModel, Comparable<MaintenanceItem> {

    public static final Mapper<MaintenanceItem> MAPPER = new Mapper<>(new Mapper.Creator<MaintenanceItem>() {
        @Override
        public MaintenanceItem create(long _id, String engine_code, String transmission_code, Long interval_mileage, Long frequency, String action_item, String item, String item_description, Double labor_units, Double part_units, String drive_type, String model_year, Double part_cost_per_unit, Long interval_month, String note1, Boolean is_scheduled, Boolean is_recurring, Long vehicle_id, Long maintenance_date) {
           return new AutoValue_MaintenanceItem(_id, engine_code, transmission_code, interval_mileage, frequency, action_item, item, item_description, labor_units, part_units, drive_type, model_year, part_cost_per_unit, interval_month, note1, is_scheduled, is_recurring, vehicle_id, maintenance_date);
        }

    });

    @Override
    public int compareTo(MaintenanceItem another) {
        return (int)(another.maintenance_date() - maintenance_date());
    }
}