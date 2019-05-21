package com.mytechideas.bodytracker.activities.inputvoice.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mytechideas.bodytracker.R;

import java.util.List;

public class VoiceAdapterIngredients extends RecyclerView.Adapter<VoiceAdapterIngredients.VoiceItemHolder> {

    private List<String> mDataset;

    public static class VoiceItemHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public VoiceItemHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.voice_ingredient);
        }
    }

    public VoiceAdapterIngredients(List<String> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public VoiceItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_voice_ingredient, parent, false);
        VoiceItemHolder vh = new VoiceItemHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VoiceItemHolder holder, int position) {
        holder.textView.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
