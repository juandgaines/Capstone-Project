
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mytechideas.bodytracker.retrofit.Recipe;

public class Hit {

    @SerializedName("recipe")
    @Expose
    private Recipe recipe;
    @SerializedName("bookmarked")
    @Expose
    private Boolean bookmarked;
    @SerializedName("bought")
    @Expose
    private Boolean bought;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hit() {
    }

    /**
     * 
     * @param recipe
     * @param bought
     * @param bookmarked
     */
    public Hit(Recipe recipe, Boolean bookmarked, Boolean bought) {
        super();
        this.recipe = recipe;
        this.bookmarked = bookmarked;
        this.bought = bought;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

}
