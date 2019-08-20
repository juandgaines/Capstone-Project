package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNutritionixInstance {

        private static final Object LOCK =new Object();
        private static Retrofit sInstance;



        private static final String BASE_URL_RETROFIT="https://trackapi.nutritionix.com/v2/";

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

        public static NutritionixService getNutritionixService(){
            return getRetroInstance().create(NutritionixService.class);
    }


}
