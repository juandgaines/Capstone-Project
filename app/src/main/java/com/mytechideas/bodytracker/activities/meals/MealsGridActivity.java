package com.mytechideas.bodytracker.activities.meals;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.home.fragments.MainMealsFragment;
import com.mytechideas.bodytracker.activities.meals.adapters.MealAdapter;
import com.mytechideas.bodytracker.activities.meals.viewmodel.MealsViewModel;
import com.mytechideas.bodytracker.activities.meals.viewmodel.MealsViewModelFactory;
import com.mytechideas.bodytracker.activities.recipedetail.RecipeDetailActivity;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;

public class MealsGridActivity extends AppCompatActivity implements MealAdapter.OnClickRecipe{


    @BindView(R.id.meals_list_recycler)
    RecyclerView mRecyclerView;

    MealsViewModel mealsViewModel;
    MealAdapter mAdapter;

    PagedList<Recipe> listOfRecepies;
    public static final String RECIPE_EXTRA_KEY_DETAIL= "extra_recipe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_grid);
        ButterKnife.bind(this);
        Intent intent=getIntent();

        if(intent!=null && intent.hasExtra(MainMealsFragment.QUERY_TEXT_KEY)){

            String query =intent.getStringExtra(MainMealsFragment.QUERY_TEXT_KEY);
            GridLayoutManager layoutManager= new GridLayoutManager(this,2);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(layoutManager);
            MealsViewModelFactory mealsViewModelFactory=new MealsViewModelFactory(query);
            mealsViewModel= ViewModelProviders.of(this,mealsViewModelFactory).get(MealsViewModel.class);
            getRecipes();

        }
    }

    private void getRecipes() {

        mealsViewModel.getRecipePagedList().observe(this, new Observer<PagedList<Recipe>>() {
            @Override
            public void onChanged(@Nullable PagedList<Recipe> recipesFromLiveData) {

                listOfRecepies=recipesFromLiveData;
                showOnRecyclerView();

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();


    }

    private void showOnRecyclerView() {
        mAdapter = new MealAdapter(this,this);
        mAdapter.submitList(listOfRecepies);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickItemRecipe(Recipe recipe) {
        Intent intent=new Intent(this, RecipeDetailActivity.class);
        intent.putExtra(RECIPE_EXTRA_KEY_DETAIL,recipe);
        startActivity(intent);

    }

}
