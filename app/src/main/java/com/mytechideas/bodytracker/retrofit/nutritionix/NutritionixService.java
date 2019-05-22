package com.mytechideas.bodytracker.retrofit.nutritionix;

import com.mytechideas.bodytracker.retrofit.edemam.Example;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NutritionixService {

    @GET("search/item")
    Call<NutritionixUPCCall> getProductbyUPC(@Query("upc") String upc, @Query("x-app-id") String appId, @Query("x-app-key") String appKey);

    @POST("natural/nutrients")
    Call<NutritionixNaturalCall>getNutrientsByQuery(@Body TextQuery query, @Query("x-app-id") String appId, @Query("x-app-key") String appKey);

}
