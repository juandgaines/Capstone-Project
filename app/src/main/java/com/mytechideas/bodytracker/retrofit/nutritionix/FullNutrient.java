
package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FullNutrient {

    @SerializedName("attr_id")
    @Expose
    private Integer attrId;
    @SerializedName("value")
    @Expose
    private Float value;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FullNutrient() {
    }

    /**
     * 
     * @param attrId
     * @param value
     */
    public FullNutrient(Integer attrId, Float value) {
        super();
        this.attrId = attrId;
        this.value = value;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

}
