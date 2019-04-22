
package com.mytechideas.bodytracker.retrofit.edemam;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NutrientsCallResponse{

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("yield")
    @Expose
    private Double yield;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("totalWeight")
    @Expose
    private Double totalWeight;
    @SerializedName("dietLabels")
    @Expose
    private List<String> dietLabels = null;
    @SerializedName("healthLabels")
    @Expose
    private List<String> healthLabels = null;
    @SerializedName("cautions")
    @Expose
    private List<String> cautions = null;
    @SerializedName("totalNutrients")
    @Expose
    private TotalNutrientsCall totalNutrients;
    @SerializedName("totalDaily")
    @Expose
    private TotalDailyCall totalDaily;
    @SerializedName("ingredients")
    @Expose
    private List<IngredientResponse> ingredients = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NutrientsCallResponse() {
    }

    /**
     * 
     * @param ingredients
     * @param dietLabels
     * @param totalDaily
     * @param healthLabels
     * @param yield
     * @param totalWeight
     * @param cautions
     * @param totalNutrients
     * @param calories
     * @param uri
     */
    public NutrientsCallResponse(String uri, Double yield, Integer calories, Double totalWeight, List<String> dietLabels, List<String> healthLabels, List<String> cautions, TotalNutrientsCall totalNutrients, TotalDailyCall totalDaily, List<IngredientResponse> ingredients) {
        super();
        this.uri = uri;
        this.yield = yield;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.cautions = cautions;
        this.totalNutrients = totalNutrients;
        this.totalDaily = totalDaily;
        this.ingredients = ingredients;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public List<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public List<String> getCautions() {
        return cautions;
    }

    public void setCautions(List<String> cautions) {
        this.cautions = cautions;
    }

    public TotalNutrientsCall getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrientsCall totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDailyCall getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDailyCall totalDaily) {
        this.totalDaily = totalDaily;
    }

    public List<IngredientResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientResponse> ingredients) {
        this.ingredients = ingredients;
    }

}
