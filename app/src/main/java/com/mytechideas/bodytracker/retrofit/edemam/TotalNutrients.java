
package com.mytechideas.bodytracker.retrofit.edemam;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalNutrients implements Parcelable{

    @SerializedName("ENERC_KCAL")
    @Expose
    private ENERCKCAL eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private FAT fAT;
    @SerializedName("FASAT")
    @Expose
    private FASAT fASAT;
    @SerializedName("FAMS")
    @Expose
    private FAMS fAMS;
    @SerializedName("FAPU")
    @Expose
    private FAPU fAPU;
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
    @SerializedName("MG")
    @Expose
    private MG mG;
    @SerializedName("K")
    @Expose
    private K k;
    @SerializedName("FE")
    @Expose
    private FE fE;
    @SerializedName("ZN")
    @Expose
    private ZN zN;
    @SerializedName("P")
    @Expose
    private P p;
    @SerializedName("VITA_RAE")
    @Expose
    private VITARAE vITARAE;
    @SerializedName("VITC")
    @Expose
    private VITC vITC;
    @SerializedName("THIA")
    @Expose
    private THIA tHIA;
    @SerializedName("RIBF")
    @Expose
    private RIBF rIBF;
    @SerializedName("NIA")
    @Expose
    private NIA nIA;
    @SerializedName("VITB6A")
    @Expose
    private VITB6A vITB6A;
    @SerializedName("FOLDFE")
    @Expose
    private FOLDFE fOLDFE;
    @SerializedName("FOLFD")
    @Expose
    private FOLFD fOLFD;
    @SerializedName("TOCPHA")
    @Expose
    private TOCPHA tOCPHA;
    @SerializedName("VITK1")
    @Expose
    private VITK1 vITK1;
    @SerializedName("FATRN")
    @Expose
    private FATRN fATRN;
    @SerializedName("CHOLE")
    @Expose
    private CHOLE cHOLE;
    @SerializedName("VITB12")
    @Expose
    private VITB12 vITB12;
    @SerializedName("VITD")
    @Expose
    private VITD vITD;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TotalNutrients() {
    }

    /**
     * 
     * @param cHOCDF
     * @param tHIA
     * @param fOLDFE
     * @param fE
     * @param nA
     * @param fOLFD
     * @param eNERCKCAL
     * @param fAMS
     * @param vITB6A
     * @param pROCNT
     * @param vITD
     * @param vITARAE
     * @param vITC
     * @param fASAT
     * @param cA
     * @param vITK1
     * @param fIBTG
     * @param fATRN
     * @param k
     * @param nIA
     * @param vITB12
     * @param fAPU
     * @param rIBF
     * @param cHOLE
     * @param tOCPHA
     * @param mG
     * @param p
     * @param sUGAR
     * @param zN
     * @param fAT
     */
    public TotalNutrients(ENERCKCAL eNERCKCAL, FAT fAT, FASAT fASAT, FAMS fAMS, FAPU fAPU, CHOCDF cHOCDF, FIBTG fIBTG, SUGAR sUGAR, PROCNT pROCNT, NA nA, CA cA, MG mG, K k, FE fE, ZN zN, P p, VITARAE vITARAE, VITC vITC, THIA tHIA, RIBF rIBF, NIA nIA, VITB6A vITB6A, FOLDFE fOLDFE, FOLFD fOLFD, TOCPHA tOCPHA, VITK1 vITK1, FATRN fATRN, CHOLE cHOLE, VITB12 vITB12, VITD vITD) {
        super();
        this.eNERCKCAL = eNERCKCAL;
        this.fAT = fAT;
        this.fASAT = fASAT;
        this.fAMS = fAMS;
        this.fAPU = fAPU;
        this.cHOCDF = cHOCDF;
        this.fIBTG = fIBTG;
        this.sUGAR = sUGAR;
        this.pROCNT = pROCNT;
        this.nA = nA;
        this.cA = cA;
        this.mG = mG;
        this.k = k;
        this.fE = fE;
        this.zN = zN;
        this.p = p;
        this.vITARAE = vITARAE;
        this.vITC = vITC;
        this.tHIA = tHIA;
        this.rIBF = rIBF;
        this.nIA = nIA;
        this.vITB6A = vITB6A;
        this.fOLDFE = fOLDFE;
        this.fOLFD = fOLFD;
        this.tOCPHA = tOCPHA;
        this.vITK1 = vITK1;
        this.fATRN = fATRN;
        this.cHOLE = cHOLE;
        this.vITB12 = vITB12;
        this.vITD = vITD;
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

    public FAMS getFAMS() {
        return fAMS;
    }

    public void setFAMS(FAMS fAMS) {
        this.fAMS = fAMS;
    }

    public FAPU getFAPU() {
        return fAPU;
    }

    public void setFAPU(FAPU fAPU) {
        this.fAPU = fAPU;
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

    public MG getMG() {
        return mG;
    }

    public void setMG(MG mG) {
        this.mG = mG;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public FE getFE() {
        return fE;
    }

    public void setFE(FE fE) {
        this.fE = fE;
    }

    public ZN getZN() {
        return zN;
    }

    public void setZN(ZN zN) {
        this.zN = zN;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public VITARAE getVITARAE() {
        return vITARAE;
    }

    public void setVITARAE(VITARAE vITARAE) {
        this.vITARAE = vITARAE;
    }

    public VITC getVITC() {
        return vITC;
    }

    public void setVITC(VITC vITC) {
        this.vITC = vITC;
    }

    public THIA getTHIA() {
        return tHIA;
    }

    public void setTHIA(THIA tHIA) {
        this.tHIA = tHIA;
    }

    public RIBF getRIBF() {
        return rIBF;
    }

    public void setRIBF(RIBF rIBF) {
        this.rIBF = rIBF;
    }

    public NIA getNIA() {
        return nIA;
    }

    public void setNIA(NIA nIA) {
        this.nIA = nIA;
    }

    public VITB6A getVITB6A() {
        return vITB6A;
    }

    public void setVITB6A(VITB6A vITB6A) {
        this.vITB6A = vITB6A;
    }

    public FOLDFE getFOLDFE() {
        return fOLDFE;
    }

    public void setFOLDFE(FOLDFE fOLDFE) {
        this.fOLDFE = fOLDFE;
    }

    public FOLFD getFOLFD() {
        return fOLFD;
    }

    public void setFOLFD(FOLFD fOLFD) {
        this.fOLFD = fOLFD;
    }

    public TOCPHA getTOCPHA() {
        return tOCPHA;
    }

    public void setTOCPHA(TOCPHA tOCPHA) {
        this.tOCPHA = tOCPHA;
    }

    public VITK1 getVITK1() {
        return vITK1;
    }

    public void setVITK1(VITK1 vITK1) {
        this.vITK1 = vITK1;
    }

    public FATRN getFATRN() {
        return fATRN;
    }

    public void setFATRN(FATRN fATRN) {
        this.fATRN = fATRN;
    }

    public CHOLE getCHOLE() {
        return cHOLE;
    }

    public void setCHOLE(CHOLE cHOLE) {
        this.cHOLE = cHOLE;
    }

    public VITB12 getVITB12() {
        return vITB12;
    }

    public void setVITB12(VITB12 vITB12) {
        this.vITB12 = vITB12;
    }

    public VITD getVITD() {
        return vITD;
    }

    public void setVITD(VITD vITD) {
        this.vITD = vITD;
    }


    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {

        dest.writeParcelable(eNERCKCAL,i);
        dest.writeParcelable(fAT,i);
        dest.writeParcelable(fASAT,i);
        dest.writeParcelable(fAMS,i);
        dest.writeParcelable(fAPU,i);
        dest.writeParcelable(cHOCDF,i);
        dest.writeParcelable(fIBTG,i);
        dest.writeParcelable(sUGAR,i);
        dest.writeParcelable(pROCNT,i);
        dest.writeParcelable(nA,i);
        dest.writeParcelable(cA,i);
        dest.writeParcelable(mG,i);
        dest.writeParcelable(k,i);
        dest.writeParcelable(fE,i);
        dest.writeParcelable(zN,i);
        dest.writeParcelable(p,i);
        dest.writeParcelable(vITARAE,i);
        dest.writeParcelable(vITC,i);
        dest.writeParcelable(tHIA,i);
        dest.writeParcelable(rIBF,i);
        dest.writeParcelable(nIA,i);
        dest.writeParcelable(vITB6A,i);
        dest.writeParcelable(fOLDFE,i);
        dest.writeParcelable(fOLFD,i);
        dest.writeParcelable(tOCPHA,i);
        dest.writeParcelable(vITK1,i);
        dest.writeParcelable(fATRN,i);
        dest.writeParcelable(cHOLE,i);
        dest.writeParcelable(vITB12,i);
        dest.writeParcelable(vITD,i);

    }

    public TotalNutrients(Parcel parcel){

        this.eNERCKCAL = parcel.readParcelable(ENERCKCAL.class.getClassLoader());
        this.fAT = parcel.readParcelable(FAT.class.getClassLoader());
        this.fASAT = parcel.readParcelable(FASAT.class.getClassLoader());
        this.fAMS = parcel.readParcelable(FAMS.class.getClassLoader());
        this.fAPU = parcel.readParcelable(FAPU.class.getClassLoader());
        this.cHOCDF = parcel.readParcelable(CHOCDF.class.getClassLoader());
        this.fIBTG = parcel.readParcelable(FIBTG.class.getClassLoader());
        this.sUGAR = parcel.readParcelable(SUGAR.class.getClassLoader());
        this.pROCNT = parcel.readParcelable(PROCNT.class.getClassLoader());
        this.nA = parcel.readParcelable(NA.class.getClassLoader());
        this.cA = parcel.readParcelable(CA.class.getClassLoader());
        this.mG = parcel.readParcelable(MG.class.getClassLoader());
        this.k = parcel.readParcelable(K.class.getClassLoader());
        this.fE = parcel.readParcelable(FE.class.getClassLoader());
        this.zN = parcel.readParcelable(ZN.class.getClassLoader());
        this.p = parcel.readParcelable(P.class.getClassLoader());
        this.vITARAE = parcel.readParcelable(VITARAE.class.getClassLoader());
        this.vITC = parcel.readParcelable(VITC.class.getClassLoader());
        this.tHIA = parcel.readParcelable(THIA.class.getClassLoader());
        this.rIBF = parcel.readParcelable(RIBF.class.getClassLoader());
        this.nIA = parcel.readParcelable(NIA.class.getClassLoader());
        this.vITB6A = parcel.readParcelable(VITB6A.class.getClassLoader());
        this.fOLDFE = parcel.readParcelable(FOLDFE.class.getClassLoader());
        this.fOLFD = parcel.readParcelable(FOLFD.class.getClassLoader());
        this.tOCPHA = parcel.readParcelable(TOCPHA.class.getClassLoader());
        this.vITK1 = parcel.readParcelable(VITK1.class.getClassLoader());
        this.fATRN = parcel.readParcelable(FATRN.class.getClassLoader());
        this.cHOLE = parcel.readParcelable(CHOLE.class.getClassLoader());
        this.vITB12 = parcel.readParcelable(VITB12.class.getClassLoader());
        this.vITD = parcel.readParcelable(VITD.class.getClassLoader());

    }


    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<TotalNutrients> CREATOR = new Parcelable.Creator<TotalNutrients>(){

        @Override
        public TotalNutrients createFromParcel(Parcel parcel) {
            return new TotalNutrients(parcel);
        }

        @Override
        public TotalNutrients[] newArray(int size) {
            return new TotalNutrients[0];
        }
    };


}
