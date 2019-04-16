package com.mytechideas.bodytracker.onboarding;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mytechideas.bodytracker.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterGoal extends RecyclerView.Adapter<AdapterGoal.MyViewHolderGoal> {

    Context mContext;
    private int mOption=-1;
    List<Goal> goals= new ArrayList<Goal>();


    public int getGoal(){

        return mOption;

    }

    public AdapterGoal(Context context, String gender) {
        mContext = context;

        String[] list= context.getResources().getStringArray(R.array.gender_array);
        if(gender.equals(list[1])) {
            goals.add(new Goal(mContext.getString(R.string.goal_lose_title), R.drawable.goal_lose_weigth, mContext.getString(R.string.goal_lose_male_description)));
            goals.add(new Goal(mContext.getString(R.string.goal_maintain_title), R.drawable.goal_maintain_weigth, mContext.getString(R.string.goal_mantain_male_description)));
            goals.add(new Goal(mContext.getString(R.string.goal_gain_title), R.drawable.goal_gain_weigth, mContext.getString(R.string.goal_gain_male_description)));
        }
        else{
            goals.add(new Goal(mContext.getString(R.string.goal_lose_title), R.drawable.goal_lose_weigth, mContext.getString(R.string.goal_lose_female_description)));
            goals.add(new Goal(mContext.getString(R.string.goal_maintain_title), R.drawable.goal_maintain_weigth, mContext.getString(R.string.goal_mantain_female_description)));
            goals.add(new Goal(mContext.getString(R.string.goal_gain_title), R.drawable.goal_gain_weigth, mContext.getString(R.string.goal_gain_female_description)));
        }
    }

    @NonNull
    @Override
    public AdapterGoal.MyViewHolderGoal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goal_and_body_item, parent, false);

        return new AdapterGoal.MyViewHolderGoal (itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGoal.MyViewHolderGoal  holder, int position) {

        holder.mCheckBox.setChecked(position == AdapterGoal.MyViewHolderGoal.selecteditem );
        Goal mLifeStyle=goals.get(position);
        holder.mLifeStyleTitleView.setText(mLifeStyle.getmTitle());
        Picasso.get().load(mLifeStyle.getmImage()).resize(1000,400).into(holder.mLifeStyleImageView);
        holder.mLifeStyleDescriptionView.setText(mLifeStyle.getmDescription());
        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdapterGoal.MyViewHolderGoal.selecteditem=position;
                mOption=position;

                Toast.makeText(mContext,"Op:"+mOption,Toast.LENGTH_LONG).show();
                notifyDataSetChanged();


            }
        });


    }

    @Override
    public int getItemCount() {
        return goals.size();
    }

    public static class MyViewHolderGoal extends RecyclerView.ViewHolder  implements View.OnClickListener{

        static int selecteditem=-1;
        public TextView mLifeStyleTitleView;
        public ImageView mLifeStyleImageView;
        public TextView mLifeStyleDescriptionView;
        public CheckBox mCheckBox;
        static int blue;
        static int white;



        public MyViewHolderGoal(@NonNull View itemView) {
            super(itemView);

            mLifeStyleTitleView= (TextView) itemView.findViewById(R.id.goal_title);
            mLifeStyleImageView= (ImageView) itemView.findViewById(R.id.image_goal);
            mLifeStyleDescriptionView= (TextView) itemView.findViewById(R.id.description_goal);
            mCheckBox=(CheckBox)itemView.findViewById(R.id.checkbox_goal);


            itemView.setOnClickListener(this);
            if (blue == 0)
                blue = itemView.getContext().getResources().getColor(R.color.colorPrimary);
            if (white == 0)
                white = itemView.getContext().getResources().getColor(R.color.background_material_light);


        }

        @Override
        public void onClick(View view) {


            boolean isDetailed = ((ColorDrawable)view.getBackground()) != null && ((ColorDrawable)view.getBackground()).getColor() == blue;

            int finalRadius = (int)Math.hypot(view.getWidth()/2, view.getHeight()/2);

            if (isDetailed) {
                Animator anim = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth()/2, (int) view.getHeight()/2, 0, finalRadius);
                mLifeStyleTitleView.setVisibility(View.VISIBLE);
                mLifeStyleImageView.setVisibility(View.VISIBLE);
                mLifeStyleDescriptionView.setVisibility(View.INVISIBLE);
                view.setBackgroundColor(white);
                view.findViewById(R.id.background_view_goal).setBackgroundColor(white);
                anim.start();

            } else {
                Animator anim = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth()/2, (int) view.getHeight()/2, 0, finalRadius);
                mLifeStyleTitleView.setVisibility(View.VISIBLE);
                mLifeStyleImageView.setVisibility(View.INVISIBLE);
                mLifeStyleDescriptionView.setVisibility(View.VISIBLE);
                view.setBackgroundColor(blue);
                view.findViewById(R.id.background_view_goal).setBackgroundColor(blue);
                anim.start();
            }

        }
    }
}