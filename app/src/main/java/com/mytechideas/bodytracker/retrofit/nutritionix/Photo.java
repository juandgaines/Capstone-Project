
package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("highres")
    @Expose
    private Object highres;
    @SerializedName("is_user_uploaded")
    @Expose
    private Boolean isUserUploaded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photo() {
    }

    /**
     * 
     * @param highres
     * @param isUserUploaded
     * @param thumb
     */
    public Photo(String thumb, Object highres, Boolean isUserUploaded) {
        super();
        this.thumb = thumb;
        this.highres = highres;
        this.isUserUploaded = isUserUploaded;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Object getHighres() {
        return highres;
    }

    public void setHighres(Object highres) {
        this.highres = highres;
    }

    public Boolean getIsUserUploaded() {
        return isUserUploaded;
    }

    public void setIsUserUploaded(Boolean isUserUploaded) {
        this.isUserUploaded = isUserUploaded;
    }

}
