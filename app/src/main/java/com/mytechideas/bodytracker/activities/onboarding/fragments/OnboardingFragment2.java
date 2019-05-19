package com.mytechideas.bodytracker.activities.onboarding.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.models.UserDataBT;
import com.mytechideas.bodytracker.activities.onboarding.adapters.AdapterGoal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingFragment2 extends Fragment {


    @BindView(R.id.goal_recyclerview)
    RecyclerView mGoalRecyclerView;

    AdapterGoal mAdapter;
    UserDataBT mUserDataBT;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_fragment2,
                container, false);

        ButterKnife.bind(this,view);

        mGoalRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mGoalRecyclerView.setLayoutManager(layoutManager);


        //Toast.makeText(getContext(),"Gender: "+mUserDataBT.getmGender(),Toast.LENGTH_LONG).show();


        return view;
    }

    public void setConfigurationForFragment2(UserDataBT userDataBT) {

        mUserDataBT=userDataBT;
        mAdapter= new AdapterGoal(getContext(), mUserDataBT.getmGender());
        mGoalRecyclerView.setAdapter(mAdapter);

    }

    public UserDataBT getUserData() {
        return mUserDataBT;
    }

    public boolean validateUserData() {

        mUserDataBT.setmGoal(mAdapter.getGoal());

        if(mUserDataBT.getmGoal()!=-1){
            return true;
        }
        Toast.makeText(getContext(),"Select a goal in order to go forward.",Toast.LENGTH_LONG).show();
        return false;
    }
}
