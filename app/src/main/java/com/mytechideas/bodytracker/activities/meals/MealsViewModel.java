package com.mytechideas.bodytracker.activities.meals;

import com.mytechideas.bodytracker.retrofit.edemam.Recipe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class MealsViewModel extends ViewModel {


    public LiveData<PagedList<Recipe>> recipePagedList;
    public LiveData<RecipeDataSource> liveDataSource;


    public MealsViewModel(){

        //executor = Executors.newFixedThreadPool(5);


        RecipeDataSourceFactory recipeDataSourceFactory= new RecipeDataSourceFactory();

        liveDataSource=recipeDataSourceFactory.getRecipeLiveDataSource();

        PagedList.Config config=(new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build();

        recipePagedList= (new LivePagedListBuilder(recipeDataSourceFactory,config)).build();

    }

    public LiveData<PagedList<Recipe>> getRecipePagedList() {
        return recipePagedList;
    }
}
