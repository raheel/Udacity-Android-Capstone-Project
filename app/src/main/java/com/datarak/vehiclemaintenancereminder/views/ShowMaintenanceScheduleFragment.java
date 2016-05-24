package com.datarak.vehiclemaintenancereminder.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.model.MaintenanceItem;
import com.datarak.vehiclemaintenancereminder.presenter.ShowMaintenanceSchedulePresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by raheel on 5/11/16.
 */
public class ShowMaintenanceScheduleFragment extends BaseFragment implements ShowMaintenanceScheduleView  {
    public static final String VEHICLE_ID = "vehicle_id";
    public static final String CURRENT_MILEAGE = "current_mileage";
    public static final String MONTHLY_MILEAGE = "monthly_mileage";

    private long vehicleId;
    private int currentMileage;
    private int monthlyMileage;


    @Bind(R.id.scrollView)
    ScrollView scrollView;

    @Bind(R.id.schedules)
    GridLayout schedules;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    ShowMaintenanceSchedulePresenter presenter;

    @Inject
    public ShowMaintenanceScheduleFragment() {
        // Required empty public constructor
    }

    public static ShowMaintenanceScheduleFragment newInstance(int  vehicleId, int currentMileage, int monthlyMileage) {
        ShowMaintenanceScheduleFragment fragment = new ShowMaintenanceScheduleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(VEHICLE_ID, vehicleId);
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

        MaintenanceApp.getInstance().getComponent().inject(this);

        View view = inflater.inflate(R.layout.fragment_show_maintenance_schedule, container, false);

        ButterKnife.bind(this, view);

        presenter.bindView(this);

        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        presenter.showSchedule(vehicleId, currentMileage, monthlyMileage);

        return view;
    }

    @Override
    public void noVehicles(){
        navigateTo(AddVehicleFragment.newInstance());
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.setToolbarTitle(getString(R.string.schedule));
        presenter.checkStatus();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unbind();
    }

    public void displayItems(final List<MaintenanceItem> items) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);

                Collections.sort(items);

                for (final MaintenanceItem item : items){
                    CheckBox checkBox = new CheckBox(getContext());
                    checkBox.setId((int)item._id());
                    checkBox.setChecked(item.is_scheduled());
                    checkBox.setOnClickListener(new View.OnClickListener() {
                        boolean isChecked = item.is_scheduled();
                        @Override
                        public void onClick(View v) {
                            isChecked = !isChecked;
                            Toast.makeText(getContext(), isChecked ? getContext().getString(R.string.item_scheduled) : getContext().getString(R.string.item_removed), Toast.LENGTH_SHORT).show();
                            presenter.scheduleItem(item._id(), isChecked);
                        }
                    });
                    schedules.addView(checkBox);


                    TextView description = new TextView(getContext());
                    description.setText(item.displayableAction());
                    description.setLayoutParams(new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.maintenance_action_width), ViewGroup.LayoutParams.WRAP_CONTENT));
                    schedules.addView(description);

                    TextView date = new TextView(getContext());
                    date.setText(item.maintenance_date());
                    schedules.addView(date);
                }
            }
        });

    }

}
