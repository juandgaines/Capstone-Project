package com.mytechideas.bodytracker.activities.meals.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MealsViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final String query;

    public  MealsViewModelFactory(String mQuery){
        this.query=mQuery;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)  new MealsViewModel(query);
    }
}
