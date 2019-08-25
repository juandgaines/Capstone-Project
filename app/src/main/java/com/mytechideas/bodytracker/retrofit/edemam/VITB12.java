
package com.mytechideas.bodytracker.retrofit.edemam;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VITB12 extends BaseNutrient implements Parcelable {

    /**
     * No args constructor for use in serialization
     *
     */
    public VITB12() {
    }

    /**
     *
     * @param unit
     * @param quantity
     * @param label
     */
    public VITB12(String label, Double quantity, String unit) {
        super(label,quantity,unit);
    }

    public String getLabel() {
        return super.getLabel();
    }

    public void setLabel(String label) {
        super.setLabel(label);
    }

    public Double getQuantity() {
        return super.getQuantity();
    }

    public void setQuantity(Double quantity) {
        super.setQuantity(quantity);
    }

    public String getUnit() {
        return super.getUnit();
    }

    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {

        dest.writeString(super.getLabel());
        dest.writeDouble(super.getQuantity());
        dest.writeString(super.getUnit());

    }

    public VITB12(Parcel parcel){
        super.setLabel(parcel.readString());
        super.setQuantity(parcel.readDouble());
        super.setUnit(parcel.readString());
    }


    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<VITB12> CREATOR = new Parcelable.Creator<VITB12>(){

        @Override
        public VITB12 createFromParcel(Parcel parcel) {
            return new VITB12(parcel);
        }

        @Override
        public VITB12[] newArray(int size) {
            return new VITB12[0];
        }
    };

}