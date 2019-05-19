package com.mytechideas.bodytracker.retrofit.edemam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytechideas.bodytracker.retrofit.nutritionix.NutritionixService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEdamanInstance {

    private static final Object LOCK =new Object();
    private static Retrofit sInstance;



    private static final String BASE_URL_RETROFIT="https://api.edamam.com/";

    private static Retrofit getRetroInstance(){
        if(sInstance==null){
            synchronized (LOCK){
                Gson gson= new GsonBuilder().create();
                sInstance=new Retrofit.Builder()
                        .baseUrl(BASE_URL_RETROFIT)
                        .addConverterFactory(GsonConverterFactory.create(gson)).build();
            }
        }
        return sInstance;
    }

    public static EdamamService getEdamanService(){
        return getRetroInstance().create(EdamamService.class);
    }


}