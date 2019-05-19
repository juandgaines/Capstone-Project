package com.mytechideas.bodytracker.models;

public class MealsType {

    private String mTitle;
    private int mImage;
    private String mDescription;

    public MealsType(String title, int image,String description){

            mTitle=title;
            mImage=image;
            mDescription=description;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }


}
