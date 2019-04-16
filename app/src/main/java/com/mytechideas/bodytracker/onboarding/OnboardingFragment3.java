package com.mytechideas.bodytracker.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytechideas.bodytracker.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingFragment3 extends Fragment {

    @BindView(R.id.body_recyclerview)
    RecyclerView mBodyRecyclerView;

    AdapterBodyType mAdapter;
    UserDataBT mUserDataBT;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_fragment3,
                container, false);

        ButterKnife.bind(this,view);

        mBodyRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mBodyRecyclerView.setLayoutManager(layoutManager);


        //Toast.makeText(getContext(),"Gender: "+mUserDataBT.getmGender(),Toast.LENGTH_LONG).show();


        return view;
    }

    public void setConfigurationForFragment3(UserDataBT userDataBT) {

        mUserDataBT=userDataBT;
        mAdapter= new AdapterBodyType(getContext());
        mBodyRecyclerView.setAdapter(mAdapter);

    }



}
