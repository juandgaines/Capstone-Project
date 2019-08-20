package com.mytechideas.bodytracker.activities.meals;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.mytechideas.bodytracker.retrofit.edemam.EdamamService;
import com.mytechideas.bodytracker.retrofit.edemam.Example;
import com.mytechideas.bodytracker.retrofit.edemam.Hit;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;
import com.mytechideas.bodytracker.retrofit.edemam.RetrofitEdamanInstance;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeDataSource extends PageKeyedDataSource<Integer, Recipe> {

    private EdamamService service;
    private Application application;


    public RecipeDataSource(EdamamService service, Application application) {
        this.service = service;
        this.application = application;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Recipe> callback) {


        service=RetrofitEdamanInstance.getService();
        Call<Example> call= service.searchRecipesByKeyWord("Breakfast",0,10,"34140566","d8433c8aab6289c965fde93fa01378de");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                List<Recipe> recipes= new ArrayList<Recipe>();
                if (response.body()!=null && response.body().getHits()!=null){

                    for(Hit hit:response.body().getHits()){

                        recipes.add(hit.getRecipe());

                    }
                    callback.onResult(recipes,null, 2);
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.v("Retrofit", t.getMessage());
            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Recipe> callback) {

        int from= (params.key-1)*10;
        int to=from+10;

        if(from<0){
            from=0;
            to=10;
        }
        if(service==null)
            service=RetrofitEdamanInstance.getService();
        Call<Example> call= service.searchRecipesByKeyWord("Breakfast",from,to,"34140566","d8433c8aab6289c965fde93fa01378de");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                List<Recipe> recipes= new ArrayList<Recipe>();
                if (response.body()!=null && response.body().getHits().size()>0){

                    for(Hit hit:response.body().getHits()){

                        recipes.add(hit.getRecipe());

                    }

                    callback.onResult(recipes,params.key-1);
                }


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.v("Retrofit", t.getMessage());
            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Recipe> callback) {

        int from= (params.key-1)*10;
        int to=from+10;
        if(service==null)
            service=RetrofitEdamanInstance.getService();
        Call<Example> call= service.searchRecipesByKeyWord("Breakfast",from,to,"34140566","d8433c8aab6289c965fde93fa01378de");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                List<Recipe> recipes= new ArrayList<Recipe>();
                if (response.body()!=null && response.body().getHits().size()>0){

                    for(Hit hit:response.body().getHits()){

                        recipes.add(hit.getRecipe());

                    }
                    callback.onResult(recipes, params.key+1);
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.v("Retrofit", t.getMessage());
            }
        });
    }
}

