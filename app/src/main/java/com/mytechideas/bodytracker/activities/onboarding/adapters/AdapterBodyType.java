package com.mytechideas.bodytracker.activities.onboarding.adapters;

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
import com.mytechideas.bodytracker.models.BodyType;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBodyType extends RecyclerView.Adapter<AdapterBodyType.MyViewHolderBodyType> {

    Context mContext;
    private int mOption=-1;
    OnClickPErBody mCallback;
    List<BodyType> bodyType= new ArrayList<BodyType>();


    public interface OnClickPErBody{

        void updateTargetNutirents(int option);
    }
    public int getBodyType(){

        return mOption;

    }

    public AdapterBodyType(Context context, OnClickPErBody callback) {
        mContext = context;
        mCallback=callback;

        String[] list= context.getResources().getStringArray(R.array.gender_array);

        bodyType.add(new BodyType(mContext.getString(R.string.bodytype_ectomorph_title), R.drawable.bodytype_ectomorph, mContext.getString(R.string.bodytype_ectomorph_description)));
        bodyType.add(new BodyType(mContext.getString(R.string.bodytype_endomorph_title), R.drawable.bodytype_endomorph, mContext.getString(R.string.bodytype_endomorph_description)));
        bodyType.add(new BodyType(mContext.getString(R.string.bodytype_mesomorph_title), R.drawable.bodytype_mesomorph, mContext.getString(R.string.bodytype_mesomorph_description)));

    }

    @NonNull
    @Override
    public AdapterBodyType.MyViewHolderBodyType onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goal_and_body_item2, parent, false);

        return new AdapterBodyType.MyViewHolderBodyType (itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBodyType.MyViewHolderBodyType  holder, int position) {

        holder.mCheckBox.setChecked(position == AdapterGoal.MyViewHolderGoal.selecteditem );
        BodyType mLifeStyle=bodyType.get(position);
        holder.mLifeStyleTitleView.setText(mLifeStyle.getmTitle());
        Picasso.get().load(mLifeStyle.getmImage()).resize(600,1000).into(holder.mLifeStyleImageView);
        holder.mLifeStyleDescriptionView.setText(mLifeStyle.getmDescription());
        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdapterGoal.MyViewHolderGoal.selecteditem=position;
                mOption=position;
                mCallback.updateTargetNutirents(mOption);

                Toast.makeText(mContext,"Op:"+mOption,Toast.LENGTH_LONG).show();
                notifyDataSetChanged();


            }
        });


    }

    @Override
    public int getItemCount() {
        return bodyType.size();
    }

    public static class MyViewHolderBodyType extends RecyclerView.ViewHolder  implements View.OnClickListener{

        static int selecteditem=-1;
        public TextView mLifeStyleTitleView;
        public ImageView mLifeStyleImageView;
        public TextView mLifeStyleDescriptionView;
        public CheckBox mCheckBox;
        static int blue;
        static int white;



        public MyViewHolderBodyType(@NonNull View itemView) {
            super(itemView);

            mLifeStyleTitleView= (TextView) itemView.findViewById(R.id.meal_title);
            mLifeStyleImageView= (ImageView) itemView.findViewById(R.id.image_meal);
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