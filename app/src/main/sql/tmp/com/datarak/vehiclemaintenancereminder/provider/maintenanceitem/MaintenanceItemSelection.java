package com.datarak.vehiclemaintenancereminder.provider.maintenanceitem;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.datarak.vehiclemaintenancereminder.provider.base.AbstractSelection;
import com.datarak.vehiclemaintenancereminder.provider.vehicle.*;

/**
 * Selection for the {@code maintenance_item} table.
 */
public class MaintenanceItemSelection extends AbstractSelection<MaintenanceItemSelection> {
    @Override
    protected Uri baseUri() {
        return MaintenanceItemColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MaintenanceItemCursor} object, which is positioned before the first entry, or null.
     */
    public MaintenanceItemCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MaintenanceItemCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MaintenanceItemCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MaintenanceItemCursor} object, which is positioned before the first entry, or null.
     */
    public MaintenanceItemCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MaintenanceItemCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MaintenanceItemCursor query(Context context) {
        return query(context, null);
    }


    public MaintenanceItemSelection id(long... value) {
        addEquals("maintenance_item." + MaintenanceItemColumns._ID, toObjectArray(value));
        return this;
    }

    public MaintenanceItemSelection idNot(long... value) {
        addNotEquals("maintenance_item." + MaintenanceItemColumns._ID, toObjectArray(value));
        return this;
    }

    public MaintenanceItemSelection orderById(boolean desc) {
        orderBy("maintenance_item." + MaintenanceItemColumns._ID, desc);
        return this;
    }

    public MaintenanceItemSelection orderById() {
        return orderById(false);
    }

    public MaintenanceItemSelection engineCode(String... value) {
        addEquals(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemSelection engineCodeNot(String... value) {
        addNotEquals(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemSelection engineCodeLike(String... value) {
        addLike(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemSelection engineCodeContains(String... value) {
        addContains(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemSelection engineCodeStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemSelection engineCodeEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.ENGINE_CODE, value);
        return this;
    }

    public MaintenanceItemSelection orderByEngineCode(boolean desc) {
        orderBy(MaintenanceItemColumns.ENGINE_CODE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByEngineCode() {
        orderBy(MaintenanceItemColumns.ENGINE_CODE, false);
        return this;
    }

    public MaintenanceItemSelection transmissionCode(String... value) {
        addEquals(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemSelection transmissionCodeNot(String... value) {
        addNotEquals(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemSelection transmissionCodeLike(String... value) {
        addLike(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemSelection transmissionCodeContains(String... value) {
        addContains(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemSelection transmissionCodeStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemSelection transmissionCodeEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.TRANSMISSION_CODE, value);
        return this;
    }

    public MaintenanceItemSelection orderByTransmissionCode(boolean desc) {
        orderBy(MaintenanceItemColumns.TRANSMISSION_CODE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByTransmissionCode() {
        orderBy(MaintenanceItemColumns.TRANSMISSION_CODE, false);
        return this;
    }

    public MaintenanceItemSelection intervalMileage(Integer... value) {
        addEquals(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection intervalMileageNot(Integer... value) {
        addNotEquals(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection intervalMileageGt(int value) {
        addGreaterThan(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection intervalMileageGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection intervalMileageLt(int value) {
        addLessThan(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection intervalMileageLtEq(int value) {
        addLessThanOrEquals(MaintenanceItemColumns.INTERVAL_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection orderByIntervalMileage(boolean desc) {
        orderBy(MaintenanceItemColumns.INTERVAL_MILEAGE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByIntervalMileage() {
        orderBy(MaintenanceItemColumns.INTERVAL_MILEAGE, false);
        return this;
    }

    public MaintenanceItemSelection frequency(Integer... value) {
        addEquals(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemSelection frequencyNot(Integer... value) {
        addNotEquals(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemSelection frequencyGt(int value) {
        addGreaterThan(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemSelection frequencyGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemSelection frequencyLt(int value) {
        addLessThan(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemSelection frequencyLtEq(int value) {
        addLessThanOrEquals(MaintenanceItemColumns.FREQUENCY, value);
        return this;
    }

    public MaintenanceItemSelection orderByFrequency(boolean desc) {
        orderBy(MaintenanceItemColumns.FREQUENCY, desc);
        return this;
    }

    public MaintenanceItemSelection orderByFrequency() {
        orderBy(MaintenanceItemColumns.FREQUENCY, false);
        return this;
    }

    public MaintenanceItemSelection actionItem(String... value) {
        addEquals(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemSelection actionItemNot(String... value) {
        addNotEquals(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemSelection actionItemLike(String... value) {
        addLike(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemSelection actionItemContains(String... value) {
        addContains(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemSelection actionItemStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemSelection actionItemEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.ACTION_ITEM, value);
        return this;
    }

    public MaintenanceItemSelection orderByActionItem(boolean desc) {
        orderBy(MaintenanceItemColumns.ACTION_ITEM, desc);
        return this;
    }

    public MaintenanceItemSelection orderByActionItem() {
        orderBy(MaintenanceItemColumns.ACTION_ITEM, false);
        return this;
    }

    public MaintenanceItemSelection item(String... value) {
        addEquals(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemSelection itemNot(String... value) {
        addNotEquals(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemSelection itemLike(String... value) {
        addLike(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemSelection itemContains(String... value) {
        addContains(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemSelection itemStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemSelection itemEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.ITEM, value);
        return this;
    }

    public MaintenanceItemSelection orderByItem(boolean desc) {
        orderBy(MaintenanceItemColumns.ITEM, desc);
        return this;
    }

    public MaintenanceItemSelection orderByItem() {
        orderBy(MaintenanceItemColumns.ITEM, false);
        return this;
    }

    public MaintenanceItemSelection itemDescription(String... value) {
        addEquals(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemSelection itemDescriptionNot(String... value) {
        addNotEquals(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemSelection itemDescriptionLike(String... value) {
        addLike(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemSelection itemDescriptionContains(String... value) {
        addContains(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemSelection itemDescriptionStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemSelection itemDescriptionEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.ITEM_DESCRIPTION, value);
        return this;
    }

    public MaintenanceItemSelection orderByItemDescription(boolean desc) {
        orderBy(MaintenanceItemColumns.ITEM_DESCRIPTION, desc);
        return this;
    }

    public MaintenanceItemSelection orderByItemDescription() {
        orderBy(MaintenanceItemColumns.ITEM_DESCRIPTION, false);
        return this;
    }

    public MaintenanceItemSelection laborUnits(Integer... value) {
        addEquals(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection laborUnitsNot(Integer... value) {
        addNotEquals(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection laborUnitsGt(int value) {
        addGreaterThan(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection laborUnitsGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection laborUnitsLt(int value) {
        addLessThan(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection laborUnitsLtEq(int value) {
        addLessThanOrEquals(MaintenanceItemColumns.LABOR_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection orderByLaborUnits(boolean desc) {
        orderBy(MaintenanceItemColumns.LABOR_UNITS, desc);
        return this;
    }

    public MaintenanceItemSelection orderByLaborUnits() {
        orderBy(MaintenanceItemColumns.LABOR_UNITS, false);
        return this;
    }

    public MaintenanceItemSelection partUnits(Integer... value) {
        addEquals(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection partUnitsNot(Integer... value) {
        addNotEquals(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection partUnitsGt(int value) {
        addGreaterThan(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection partUnitsGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection partUnitsLt(int value) {
        addLessThan(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection partUnitsLtEq(int value) {
        addLessThanOrEquals(MaintenanceItemColumns.PART_UNITS, value);
        return this;
    }

    public MaintenanceItemSelection orderByPartUnits(boolean desc) {
        orderBy(MaintenanceItemColumns.PART_UNITS, desc);
        return this;
    }

    public MaintenanceItemSelection orderByPartUnits() {
        orderBy(MaintenanceItemColumns.PART_UNITS, false);
        return this;
    }

    public MaintenanceItemSelection driveType(String... value) {
        addEquals(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemSelection driveTypeNot(String... value) {
        addNotEquals(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemSelection driveTypeLike(String... value) {
        addLike(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemSelection driveTypeContains(String... value) {
        addContains(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemSelection driveTypeStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemSelection driveTypeEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.DRIVE_TYPE, value);
        return this;
    }

    public MaintenanceItemSelection orderByDriveType(boolean desc) {
        orderBy(MaintenanceItemColumns.DRIVE_TYPE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByDriveType() {
        orderBy(MaintenanceItemColumns.DRIVE_TYPE, false);
        return this;
    }

    public MaintenanceItemSelection modelYear(String... value) {
        addEquals(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection modelYearNot(String... value) {
        addNotEquals(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection modelYearLike(String... value) {
        addLike(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection modelYearContains(String... value) {
        addContains(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection modelYearStartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection modelYearEndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.MODEL_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection orderByModelYear(boolean desc) {
        orderBy(MaintenanceItemColumns.MODEL_YEAR, desc);
        return this;
    }

    public MaintenanceItemSelection orderByModelYear() {
        orderBy(MaintenanceItemColumns.MODEL_YEAR, false);
        return this;
    }

    public MaintenanceItemSelection partCostPerUnit(Double... value) {
        addEquals(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemSelection partCostPerUnitNot(Double... value) {
        addNotEquals(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemSelection partCostPerUnitGt(double value) {
        addGreaterThan(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemSelection partCostPerUnitGtEq(double value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemSelection partCostPerUnitLt(double value) {
        addLessThan(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemSelection partCostPerUnitLtEq(double value) {
        addLessThanOrEquals(MaintenanceItemColumns.PART_COST_PER_UNIT, value);
        return this;
    }

    public MaintenanceItemSelection orderByPartCostPerUnit(boolean desc) {
        orderBy(MaintenanceItemColumns.PART_COST_PER_UNIT, desc);
        return this;
    }

    public MaintenanceItemSelection orderByPartCostPerUnit() {
        orderBy(MaintenanceItemColumns.PART_COST_PER_UNIT, false);
        return this;
    }

    public MaintenanceItemSelection intervalMonth(Integer... value) {
        addEquals(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemSelection intervalMonthNot(Integer... value) {
        addNotEquals(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemSelection intervalMonthGt(int value) {
        addGreaterThan(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemSelection intervalMonthGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemSelection intervalMonthLt(int value) {
        addLessThan(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemSelection intervalMonthLtEq(int value) {
        addLessThanOrEquals(MaintenanceItemColumns.INTERVAL_MONTH, value);
        return this;
    }

    public MaintenanceItemSelection orderByIntervalMonth(boolean desc) {
        orderBy(MaintenanceItemColumns.INTERVAL_MONTH, desc);
        return this;
    }

    public MaintenanceItemSelection orderByIntervalMonth() {
        orderBy(MaintenanceItemColumns.INTERVAL_MONTH, false);
        return this;
    }

    public MaintenanceItemSelection note1(String... value) {
        addEquals(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemSelection note1Not(String... value) {
        addNotEquals(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemSelection note1Like(String... value) {
        addLike(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemSelection note1Contains(String... value) {
        addContains(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemSelection note1StartsWith(String... value) {
        addStartsWith(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemSelection note1EndsWith(String... value) {
        addEndsWith(MaintenanceItemColumns.NOTE1, value);
        return this;
    }

    public MaintenanceItemSelection orderByNote1(boolean desc) {
        orderBy(MaintenanceItemColumns.NOTE1, desc);
        return this;
    }

    public MaintenanceItemSelection orderByNote1() {
        orderBy(MaintenanceItemColumns.NOTE1, false);
        return this;
    }

    public MaintenanceItemSelection isScheduled(Boolean value) {
        addEquals(MaintenanceItemColumns.IS_SCHEDULED, toObjectArray(value));
        return this;
    }

    public MaintenanceItemSelection orderByIsScheduled(boolean desc) {
        orderBy(MaintenanceItemColumns.IS_SCHEDULED, desc);
        return this;
    }

    public MaintenanceItemSelection orderByIsScheduled() {
        orderBy(MaintenanceItemColumns.IS_SCHEDULED, false);
        return this;
    }

    public MaintenanceItemSelection vehicleId(Integer... value) {
        addEquals(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleIdNot(Integer... value) {
        addNotEquals(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleIdGt(int value) {
        addGreaterThan(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleIdGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleIdLt(int value) {
        addLessThan(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleIdLtEq(int value) {
        addLessThanOrEquals(MaintenanceItemColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleId(boolean desc) {
        orderBy(MaintenanceItemColumns.VEHICLE_ID, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleId() {
        orderBy(MaintenanceItemColumns.VEHICLE_ID, false);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleId(Integer... value) {
        addEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleIdNot(Integer... value) {
        addNotEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleIdGt(int value) {
        addGreaterThan(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleIdGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleIdLt(int value) {
        addLessThan(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleIdLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleId(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_ID, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleId() {
        orderBy(VehicleColumns.VEHICLE_ID, false);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleYear(String... value) {
        addEquals(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleYearNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleYearLike(String... value) {
        addLike(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleYearContains(String... value) {
        addContains(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleYearStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleYearEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_YEAR, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleYear(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_YEAR, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleYear() {
        orderBy(VehicleColumns.VEHICLE_YEAR, false);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleMake(String... value) {
        addEquals(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleMakeNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleMakeLike(String... value) {
        addLike(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleMakeContains(String... value) {
        addContains(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleMakeStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleMakeEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_MAKE, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleMake(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_MAKE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleMake() {
        orderBy(VehicleColumns.VEHICLE_MAKE, false);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleModel(String... value) {
        addEquals(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleModelLike(String... value) {
        addLike(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleModelContains(String... value) {
        addContains(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public MaintenanceItemSelection vehicleVehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_MODEL, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleModel(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_MODEL, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleVehicleModel() {
        orderBy(VehicleColumns.VEHICLE_MODEL, false);
        return this;
    }

    public MaintenanceItemSelection vehicleLastRecordedMileage(Integer... value) {
        addEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleLastRecordedMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleLastRecordedMileageGt(int value) {
        addGreaterThan(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleLastRecordedMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleLastRecordedMileageLt(int value) {
        addLessThan(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleLastRecordedMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.LAST_RECORDED_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleLastRecordedMileage(boolean desc) {
        orderBy(VehicleColumns.LAST_RECORDED_MILEAGE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleLastRecordedMileage() {
        orderBy(VehicleColumns.LAST_RECORDED_MILEAGE, false);
        return this;
    }

    public MaintenanceItemSelection vehicleMonthyMileage(Integer... value) {
        addEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleMonthyMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleMonthyMileageGt(int value) {
        addGreaterThan(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleMonthyMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleMonthyMileageLt(int value) {
        addLessThan(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection vehicleMonthyMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MONTHY_MILEAGE, value);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleMonthyMileage(boolean desc) {
        orderBy(VehicleColumns.MONTHY_MILEAGE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByVehicleMonthyMileage() {
        orderBy(VehicleColumns.MONTHY_MILEAGE, false);
        return this;
    }

    public MaintenanceItemSelection maintenanceDate(Date... value) {
        addEquals(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection maintenanceDateNot(Date... value) {
        addNotEquals(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection maintenanceDate(Long... value) {
        addEquals(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection maintenanceDateAfter(Date value) {
        addGreaterThan(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection maintenanceDateAfterEq(Date value) {
        addGreaterThanOrEquals(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection maintenanceDateBefore(Date value) {
        addLessThan(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection maintenanceDateBeforeEq(Date value) {
        addLessThanOrEquals(MaintenanceItemColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceItemSelection orderByMaintenanceDate(boolean desc) {
        orderBy(MaintenanceItemColumns.MAINTENANCE_DATE, desc);
        return this;
    }

    public MaintenanceItemSelection orderByMaintenanceDate() {
        orderBy(MaintenanceItemColumns.MAINTENANCE_DATE, false);
        return this;
    }
}
