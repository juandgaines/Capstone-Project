package com.mytechideas.bodytracker.mainviewpager;

import com.mytechideas.bodytracker.onboarding.OnboardingFragment1;
import com.mytechideas.bodytracker.onboarding.OnboardingFragment2;
import com.mytechideas.bodytracker.onboarding.OnboardingFragment3;
import com.mytechideas.bodytracker.onboarding.UserDataBT;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainAdapterViewPager extends FragmentPagerAdapter {    private static int NUM_ITEMS = 3;
    private String mName;
    private String mFirebaseuid;

    MainHomeFragment onboardingFragment1;
    MainMealsFragment onboardingFragment2;
    MainProfileFragment onboardingFragment3;

    public MainAdapterViewPager(FragmentManager fragmentManager, String name, String uidfirebase) {

        super(fragmentManager);
        mName=name;
        mFirebaseuid=uidfirebase;
        onboardingFragment1= new OnboardingFragment1();
        onboardingFragment1.setName(mName);
        onboardingFragment1.setUID(mFirebaseuid);
        onboardingFragment2=new OnboardingFragment2();
        onboardingFragment3=new OnboardingFragment3();

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return mainHomeFragment ;

            case 1: // Fragment # 0 - This will show FirstFragment different title
                return onboardingFragment2;
            case 2: // Fragment # 1 - This will show SecondFragment
                return onboardingFragment3;
            default:
                return null;
        }
    }

    public boolean validateTransition1(){
        boolean x=onboardingFragment1.validateUserData();
        //notifyDataSetChanged();
        return x;
    }

    public UserDataBT getUserDataForm(){
        return onboardingFragment1.getUserData();
    }

    public void setConfigurationForFragment2(UserDataBT userDataBT){

        onboardingFragment2.setConfigurationForFragment2(userDataBT);
        notifyDataSetChanged();
    }

    public void setConfigurationForFragment3(UserDataBT userDataBT){

        onboardingFragment3.setConfigurationForFragment3(userDataBT);
        onboardingFragment3.setUID(mFirebaseuid);
        notifyDataSetChanged();
    }


    public boolean validateTransition2(){
        boolean x=onboardingFragment2.validateUserData();
        //notifyDataSetChanged();
        return x;
    }

    public boolean validateTransition3(){
        boolean x=onboardingFragment3.validateUserData();
        //notifyDataSetChanged();
        return x;
    }

    public UserDataBT getUserDataForm2(){
        return onboardingFragment2.getUserData();
    }







}
