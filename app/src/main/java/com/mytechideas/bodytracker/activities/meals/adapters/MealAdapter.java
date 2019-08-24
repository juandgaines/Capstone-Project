package com.mytechideas.bodytracker.activities.meals.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.retrofit.edemam.Recipe;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MealAdapter extends PagedListAdapter<Recipe, MealAdapter.MealViewHolder> {


    private Context mContext;
    private OnClickRecipe onClickRecipe;

    public interface OnClickRecipe{
        void onClickItemRecipe(Recipe recipe);
    }

    public MealAdapter(Context context, OnClickRecipe onClickRecipe) {
        super(Recipe.CALLBACK);
        mContext=context;
        this.onClickRecipe=onClickRecipe;

    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate( R.layout.recycler_meal_item,parent,false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {

        Recipe recipe =getItem(position);

        if(recipe!=null) {

            Picasso.get().load(recipe.getImage()).resize(370, 500).into(holder.mealImageView);
            holder.mealTitleView.setText(recipe.getLabel());
        }
        else {

            Toast.makeText(mContext,"Meal is null",Toast.LENGTH_LONG).show();
        }

    }



    public class  MealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mealImageView;
        public TextView mealTitleView;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            mealImageView= (ImageView)itemView.findViewById(R.id.meal_image);
            mealTitleView= (TextView) itemView.findViewById(R.id.meal_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                int adapterPosition=getAdapterPosition();
                Recipe recipe = getItem(adapterPosition);
                onClickRecipe.onClickItemRecipe(recipe);
        }
    }

}
