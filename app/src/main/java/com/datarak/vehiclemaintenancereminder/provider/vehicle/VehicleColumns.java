package com.datarak.vehiclemaintenancereminder.provider.vehicle;

import android.net.Uri;
import android.provider.BaseColumns;

import com.datarak.vehiclemaintenancereminder.provider.MaintenanceProvider;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemColumns;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleColumns;

/**
 * Columns for the {@code vehicle} table.
 */
public class VehicleColumns implements BaseColumns {
    public static final String TABLE_NAME = "vehicle";
    public static final Uri CONTENT_URI = Uri.parse(MaintenanceProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String VEHICLE_ID = "vehicle__vehicle_id";

    public static final String VEHICLE_YEAR = "vehicle_year";

    public static final String VEHICLE_MAKE = "vehicle_make";

    public static final String VEHICLE_MODEL = "vehicle_model";

    public static final String LAST_RECORDED_MILEAGE = "last_recorded_mileage";

    public static final String MONTHY_MILEAGE = "monthy_mileage";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_ID,
            VEHICLE_YEAR,
            VEHICLE_MAKE,
            VEHICLE_MODEL,
            LAST_RECORDED_MILEAGE,
            MONTHY_MILEAGE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(VEHICLE_YEAR) || c.contains("." + VEHICLE_YEAR)) return true;
            if (c.equals(VEHICLE_MAKE) || c.contains("." + VEHICLE_MAKE)) return true;
            if (c.equals(VEHICLE_MODEL) || c.contains("." + VEHICLE_MODEL)) return true;
            if (c.equals(LAST_RECORDED_MILEAGE) || c.contains("." + LAST_RECORDED_MILEAGE)) return true;
            if (c.equals(MONTHY_MILEAGE) || c.contains("." + MONTHY_MILEAGE)) return true;
        }
        return false;
    }

}
