package com.datarak.vehiclemaintenancereminder.injection;


import com.datarak.vehiclemaintenancereminder.SettingsActivity;
import com.datarak.vehiclemaintenancereminder.job.MaintenanceJob;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleFragment;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleInfoFragment;
import com.datarak.vehiclemaintenancereminder.views.MainActivity;
import com.datarak.vehiclemaintenancereminder.views.ShowMaintenanceScheduleFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raheel on 5/17/16.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface MaintenanceComponent {
    void inject(MainActivity activity);
    void inject(SettingsActivity activity);
    void inject(AddVehicleFragment fragment);
    void inject(AddVehicleInfoFragment fragment);
    void inject(ShowMaintenanceScheduleFragment fragment);
    void inject(MaintenanceJob job);
}
