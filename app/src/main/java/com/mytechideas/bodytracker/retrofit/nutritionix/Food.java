
package com.mytechideas.bodytracker.retrofit.nutritionix;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("brand_name")
    @Expose
    private Object brandName;
    @SerializedName("serving_qty")
    @Expose
    private Integer servingQty;
    @SerializedName("serving_unit")
    @Expose
    private String servingUnit;
    @SerializedName("serving_weight_grams")
    @Expose
    private Double servingWeightGrams;
    @SerializedName("nf_calories")
    @Expose
    private Double nfCalories;
    @SerializedName("nf_total_fat")
    @Expose
    private Double nfTotalFat;
    @SerializedName("nf_saturated_fat")
    @Expose
    private Double nfSaturatedFat;
    @SerializedName("nf_cholesterol")
    @Expose
    private Double nfCholesterol;
    @SerializedName("nf_sodium")
    @Expose
    private Double nfSodium;
    @SerializedName("nf_total_carbohydrate")
    @Expose
    private Double nfTotalCarbohydrate;
    @SerializedName("nf_dietary_fiber")
    @Expose
    private Double nfDietaryFiber;
    @SerializedName("nf_sugars")
    @Expose
    private Double nfSugars;
    @SerializedName("nf_protein")
    @Expose
    private Double nfProtein;
    @SerializedName("nf_potassium")
    @Expose
    private Double nfPotassium;
    @SerializedName("nf_p")
    @Expose
    private Double nfP;
    @SerializedName("full_nutrients")
    @Expose
    private List<FullNutrient> fullNutrients = null;
    @SerializedName("nix_brand_name")
    @Expose
    private Object nixBrandName;
    @SerializedName("nix_brand_id")
    @Expose
    private Object nixBrandId;
    @SerializedName("nix_item_name")
    @Expose
    private Object nixItemName;
    @SerializedName("nix_item_id")
    @Expose
    private Object nixItemId;
    @SerializedName("upc")
    @Expose
    private Object upc;
    @SerializedName("consumed_at")
    @Expose
    private String consumedAt;
    @SerializedName("metadata")
    @Expose
    private Metadata_ metadata;
    @SerializedName("source")
    @Expose
    private Integer source;
    @SerializedName("ndb_no")
    @Expose
    private Integer ndbNo;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("alt_measures")
    @Expose
    private List<AltMeasure> altMeasures = null;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("meal_type")
    @Expose
    private Integer mealType;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("sub_recipe")
    @Expose
    private Object subRecipe;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Food() {
    }

    /**
     * @param foodName
     * @param brandName
     * @param servingQty
     * @param servingUnit
     * @param servingWeightGrams
     * @param nfCalories
     * @param nfTotalFat
     * @param nfSaturatedFat
     * @param nfCholesterol
     * @param nfSodium
     * @param nfTotalCarbohydrate
     * @param nfDietaryFiber
     * @param nfSugars
     * @param nfProtein
     * @param nfPotassium
     * @param nfP
     * @param fullNutrients
     * @param nixBrandName
     * @param nixBrandId
     * @param nixItemName
     * @param nixItemId
     * @param upc
     * @param consumedAt
     * @param metadata
     * @param source
     * @param ndbNo
     * @param tags
     * @param altMeasures
     * @param lat
     * @param lng
     * @param mealType
     * @param photo
     * @param subRecipe
     */
    public Food(String foodName, Object brandName, Integer servingQty, String servingUnit, Double servingWeightGrams, Double nfCalories, Double nfTotalFat, Double nfSaturatedFat, Double nfCholesterol, Double nfSodium, Double nfTotalCarbohydrate, Double nfDietaryFiber, Double nfSugars, Double nfProtein, Double nfPotassium, Double nfP, List<FullNutrient> fullNutrients, Object nixBrandName, Object nixBrandId, Object nixItemName, Object nixItemId, Object upc, String consumedAt, Metadata_ metadata, Integer source, Integer ndbNo, Tags tags, List<AltMeasure> altMeasures, Object lat, Object lng, Integer mealType, Photo photo, Object subRecipe) {
        super();
        this.foodName = foodName;
        this.brandName = brandName;
        this.servingQty = servingQty;
        this.servingUnit = servingUnit;
        this.servingWeightGrams = servingWeightGrams;
        this.nfCalories = nfCalories;
        this.nfTotalFat = nfTotalFat;
        this.nfSaturatedFat = nfSaturatedFat;
        this.nfCholesterol = nfCholesterol;
        this.nfSodium = nfSodium;
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
        this.nfDietaryFiber = nfDietaryFiber;
        this.nfSugars = nfSugars;
        this.nfProtein = nfProtein;
        this.nfPotassium = nfPotassium;
        this.nfP = nfP;
        this.fullNutrients = fullNutrients;
        this.nixBrandName = nixBrandName;
        this.nixBrandId = nixBrandId;
        this.nixItemName = nixItemName;
        this.nixItemId = nixItemId;
        this.upc = upc;
        this.consumedAt = consumedAt;
        this.metadata = metadata;
        this.source = source;
        this.ndbNo = ndbNo;
        this.tags = tags;
        this.altMeasures = altMeasures;
        this.lat = lat;
        this.lng = lng;
        this.mealType = mealType;
        this.photo = photo;
        this.subRecipe = subRecipe;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Object getBrandName() {
        return brandName;
    }

    public void setBrandName(Object brandName) {
        this.brandName = brandName;
    }

    public Integer getServingQty() {
        return servingQty;
    }

    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
    }

    public String getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    public Double getServingWeightGrams() {
        return servingWeightGrams;
    }

    public void setServingWeightGrams(Double servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    public Double getNfCalories() {
        return nfCalories;
    }

    public void setNfCalories(Double nfCalories) {
        this.nfCalories = nfCalories;
    }

    public Double getNfTotalFat() {
        return nfTotalFat;
    }

    public void setNfTotalFat(Double nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    public Double getNfSaturatedFat() {
        return nfSaturatedFat;
    }

    public void setNfSaturatedFat(Double nfSaturatedFat) {
        this.nfSaturatedFat = nfSaturatedFat;
    }

    public Double getNfCholesterol() {
        return nfCholesterol;
    }

    public void setNfCholesterol(Double nfCholesterol) {
        this.nfCholesterol = nfCholesterol;
    }

    public Double getNfSodium() {
        return nfSodium;
    }

    public void setNfSodium(Double nfSodium) {
        this.nfSodium = nfSodium;
    }

    public Double getNfTotalCarbohydrate() {
        return nfTotalCarbohydrate;
    }

    public void setNfTotalCarbohydrate(Double nfTotalCarbohydrate) {
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
    }

    public Double getNfDietaryFiber() {
        return nfDietaryFiber;
    }

    public void setNfDietaryFiber(Double nfDietaryFiber) {
        this.nfDietaryFiber = nfDietaryFiber;
    }

    public Double getNfSugars() {
        return nfSugars;
    }

    public void setNfSugars(Double nfSugars) {
        this.nfSugars = nfSugars;
    }

    public Double getNfProtein() {
        return nfProtein;
    }

    public void setNfProtein(Double nfProtein) {
        this.nfProtein = nfProtein;
    }

    public Double getNfPotassium() {
        return nfPotassium;
    }

    public void setNfPotassium(Double nfPotassium) {
        this.nfPotassium = nfPotassium;
    }

    public Double getNfP() {
        return nfP;
    }

    public void setNfP(Double nfP) {
        this.nfP = nfP;
    }

    public List<FullNutrient> getFullNutrients() {
        return fullNutrients;
    }

    public void setFullNutrients(List<FullNutrient> fullNutrients) {
        this.fullNutrients = fullNutrients;
    }

    public Object getNixBrandName() {
        return nixBrandName;
    }

    public void setNixBrandName(Object nixBrandName) {
        this.nixBrandName = nixBrandName;
    }

    public Object getNixBrandId() {
        return nixBrandId;
    }

    public void setNixBrandId(Object nixBrandId) {
        this.nixBrandId = nixBrandId;
    }

    public Object getNixItemName() {
        return nixItemName;
    }

    public void setNixItemName(Object nixItemName) {
        this.nixItemName = nixItemName;
    }

    public Object getNixItemId() {
        return nixItemId;
    }

    public void setNixItemId(Object nixItemId) {
        this.nixItemId = nixItemId;
    }

    public Object getUpc() {
        return upc;
    }

    public void setUpc(Object upc) {
        this.upc = upc;
    }

    public String getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(String consumedAt) {
        this.consumedAt = consumedAt;
    }

    public Metadata_ getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(Integer ndbNo) {
        this.ndbNo = ndbNo;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public List<AltMeasure> getAltMeasures() {
        return altMeasures;
    }

    public void setAltMeasures(List<AltMeasure> altMeasures) {
        this.altMeasures = altMeasures;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public Integer getMealType() {
        return mealType;
    }

    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Object getSubRecipe() {
        return subRecipe;
    }

    public void setSubRecipe(Object subRecipe) {
        this.subRecipe = subRecipe;
    }

}
