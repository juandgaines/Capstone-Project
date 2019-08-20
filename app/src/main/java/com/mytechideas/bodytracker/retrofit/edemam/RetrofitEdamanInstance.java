package com.mytechideas.bodytracker.retrofit.edemam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytechideas.bodytracker.retrofit.nutritionix.NutritionixService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEdamanInstance {

    private static Retrofit retrofit = null;
    private static final String BASE_URL_RETROFIT="https://api.edamam.com/";


    public static EdamamService getService(){


        if(retrofit==null){

            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL_RETROFIT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(EdamamService.class);

    }


}
