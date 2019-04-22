
package com.mytechideas.bodytracker.retrofit.edemam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parsed {

    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("food")
    @Expose
    private String food;
    @SerializedName("foodId")
    @Expose
    private String foodId;
    @SerializedName("foodContentsLabel")
    @Expose
    private String foodContentsLabel;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("retainedWeight")
    @Expose
    private Double retainedWeight;
    @SerializedName("measureURI")
    @Expose
    private String measureURI;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Parsed() {
    }

    /**
     * 
     * @param retainedWeight
     * @param foodId
     * @param weight
     * @param foodContentsLabel
     * @param measure
     * @param status
     * @param food
     * @param measureURI
     * @param quantity
     */
    public Parsed(Double quantity, String measure, String food, String foodId, String foodContentsLabel, Double weight, Double retainedWeight, String measureURI, String status) {
        super();
        this.quantity = quantity;
        this.measure = measure;
        this.food = food;
        this.foodId = foodId;
        this.foodContentsLabel = foodContentsLabel;
        this.weight = weight;
        this.retainedWeight = retainedWeight;
        this.measureURI = measureURI;
        this.status = status;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodContentsLabel() {
        return foodContentsLabel;
    }

    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getRetainedWeight() {
        return retainedWeight;
    }

    public void setRetainedWeight(Double retainedWeight) {
        this.retainedWeight = retainedWeight;
    }

    public String getMeasureURI() {
        return measureURI;
    }

    public void setMeasureURI(String measureURI) {
        this.measureURI = measureURI;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
