
package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AltMeasure {

    @SerializedName("serving_weight")
    @Expose
    private Double servingWeight;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("seq")
    @Expose
    private Integer seq;
    @SerializedName("qty")
    @Expose
    private Integer qty;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AltMeasure() {
    }

    /**
     * 
     * @param measure
     * @param seq
     * @param qty
     * @param servingWeight
     */
    public AltMeasure(Double servingWeight, String measure, Integer seq, Integer qty) {
        super();
        this.servingWeight = servingWeight;
        this.measure = measure;
        this.seq = seq;
        this.qty = qty;
    }

    public Double getServingWeight() {
        return servingWeight;
    }

    public void setServingWeight(Double servingWeight) {
        this.servingWeight = servingWeight;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}
