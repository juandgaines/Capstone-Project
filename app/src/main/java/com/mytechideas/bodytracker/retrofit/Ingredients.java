package com.mytechideas.bodytracker.retrofit;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredients {

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("measureURI")
    @Expose
    private String measureURI;
    @SerializedName("foodId")
    @Expose
    private String foodId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ingredients() {
    }

    /**
     * 
     * @param foodId
     * @param measureURI
     * @param quantity
     */
    public Ingredients(Integer quantity, String measureURI, String foodId) {
        super();
        this.quantity = quantity;
        this.measureURI = measureURI;
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMeasureURI() {
        return measureURI;
    }

    public void setMeasureURI(String measureURI) {
        this.measureURI = measureURI;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

}
