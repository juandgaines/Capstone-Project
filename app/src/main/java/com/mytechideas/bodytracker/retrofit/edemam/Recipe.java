
package com.mytechideas.bodytracker.retrofit.edemam;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shareAs")
    @Expose
    private String shareAs;
    @SerializedName("yield")
    @Expose
    private Double yield;
    @SerializedName("dietLabels")
    @Expose
    private List<String> dietLabels = null;
    @SerializedName("healthLabels")
    @Expose
    private List<String> healthLabels = null;
    @SerializedName("cautions")
    @Expose
    private List<String> cautions = null;
    @SerializedName("ingredientLines")
    @Expose
    private List<String> ingredientLines = null;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = null;
    @SerializedName("calories")
    @Expose
    private Double calories;
    @SerializedName("totalWeight")
    @Expose
    private Double totalWeight;
    @SerializedName("totalTime")
    @Expose
    private Double totalTime;
    @SerializedName("totalNutrients")
    @Expose
    private TotalNutrients totalNutrients;
    @SerializedName("totalDaily")
    @Expose
    private TotalDaily totalDaily;
    @SerializedName("digest")
    @Expose
    private List<Digest> digest = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipe() {
    }

    /**
     * 
     * @param dietLabels
     * @param totalDaily
     * @param yield
     * @param cautions
     * @param ingredientLines
     * @param image
     * @param digest
     * @param label
     * @param uri
     * @param url
     * @param shareAs
     * @param ingredients
     * @param source
     * @param healthLabels
     * @param totalWeight
     * @param totalNutrients
     * @param calories
     * @param totalTime
     */
    public Recipe(String uri, String label, String image, String source, String url, String shareAs, Double yield, List<String> dietLabels, List<String> healthLabels, List<String> cautions, List<String> ingredientLines, List<Ingredient> ingredients, Double calories, Double totalWeight, Double totalTime, TotalNutrients totalNutrients, TotalDaily totalDaily, List<Digest> digest) {
        super();
        this.uri = uri;
        this.label = label;
        this.image = image;
        this.source = source;
        this.url = url;
        this.shareAs = shareAs;
        this.yield = yield;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.cautions = cautions;
        this.ingredientLines = ingredientLines;
        this.ingredients = ingredients;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.totalTime = totalTime;
        this.totalNutrients = totalNutrients;
        this.totalDaily = totalDaily;
        this.digest = digest;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShareAs() {
        return shareAs;
    }

    public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public List<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public List<String> getCautions() {
        return cautions;
    }

    public void setCautions(List<String> cautions) {
        this.cautions = cautions;
    }

    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public List<Digest> getDigest() {
        return digest;
    }

    public void setDigest(List<Digest> digest) {
        this.digest = digest;
    }

    public static final DiffUtil.ItemCallback<Recipe> CALLBACK= new DiffUtil.ItemCallback<Recipe>() {
        @Override
        public boolean areItemsTheSame(@NonNull Recipe oldItem, @NonNull Recipe newItem) {
            return oldItem.getUri().equals(newItem.getUri());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Recipe oldItem, @NonNull Recipe newItem) {
            return true;
        }
    };

}
