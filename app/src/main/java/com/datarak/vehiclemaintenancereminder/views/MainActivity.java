package com.datarak.vehiclemaintenancereminder.views;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.SettingsActivity;
import com.datarak.vehiclemaintenancereminder.injection.DaggerMaintenanceComponent;
import com.datarak.vehiclemaintenancereminder.job.MaintenanceJob;
import com.datarak.vehiclemaintenancereminder.storage.KeyValueStore;
import com.evernote.android.job.JobRequest;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener, MainView {
    private static final int DAY_IN_MILLISECONDS = 24 * 60 * 60 * 1000;

    @Inject
    KeyValueStore keyValueStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMaintenanceComponent.create().inject(this);

        if (!keyValueStore.hasKey(KeyValueStore.APP_INITIALIZED)){
            //run job daily
            keyValueStore.putBoolean(KeyValueStore.APP_INITIALIZED, true);
            new JobRequest.Builder(MaintenanceJob.TAG)
                    .setPeriodic(DAY_IN_MILLISECONDS)
                    .setPersisted(true)
                    .build()
                    .schedule();

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, AddVehicleFragment.newInstance()).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }
}
