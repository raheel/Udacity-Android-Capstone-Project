package com.datarak.vehiclemaintenancereminder.presenter;

import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;
import com.datarak.vehiclemaintenancereminder.model.Make;
import com.datarak.vehiclemaintenancereminder.model.Makes;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleCursor;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleSelection;
import com.datarak.vehiclemaintenancereminder.scheduler.AndroidScheduler;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by raheel on 5/17/16.
 */
public class AddVehiclePresenter {
    private AddVehicleView view;
    final EdmundsApiService apiService;
    final AndroidScheduler scheduler;

    @Inject
    public AddVehiclePresenter(EdmundsApiService apiService, AndroidScheduler scheduler) {
        this.apiService = apiService;
        this.scheduler = scheduler;
    }

    private static int LATEST_YEAR = Calendar.getInstance().get(Calendar.YEAR) + 1;
    private static int EARLIEST_YEAR = 1980;

    public void bindView(AddVehicleView view){
        this.view = view;
        this.populateYears();
    }

    public void unbind(){
        this.view = null;
    }

    public void populateYears(){
        List<String> years = new ArrayList<String>();

        for (int i = LATEST_YEAR; i>=EARLIEST_YEAR; i--){
            years.add(String.valueOf(i));
        }

        view.populateYearSpinner(years);
    }

    public void onYearSelected(String year){
        apiService.getMakesByYear(year)
                .subscribeOn(scheduler.getNewThread())
                .observeOn(scheduler.getMainThread())
                .subscribe(new Subscriber<Makes>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onNext(Makes makes) {
                        view.populateMakeSpinner(makes.getMakes());
                    }
                });

    }

    public void onMakeSelected(Make make){
        view.populateModelSpinner(make.getModels());
    }

    public void checkStatus() {
                VehicleCursor cursor = new VehicleSelection().query(MaintenanceApp.getInstance().getContentResolver());
                if (cursor!=null && cursor.getCount()>0){
            cursor.moveToNext();
            view.hasVehicle(cursor.getId(), cursor.getLastRecordedMileage(), cursor.getMonthyMileage());
        }
    }


}
