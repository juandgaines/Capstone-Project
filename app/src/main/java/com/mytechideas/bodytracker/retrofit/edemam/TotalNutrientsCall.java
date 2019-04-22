
package com.mytechideas.bodytracker.retrofit.edemam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalNutrientsCall {

    @SerializedName("ENERC_KCAL")
    @Expose
    private ENERCKCAL eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private FAT fAT;
    @SerializedName("FASAT")
    @Expose
    private FASAT fASAT;
    @SerializedName("CHOCDF")
    @Expose
    private CHOCDF cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private FIBTG fIBTG;
    @SerializedName("SUGAR")
    @Expose
    private SUGAR sUGAR;
    @SerializedName("PROCNT")
    @Expose
    private PROCNT pROCNT;
    @SerializedName("NA")
    @Expose
    private NA nA;
    @SerializedName("CA")
    @Expose
    private CA cA;
    @SerializedName("FE")
    @Expose
    private FE fE;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TotalNutrientsCall() {
    }

    /**
     * 
     * @param nA
     * @param cHOCDF
     * @param eNERCKCAL
     * @param cA
     * @param pROCNT
     * @param sUGAR
     * @param fIBTG
     * @param fASAT
     * @param fE
     * @param fAT
     */
    public TotalNutrientsCall(ENERCKCAL eNERCKCAL, FAT fAT, FASAT fASAT, CHOCDF cHOCDF, FIBTG fIBTG, SUGAR sUGAR, PROCNT pROCNT, NA nA, CA cA, FE fE) {
        super();
        this.eNERCKCAL = eNERCKCAL;
        this.fAT = fAT;
        this.fASAT = fASAT;
        this.cHOCDF = cHOCDF;
        this.fIBTG = fIBTG;
        this.sUGAR = sUGAR;
        this.pROCNT = pROCNT;
        this.nA = nA;
        this.cA = cA;
        this.fE = fE;
    }

    public ENERCKCAL getENERCKCAL() {
        return eNERCKCAL;
    }

    public void setENERCKCAL(ENERCKCAL eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    public FAT getFAT() {
        return fAT;
    }

    public void setFAT(FAT fAT) {
        this.fAT = fAT;
    }

    public FASAT getFASAT() {
        return fASAT;
    }

    public void setFASAT(FASAT fASAT) {
        this.fASAT = fASAT;
    }

    public CHOCDF getCHOCDF() {
        return cHOCDF;
    }

    public void setCHOCDF(CHOCDF cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    public FIBTG getFIBTG() {
        return fIBTG;
    }

    public void setFIBTG(FIBTG fIBTG) {
        this.fIBTG = fIBTG;
    }

    public SUGAR getSUGAR() {
        return sUGAR;
    }

    public void setSUGAR(SUGAR sUGAR) {
        this.sUGAR = sUGAR;
    }

    public PROCNT getPROCNT() {
        return pROCNT;
    }

    public void setPROCNT(PROCNT pROCNT) {
        this.pROCNT = pROCNT;
    }

    public NA getNA() {
        return nA;
    }

    public void setNA(NA nA) {
        this.nA = nA;
    }

    public CA getCA() {
        return cA;
    }

    public void setCA(CA cA) {
        this.cA = cA;
    }

    public FE getFE() {
        return fE;
    }

    public void setFE(FE fE) {
        this.fE = fE;
    }

}
