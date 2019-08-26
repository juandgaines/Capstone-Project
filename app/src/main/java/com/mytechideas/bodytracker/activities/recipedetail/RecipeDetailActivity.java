package com.mytechideas.bodytracker.activities.recipedetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.meals.MealsGridActivity;
import com.mytechideas.bodytracker.activities.recipedetail.adapter.IngredientsAdapter;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends AppCompatActivity {


    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView mRecipeImageToolbar;

    @BindView(R.id.recycler_ingredients)
    RecyclerView mRecyclerIngredients;

    @BindView(R.id.servings_value)
    TextView mServings;
    @BindView(R.id.total_calories_value)
    TextView mTotalCalories;
    @BindView(R.id.cooking_time_value)
    TextView mCookingTime;
    @BindView(R.id.serving_calories_value)
    TextView mServingCalories;
    @BindView(R.id.go_to_instructions_button)
    Button mGoToInstructions;
    @BindView(R.id.pieChart)
    PieChart pieChart;

    @BindView(R.id.additional_info)
    ImageView mInfoButton;

    private IngredientsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Recipe recipe;

    private String scene="A";



    private int[] colorArray=new int[] {R.color.carbs,R.color.fats,R.color.protein};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);
        collapsingToolbarLayout=((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout));
        mRecipeImageToolbar= collapsingToolbarLayout.findViewById(R.id.image_recipe);

        getWindow().getSharedElementEnterTransition().addListener(new android.transition.Transition.TransitionListener() {
            @Override
            public void onTransitionStart(android.transition.Transition transition) {

            }

            @Override
            public void onTransitionEnd(android.transition.Transition transition) {
                setPieChart();
            }

            @Override
            public void onTransitionCancel(android.transition.Transition transition) {

            }

            @Override
            public void onTransitionPause(android.transition.Transition transition) {

            }

            @Override
            public void onTransitionResume(android.transition.Transition transition) {

            }
        });
        Intent intent =getIntent();
        if(intent!=null && intent.hasExtra(MealsGridActivity.RECIPE_EXTRA_KEY_DETAIL)) {
            recipe = intent.getParcelableExtra(MealsGridActivity.RECIPE_EXTRA_KEY_DETAIL);
            collapsingToolbarLayout.setTitle(recipe.getLabel());
            Picasso.get().load(recipe.getImage()).into(mRecipeImageToolbar);
            mServings.setText(recipe.getYield().toString());
            mCookingTime.setText(recipe.getTotalTime().toString());
            mTotalCalories.setText(recipe.getCalories().toString());

            mGoToInstructions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(recipe.getUrl()));
                    startActivity(intent);
                }
            });
            Double mCaloriesPerServing=null;
            try{
                mCaloriesPerServing=recipe.getCalories()/recipe.getYield();
            }
            catch (Exception e){
                mCaloriesPerServing=0.0;
            }
            finally {
                mServingCalories.setText(mCaloriesPerServing.toString());
            }
            setPieChart();

            mRecyclerIngredients.setHasFixedSize(true);

            // use a linear layout manager
            layoutManager = new LinearLayoutManager(this);
            mRecyclerIngredients.setLayoutManager(layoutManager);

            // specify an adapter (see also next example)
            mAdapter = new IngredientsAdapter(recipe.getIngredientLines());
            mRecyclerIngredients.setAdapter(mAdapter);

            mInfoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(scene.equals("A")) {
                        scene = "B";
                        TransitionManager.go(
                                Scene.getSceneForLayout(
                                        (ViewGroup) findViewById(R.id.scene),
                                        R.layout.activity_recipe_detail_scene_b,
                                        RecipeDetailActivity.this
                                )
                        );
                    }
                    else {
                        scene = "A";
                        TransitionManager.go(
                                Scene.getSceneForLayout(
                                        (ViewGroup) findViewById(R.id.scene),
                                        R.layout.activity_recipe_detail_scene_a,
                                        RecipeDetailActivity.this
                                )
                        );
                    }




                }
            });


        }



    }

    private void setPieChart() {
        if (scene.equals("A")) {
            List<PieEntry> entries = new ArrayList<>();

            entries.add(new PieEntry(recipe.getTotalNutrients().getCHOCDF().getQuantity().floatValue(), "Carbs"));
            entries.add(new PieEntry(recipe.getTotalNutrients().getFAT().getQuantity().floatValue(), "Fats"));
            entries.add(new PieEntry(recipe.getTotalNutrients().getPROCNT().getQuantity().floatValue(), "Protein"));

            PieDataSet set = new PieDataSet(entries, "Macro-nutrients summary");
            set.setColors(colorArray, this);
            PieData data = new PieData(set);
            pieChart.setData(data);
            pieChart.invalidate();
        }
        else {
            PieChart pieChart2=(PieChart)findViewById(R.id.pieChart2);

            List<PieEntry> entries = new ArrayList<>();

            entries.add(new PieEntry(recipe.getTotalNutrients().getCHOCDF().getQuantity().floatValue(), "Carbs"));
            entries.add(new PieEntry(recipe.getTotalNutrients().getFAT().getQuantity().floatValue(), "Fats"));
            entries.add(new PieEntry(recipe.getTotalNutrients().getPROCNT().getQuantity().floatValue(), "Protein"));

            PieDataSet set = new PieDataSet(entries, "Macro-nutrients summary");
            set.setColors(colorArray, this);
            PieData data = new PieData(set);
            pieChart2.setData(data);
            pieChart2.invalidate();
        }
    }

}
