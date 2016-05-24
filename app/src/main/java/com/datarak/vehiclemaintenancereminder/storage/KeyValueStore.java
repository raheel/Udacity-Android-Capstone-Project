package com.datarak.vehiclemaintenancereminder.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;

import javax.inject.Inject;

/**
 * Created by raheel on 5/23/16.
 */
public class KeyValueStore {
    public static final String APP_INITIALIZED = "APP_INITIALIZED";

    private final SharedPreferences sharedPreferences;

    @Inject
    public KeyValueStore() {
        sharedPreferences = MaintenanceApp.getInstance().getSharedPreferences("maintenance_db", Context.MODE_PRIVATE);
    }

    public void putBoolean(final String key, final boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(final String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public boolean hasKey(final String key){
        return sharedPreferences.contains(key);
    }

    public void removeKey(final String key){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

}
