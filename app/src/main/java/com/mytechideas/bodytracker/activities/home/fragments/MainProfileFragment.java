package com.mytechideas.bodytracker.activities.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mytechideas.bodytracker.R;

import butterknife.ButterKnife;

public class MainProfileFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.main_profile_fragment,
                container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    public void onSignedOutCleanUp() {

    }
}
