package com.mytechideas.bodytracker.mainviewpager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.onboarding.AdapterCardTextAndImage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;



public class MainMealsFragment extends Fragment {

    @BindView(R.id.meals_recyclerview)
    RecyclerView mMealsRecyclerView;

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



        mAdapter= new AdapterMeals(getContext());

        mMealsRecyclerView.setAdapter(mAdapter);

        return view;

    }
}
