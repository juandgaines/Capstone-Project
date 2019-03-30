
package com.mytechideas.bodytracker.retrofit;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("params")
    @Expose
    private Params params;
    @SerializedName("more")
    @Expose
    private Boolean more;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("hits")
    @Expose
    private List<com.example.Hit> hits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Example() {
    }

    /**
     * 
     * @param to
     * @param hits
     * @param more
     * @param count
     * @param q
     * @param params
     * @param from
     */
    public Example(String q, Integer from, Integer to, Params params, Boolean more, Integer count, List<com.example.Hit> hits) {
        super();
        this.q = q;
        this.from = from;
        this.to = to;
        this.params = params;
        this.more = more;
        this.count = count;
        this.hits = hits;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Boolean getMore() {
        return more;
    }

    public void setMore(Boolean more) {
        this.more = more;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<com.example.Hit> getHits() {
        return hits;
    }

    public void setHits(List<com.example.Hit> hits) {
        this.hits = hits;
    }

}
