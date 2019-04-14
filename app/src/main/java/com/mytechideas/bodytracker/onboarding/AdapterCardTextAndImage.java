package com.mytechideas.bodytracker.onboarding;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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

public class AdapterCardTextAndImage extends RecyclerView.Adapter<AdapterCardTextAndImage.MyViewHolder> {

    Context mContext;
    private int mOption=-1;
    List<LifeStyle> lifeStyles= new ArrayList<LifeStyle>();


    public int getLifestyleOption(){

        return mOption;

    }

    public AdapterCardTextAndImage(Context context) {

        mContext=context;
        lifeStyles.add(new LifeStyle(mContext.getString(R.string.lifestyle_sedentary_title),R.drawable.lifestyle_sedentary, mContext.getString(R.string.lifestyle_sedentary_description)));
        lifeStyles.add(new LifeStyle(mContext.getString(R.string.lifestyle_moderately_active_title),R.drawable.lifestyle_moderately_active, mContext.getString(R.string.lifestyle_moderately_active_description)));
        lifeStyles.add(new LifeStyle(mContext.getString(R.string.lifestyle_active_title),R.drawable.lifestyle_active, mContext.getString(R.string.lifestyle_active_description)));
        lifeStyles.add(new LifeStyle(mContext.getString(R.string.lifestyle_highly_active_title),R.drawable.lifestyle_highly_active, mContext.getString(R.string.lifestyle_highly_active_description)));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imagetext_card_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mCheckBox.setChecked(position ==MyViewHolder.selecteditem );
        LifeStyle mLifeStyle=lifeStyles.get(position);
        holder.mLifeStyleTitleView.setText(mLifeStyle.getmTitle());
        Picasso.get().load(mLifeStyle.getmImage()).resize(370,500).into(holder.mLifeStyleImageView);
        holder.mLifeStyleDescriptionView.setText(mLifeStyle.getmDescription());
        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyViewHolder.selecteditem=position;
                mOption=position;

Toast.makeText(mContext,"Op:"+mOption,Toast.LENGTH_LONG).show();
            notifyDataSetChanged();


            }
        });


    }

    @Override
    public int getItemCount() {
        return lifeStyles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        static int selecteditem=-1;
        public TextView mLifeStyleTitleView;
        public ImageView mLifeStyleImageView;
        public TextView mLifeStyleDescriptionView;
        public CheckBox mCheckBox;
        static int blue;
        static int white;

        interface mycallback{
            void notifyToAdapter();
        }


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mLifeStyleTitleView= (TextView) itemView.findViewById(R.id.lifestyle_title);
            mLifeStyleImageView= (ImageView) itemView.findViewById(R.id.lifestyle_image);
            mLifeStyleDescriptionView= (TextView) itemView.findViewById(R.id.lifestyle_description);
            mCheckBox=(CheckBox)itemView.findViewById(R.id.checkBox);


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
                view.findViewById(R.id.background_view).setBackgroundColor(white);
                anim.start();

            } else {
                Animator anim = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth()/2, (int) view.getHeight()/2, 0, finalRadius);
                mLifeStyleTitleView.setVisibility(View.VISIBLE);
                mLifeStyleImageView.setVisibility(View.INVISIBLE);
                mLifeStyleDescriptionView.setVisibility(View.VISIBLE);
                view.setBackgroundColor(blue);
                view.findViewById(R.id.background_view).setBackgroundColor(blue);
                anim.start();
            }

        }
    }
}
