package com.datarak.vehiclemaintenancereminder.views;

import com.datarak.vehiclemaintenancereminder.model.Make;
import com.datarak.vehiclemaintenancereminder.model.Model;

import java.util.List;

/**
 * Created by raheel on 5/18/16.
 */
public interface AddVehicleView {
    void populateYearSpinner(List<String> years);
    void populateMakeSpinner(List<Make> makes);
    void populateModelSpinner(List<Model> models);
}
