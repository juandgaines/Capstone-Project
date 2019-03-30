package com.mytechideas.bodytracker.retrofit;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("sane")
    @Expose
    private List<Object> sane = null;
    @SerializedName("q")
    @Expose
    private List<String> q = null;
    @SerializedName("app_key")
    @Expose
    private List<String> appKey = null;
    @SerializedName("yield")
    @Expose
    private List<String> yield = null;
    @SerializedName("from")
    @Expose
    private List<String> from = null;
    @SerializedName("time")
    @Expose
    private List<String> time = null;
    @SerializedName("to")
    @Expose
    private List<String> to = null;
    @SerializedName("diet")
    @Expose
    private List<String> diet = null;
    @SerializedName("app_id")
    @Expose
    private List<String> appId = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Params() {
    }

    /**
     * 
     * @param to
     * @param sane
     * @param time
     * @param appId
     * @param diet
     * @param yield
     * @param q
     * @param from
     * @param appKey
     */
    public Params(List<Object> sane, List<String> q, List<String> appKey, List<String> yield, List<String> from, List<String> time, List<String> to, List<String> diet, List<String> appId) {
        super();
        this.sane = sane;
        this.q = q;
        this.appKey = appKey;
        this.yield = yield;
        this.from = from;
        this.time = time;
        this.to = to;
        this.diet = diet;
        this.appId = appId;
    }

    public List<Object> getSane() {
        return sane;
    }

    public void setSane(List<Object> sane) {
        this.sane = sane;
    }

    public List<String> getQ() {
        return q;
    }

    public void setQ(List<String> q) {
        this.q = q;
    }

    public List<String> getAppKey() {
        return appKey;
    }

    public void setAppKey(List<String> appKey) {
        this.appKey = appKey;
    }

    public List<String> getYield() {
        return yield;
    }

    public void setYield(List<String> yield) {
        this.yield = yield;
    }

    public List<String> getFrom() {
        return from;
    }

    public void setFrom(List<String> from) {
        this.from = from;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getDiet() {
        return diet;
    }

    public void setDiet(List<String> diet) {
        this.diet = diet;
    }

    public List<String> getAppId() {
        return appId;
    }

    public void setAppId(List<String> appId) {
        this.appId = appId;
    }

}
