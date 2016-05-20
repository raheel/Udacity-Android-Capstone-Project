package com.datarak.vehiclemaintenancereminder.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.datarak.vehiclemaintenancereminder.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddVehicleInfoFragment extends BaseFragment implements AddVehicleInfoView{
    public static final String VEHICLE_ID = "vehicle_id";

    private String vehicleId;

    @Bind(R.id.input_layout_vehicle_current_mileage)
    EditText currentMileage;

    @Bind(R.id.input_layout_vehicle_monthly_mileage)
    EditText monthlyMileage;

    public AddVehicleInfoFragment() {
        // Required empty public constructor
    }


    public static AddVehicleInfoFragment newInstance(int vehicleId) {
        AddVehicleInfoFragment fragment = new AddVehicleInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(AddVehicleInfoFragment.VEHICLE_ID, vehicleId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.vehicleId = getArguments().getString(VEHICLE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_vehicle_info, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.next_button)
    public void onNextClicked(){
        System.out.println("AddVehicleInfoPresenter.onNextClicked: " + vehicleId);
        int current = Integer.parseInt(currentMileage.getText().toString());
        int monthly = Integer.parseInt(monthlyMileage.getText().toString());
        ShowMaintenanceScheduleFragment fragment = ShowMaintenanceScheduleFragment.newInstance(vehicleId, current, monthly);
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }


    @Override
    public void showMaintenanceSchedule() {

    }
}
