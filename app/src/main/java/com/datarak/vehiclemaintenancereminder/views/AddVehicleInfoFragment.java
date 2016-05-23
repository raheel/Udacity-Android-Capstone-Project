package com.datarak.vehiclemaintenancereminder.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.presenter.AddVehicleInfoPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.datarak.vehiclemaintenancereminder.views.ViewConstants.VEHICLE_ID;
import static com.datarak.vehiclemaintenancereminder.views.ViewConstants.VEHICLE_MAKE;
import static com.datarak.vehiclemaintenancereminder.views.ViewConstants.VEHICLE_MODEL;
import static com.datarak.vehiclemaintenancereminder.views.ViewConstants.VEHICLE_YEAR;


public class AddVehicleInfoFragment extends BaseFragment implements AddVehicleInfoView{
    private int vehicleId;
    private String vehicleYear;
    private String vehicleMake;
    private String vehicleModel;

    @Bind(R.id.input_vehicle_current_mileage)
    EditText currentMileage;

    @Bind(R.id.input_vehicle_monthly_mileage)
    EditText monthlyMileage;

    @Inject
    AddVehicleInfoPresenter presenter;

    @Inject
    public AddVehicleInfoFragment() {
    }

    public static AddVehicleInfoFragment newInstance(int vehicleId, String year, String make, String model) {
        AddVehicleInfoFragment fragment = new AddVehicleInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(VEHICLE_ID, vehicleId);
        bundle.putString(VEHICLE_YEAR, year);
        bundle.putString(VEHICLE_MAKE, make);
        bundle.putString(VEHICLE_MODEL, model);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.vehicleId = getArguments().getInt(VEHICLE_ID);
            this.vehicleYear = getArguments().getString(VEHICLE_YEAR);
            this.vehicleMake = getArguments().getString(VEHICLE_MAKE);
            this.vehicleModel = getArguments().getString(VEHICLE_MODEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_vehicle_info, container, false);

        MaintenanceApp.getInstance().getComponent().inject(this);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.save_button)
    public void onSaveClicked(){
        System.out.println("AddVehicleInfoPresenter.onNextClicked: " + vehicleId);
        int current = Integer.parseInt(currentMileage.getText().toString());
        int monthly = Integer.parseInt(monthlyMileage.getText().toString());

        presenter.saveVehicle(vehicleId, vehicleYear, vehicleMake, vehicleModel, current, monthly);
        ShowMaintenanceScheduleFragment fragment = ShowMaintenanceScheduleFragment.newInstance(vehicleId, current, monthly);
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }


    @Override
    public void showMaintenanceSchedule() {

    }
}
