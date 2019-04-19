package com.mytechideas.bodytracker.onboarding;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mytechideas.bodytracker.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingFragment3 extends Fragment implements AdapterBodyType.OnClickPErBody{

    @BindView(R.id.body_recyclerview)
    RecyclerView mBodyRecyclerView;

    @BindView(R.id.target_calories_value)
    TextView mTargetCaloriesView;

    @BindView(R.id.protein_percentage_value)
    TextView mProteinPercentageView;

    @BindView(R.id.carbs_percentage_value)
    TextView mCarbsPercentageView;

    @BindView(R.id.fats_percentage_value)
    TextView mFatsPercentageView;


    private AdapterBodyType mAdapter;
    private UserDataBT mUserDataBT;
    private Double mTargetCalories;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mUserDataReference;
    private String mFirebaseUI;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_fragment3,
                container, false);

        ButterKnife.bind(this,view);
        mFirebaseDatabase=FirebaseDatabase.getInstance();

        mBodyRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mBodyRecyclerView.setLayoutManager(layoutManager);



        //Toast.makeText(getContext(),"Gender: "+mUserDataBT.getmGender(),Toast.LENGTH_LONG).show(

        return view;
    }

    public void setConfigurationForFragment3(UserDataBT userDataBT) {

        mUserDataBT=userDataBT;
        mAdapter= new AdapterBodyType(getContext(),this);
        mBodyRecyclerView.setAdapter(mAdapter);

        String[] list= getResources().getStringArray(R.array.gender_array);
        if(mUserDataBT.getmGender().equals(list[1])){
            //Male
            //Hombre= ( 66+(13.7*pesokg + ((5*alturacm-6.8*edad)*factorDeActividad)
            mTargetCalories=(66.47+ (13.75* mUserDataBT.getmWeight())+ (5.003*mUserDataBT.getmHeight())-(6.755*mUserDataBT.getEdad()))*mUserDataBT.getmLifeStyleFactor();
        }
        else if (mUserDataBT.getmGender().equals(list[2])){
            //Female
            //(655 +(9.6 * pesoKg) +1.8 * altura(cm) -(4.7*edad))*factorDeActividad
            mTargetCalories=(655.1+ (9.563* mUserDataBT.getmWeight())+ (1.850*mUserDataBT.getmHeight())-(4.676*mUserDataBT.getEdad()))*mUserDataBT.getmLifeStyleFactor();

        }
        mTargetCalories= BigDecimal.valueOf(mTargetCalories)
                .setScale(0, RoundingMode.HALF_UP)
                .doubleValue();

        if(mUserDataBT.getmGoal()==0){
            mTargetCalories=mTargetCalories*(1-0.20);
        }
        else if(mUserDataBT.getmGoal()==1){
            mTargetCalories=mTargetCalories;
        }
        else if(mUserDataBT.getmGoal()==2){
            mTargetCalories=mTargetCalories*(1.25);
        }
        mUserDataBT.setmTargetCalories(mTargetCalories);
        mTargetCaloriesView.setText(mTargetCalories.toString()+" cal");

    }

    public boolean validateUserData() {

        mUserDataBT.setmBodyType(mAdapter.getBodyType());

        if(mUserDataBT.getmBodyType()!=-1){

            mFirebaseDatabase.getReference().child("users").child(mFirebaseUI).removeValue();
            mUserDataReference.push().setValue(mUserDataBT);
            return true;
        }
        Toast.makeText(getContext(),"Select a bodytype in order to go forward.",Toast.LENGTH_LONG).show();
        return false;
    }


    @Override
    public void updateTargetNutirents(int option) {

        int result=option;

        if(result==0){

            mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.55)
                    .setScale(0, RoundingMode.HALF_UP)
                    .doubleValue());
            mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.20)
                    .setScale(0, RoundingMode.HALF_UP)
                    .doubleValue());
            mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.25)
                    .setScale(0, RoundingMode.HALF_UP)
                    .doubleValue());

            mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
            mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
            mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));

        }
        else if (result==1){

            if(mUserDataBT.getmGoal()==0){

                mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.35)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.35)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());

                mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
                mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
                mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));

            }
            else if(mUserDataBT.getmGoal()==1){
                mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.35)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.35)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());

                mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
                mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
                mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));

            }
            else{

                mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.35)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.35)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());

                mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
                mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
                mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));
            }

        }

        else if(result==2){
            if(mUserDataBT.getmGoal()==0){

                mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.40)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());

                mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
                mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
                mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));

            }
            else if(mUserDataBT.getmGoal()==1){
                mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.40)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());

                mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
                mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
                mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));

            }
            else{
                mUserDataBT.setmPerCarbs(BigDecimal.valueOf(mTargetCalories*0.40)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerFats(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());
                mUserDataBT.setmPerProtein(BigDecimal.valueOf(mTargetCalories*0.30)
                        .setScale(0, RoundingMode.HALF_UP)
                        .doubleValue());

                mCarbsPercentageView.setText( Double.toString(mUserDataBT.getmPerCarbs()));
                mFatsPercentageView.setText( Double.toString(mUserDataBT.getmPerFats()));
                mProteinPercentageView.setText( Double.toString(mUserDataBT.getmPerProtein()));

            }
        }

    }

    public void setUID(String mFirebaseuid) {
        this.mFirebaseUI=mFirebaseuid;
        mUserDataReference =mFirebaseDatabase.getReference().child("users").child(mFirebaseUI);
    }
}
