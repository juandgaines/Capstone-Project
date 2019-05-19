package com.mytechideas.bodytracker.models;



public class UserDataBT {
    private String mName;
    private int edad,mLifestyle,mGoal,mBodyType;
    private String mGender;
    private float mWeight,mHeight;
    private double mLifeStyleFactor,mPerCarbs,mPerFats,mPerProtein,mTargetCalories;


    public UserDataBT( String mName, int edad, String mGender, float mWeight, float mHeight, int lifestyleOption) {

        this.mName=mName;
        this.edad=edad;
        this.mGender=mGender;
        this.mWeight=mWeight;
        this.mHeight=mHeight;
        this.mLifestyle=lifestyleOption;


        if(mLifestyle==0){
            this.mLifeStyleFactor=1.2;

        }
        else if(mLifestyle==1){
            this.mLifeStyleFactor=1.375;
        }
        else if(mLifestyle==2){
            this.mLifeStyleFactor=1.5;
        }
        else if(mLifestyle==3){
            this.mLifeStyleFactor=1.725;
        }


    }

    public double getmTargetCalories() {
        return mTargetCalories;
    }

    public void setmTargetCalories(double mTargetCalories) {
        this.mTargetCalories = mTargetCalories;
    }

    public double getmPerCarbs() {
        return mPerCarbs;
    }

    public double getmPerFats() {
        return mPerFats;
    }

    public double getmPerProtein() {
        return mPerProtein;
    }

    public void setmLifeStyleFactor(double mLifeStyleFactor) {
        this.mLifeStyleFactor = mLifeStyleFactor;
    }

    public void setmPerCarbs(double mPerCarbs) {
        this.mPerCarbs = mPerCarbs;
    }

    public void setmPerFats(double mPerFats) {
        this.mPerFats = mPerFats;
    }

    public void setmPerProtein(double mPerProtein) {
        this.mPerProtein = mPerProtein;
    }


    public double getmLifeStyleFactor() {
        return mLifeStyleFactor;
    }

    public int getmBodyType() {
        return mBodyType;
    }

    public int getmGoal() {
        return mGoal;
    }

    public void setmBodyType(int mBodyType) {
        this.mBodyType = mBodyType;
    }

    public void setmGoal(int mGoal) {
        this.mGoal = mGoal;
    }

    public float getmHeight() {
        return mHeight;
    }

    public float getmWeight() {
        return mWeight;
    }

    public int getEdad() {
        return edad;
    }

    public int getmLifestyle() {
        return mLifestyle;
    }

    public String getmGender() {
        return mGender;
    }

    public String getmName() {
        return mName;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public void setmHeight(float mHeight) {
        this.mHeight = mHeight;
    }

    public void setmLifestyle(int mLifestyle) {
        this.mLifestyle = mLifestyle;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmWeight(float mWeight) {
        this.mWeight = mWeight;
    }

}
