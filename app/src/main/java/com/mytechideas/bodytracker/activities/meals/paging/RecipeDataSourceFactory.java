package com.mytechideas.bodytracker.activities.meals.paging;

import android.app.Application;

import com.mytechideas.bodytracker.retrofit.edemam.EdamamService;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class RecipeDataSourceFactory extends DataSource.Factory {

    private RecipeDataSource recipeDataSource;
    private EdamamService edamamService;
    private MutableLiveData<RecipeDataSource> mutableLiveData;
    private String mQuery;

    public RecipeDataSourceFactory(EdamamService edamamService, String mQuery) {
        this.edamamService = edamamService;
        this.mQuery=mQuery;
        if(mutableLiveData==null){
            mutableLiveData= new MutableLiveData<>();
        }


    }

    @Override
    public DataSource create() {

        recipeDataSource= new RecipeDataSource(edamamService,mQuery);
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
