package com.datarak.vehiclemaintenancereminder.model;

import com.google.auto.value.AutoValue;
import com.datarak.vehiclemaintenancereminder.model.VehicleModel;

/**
 * Created by raheel on 5/21/16.
 */
@AutoValue
    public abstract class Vehicle implements VehicleModel {

    public static final Mapper<Vehicle> MAPPER = new Mapper<>(new Mapper.Creator<Vehicle>() {

        @Override
        public Vehicle create(long _id, Long vehicle_id, String vehicle_year, String vehicle_make, String vehicle_model, Long last_recorded_mileage, Long monthy_mileage) {
            return new AutoValue_Vehicle(_id, vehicle_id, vehicle_year, vehicle_make, vehicle_model, last_recorded_mileage, monthy_mileage);
        }
    });
}