package com.mytechideas.bodytracker.activities.home.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.inputvoice.VoiceInputActivity;
import com.mytechideas.bodytracker.activities.inputbarcode.InputBarcodeActivity;
import com.mytechideas.bodytracker.models.FoodDataForFireBase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainHomeFragment extends Fragment implements OnChartValueSelectedListener {
    @BindView(R.id.daily_bar_chart_data)
    BarChart chart;
    @BindView(R.id.fab_main)
    FloatingActionButton mFabMain;
    @BindView(R.id.fab_op1)
    FloatingActionButton mFabOp1;
    @BindView(R.id.fab_op2)
    FloatingActionButton mFabOp2;
    @BindView(R.id.fab_op3)
    FloatingActionButton mFabOp3;

    public static final String TAG=MainHomeFragment.class.getSimpleName();

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mCaloriesDataReference;
    private ChildEventListener mEventListenerDaily;

    private float dailyCalories=0f;
    private float dailyFats=0f;
    private float dailyProteins=0f;
    private float dailyCarbs=0f;

    private boolean isFABOpen=false;

    private int[] colorArray=new int[] {R.color.carbs,R.color.fats,R.color.protein};
    private int[] colorArrayLabels=new int[] {Color.YELLOW,Color.RED,Color.GREEN};
    private String [] mMacroNutrientsLabels= new String[]{"Carbs","Fats","Proteins"};
    private String mUserID;

    private List<BarEntry> entries = new ArrayList<>();
    private float mMaxProtein;
    private float mMaxCarbs;
    private float mMaxFats;
    private float mMaxCalories;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_fragment,
                container, false);
        ButterKnife.bind(this,view);


        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getContext());

        mUserID=sharedPreferences.getString(getString(R.string.id_user_firebase_app),"");

        mMaxCalories=sharedPreferences.getFloat(getString(R.string.id_user_max_calories),0f);
        mMaxProtein=sharedPreferences.getFloat(getString(R.string.id_user_max_protein),0f);
        mMaxCarbs=sharedPreferences.getFloat(getString(R.string.id_user_max_carbs),0f);
        mMaxFats=sharedPreferences.getFloat(getString(R.string.id_user_max_fats),0f);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mCaloriesDataReference=mFirebaseDatabase.getReference().child("calories").child(mUserID);


        Calendar calendar=Calendar.getInstance();
        String mDateFormatted= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        Query query=mCaloriesDataReference.orderByChild("mDateFormatted").equalTo(mDateFormatted);
        attachReadDatabaseListener();
        mCaloriesDataReference.addChildEventListener(mEventListenerDaily);

        mCaloriesDataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                    FoodDataForFireBase data= postSnapshot.getValue(FoodDataForFireBase.class);

                    dailyCalories+= data.getmCalories();
                    dailyCarbs +=data.getmCarbs();
                    dailyProteins+=data.getmProtein();
                    dailyFats+=data.getmFats();

                }

                chart.clear();
                barChart();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        mFabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });

        mFabOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), InputBarcodeActivity.class);
                startActivity(intent);
            }
        });


        mFabOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), VoiceInputActivity.class);
                startActivity(intent);
            }
        });

        //barChart();


        return view;
    }

    private void attachReadDatabaseListener() {

        if(mEventListenerDaily==null) {
            mEventListenerDaily = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    FoodDataForFireBase data = dataSnapshot.getValue(FoodDataForFireBase.class);

                    dailyCalories += data.getmCalories();
                    dailyCarbs += data.getmCarbs();
                    dailyFats += data.getmFats();
                    dailyProteins += data.getmProtein();
                    barChart();

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {


                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
        }
    }

    private void barChart() {

        chart.clear();
        entries.clear();
        entries.add(new BarEntry(0f, dailyCarbs));
        entries.add(new BarEntry(1f, dailyFats));
        entries.add(new BarEntry(2f, dailyProteins));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        set.setColors(colorArray, getContext());

        BarData data = new BarData(set);

        data.setBarWidth(0.9f); // set custom bar width

        chart.setData(data);

        chart.setFitBars(true); // make the x-axis fit exactly all bars


        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaximum(mMaxCalories/2);



        LimitLine lc = new LimitLine(mMaxCarbs, "Carbs limit");
        LimitLine lp = new LimitLine(mMaxProtein, "Protein limit");
        LimitLine lf = new LimitLine(mMaxFats, "Fats limit");

        lc.setLineColor(Color.YELLOW);
        lc.setLineWidth(4f);
        lc.setTextColor(Color.BLACK);
        lc.setTextSize(12f);
// .. and more styling options
        leftAxis.addLimitLine(lc);

        lp.setLineColor(Color.GREEN);
        lp.setLineWidth(4f);
        lp.setTextColor(Color.BLACK);
        lp.setTextSize(12f);
// .. and more styling options
        leftAxis.addLimitLine(lp);

        lf.setLineColor(Color.RED);
        lf.setLineWidth(4f);
        lf.setTextColor(Color.BLACK);
        lf.setTextSize(12f);
// .. and more styling options
        leftAxis.addLimitLine(lf);

        Legend legend=chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);

        LegendEntry[] legendEntries= new LegendEntry[3];

        for(int i=0; i<legendEntries.length;i++){
            LegendEntry entry=new LegendEntry();
            entry.formColor=colorArrayLabels[i];
            entry.label=mMacroNutrientsLabels[i];
            legendEntries[i]=entry;
        }
        legend.setCustom(legendEntries);

        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.invalidate(); // refresh
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }


    private void showFABMenu(){
        isFABOpen=true;
        AnimatedVectorDrawable addToCancel= (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.avd_add_to_cancel);
        mFabMain.setImageDrawable(addToCancel);

        mFabOp1.animate().translationY(-getResources().getDimension(R.dimen.standard_60));
        mFabOp2.animate().translationY(-getResources().getDimension(R.dimen.standard_120));
        mFabOp3.animate().translationY(-getResources().getDimension(R.dimen.standard_180));
        addToCancel.start();
    }

    private void closeFABMenu(){
        isFABOpen=false;
        AnimatedVectorDrawable cancelToAdd= (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.avd_cancel_to_add);
        mFabMain.setImageDrawable(cancelToAdd);
        mFabOp1.animate().translationY(0);
        mFabOp2.animate().translationY(0);
        mFabOp3.animate().translationY(0);
        cancelToAdd.start();
    }


    public void onSignedOutCleanUp(){
        entries.clear();
        dailyCarbs=0;
        dailyFats=0;
        dailyProteins=0;
        mMaxCalories=0;
        mUserID=null;
        dettachReadDatabaseListener();

    }

    @Override
    public void onPause() {
        super.onPause();
        dettachReadDatabaseListener();
    }

    private void dettachReadDatabaseListener() {
        if(mEventListenerDaily!=null) {
            mCaloriesDataReference.removeEventListener(mEventListenerDaily);
            mEventListenerDaily=null;
        }
    }
}
