package com.datarak.vehiclemaintenancereminder;

import android.app.Application;

import com.datarak.vehiclemaintenancereminder.injection.DaggerMaintenanceComponent;
import com.datarak.vehiclemaintenancereminder.injection.MaintenanceComponent;

/**
 * Created by raheel on 5/17/16.
 */
public class MaintenanceApp extends Application {
    private static MaintenanceApp instance;
    private MaintenanceComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerMaintenanceComponent.builder().build();
    }

    public static MaintenanceApp getInstance(){
        return instance;
    }

    public MaintenanceComponent getComponent() {
        return component;
    }

}
