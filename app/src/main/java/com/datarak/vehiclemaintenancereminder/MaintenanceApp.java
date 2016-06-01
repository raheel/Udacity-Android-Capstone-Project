package com.datarak.vehiclemaintenancereminder;

import android.app.Application;

import com.datarak.vehiclemaintenancereminder.injection.DaggerMaintenanceComponent;
import com.datarak.vehiclemaintenancereminder.injection.MaintenanceComponent;
import com.datarak.vehiclemaintenancereminder.job.MaintenanceJobCreator;
import com.evernote.android.job.JobManager;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by raheel on 5/17/16.
 */
public class MaintenanceApp extends Application {
    private static MaintenanceApp instance;
    private MaintenanceComponent component;
    private Tracker tracker;

    private static final int DAY_IN_MILLISECONDS = 24 * 60 * 60 * 1000;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerMaintenanceComponent.builder().build();

        JobManager.create(this).addJobCreator(new MaintenanceJobCreator());
    }

    public static MaintenanceApp getInstance(){
        return instance;
    }

    public MaintenanceComponent getComponent() {
        return component;
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }
}
