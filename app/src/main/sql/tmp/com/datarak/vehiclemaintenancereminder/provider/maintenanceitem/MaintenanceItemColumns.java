package com.datarak.vehiclemaintenancereminder.provider.maintenanceitem;

import android.net.Uri;
import android.provider.BaseColumns;

import com.datarak.vehiclemaintenancereminder.provider.MaintenanceProvider;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemColumns;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleColumns;

/**
 * Columns for the {@code maintenance_item} table.
 */
public class MaintenanceItemColumns implements BaseColumns {
    public static final String TABLE_NAME = "maintenance_item";
    public static final Uri CONTENT_URI = Uri.parse(MaintenanceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String ENGINE_CODE = "engine_code";

    public static final String TRANSMISSION_CODE = "transmission_code";

    public static final String INTERVAL_MILEAGE = "interval_mileage";

    public static final String FREQUENCY = "frequency";

    public static final String ACTION_ITEM = "action_item";

    public static final String ITEM = "item";

    public static final String ITEM_DESCRIPTION = "item_description";

    public static final String LABOR_UNITS = "labor_units";

    public static final String PART_UNITS = "part_units";

    public static final String DRIVE_TYPE = "drive_type";

    public static final String MODEL_YEAR = "model_year";

    public static final String PART_COST_PER_UNIT = "part_cost_per_unit";

    public static final String INTERVAL_MONTH = "interval_month";

    public static final String NOTE1 = "note1";

    public static final String IS_SCHEDULED = "is_scheduled";

    public static final String VEHICLE_ID = "maintenance_item__vehicle_id";

    public static final String MAINTENANCE_DATE = "maintenance_date";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            ENGINE_CODE,
            TRANSMISSION_CODE,
            INTERVAL_MILEAGE,
            FREQUENCY,
            ACTION_ITEM,
            ITEM,
            ITEM_DESCRIPTION,
            LABOR_UNITS,
            PART_UNITS,
            DRIVE_TYPE,
            MODEL_YEAR,
            PART_COST_PER_UNIT,
            INTERVAL_MONTH,
            NOTE1,
            IS_SCHEDULED,
            VEHICLE_ID,
            MAINTENANCE_DATE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ENGINE_CODE) || c.contains("." + ENGINE_CODE)) return true;
            if (c.equals(TRANSMISSION_CODE) || c.contains("." + TRANSMISSION_CODE)) return true;
            if (c.equals(INTERVAL_MILEAGE) || c.contains("." + INTERVAL_MILEAGE)) return true;
            if (c.equals(FREQUENCY) || c.contains("." + FREQUENCY)) return true;
            if (c.equals(ACTION_ITEM) || c.contains("." + ACTION_ITEM)) return true;
            if (c.equals(ITEM) || c.contains("." + ITEM)) return true;
            if (c.equals(ITEM_DESCRIPTION) || c.contains("." + ITEM_DESCRIPTION)) return true;
            if (c.equals(LABOR_UNITS) || c.contains("." + LABOR_UNITS)) return true;
            if (c.equals(PART_UNITS) || c.contains("." + PART_UNITS)) return true;
            if (c.equals(DRIVE_TYPE) || c.contains("." + DRIVE_TYPE)) return true;
            if (c.equals(MODEL_YEAR) || c.contains("." + MODEL_YEAR)) return true;
            if (c.equals(PART_COST_PER_UNIT) || c.contains("." + PART_COST_PER_UNIT)) return true;
            if (c.equals(INTERVAL_MONTH) || c.contains("." + INTERVAL_MONTH)) return true;
            if (c.equals(NOTE1) || c.contains("." + NOTE1)) return true;
            if (c.equals(IS_SCHEDULED) || c.contains("." + IS_SCHEDULED)) return true;
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(MAINTENANCE_DATE) || c.contains("." + MAINTENANCE_DATE)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE = TABLE_NAME + "__" + VehicleColumns.TABLE_NAME;
}
