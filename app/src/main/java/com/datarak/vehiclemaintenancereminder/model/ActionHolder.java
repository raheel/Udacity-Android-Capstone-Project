
package com.datarak.vehiclemaintenancereminder.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ActionHolder {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("engineCode")
    @Expose
    private String engineCode;
    @SerializedName("transmissionCode")
    @Expose
    private String transmissionCode;
    @SerializedName("intervalMileage")
    @Expose
    private Long intervalMileage;
    @SerializedName("frequency")
    @Expose
    private Long frequency;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("itemDescription")
    @Expose
    private String itemDescription;
    @SerializedName("laborUnits")
    @Expose
    private Double laborUnits;
    @SerializedName("partUnits")
    @Expose
    private Double partUnits;
    @SerializedName("driveType")
    @Expose
    private String driveType;
    @SerializedName("modelYear")
    @Expose
    private String modelYear;
    @SerializedName("partCostPerUnit")
    @Expose
    private Double partCostPerUnit;
    @SerializedName("intervalMonth")
    @Expose
    private Long intervalMonth;
    @SerializedName("note1")
    @Expose
    private String note1;

    private String maintenanceDate;

    /**
     * 
     * @return
     *     The id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The engineCode
     */
    public String getEngineCode() {
        return engineCode;
    }

    /**
     * 
     * @param engineCode
     *     The engineCode
     */
    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }

    /**
     * 
     * @return
     *     The transmissionCode
     */
    public String getTransmissionCode() {
        return transmissionCode;
    }

    /**
     * 
     * @param transmissionCode
     *     The transmissionCode
     */
    public void setTransmissionCode(String transmissionCode) {
        this.transmissionCode = transmissionCode;
    }

    /**
     * 
     * @return
     *     The intervalMileage
     */
    public Long getIntervalMileage() {
        return intervalMileage;
    }

    /**
     * 
     * @param intervalMileage
     *     The intervalMileage
     */
    public void setIntervalMileage(Long intervalMileage) {
        this.intervalMileage = intervalMileage;
    }

    /**
     * 
     * @return
     *     The frequency
     */
    public Long getFrequency() {
        return frequency;
    }

    /**
     * 
     * @param frequency
     *     The frequency
     */
    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    /**
     * 
     * @return
     *     The action
     */
    public String getAction() {
        return action;
    }

    /**
     * 
     * @param action
     *     The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     * @return
     *     The item
     */
    public String getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * 
     * @return
     *     The itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * 
     * @param itemDescription
     *     The itemDescription
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * 
     * @return
     *     The laborUnits
     */
    public Double getLaborUnits() {
        return laborUnits;
    }

    /**
     * 
     * @param laborUnits
     *     The laborUnits
     */
    public void setLaborUnits(Double laborUnits) {
        this.laborUnits = laborUnits;
    }

    /**
     * 
     * @return
     *     The partUnits
     */
    public Double getPartUnits() {
        return partUnits;
    }

    /**
     * 
     * @param partUnits
     *     The partUnits
     */
    public void setPartUnits(Double partUnits) {
        this.partUnits = partUnits;
    }

    /**
     * 
     * @return
     *     The driveType
     */
    public String getDriveType() {
        return driveType;
    }

    /**
     * 
     * @param driveType
     *     The driveType
     */
    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    /**
     * 
     * @return
     *     The modelYear
     */
    public String getModelYear() {
        return modelYear;
    }

    /**
     * 
     * @param modelYear
     *     The modelYear
     */
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * 
     * @return
     *     The partCostPerUnit
     */
    public Double getPartCostPerUnit() {
        return partCostPerUnit;
    }

    /**
     * 
     * @param partCostPerUnit
     *     The partCostPerUnit
     */
    public void setPartCostPerUnit(Double partCostPerUnit) {
        this.partCostPerUnit = partCostPerUnit;
    }

    /**
     * 
     * @return
     *     The intervalMonth
     */
    public Long getIntervalMonth() {
        return intervalMonth;
    }

    /**
     * 
     * @param intervalMonth
     *     The intervalMonth
     */
    public void setIntervalMonth(Long intervalMonth) {
        this.intervalMonth = intervalMonth;
    }

    /**
     * 
     * @return
     *     The note1
     */
    public String getNote1() {
        return note1;
    }

    /**
     * 
     * @param note1
     *     The note1
     */
    public void setNote1(String note1) {
        this.note1 = note1;
    }


    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    @Override
    public String toString() {
        return "ActionHolder{" +
                "id=" + id +
                ", engineCode='" + engineCode + '\'' +
                ", transmissionCode='" + transmissionCode + '\'' +
                ", intervalMileage=" + intervalMileage +
                ", frequency=" + frequency +
                ", action='" + action + '\'' +
                ", item='" + item + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", laborUnits=" + laborUnits +
                ", partUnits=" + partUnits +
                ", driveType='" + driveType + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", partCostPerUnit=" + partCostPerUnit +
                ", intervalMonth=" + intervalMonth +
                ", note1='" + note1 + '\'' +
                '}';
    }


    public boolean isRepeat() {
        return frequency==4;
    }


    public MaintenanceItem getMaintenanceItem(){
        return new AutoValue_MaintenanceItem(-1l, engineCode, transmissionCode, intervalMileage, frequency,
                action, item, itemDescription, laborUnits, partUnits, driveType, modelYear, partCostPerUnit, intervalMonth, note1,
                false, false, id, maintenanceDate);
    }
}
