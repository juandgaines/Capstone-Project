
package com.mytechideas.bodytracker.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrients {

    @SerializedName("ENERC_KCAL")
    @Expose
    private Double eNERCKCAL;
    @SerializedName("PROCNT")
    @Expose
    private Double pROCNT;
    @SerializedName("FAT")
    @Expose
    private Double fAT;
    @SerializedName("CHOCDF")
    @Expose
    private Double cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private Double fIBTG;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Nutrients() {
    }

    /**
     * 
     * @param cHOCDF
     * @param eNERCKCAL
     * @param pROCNT
     * @param fIBTG
     * @param fAT
     */
    public Nutrients(Double eNERCKCAL, Double pROCNT, Double fAT, Double cHOCDF, Double fIBTG) {
        super();
        this.eNERCKCAL = eNERCKCAL;
        this.pROCNT = pROCNT;
        this.fAT = fAT;
        this.cHOCDF = cHOCDF;
        this.fIBTG = fIBTG;
    }

    public Double getENERCKCAL() {
        return eNERCKCAL;
    }

    public void setENERCKCAL(Double eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    public Double getPROCNT() {
        return pROCNT;
    }

    public void setPROCNT(Double pROCNT) {
        this.pROCNT = pROCNT;
    }

    public Double getFAT() {
        return fAT;
    }

    public void setFAT(Double fAT) {
        this.fAT = fAT;
    }

    public Double getCHOCDF() {
        return cHOCDF;
    }

    public void setCHOCDF(Double cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    public Double getFIBTG() {
        return fIBTG;
    }

    public void setFIBTG(Double fIBTG) {
        this.fIBTG = fIBTG;
    }

}
