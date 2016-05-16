package com.datarak.vehiclemaintenancereminder.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datarak.vehiclemaintenancereminder.R;

/**
 * Created by raheel on 5/11/16.
 */
public class ShowMaintenanceScheduleFragment extends BaseFragment  {
    public ShowMaintenanceScheduleFragment() {
        // Required empty public constructor
    }


    public static ShowMaintenanceScheduleFragment newInstance() {
        ShowMaintenanceScheduleFragment fragment = new ShowMaintenanceScheduleFragment();
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
        return inflater.inflate(R.layout.fragment_add_vehicle, container, false);
    }
}
