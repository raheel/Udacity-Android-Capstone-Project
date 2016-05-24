package com.datarak.vehiclemaintenancereminder.views;

import com.datarak.vehiclemaintenancereminder.model.MaintenanceItem;

import java.util.List;

/**
 * Created by raheel on 5/19/16.
 */
public interface ShowMaintenanceScheduleView {
    void displayItems(List<MaintenanceItem> items);
    void noVehicles();
}
