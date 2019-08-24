package com.mytechideas.bodytracker.retrofit.edemam;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseNutrient{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public BaseNutrient(){

    }

    public BaseNutrient(String label, Double quantity, String unit) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getLabel() {
        return label;
    }

    public String getUnit() {
        return unit;
    }

}
