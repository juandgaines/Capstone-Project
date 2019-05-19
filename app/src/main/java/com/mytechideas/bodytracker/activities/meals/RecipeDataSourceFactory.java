package com.mytechideas.bodytracker.activities.meals;

import com.mytechideas.bodytracker.activities.meals.RecipeDataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class RecipeDataSourceFactory extends DataSource.Factory {


    private MutableLiveData<RecipeDataSource> recipeLiveDataSource=new MutableLiveData<>();



    @Override
    public DataSource create() {

        RecipeDataSource recipeDataSource=new RecipeDataSource();

        recipeLiveDataSource.postValue(recipeDataSource);

        return recipeDataSource;
    }

    public MutableLiveData<RecipeDataSource> getRecipeLiveDataSource() {

        if(recipeLiveDataSource==null){

            recipeLiveDataSource= new MutableLiveData<RecipeDataSource>();
        }
        return recipeLiveDataSource;
    }


}
