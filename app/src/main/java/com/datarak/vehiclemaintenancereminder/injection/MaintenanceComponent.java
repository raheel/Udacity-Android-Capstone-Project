package com.datarak.vehiclemaintenancereminder.injection;


import com.datarak.vehiclemaintenancereminder.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raheel on 5/17/16.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface MaintenanceComponent {
    void inject(MainActivity activity);
}
