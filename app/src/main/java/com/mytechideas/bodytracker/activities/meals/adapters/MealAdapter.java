package com.mytechideas.bodytracker.activities.meals.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MealAdapter extends PagedListAdapter<Recipe, MealAdapter.MealViewHolder> {


    private Context mContext;

    public MealAdapter(Context context) {
        super(DIFF_CALLBACK);

        mContext=context;

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


    private static DiffUtil.ItemCallback<Recipe> DIFF_CALLBACK= new DiffUtil.ItemCallback<Recipe>() {
        @Override
        public boolean areItemsTheSame(@NonNull Recipe oldItem, @NonNull Recipe newItem) {
            return oldItem.getUri().equals(newItem.getUri());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Recipe oldItem, @NonNull Recipe newItem) {
            return oldItem.equals(newItem);
        }
    };


    public class  MealViewHolder extends RecyclerView.ViewHolder{

        public ImageView mealImageView;
        public TextView mealTitleView;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            mealImageView= (ImageView)itemView.findViewById(R.id.meal_image);
            mealTitleView= (TextView) itemView.findViewById(R.id.meal_title);

        }
    }

}
