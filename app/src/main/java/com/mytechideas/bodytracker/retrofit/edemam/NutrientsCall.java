
package com.mytechideas.bodytracker.retrofit.edemam;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NutrientsCall {

    @SerializedName("ingredients")
    @Expose
    private List<Ingredients> ingredients = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NutrientsCall() {
    }

    /**
     * 
     * @param ingredients
     */
    public NutrientsCall(List<Ingredients> ingredients) {
        super();
        this.ingredients = ingredients;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

}
