package com.mytechideas.bodytracker.retrofit;

import com.google.firebase.database.core.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EdamamService {

    @GET("search")
    Call<Example> listRepos(@Query("q") String word, @Query("app_id") String appId,@Query("app_key") String appKey);
}


//https://api.edamam.com/search