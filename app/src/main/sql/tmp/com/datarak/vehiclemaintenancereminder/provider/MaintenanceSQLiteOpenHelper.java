package com.datarak.vehiclemaintenancereminder.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.datarak.vehiclemaintenancereminder.BuildConfig;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemColumns;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleColumns;

public class MaintenanceSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = MaintenanceSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "Maintenance.db";
    private static final int DATABASE_VERSION = 1;
    private static MaintenanceSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final MaintenanceSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_MAINTENANCE_ITEM = "CREATE TABLE IF NOT EXISTS "
            + MaintenanceItemColumns.TABLE_NAME + " ( "
            + MaintenanceItemColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MaintenanceItemColumns.ENGINE_CODE + " TEXT, "
            + MaintenanceItemColumns.TRANSMISSION_CODE + " TEXT, "
            + MaintenanceItemColumns.INTERVAL_MILEAGE + " INTEGER, "
            + MaintenanceItemColumns.FREQUENCY + " INTEGER, "
            + MaintenanceItemColumns.ACTION_ITEM + " TEXT, "
            + MaintenanceItemColumns.ITEM + " TEXT, "
            + MaintenanceItemColumns.ITEM_DESCRIPTION + " TEXT, "
            + MaintenanceItemColumns.LABOR_UNITS + " INTEGER, "
            + MaintenanceItemColumns.PART_UNITS + " INTEGER, "
            + MaintenanceItemColumns.DRIVE_TYPE + " TEXT, "
            + MaintenanceItemColumns.MODEL_YEAR + " TEXT, "
            + MaintenanceItemColumns.PART_COST_PER_UNIT + " REAL, "
            + MaintenanceItemColumns.INTERVAL_MONTH + " INTEGER, "
            + MaintenanceItemColumns.NOTE1 + " TEXT, "
            + MaintenanceItemColumns.IS_SCHEDULED + " INTEGER, "
            + MaintenanceItemColumns.VEHICLE_ID + " INTEGER, "
            + MaintenanceItemColumns.MAINTENANCE_DATE + " INTEGER "
            + ", CONSTRAINT fk_vehicle_id FOREIGN KEY (" + MaintenanceItemColumns.VEHICLE_ID + ") REFERENCES vehicle (_id) ON DELETE CASCADE"
            + " );";

    public static final String SQL_CREATE_TABLE_VEHICLE = "CREATE TABLE IF NOT EXISTS "
            + VehicleColumns.TABLE_NAME + " ( "
            + VehicleColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VehicleColumns.VEHICLE_ID + " INTEGER, "
            + VehicleColumns.VEHICLE_YEAR + " TEXT, "
            + VehicleColumns.VEHICLE_MAKE + " TEXT, "
            + VehicleColumns.VEHICLE_MODEL + " TEXT, "
            + VehicleColumns.LAST_RECORDED_MILEAGE + " INTEGER, "
            + VehicleColumns.MONTHY_MILEAGE + " INTEGER "
            + " );";

    // @formatter:on

    public static MaintenanceSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static MaintenanceSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static MaintenanceSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new MaintenanceSQLiteOpenHelper(context);
    }

    private MaintenanceSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new MaintenanceSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static MaintenanceSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new MaintenanceSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private MaintenanceSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new MaintenanceSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_MAINTENANCE_ITEM);
        db.execSQL(SQL_CREATE_TABLE_VEHICLE);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
