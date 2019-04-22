
package com.mytechideas.bodytracker.retrofit.edemam;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodAPI{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("parsed")
    @Expose
    private List<Object> parsed = null;
    @SerializedName("hints")
    @Expose
    private List<Hint> hints = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FoodAPI() {
    }

    /**
     * 
     * @param text
     * @param parsed
     * @param hints
     */
    public FoodAPI(String text, List<Object> parsed, List<Hint> hints) {
        super();
        this.text = text;
        this.parsed = parsed;
        this.hints = hints;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Object> getParsed() {
        return parsed;
    }

    public void setParsed(List<Object> parsed) {
        this.parsed = parsed;
    }

    public List<Hint> getHints() {
        return hints;
    }

    public void setHints(List<Hint> hints) {
        this.hints = hints;
    }

}
