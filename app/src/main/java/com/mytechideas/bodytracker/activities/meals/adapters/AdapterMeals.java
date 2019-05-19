package com.mytechideas.bodytracker.activities.meals.adapters;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.models.MealsType;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class AdapterMeals extends RecyclerView.Adapter<AdapterMeals.MealsViewHolder> {

    public interface MealsAdapterOnClickHandler {
        void onClick(MealsType mealsType);
    }


    private Context mContext;
    private List<MealsType> mealsTypes= new ArrayList<MealsType>();

    private MealsAdapterOnClickHandler mMealsAdapterOnClickHandler;

    public AdapterMeals(Context context, MealsAdapterOnClickHandler mealsAdapterOnClickHandler) {
        mContext=context;
        mMealsAdapterOnClickHandler= mealsAdapterOnClickHandler;

        mealsTypes.add(new MealsType(mContext.getString(R.string.meal_breakfast_title),R.drawable.meal_breakfast, mContext.getString(R.string.meal_breakfast_description)));
        mealsTypes.add(new MealsType(mContext.getString(R.string.meal_lunch_title),R.drawable.meal_lunch, mContext.getString(R.string.meal_lunch_description)));
        mealsTypes.add(new MealsType(mContext.getString(R.string.meal_dinner_title),R.drawable.meal_dinner, mContext.getString(R.string.meal_dinner_description)));
        mealsTypes.add(new MealsType(mContext.getString(R.string.meal_snacks_title),R.drawable.meal_snacks, mContext.getString(R.string.meal_snacks_description)));

    }

    @NonNull
    @Override
    public AdapterMeals.MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meals_card_layout, parent, false);
        return new MealsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMeals.MealsViewHolder holder, int position) {


        MealsType mMealtype=mealsTypes.get(position);
        holder.mMealTitleView.setText(mMealtype.getmTitle());
        Picasso.get().load(mMealtype.getmImage()).resize(1000,600).into(holder.mMealImageView);
        holder.mMealDescriptionView.setText(mMealtype.getmDescription());

    }

    @Override
    public int getItemCount() {
        return mealsTypes.size();
    }



    public  class MealsViewHolder extends RecyclerView.ViewHolder  implements View.OnLongClickListener, View.OnClickListener{

        public TextView mMealTitleView;
        public ImageView mMealImageView;
        public TextView mMealDescriptionView;
        private int blue;
        private int white;

        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);

            mMealTitleView= (TextView) itemView.findViewById(R.id.meal_title);
            mMealImageView= (ImageView) itemView.findViewById(R.id.image_meal);
            mMealDescriptionView= (TextView) itemView.findViewById(R.id.description_meal);



            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);

            if (blue == 0)
                blue = itemView.getContext().getResources().getColor(R.color.colorPrimary);
            if (white == 0)
                white = itemView.getContext().getResources().getColor(R.color.background_material_light);

        }

        @Override
        public boolean onLongClick(View view) {
            boolean isDetailed = ((ColorDrawable)view.getBackground()) != null && ((ColorDrawable)view.getBackground()).getColor() == blue;

            int finalRadius = (int)Math.hypot(view.getWidth()/2, view.getHeight()/2);

            if (isDetailed) {
                Animator anim = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth()/2, (int) view.getHeight()/2, 0, finalRadius);
                mMealTitleView.setVisibility(View.VISIBLE);
                mMealImageView.setVisibility(View.VISIBLE);
                mMealDescriptionView.setVisibility(View.INVISIBLE);
                view.setBackgroundColor(white);
                view.findViewById(R.id.background_view_meal).setBackgroundColor(white);
                anim.start();

            } else {
                Animator anim = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth()/2, (int) view.getHeight()/2, 0, finalRadius);
                mMealTitleView.setVisibility(View.INVISIBLE);
                mMealImageView.setVisibility(View.INVISIBLE);
                mMealDescriptionView.setVisibility(View.VISIBLE);
                view.setBackgroundColor(blue);
                view.findViewById(R.id.background_view_meal).setBackgroundColor(blue);
                anim.start();
            }

            return true;
        }


        @Override
        public void onClick(View view) {

            MealsType mType=mealsTypes.get(getAdapterPosition());
            mMealsAdapterOnClickHandler.onClick(mType);


        }
    }
}
