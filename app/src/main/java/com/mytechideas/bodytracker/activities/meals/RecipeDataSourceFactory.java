package com.mytechideas.bodytracker.activities.meals;

import android.app.Application;

import com.mytechideas.bodytracker.activities.meals.RecipeDataSource;
import com.mytechideas.bodytracker.retrofit.edemam.EdamamService;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class RecipeDataSourceFactory extends DataSource.Factory {

    private RecipeDataSource recipeDataSource;
    private EdamamService edamamService;
    private Application application;
    private MutableLiveData<RecipeDataSource> mutableLiveData;

    public RecipeDataSourceFactory(EdamamService edamamService, Application application) {
        this.edamamService = edamamService;
        this.application = application;
        if(mutableLiveData==null){
            mutableLiveData= new MutableLiveData<>();
        }


    }

    @Override
    public DataSource create() {

        recipeDataSource= new RecipeDataSource(edamamService,application);
        mutableLiveData.postValue(recipeDataSource);
        return recipeDataSource;
    }

    public MutableLiveData<RecipeDataSource> getMutableLiveData() {
        if(mutableLiveData==null){
            mutableLiveData=new MutableLiveData<>();
        }
        return mutableLiveData;
    }



}
