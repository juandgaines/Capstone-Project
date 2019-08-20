
package com.mytechideas.bodytracker.retrofit.nutritionix;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Foods {

    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("serving_qty")
    @Expose
    private Integer servingQty;
    @SerializedName("serving_unit")
    @Expose
    private String servingUnit;
    @SerializedName("serving_weight_grams")
    @Expose
    private Integer servingWeightGrams;
    @SerializedName("nf_calories")
    @Expose
    private Float nfCalories;
    @SerializedName("nf_total_fat")
    @Expose
    private Float nfTotalFat;
    @SerializedName("nf_saturated_fat")
    @Expose
    private Float nfSaturatedFat;
    @SerializedName("nf_cholesterol")
    @Expose
    private Float nfCholesterol;
    @SerializedName("nf_sodium")
    @Expose
    private Float nfSodium;
    @SerializedName("nf_total_carbohydrate")
    @Expose
    private Float nfTotalCarbohydrate;
    @SerializedName("nf_dietary_fiber")
    @Expose
    private Float nfDietaryFiber;
    @SerializedName("nf_sugars")
    @Expose
    private Float nfSugars;
    @SerializedName("nf_protein")
    @Expose
    private Float nfProtein;
    @SerializedName("nf_potassium")
    @Expose
    private Object nfPotassium;
    @SerializedName("nf_p")
    @Expose
    private Object nfP;
    @SerializedName("full_nutrients")
    @Expose
    private List<FullNutrient> fullNutrients = null;
    @SerializedName("nix_brand_name")
    @Expose
    private String nixBrandName;
    @SerializedName("nix_brand_id")
    @Expose
    private String nixBrandId;
    @SerializedName("nix_item_name")
    @Expose
    private String nixItemName;
    @SerializedName("nix_item_id")
    @Expose
    private String nixItemId;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("source")
    @Expose
    private Integer source;
    @SerializedName("ndb_no")
    @Expose
    private Object ndbNo;
    @SerializedName("tags")
    @Expose
    private Object tags;
    @SerializedName("alt_measures")
    @Expose
    private Object altMeasures;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("nf_ingredient_statement")
    @Expose
    private String nfIngredientStatement;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Foods() {
    }

    /**
     *  @param foodName
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
     * @param metadata
     * @param source
     * @param ndbNo
     * @param tags
     * @param altMeasures
     * @param lat
     * @param lng
     * @param photo
     * @param note
     * @param updatedAt
     * @param nfIngredientStatement
     */
    public Foods(String foodName, String brandName, Integer servingQty, String servingUnit, Integer servingWeightGrams, Float nfCalories, Float nfTotalFat, Float nfSaturatedFat, Float nfCholesterol, Float nfSodium, Float nfTotalCarbohydrate, Float nfDietaryFiber, Float nfSugars, Float nfProtein, Object nfPotassium, Object nfP, List<FullNutrient> fullNutrients, String nixBrandName, String nixBrandId, String nixItemName, String nixItemId, Metadata metadata, Integer source, Object ndbNo, Object tags, Object altMeasures, Object lat, Object lng, Photo photo, Object note, String updatedAt, String nfIngredientStatement) {
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
        this.metadata = metadata;
        this.source = source;
        this.ndbNo = ndbNo;
        this.tags = tags;
        this.altMeasures = altMeasures;
        this.lat = lat;
        this.lng = lng;
        this.photo = photo;
        this.note = note;
        this.updatedAt = updatedAt;
        this.nfIngredientStatement = nfIngredientStatement;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
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

    public Integer getServingWeightGrams() {
        return servingWeightGrams;
    }

    public void setServingWeightGrams(Integer servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    public Float getNfCalories() {
        return nfCalories;
    }

    public void setNfCalories(Float nfCalories) {
        this.nfCalories = nfCalories;
    }

    public Float getNfTotalFat() {
        return nfTotalFat;
    }

    public void setNfTotalFat(Float nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    public Float getNfSaturatedFat() {
        return nfSaturatedFat;
    }

    public void setNfSaturatedFat(Float nfSaturatedFat) {
        this.nfSaturatedFat = nfSaturatedFat;
    }

    public Float getNfCholesterol() {
        return nfCholesterol;
    }

    public void setNfCholesterol(Float nfCholesterol) {
        this.nfCholesterol = nfCholesterol;
    }

    public Float getNfSodium() {
        return nfSodium;
    }

    public void setNfSodium(Float nfSodium) {
        this.nfSodium = nfSodium;
    }

    public Float getNfTotalCarbohydrate() {
        return nfTotalCarbohydrate;
    }

    public void setNfTotalCarbohydrate(Float nfTotalCarbohydrate) {
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
    }

    public Float getNfDietaryFiber() {
        return nfDietaryFiber;
    }

    public void setNfDietaryFiber(Float nfDietaryFiber) {
        this.nfDietaryFiber = nfDietaryFiber;
    }

    public Float getNfSugars() {
        return nfSugars;
    }

    public void setNfSugars(Float nfSugars) {
        this.nfSugars = nfSugars;
    }

    public Float getNfProtein() {
        return nfProtein;
    }

    public void setNfProtein(Float nfProtein) {
        this.nfProtein = nfProtein;
    }

    public Object getNfPotassium() {
        return nfPotassium;
    }

    public void setNfPotassium(Object nfPotassium) {
        this.nfPotassium = nfPotassium;
    }

    public Object getNfP() {
        return nfP;
    }

    public void setNfP(Object nfP) {
        this.nfP = nfP;
    }

    public List<FullNutrient> getFullNutrients() {
        return fullNutrients;
    }

    public void setFullNutrients(List<FullNutrient> fullNutrients) {
        this.fullNutrients = fullNutrients;
    }

    public String getNixBrandName() {
        return nixBrandName;
    }

    public void setNixBrandName(String nixBrandName) {
        this.nixBrandName = nixBrandName;
    }

    public String getNixBrandId() {
        return nixBrandId;
    }

    public void setNixBrandId(String nixBrandId) {
        this.nixBrandId = nixBrandId;
    }

    public String getNixItemName() {
        return nixItemName;
    }

    public void setNixItemName(String nixItemName) {
        this.nixItemName = nixItemName;
    }

    public String getNixItemId() {
        return nixItemId;
    }

    public void setNixItemId(String nixItemId) {
        this.nixItemId = nixItemId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Object getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(Object ndbNo) {
        this.ndbNo = ndbNo;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public Object getAltMeasures() {
        return altMeasures;
    }

    public void setAltMeasures(Object altMeasures) {
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNfIngredientStatement() {
        return nfIngredientStatement;
    }

    public void setNfIngredientStatement(String nfIngredientStatement) {
        this.nfIngredientStatement = nfIngredientStatement;
    }

}
