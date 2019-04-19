package com.mytechideas.bodytracker.onboarding;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.service.autofill.UserData;
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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
    @BindView(R.id.weight_view)
    EditText mWeight;
    @BindView(R.id.height_view)
    EditText mHeight;
    @BindView(R.id.lifestyle_recycler_view)
    RecyclerView mRecyclerView;

    private String mName;
    private String mFirebaseUI;
    private Calendar c;
    private int mYear;
    private int mMonth;
    private int mDay;
    DatePickerDialog datePickerDialog;
    private String mGender;
    private GridLayoutManager layoutManager;
    private int edad=-1;



    private AdapterCardTextAndImage mAdapter;
    private UserDataBT data;


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
        int Actual=mYear;

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
                        edad=Actual-mYear;

                        if(mMonth<month){
                            edad--;
                        }
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

    public boolean validateUserData() {
        float numericalWeight;
        float numericalHeight;
        String[] list= getResources().getStringArray(R.array.gender_array);
        if (edad <= 18) {
            Toast.makeText(getContext(),"No menores de edad",Toast.LENGTH_LONG).show();
            return false;
        }
        if(mGender.equals(list[0])){
            Toast.makeText(getContext(),"Seleccione genero valido",Toast.LENGTH_LONG).show();
            return false;
        }
        String weight=mWeight.getText().toString();
        if(weight.equals("")){
            Toast.makeText(getContext(),"Poner peso...",Toast.LENGTH_LONG).show();
            return false;
        }
        else{
             numericalWeight=Float.parseFloat(weight);

        }

        String height=mHeight.getText().toString();
        if(height.equals("")){
            Toast.makeText(getContext(),"Poner altura...",Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            numericalHeight=Float.parseFloat(height);

        }

        if (mAdapter.getLifestyleOption()<0){
            Toast.makeText(getContext(),"Seleccione estilo de vida...",Toast.LENGTH_LONG).show();
            return false;
        }


        data= new UserDataBT(mName,edad,mGender,numericalWeight,numericalHeight,mAdapter.getLifestyleOption());

        return true;
    }


    public void setUID(String mFirebaseuid) {
        this.mFirebaseUI=mFirebaseuid;
    }

    public UserDataBT getUserData() {
        return data;
    }
}
