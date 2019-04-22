
package com.mytechideas.bodytracker.retrofit.edemam;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IngredientResponse {

    @SerializedName("parsed")
    @Expose
    private List<Parsed> parsed = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngredientResponse() {
    }

    /**
     * 
     * @param parsed
     */
    public IngredientResponse(List<Parsed> parsed) {
        super();
        this.parsed = parsed;
    }

    public List<Parsed> getParsed() {
        return parsed;
    }

    public void setParsed(List<Parsed> parsed) {
        this.parsed = parsed;
    }

}
