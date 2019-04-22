
package com.mytechideas.bodytracker.retrofit.edemam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalDailyCall {

    @SerializedName("ENERC_KCAL")
    @Expose
    private ENERCKCAL_ eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private FAT_ fAT;
    @SerializedName("FASAT")
    @Expose
    private FASAT_ fASAT;
    @SerializedName("CHOCDF")
    @Expose
    private CHOCDF_ cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private FIBTG_ fIBTG;
    @SerializedName("PROCNT")
    @Expose
    private PROCNT_ pROCNT;
    @SerializedName("NA")
    @Expose
    private NA_ nA;
    @SerializedName("CA")
    @Expose
    private CA_ cA;
    @SerializedName("FE")
    @Expose
    private FE_ fE;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TotalDailyCall() {
    }

    /**
     * 
     * @param nA
     * @param cHOCDF
     * @param eNERCKCAL
     * @param cA
     * @param pROCNT
     * @param fIBTG
     * @param fASAT
     * @param fE
     * @param fAT
     */
    public TotalDailyCall(ENERCKCAL_ eNERCKCAL, FAT_ fAT, FASAT_ fASAT, CHOCDF_ cHOCDF, FIBTG_ fIBTG, PROCNT_ pROCNT, NA_ nA, CA_ cA, FE_ fE) {
        super();
        this.eNERCKCAL = eNERCKCAL;
        this.fAT = fAT;
        this.fASAT = fASAT;
        this.cHOCDF = cHOCDF;
        this.fIBTG = fIBTG;
        this.pROCNT = pROCNT;
        this.nA = nA;
        this.cA = cA;
        this.fE = fE;
    }

    public ENERCKCAL_ getENERCKCAL() {
        return eNERCKCAL;
    }

    public void setENERCKCAL(ENERCKCAL_ eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    public FAT_ getFAT() {
        return fAT;
    }

    public void setFAT(FAT_ fAT) {
        this.fAT = fAT;
    }

    public FASAT_ getFASAT() {
        return fASAT;
    }

    public void setFASAT(FASAT_ fASAT) {
        this.fASAT = fASAT;
    }

    public CHOCDF_ getCHOCDF() {
        return cHOCDF;
    }

    public void setCHOCDF(CHOCDF_ cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    public FIBTG_ getFIBTG() {
        return fIBTG;
    }

    public void setFIBTG(FIBTG_ fIBTG) {
        this.fIBTG = fIBTG;
    }

    public PROCNT_ getPROCNT() {
        return pROCNT;
    }

    public void setPROCNT(PROCNT_ pROCNT) {
        this.pROCNT = pROCNT;
    }

    public NA_ getNA() {
        return nA;
    }

    public void setNA(NA_ nA) {
        this.nA = nA;
    }

    public CA_ getCA() {
        return cA;
    }

    public void setCA(CA_ cA) {
        this.cA = cA;
    }

    public FE_ getFE() {
        return fE;
    }

    public void setFE(FE_ fE) {
        this.fE = fE;
    }

}
