package com.datarak.vehiclemaintenancereminder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.datarak.vehiclemaintenancereminder.injection.DaggerMaintenanceComponent;
import com.datarak.vehiclemaintenancereminder.model.Vehicle;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {
    @Inject
    VehicleDao vehicleDao;

    @Bind(R.id.vehicle_container)
    View vehicleContainer;

    @Bind(R.id.current_vehicle_name)
    TextView vehicleName;


    @Bind(R.id.no_vehicle)
    TextView noVehicle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ButterKnife.bind(this);

        DaggerMaintenanceComponent.create().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.menu_settings));
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        Vehicle vehicle = vehicleDao.getVehicle();
        if (vehicle!=null){
            vehicleContainer.setVisibility(View.VISIBLE);
            noVehicle.setVisibility(View.GONE);

            vehicleName.setText(vehicle.vehicle_year() + " " + vehicle.vehicle_make() + " " + vehicle.vehicle_model());
        }
        else{
            vehicleContainer.setVisibility(View.GONE);
            noVehicle.setVisibility(View.VISIBLE);
        }
    }


    @OnClick(R.id.delete_vehicle)
    public void deleteVehicle(){
        vehicleDao.deleteAllVehicles();

        vehicleContainer.setVisibility(View.GONE);
        noVehicle.setVisibility(View.VISIBLE);
    }
}
