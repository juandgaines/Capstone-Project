
package com.mytechideas.bodytracker.retrofit.nutritionix;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mytechideas.bodytracker.retrofit.edemam.Food;


public class NutritionixUPCCall {

    @SerializedName("foods")
    @Expose
    private List<Foods> foods = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NutritionixUPCCall() {
    }

    /**
     * 
     * @param foods
     */
    public NutritionixUPCCall(List<Foods> foods) {
        super();
        this.foods = foods;
    }

    public List<Foods> getFoods() {
        return foods;
    }

    public void setFoods(List<Foods> foods) {
        this.foods = foods;
    }

}
