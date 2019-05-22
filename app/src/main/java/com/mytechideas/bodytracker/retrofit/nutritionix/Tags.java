
package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tags {

    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("food_group")
    @Expose
    private Integer foodGroup;
    @SerializedName("tag_id")
    @Expose
    private Integer tagId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tags() {
    }

    /**
     * 
     * @param measure
     * @param item
     * @param foodGroup
     * @param quantity
     * @param tagId
     */
    public Tags(String item, String measure, String quantity, Integer foodGroup, Integer tagId) {
        super();
        this.item = item;
        this.measure = measure;
        this.quantity = quantity;
        this.foodGroup = foodGroup;
        this.tagId = tagId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(Integer foodGroup) {
        this.foodGroup = foodGroup;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

}
