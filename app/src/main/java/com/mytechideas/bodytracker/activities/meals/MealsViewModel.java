package com.mytechideas.bodytracker.activities.meals;

import android.app.Application;
import android.graphics.Movie;

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

public class MealsViewModel extends AndroidViewModel {


    LiveData<RecipeDataSource> liveDataSource;
    private Executor executor;
    private  LiveData<PagedList<Recipe>>  recipePagedList;



    public MealsViewModel(@NonNull Application application) {
        super(application);

        EdamamService edamamService= RetrofitEdamanInstance.getService();
        RecipeDataSourceFactory recipeDataSourceFactory= new RecipeDataSourceFactory(edamamService,application);

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
