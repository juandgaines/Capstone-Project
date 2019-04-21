
package com.mytechideas.bodytracker.retrofit;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hint {

    @SerializedName("food")
    @Expose
    private Food food;
    @SerializedName("measures")
    @Expose
    private List<Measure> measures = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hint() {
    }

    /**
     * 
     * @param food
     * @param measures
     */
    public Hint(Food food, List<Measure> measures) {
        super();
        this.food = food;
        this.measures = measures;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

}
