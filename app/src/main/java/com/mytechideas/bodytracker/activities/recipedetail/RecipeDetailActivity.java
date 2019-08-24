package com.mytechideas.bodytracker.activities.recipedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.meals.MealsGridActivity;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Intent intent =getIntent();
        if(intent!=null && intent.hasExtra(MealsGridActivity.RECIPE_EXTRA_KEY_DETAIL));
            Recipe recipe =intent.getParcelableExtra(MealsGridActivity.RECIPE_EXTRA_KEY_DETAIL);
    }
}
