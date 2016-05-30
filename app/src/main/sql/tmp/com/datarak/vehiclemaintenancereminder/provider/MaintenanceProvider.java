package com.datarak.vehiclemaintenancereminder.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.datarak.vehiclemaintenancereminder.BuildConfig;
import com.datarak.vehiclemaintenancereminder.provider.base.BaseContentProvider;
import com.datarak.vehiclemaintenancereminder.provider.maintenanceitem.MaintenanceItemColumns;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.VehicleColumns;

public class MaintenanceProvider extends BaseContentProvider {
    private static final String TAG = MaintenanceProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "com.datarak.vehiclemaintenancereminder.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_MAINTENANCE_ITEM = 0;
    private static final int URI_TYPE_MAINTENANCE_ITEM_ID = 1;

    private static final int URI_TYPE_VEHICLE = 2;
    private static final int URI_TYPE_VEHICLE_ID = 3;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, MaintenanceItemColumns.TABLE_NAME, URI_TYPE_MAINTENANCE_ITEM);
        URI_MATCHER.addURI(AUTHORITY, MaintenanceItemColumns.TABLE_NAME + "/#", URI_TYPE_MAINTENANCE_ITEM_ID);
        URI_MATCHER.addURI(AUTHORITY, VehicleColumns.TABLE_NAME, URI_TYPE_VEHICLE);
        URI_MATCHER.addURI(AUTHORITY, VehicleColumns.TABLE_NAME + "/#", URI_TYPE_VEHICLE_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return MaintenanceSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_MAINTENANCE_ITEM:
                return TYPE_CURSOR_DIR + MaintenanceItemColumns.TABLE_NAME;
            case URI_TYPE_MAINTENANCE_ITEM_ID:
                return TYPE_CURSOR_ITEM + MaintenanceItemColumns.TABLE_NAME;

            case URI_TYPE_VEHICLE:
                return TYPE_CURSOR_DIR + VehicleColumns.TABLE_NAME;
            case URI_TYPE_VEHICLE_ID:
                return TYPE_CURSOR_ITEM + VehicleColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_MAINTENANCE_ITEM:
            case URI_TYPE_MAINTENANCE_ITEM_ID:
                res.table = MaintenanceItemColumns.TABLE_NAME;
                res.idColumn = MaintenanceItemColumns._ID;
                res.tablesWithJoins = MaintenanceItemColumns.TABLE_NAME;
                if (VehicleColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + VehicleColumns.TABLE_NAME + " AS " + MaintenanceItemColumns.PREFIX_VEHICLE + " ON " + MaintenanceItemColumns.TABLE_NAME + "." + MaintenanceItemColumns.VEHICLE_ID + "=" + MaintenanceItemColumns.PREFIX_VEHICLE + "." + VehicleColumns._ID;
                }
                res.orderBy = MaintenanceItemColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_VEHICLE:
            case URI_TYPE_VEHICLE_ID:
                res.table = VehicleColumns.TABLE_NAME;
                res.idColumn = VehicleColumns._ID;
                res.tablesWithJoins = VehicleColumns.TABLE_NAME;
                res.orderBy = VehicleColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_MAINTENANCE_ITEM_ID:
            case URI_TYPE_VEHICLE_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
