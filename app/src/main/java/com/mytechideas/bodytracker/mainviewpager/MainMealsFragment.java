package com.mytechideas.bodytracker.mainviewpager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.onboarding.AdapterBodyType;
import com.mytechideas.bodytracker.onboarding.AdapterCardTextAndImage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;



public class MainMealsFragment extends Fragment  implements AdapterMeals.MealsAdapterOnClickHandler {


    public static final String QUERY_TEXT_KEY="query_key";

    @BindView(R.id.meals_recyclerview)
    RecyclerView mMealsRecyclerView;

    @BindView(R.id.meal_search_fab)
    FloatingActionButton mMealFab;

    private AdapterMeals mAdapter;
    GridLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.main_meals_fragment,
                container, false);
        ButterKnife.bind(this,view);

        mMealsRecyclerView.setHasFixedSize(true);

        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            layoutManager = new GridLayoutManager(getContext(),2);
        }
        else {
            // In portrait
            layoutManager = new GridLayoutManager(getContext(),1);
        }

        mMealsRecyclerView.setLayoutManager(layoutManager);



        mAdapter= new AdapterMeals(getContext(),this);

        mMealsRecyclerView.setAdapter(mAdapter);

        mMealFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir actividad buscador
            }
        });
        return view;

    }

    @Override
    public void onClick(MealsType mealsType) {


        Intent intent=new Intent(getActivity(),MealsGridActivity.class);

        intent.putExtra(QUERY_TEXT_KEY, mealsType.getmTitle());

        getActivity().startActivity(intent);


    }
}
