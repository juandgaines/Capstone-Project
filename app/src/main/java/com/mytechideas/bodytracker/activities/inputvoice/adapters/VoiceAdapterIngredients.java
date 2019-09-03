package com.mytechideas.bodytracker.activities.inputvoice.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mytechideas.bodytracker.R;

import java.util.List;

public class VoiceAdapterIngredients extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ADD_BUTTON = 0;
    public static final int ITEM_LIST = 1 ;
    private List<String> mDataset;
    private AddButton mAddButton;

    public interface AddButton{
        void onClickAddButton();
    }

    public static class VoiceItemHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public VoiceItemHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.voice_ingredient);
        }
    }

    public static class VoiceItemAddButton extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public Button addButton;
        private AddButton mAddButton;

        public VoiceItemAddButton(View v, AddButton callback) {
            super(v);
            addButton = v.findViewById(R.id.add_button);
            mAddButton=callback;
            addButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mAddButton.onClickAddButton();
        }
    }

    public VoiceAdapterIngredients(List<String> myDataset, AddButton addButton) {
        mDataset = myDataset;
        mAddButton=addButton;
        mDataset.add("burger");
        mDataset.add("soda");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int mItemViewLayout;
        switch (viewType) {
            case ADD_BUTTON: {
                mItemViewLayout=R.layout.add_button;
                View v =LayoutInflater.from(parent.getContext())
                        .inflate(mItemViewLayout, parent, false);
                VoiceItemAddButton vh = new VoiceItemAddButton(v,mAddButton);
                return vh;
            }
            case ITEM_LIST: {
                mItemViewLayout=R.layout.item_ingredient;
                View v =LayoutInflater.from(parent.getContext())
                        .inflate(mItemViewLayout, parent, false);
                VoiceItemHolder vh = new VoiceItemHolder(v);
                return vh;
            }
            default:
                throw new IllegalArgumentException("Invalid view type, value of " + viewType);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0) {
            return ADD_BUTTON;
        } else {
            return ITEM_LIST;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case ADD_BUTTON: {
                break;
            }
            case ITEM_LIST: {
                ((VoiceItemHolder)holder).textView.setText(mDataset.get(position-1));
                break;
            }
            default:
                throw new IllegalArgumentException("Invalid view type, value of " + holder.getItemViewType());
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.size()+1;
    }

    public void deleteItem(int position){

        mDataset.remove(position);
        notifyDataSetChanged();
    }
    public void add(String item){

        mDataset.add(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public String toString() {

        String all="";

        for(String s:mDataset){
            all+=" "+s;
        }
        return all;
    }
}
