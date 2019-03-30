package com.mytechideas.bodytracker;


import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.core.Repo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytechideas.bodytracker.retrofit.EdamamService;
import com.mytechideas.bodytracker.retrofit.Example;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
