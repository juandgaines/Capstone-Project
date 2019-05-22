
package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata_ {

    @SerializedName("is_raw_food")
    @Expose
    private Boolean isRawFood;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metadata_() {
    }

    /**
     * 
     * @param isRawFood
     */
    public Metadata_(Boolean isRawFood) {
        super();
        this.isRawFood = isRawFood;
    }

    public Boolean getIsRawFood() {
        return isRawFood;
    }

    public void setIsRawFood(Boolean isRawFood) {
        this.isRawFood = isRawFood;
    }

}
