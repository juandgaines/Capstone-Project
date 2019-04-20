package com.mytechideas.bodytracker.mainviewpager;

import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mytechideas.bodytracker.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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

    private boolean isFABOpen=false;

    private int[] colorArray=new int[] {R.color.carbs,R.color.fats,R.color.protein};
    private int[] colorArrayLabels=new int[] {Color.YELLOW,Color.RED,Color.GREEN};
    private String [] mMacroNutrientsLabels= new String[]{"Carbs","Fats","Proteins"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_home_fragment,
                container, false);
        ButterKnife.bind(this,view);

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

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 120f));
        entries.add(new BarEntry(1f, 200f));
        entries.add(new BarEntry(2f, 400f));


        BarDataSet set = new BarDataSet(entries, "BarDataSet");


        set.setColors(colorArray, getContext());

        BarData data = new BarData(set);

        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars


        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaximum(1500f);
        LimitLine lc = new LimitLine(500f, "Carbs limit");
        LimitLine lp = new LimitLine(700f, "Protein limit");
        LimitLine lf = new LimitLine(450f, "Fats limit");

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

        chart.invalidate(); // refresh


        return view;
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
}
