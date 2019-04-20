package com.mytechideas.bodytracker.mainviewpager;

import android.content.Context;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.onboarding.OnboardingFragment1;
import com.mytechideas.bodytracker.onboarding.OnboardingFragment2;
import com.mytechideas.bodytracker.onboarding.OnboardingFragment3;
import com.mytechideas.bodytracker.onboarding.UserDataBT;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainAdapterViewPager extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;


    private MainHomeFragment mainHomeFragment;
    private MainMealsFragment mainMealsFragment;
    private MainProfileFragment mainProfileFragment;
    private Context mContext;

    public MainAdapterViewPager(FragmentManager fragmentManager, Context context) {

        super(fragmentManager);
        mainHomeFragment= new MainHomeFragment();
        mainMealsFragment=new MainMealsFragment();
        mainProfileFragment=new MainProfileFragment();
        mContext=context;

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
                return mainMealsFragment;
            case 2: // Fragment # 1 - This will show SecondFragment
                return mainProfileFragment;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return mContext.getString(R.string.tab_layout_home_text);

            case 1:
                return mContext.getString(R.string.tab_layout_meals_text);

            case 2:
                return mContext.getString(R.string.tab_layout_profile_text);

        }
       return null;
    }






}
