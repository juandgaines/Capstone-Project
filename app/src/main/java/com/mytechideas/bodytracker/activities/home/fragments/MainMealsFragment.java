package com.mytechideas.bodytracker.activities.home.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.meals.adapters.AdapterMeals;
import com.mytechideas.bodytracker.activities.meals.MealsGridActivity;
import com.mytechideas.bodytracker.models.MealsType;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
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
                FireMissilesDialogFragment dialogFragment= new FireMissilesDialogFragment();
                dialogFragment.show(getActivity().getSupportFragmentManager(), "query");
            }
        });
        return view;

    }

    @Override
    public void onClick(MealsType mealsType) {


        Intent intent=new Intent(getActivity(), MealsGridActivity.class);

        intent.putExtra(QUERY_TEXT_KEY, mealsType.getmTitle());

        getActivity().startActivity(intent);


    }


    public static class FireMissilesDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            LayoutInflater inflater= requireActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_search_query_parameter, null);

            builder.setView(view)
                    .setPositiveButton(R.string.search, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            EditText queryText=(EditText) view.findViewById(R.id.query_recipe);
                            String queryString=queryText.getText().toString();

                            Intent intent=new Intent(getActivity(), MealsGridActivity.class);

                            intent.putExtra(QUERY_TEXT_KEY, queryString);

                            getActivity().startActivity(intent);
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            return builder.create();
        }
    }
}
