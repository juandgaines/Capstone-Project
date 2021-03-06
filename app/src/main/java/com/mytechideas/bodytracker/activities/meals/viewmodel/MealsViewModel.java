package com.mytechideas.bodytracker.activities.meals.viewmodel;

import android.app.Application;

import com.mytechideas.bodytracker.activities.meals.paging.RecipeDataSource;
import com.mytechideas.bodytracker.activities.meals.paging.RecipeDataSourceFactory;
import com.mytechideas.bodytracker.retrofit.edemam.EdamamService;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;
import com.mytechideas.bodytracker.retrofit.edemam.RetrofitEdamanInstance;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MealsViewModel extends ViewModel {


    LiveData<RecipeDataSource> liveDataSource;
    private Executor executor;
    private  LiveData<PagedList<Recipe>>  recipePagedList;
    private String mQuery="";



    public MealsViewModel(String query) {

        mQuery=query;
        EdamamService edamamService= RetrofitEdamanInstance.getService();
        RecipeDataSourceFactory recipeDataSourceFactory= new RecipeDataSourceFactory(edamamService,mQuery);
        this.mQuery=query;
        liveDataSource=recipeDataSourceFactory.getMutableLiveData();

        PagedList.Config config=(new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(5)
                .setPageSize(10)
                .setPrefetchDistance(4)
                .build();

        executor= Executors.newFixedThreadPool(5);

        recipePagedList= (new LivePagedListBuilder<Integer, Recipe>(recipeDataSourceFactory,config))
                .setFetchExecutor(executor)
                .build();
    }


    public LiveData<PagedList<Recipe>> getRecipePagedList() {
            return recipePagedList;
    }

}
