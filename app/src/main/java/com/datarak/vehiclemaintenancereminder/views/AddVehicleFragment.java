package com.datarak.vehiclemaintenancereminder.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.R;
import com.datarak.vehiclemaintenancereminder.model.Maintenance;
import com.datarak.vehiclemaintenancereminder.model.Make;
import com.datarak.vehiclemaintenancereminder.model.Model;
import com.datarak.vehiclemaintenancereminder.presenter.AddVehiclePresenter;

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

    public AddVehicleFragment() {
        // Required empty public constructor
    }


    public static AddVehicleFragment newInstance() {
        System.out.println("AddVehicleFragment.newInstance");
        AddVehicleFragment fragment = new AddVehicleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("AddVehicleFragment.onCreate");
        System.out.println("yearSpinner = " + yearSpinner);
        System.out.println("MaintenanceApp.getInstance() = " + MaintenanceApp.getInstance());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_vehicle, container, false);

        ButterKnife.bind(this, view);

        System.out.println("AddVehicleFragment.onCreateView");

        MaintenanceApp.getInstance().getComponent().inject(this);
        System.out.println("_______1 presenter = " + presenter);
        presenter.bindView(this);

        // Inflate the layout for this fragment
        return view;
    }

    @OnItemSelected(R.id.vehicle_year)
    public void onYearChange(int position){
        if (position>=0) {
            String year = (String) yearSpinner.getItemAtPosition(position + 1);
            presenter.onYearSelected(year);
        }
    }


    @OnItemSelected(R.id.vehicle_make)
    public void onMakeChange(int position){
        if (position>=0) {
            Make make = (Make) makeSpinner.getItemAtPosition(position + 1);
            presenter.onMakeSelected(make);
        }
    }

    @OnItemSelected(R.id.vehicle_model)
    public void onModelChange(int position){
        if (position>=0) {
            Model model = (Model) modelSpinner.getItemAtPosition(position + 1);
            vehicleId = model.getYears().get(0).getId();
        }
    }


    @OnClick(R.id.next_button)
    public void onNextClicked(){
        System.out.println("AddVehicleFragment.onNextClicked: " + vehicleId);
        AddVehicleInfoFragment fragment = AddVehicleInfoFragment.newInstance(vehicleId);
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void populateYearSpinner(List<String> years) {
        System.out.println("AddVehicleFragment.populateYearSpinner");
        System.out.println("years = " + years);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, years.toArray(new String[years.size()]));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapter);
    }

    @Override
    public void populateMakeSpinner(List<Make> makes) {
        System.out.println("AddVehicleFragment.populateMakeSpinner");
        System.out.println("models = " + makes);

        ArrayAdapter<Make> adapter = new ArrayAdapter<Make>(
                getContext(), android.R.layout.simple_spinner_item, makes.toArray(new Make[makes.size()]));

        makeSpinner.setAdapter(adapter);
    }

    @Override
    public void populateModelSpinner(List<Model> models) {
        System.out.println("AddVehicleFragment.populateModelSpinner");
        System.out.println("models = " + models);

        ArrayAdapter<Model> adapter = new ArrayAdapter<Model>(
                getContext(), android.R.layout.simple_spinner_item, models.toArray(new Model[models .size()]));

        modelSpinner.setAdapter(adapter);


    }
}
