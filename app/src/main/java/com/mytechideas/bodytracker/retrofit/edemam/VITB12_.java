
package com.mytechideas.bodytracker.retrofit.edemam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VITB12_ extends BaseNutrient{

    /**
     * No args constructor for use in serialization
     *
     */
    public VITB12_() {
    }

    /**
     *
     * @param unit
     * @param quantity
     * @param label
     */
    public VITB12_(String label, Double quantity, String unit) {
        super(label,quantity,unit);
    }

    public String getLabel() {
        return super.getLabel();
    }

    public void setLabel(String label) {
        super.setLabel(label);
    }

    public Double getQuantity() {
        return super.getQuantity();
    }

    public void setQuantity(Double quantity) {
        super.setQuantity(quantity);
    }

    public String getUnit() {
        return super.getUnit();
    }

    public void setUnit(String unit) {
        super.setUnit(unit);
    }

}