package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.annotations.SerializedName;

public class TextQuery {

    @SerializedName("query")
    private String query;

    public TextQuery(){}

    public TextQuery(String query){
        this.query=query;

    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
