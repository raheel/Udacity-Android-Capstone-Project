package com.datarak.vehiclemaintenancereminder.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datarak.vehiclemaintenancereminder.R;


public class AddVehicleInfoFragment extends BaseFragment {
    public AddVehicleInfoFragment() {
        // Required empty public constructor
    }


    public static AddVehicleInfoFragment newInstance() {
        AddVehicleInfoFragment fragment = new AddVehicleInfoFragment();
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
        return inflater.inflate(R.layout.fragment_add_vehicle_info, container, false);
    }
}
