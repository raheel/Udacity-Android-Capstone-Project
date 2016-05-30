package com.datarak.vehiclemaintenancereminder.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.model.Maintenance;
import com.datarak.vehiclemaintenancereminder.model.Make;
import com.datarak.vehiclemaintenancereminder.model.Model;
import com.datarak.vehiclemaintenancereminder.presenter.AddVehiclePresenter;
import com.datarak.vehiclemaintenancereminder.presenter.ShowMaintenanceSchedulePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;


public class AddVehicleFragment extends BaseFragment implements AddVehicleView{
    @Bind(R.id.vehicle_year)
    Spinner yearSpinner;

    @Bind(R.id.vehicle_make)
    Spinner makeSpinner;

    @Bind(R.id.vehicle_model)
    Spinner modelSpinner;

    @Inject
    AddVehiclePresenter presenter;

    private int vehicleId;

    private String year;
    private String make;
    private String model;

    public AddVehicleFragment() {
        // Required empty public constructor
    }


    public static AddVehicleFragment newInstance() {
        AddVehicleFragment fragment = new AddVehicleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_vehicle, container, false);

        MaintenanceApp.getInstance().getComponent().inject(this);
        ButterKnife.bind(this, view);

        MaintenanceApp.getInstance().getComponent().inject(this);
        presenter.bindView(this);

        return view;
    }


    @Override
    public void onResume() {
                super.onResume();
        listener.setToolbarTitle(getString(R.string.add_vehicle));
        presenter.checkStatus();
    }




    @OnItemSelected(R.id.vehicle_year)
    public void onYearChange(int position){
        if (position>=0) {
            year = (String) yearSpinner.getItemAtPosition(position + 1);
            presenter.onYearSelected(year);
        }
    }


    @OnItemSelected(R.id.vehicle_make)
    public void onMakeChange(int position){
        if (position>=0) {
            Make m = (Make) makeSpinner.getItemAtPosition(position + 1);
            make = m.getName();
            presenter.onMakeSelected(m);
        }
    }

    @OnItemSelected(R.id.vehicle_model)
    public void onModelChange(int position){
        if (position>=0) {
            Model m = (Model) modelSpinner.getItemAtPosition(position + 1);
            model = m.getName();
            vehicleId = m.getYears().get(0).getId();
        }
    }


    @OnClick(R.id.next_button)
    public void onNextClicked(){
        if (year==null || make==null || model==null){
            Toast.makeText(getContext(), getContext().getString(R.string.select_all_fields), Toast.LENGTH_SHORT).show();
            return;
        }
        AddVehicleInfoFragment fragment = AddVehicleInfoFragment.newInstance(vehicleId, year, make, model);
        navigateTo(fragment);
    }

    @Override
    public void populateYearSpinner(List<String> years) {
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, years.toArray(new String[years.size()]));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapter);
        yearSpinner.setSelection(4);
    }

    @Override
    public void populateMakeSpinner(List<Make> makes) {
        ArrayAdapter<Make> adapter = new ArrayAdapter<Make>(
                getContext(), android.R.layout.simple_spinner_item, makes.toArray(new Make[makes.size()]));

        makeSpinner.setAdapter(adapter);
        makeSpinner.setSelection(4);

    }

    @Override
    public void populateModelSpinner(List<Model> models) {
        ArrayAdapter<Model> adapter = new ArrayAdapter<Model>(
                getContext(), android.R.layout.simple_spinner_item, models.toArray(new Model[models .size()]));

        modelSpinner.setAdapter(adapter);
        modelSpinner.setSelection(4);
    }

    @Override
    public void hasVehicle(long vehicleId, long currentMileage, long monthlyMileage) {
                        navigateTo(ShowMaintenanceScheduleFragment.newInstance((int) vehicleId, (int) currentMileage, (int) monthlyMileage));
    }
}
