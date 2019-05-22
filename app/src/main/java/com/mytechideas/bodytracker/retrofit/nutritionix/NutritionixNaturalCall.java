
package com.mytechideas.bodytracker.retrofit.nutritionix;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NutritionixNaturalCall {

    @SerializedName("foods")
    @Expose
    private List<Food> foods = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NutritionixNaturalCall() {
    }

    /**
     * 
     * @param foods
     */
    public NutritionixNaturalCall(List<Food> foods) {
        super();
        this.foods = foods;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

}
