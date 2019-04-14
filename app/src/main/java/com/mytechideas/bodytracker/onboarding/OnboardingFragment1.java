package com.mytechideas.bodytracker.onboarding;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mytechideas.bodytracker.R;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class OnboardingFragment1 extends Fragment implements AdapterView.OnItemSelectedListener {

    public final String LOG_TAG= OnboardingFragment1.class.getSimpleName();
    @BindView(R.id.name_view)
    EditText mUserName;
    @BindView(R.id.date_view)
    EditText mDateView;
    @BindView(R.id.gender_spinner)
    Spinner mSpinner;
    @BindView(R.id.lifestyle_recycler_view)
    RecyclerView mRecyclerView;

    private String mName;
    private Calendar c;
    private int mYear;
    private int mMonth;
    private int mDay;
    DatePickerDialog datePickerDialog;
    private String mGender;
    private GridLayoutManager layoutManager;

    private AdapterCardTextAndImage mAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_fragment1,
                container, false);

        ButterKnife.bind(this,view);

        c=Calendar.getInstance();

        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);

        mUserName.setText(mName);
        mUserName.setEnabled(false);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setOnItemSelectedListener(this);
        mSpinner.setAdapter(adapter);


        mDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        mDateView.setText(year +"/"+ (month+1)+"/"+day);

                        mYear=year;
                        mMonth=month;
                        mDay=day;

                        Log.d(LOG_TAG,"Date:"+year +"/"+ (month)+"/"+day);
                    }
                },mYear,mMonth,mDay);
                datePickerDialog.show();
            }
        });

        mRecyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter= new AdapterCardTextAndImage(getContext());

        mRecyclerView.setAdapter(mAdapter);

        return view;


    }

    public void setName(String name) {
     mName=name;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        mGender=(String) parent.getItemAtPosition(pos);
        Log.d(LOG_TAG,"Gender:"+mGender);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
