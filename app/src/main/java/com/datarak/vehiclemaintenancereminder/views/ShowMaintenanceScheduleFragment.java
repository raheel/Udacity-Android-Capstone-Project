package com.datarak.vehiclemaintenancereminder.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datarak.vehiclemaintenancereminder.R;

/**
 * Created by raheel on 5/11/16.
 */
public class ShowMaintenanceScheduleFragment extends BaseFragment implements ShowMaintenanceScheduleView  {
    public static final String VEHICLE_ID = "vehicle_id";
    public static final String CURRENT_MILEAGE = "current_mileage";
    public static final String MONTHLY_MILEAGE = "monthly_mileage";

    private int vehicleId;
    private int currentMileage;
    private int monthlyMileage;

    public ShowMaintenanceScheduleFragment() {
        // Required empty public constructor
    }

    public static ShowMaintenanceScheduleFragment newInstance(String vehicleId, int currentMileage, int monthlyMileage) {
        ShowMaintenanceScheduleFragment fragment = new ShowMaintenanceScheduleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VEHICLE_ID, vehicleId);
        bundle.putInt(CURRENT_MILEAGE, currentMileage);
        bundle.putInt(MONTHLY_MILEAGE, monthlyMileage);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (getArguments() != null) {
            this.vehicleId = getArguments().getInt(VEHICLE_ID);
            this.currentMileage = getArguments().getInt(CURRENT_MILEAGE);
            this.monthlyMileage = getArguments().getInt(MONTHLY_MILEAGE);
        }
        return inflater.inflate(R.layout.fragment_show_maintenance_schedule, container, false);
    }
}
