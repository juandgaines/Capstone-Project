package com.mytechideas.bodytracker.activities.meals;

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

    private static final int PAGE=1;



    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Recipe> callback) {

        EdamamService service= RetrofitEdamanInstance.getEdamanService();
        int from= (PAGE-1)*10;
        int to=from+10;

        service.searchRecipesByKeyWord("Breakfast",from,to,"34140566","d8433c8aab6289c965fde93fa01378de").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.body()!=null && response.body().getHits().size()>0){

                    List<Recipe> recipes= new ArrayList<Recipe>();
                    for(Hit hit:response.body().getHits()){

                        recipes.add(hit.getRecipe());

                    }
                    callback.onResult(recipes,null,PAGE+1);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Recipe> callback) {


        EdamamService service= RetrofitEdamanInstance.getEdamanService();
        int from= (params.key-1)*10;
        int to=from+10;

        service.searchRecipesByKeyWord("Breakfast",from,to,"34140566","d8433c8aab6289c965fde93fa01378de").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {



                if (response.body()!=null && response.body().getHits().size()>0){
                    Integer key= (params.key>1)? params.key-1: null;

                    List<Recipe> recipes= new ArrayList<Recipe>();
                    for(Hit hit:response.body().getHits()){

                        recipes.add(hit.getRecipe());


                    }
                    callback.onResult(recipes,key);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Recipe> callback) {

        EdamamService service= RetrofitEdamanInstance.getEdamanService();
        int from= (params.key-1)*10;
        int to=from+10;

        service.searchRecipesByKeyWord("Breakfast",from,to,"34140566","d8433c8aab6289c965fde93fa01378de").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.body()!=null && response.body().getHits().size()>0){
                    Integer key= (response.body().getMore())? params.key+1: null;
                    List<Recipe> recipes= new ArrayList<Recipe>();
                    for(Hit hit:response.body().getHits()){

                        recipes.add(hit.getRecipe());


                    }
                    callback.onResult(recipes,key);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}
