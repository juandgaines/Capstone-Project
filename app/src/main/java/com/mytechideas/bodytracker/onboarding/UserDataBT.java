package com.mytechideas.bodytracker.onboarding;



public class UserDataBT {
    private String mName;
    private int edad,mLifestyle,mGoal,mBodyType;
    private String mGender;
    private float mWeight,mHeight;


    public UserDataBT( String mName, int edad, String mGender, float mWeight, float mHeight, int lifestyleOption) {

        this.mName=mName;
        this.edad=edad;
        this.mGender=mGender;
        this.mWeight=mWeight;
        this.mHeight=mHeight;
        this.mLifestyle=lifestyleOption;


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
