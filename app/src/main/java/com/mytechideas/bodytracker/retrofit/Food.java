
package com.mytechideas.bodytracker.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("foodId")
    @Expose
    private String foodId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("nutrients")
    @Expose
    private Nutrients nutrients;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("categoryLabel")
    @Expose
    private String categoryLabel;
    @SerializedName("foodContentsLabel")
    @Expose
    private String foodContentsLabel;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Food() {
    }

    /**
     * 
     * @param nutrients
     * @param foodId
     * @param category
     * @param foodContentsLabel
     * @param categoryLabel
     * @param image
     * @param brand
     * @param label
     */
    public Food(String foodId, String label, Nutrients nutrients, String brand, String category, String categoryLabel, String foodContentsLabel, String image) {
        super();
        this.foodId = foodId;
        this.label = label;
        this.nutrients = nutrients;
        this.brand = brand;
        this.category = category;
        this.categoryLabel = categoryLabel;
        this.foodContentsLabel = foodContentsLabel;
        this.image = image;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getFoodContentsLabel() {
        return foodContentsLabel;
    }

    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
