package com.datarak.vehiclemaintenancereminder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.datarak.vehiclemaintenancereminder.model.MaintenanceItem;
import com.datarak.vehiclemaintenancereminder.model.MaintenanceItemModel;
import com.datarak.vehiclemaintenancereminder.model.Vehicle;
import com.datarak.vehiclemaintenancereminder.model.VehicleModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by raheel on 5/21/16.
 */
public class VehicleDao extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "vehicles";
    private static final int DATABASE_VERSION = 1;


    @Inject
    public VehicleDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VehicleModel.CREATE_TABLE);
        db.execSQL(MaintenanceItemModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addVehicle(int vehicleId, String year, String make, String model, int lastRecordedMileage, int monthlyMileage){
        getWritableDatabase().insert(VehicleModel.TABLE_NAME, null,
                new VehicleModel.VehicleMarshal().
                        vehicle_id((long) vehicleId).
                        vehicle_year(year).
                        vehicle_make(make).
                        vehicle_model(model).
                        last_recorded_mileage((long) lastRecordedMileage).
                        monthy_mileage((long) monthlyMileage).
                        asContentValues()
        );
    }

    public void deleteVehicle(long vehicleId){
        getWritableDatabase().execSQL(Vehicle.DELETE_VEHICLE, new Object[] {vehicleId});
        getWritableDatabase().close();
    }

    public void deleteAllVehicles(){
        getWritableDatabase().execSQL(Vehicle.DELETE_ALL);
        getWritableDatabase().execSQL(MaintenanceItem.DELETE_ALL);
        getWritableDatabase().close();
    }


    public Vehicle getVehicle(){
        Vehicle vehicle = null;
        Cursor cursor = getReadableDatabase().rawQuery(VehicleModel.SELECT_ALL, null);
        while (cursor.moveToNext()){
            vehicle = Vehicle.MAPPER.map(cursor);
        }

        getReadableDatabase().close();

        return vehicle;
    }

    public List<MaintenanceItem> getAllMaintenance(){
        List<MaintenanceItem> items = new ArrayList<MaintenanceItem>();
        Cursor cursor = getReadableDatabase().rawQuery(MaintenanceItem.SELECT_ALL, null);
        while (cursor.moveToNext()){
            items.add(MaintenanceItem.MAPPER.map(cursor));
        }
        return items;
    }

    public List<MaintenanceItem> getAllMaintenance(String date){
        List<MaintenanceItem> items = new ArrayList<MaintenanceItem>();
        Cursor cursor = getReadableDatabase().rawQuery(MaintenanceItem.SELECT_TODAY_SCHEDULED, new String[]{date});
        while (cursor.moveToNext()){
            items.add(MaintenanceItem.MAPPER.map(cursor));
        }
        return items;
    }

    public void addMaintenance(MaintenanceItem item) {
        getWritableDatabase().insert(MaintenanceItem.TABLE_NAME, null,
                new MaintenanceItemModel.MaintenanceItemMarshal().
                    vehicle_id(item.vehicle_id()).
                        engine_code(item.engine_code()).
                        transmission_code(item.transmission_code()).
                        interval_mileage(item.interval_mileage()).
                        frequency(item.frequency()).
                        action_item(item.action_item()).
                        item(item.item()).
                        item_description(item.item_description()).
                        labor_units(item.labor_units()).
                        part_units(item.part_units()).
                        drive_type(item.drive_type()).
                        model_year(item.model_year()).
                        part_cost_per_unit(item.part_cost_per_unit()).
                        interval_month(item.interval_month()).
                        note1(item.note1()).
                        is_scheduled(item.is_scheduled()).
                        is_recurring(item.is_recurring()).
                        maintenance_date(item.maintenance_date()).
                        asContentValues());

        getWritableDatabase().close();
    }

    public void scheduleMaintenance(long id, boolean isRecurring){
        SQLiteStatement statement = getWritableDatabase().compileStatement(MaintenanceItem.SCHEDULE_ITEM);
        try {
            statement.bindLong(1, 1);
            statement.bindLong(2, isRecurring ? 1 : 0);
            statement.bindLong(3, id);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getWritableDatabase().close();
    }

    public void removeMaintenance(long id, boolean isRecurring){
        SQLiteStatement statement = getWritableDatabase().compileStatement(MaintenanceItem.SCHEDULE_ITEM);
        try {
            statement.bindLong(1, 0);
            statement.bindLong(2, 0);
            statement.bindLong(3, id);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getWritableDatabase().close();
    }
}

