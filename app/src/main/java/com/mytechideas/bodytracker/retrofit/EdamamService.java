package com.mytechideas.bodytracker.retrofit;

import com.google.firebase.database.core.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EdamamService {

    @GET("search")
    Call<Example> searchRecipesByKeyWord(@Query("q") String word, @Query("app_id") String appId,@Query("app_key") String appKey);

    @GET("api/food-database/parser")
    Call<FoodAPI> listProductUPC(@Query("upc") String upccode, @Query("app_id") String appId,@Query("app_key") String appKey);
    @POST("api/food-database/nutrients")
    Call<NutrientsCall> getNutritionsFromUPC(@Body NutrientsCall mNutrients, @Query("app_id") String appId, @Query("app_key") String appKey);

}


//https://api.edamam.com/search