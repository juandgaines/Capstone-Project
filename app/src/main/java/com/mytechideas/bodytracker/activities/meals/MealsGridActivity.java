package com.mytechideas.bodytracker.activities.meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.home.fragments.MainMealsFragment;
import com.mytechideas.bodytracker.activities.meals.adapters.MealAdapter;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;

public class MealsGridActivity extends AppCompatActivity {


    @BindView(R.id.meals_list_recycler)
    RecyclerView mRecyclerView;

    MealsViewModel mealsViewModel;
    MealAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_grid);
        ButterKnife.bind(this);

        Intent intent=getIntent();

        if(intent!=null && intent.hasExtra(MainMealsFragment.QUERY_TEXT_KEY)){

            String query =intent.getStringExtra(MainMealsFragment.QUERY_TEXT_KEY);

            Toast.makeText(this,query,Toast.LENGTH_LONG).show();
            GridLayoutManager layoutManager= new GridLayoutManager(this,2);

            mRecyclerView.setHasFixedSize(true);

            mealsViewModel= ViewModelProviders.of(this).get(MealsViewModel.class);

           mAdapter= new MealAdapter(this);


            mealsViewModel.getRecipePagedList().observe(this, new Observer<PagedList<Recipe>>() {
                @Override
                public void onChanged(PagedList<Recipe> recipes) {

                    mAdapter.submitList(recipes);

                }
            });

            mRecyclerView.setAdapter(mAdapter);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}
