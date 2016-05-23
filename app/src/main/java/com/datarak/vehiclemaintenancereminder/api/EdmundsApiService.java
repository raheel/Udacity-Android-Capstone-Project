package com.datarak.vehiclemaintenancereminder.api;

import com.datarak.vehiclemaintenancereminder.model.Maintenance;
import com.datarak.vehiclemaintenancereminder.model.Makes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by raheel on 5/16/16.
 */
public interface EdmundsApiService {
    @GET("/api/vehicle/v2/makes")
    public Observable<Makes> getMakesByYear(@Query("year")String year);

    @GET("v1/api/maintenance/actionrepository/findbymodelyearid")
    public Observable<Maintenance> getVehicleMaintenance(@Query("modelyearid")long vehicleId);
}
