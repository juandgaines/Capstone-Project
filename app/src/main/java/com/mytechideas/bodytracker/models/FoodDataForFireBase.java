package com.mytechideas.bodytracker.models;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class FoodDataForFireBase {


    private Integer mPartOfDayTime;
    private String mName;
    private Float mCalories;
    private Float mCarbs;
    private Float mFats;
    private Float mProtein;
    //private Calendar mDate;
    private String mDateFormatted;
    private Integer mDateDayOfWeek;
    private Integer mDateMonth;
    private Integer mDateDayNumber;
    private Integer mDateYear;
    private Integer mDateHour;
    private Integer mDateMinutes;




    public FoodDataForFireBase(String name, Float calories, Float carbs, Float fats, Float protein, Calendar date) {

        mName=name;
        mCalories=calories;
        mCarbs=carbs;
        mFats=fats;
        mProtein=protein;
        //mDate=date;

        mDateFormatted= DateFormat.getDateInstance(DateFormat.FULL).format(Calendar.getInstance().getTime());
        mDateDayNumber=  Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        mDateDayOfWeek= Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        mDateYear=Calendar.getInstance().get(Calendar.YEAR);
        mDateHour= Calendar.getInstance().get(Calendar.HOUR);
        mDateMinutes= Calendar.getInstance().get(Calendar.MINUTE);
        mPartOfDayTime=Calendar.getInstance().get(Calendar.AM_PM);
        

    }

    public FoodDataForFireBase(){}


    public Integer getmPartOfDayTime() {
        return mPartOfDayTime;
    }
    public void setmPartOfDayTime(Integer partOfDayTime){

        this.mPartOfDayTime=partOfDayTime;
    }

    public void setmDateYear(Integer mDateYear) {
        this.mDateYear = mDateYear;
    }

    public void setmDateMonth(Integer mDateMonth) {
        this.mDateMonth = mDateMonth;
    }

    public void setmDateMinutes(Integer mDateMinutes) {
        this.mDateMinutes = mDateMinutes;
    }

    public void setmDateHour(Integer mDateHour) {
        this.mDateHour = mDateHour;
    }

    public void setmDateFormatted(String mDateFormatted) {
        this.mDateFormatted = mDateFormatted;
    }

    public void setmDateDayOfWeek(Integer mDateDayOfWeek) {
        this.mDateDayOfWeek = mDateDayOfWeek;
    }

    public void setmDateDayNumber(Integer mDateDayNumber) {
        this.mDateDayNumber = mDateDayNumber;
    }

    public Integer getmDateMinutes() {
        return mDateMinutes;
    }

    public Integer getmDateYear() {
        return mDateYear;
    }

    public Integer getmDateHour() {
        return mDateHour;
    }

    public Integer getmDateMonth() {
        return mDateMonth;
    }

    public String getmDateFormatted() {
        return mDateFormatted;
    }

    public Integer getmDateDayOfWeek() {
        return mDateDayOfWeek;
    }

    public Integer getmDateDayNumber() {
        return mDateDayNumber;
    }

    public void setmCalories(Float mCalories) {
        this.mCalories = mCalories;
    }

    public void setmCarbs(Float mCarbs) {
        this.mCarbs = mCarbs;
    }

    public void setmFats(Float mFats) {
        this.mFats = mFats;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmProtein(Float mProtein) {
        this.mProtein = mProtein;
    }

    public Float getmCalories() {
        return mCalories;
    }

    public Float getmCarbs() {
        return mCarbs;
    }

    public Float getmFats() {
        return mFats;
    }

    public Float getmProtein() {
        return mProtein;
    }

    public String getmName() {
        return mName;
    }

}
