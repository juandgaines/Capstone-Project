package com.mytechideas.bodytracker.onboarding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SliderAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private String mName;

    OnboardingFragment1 onboardingFragment1;
    OnboardingFragment2 onboardingFragment2;
    OnboardingFragment3 onboardingFragment3;

    public SliderAdapter(FragmentManager fragmentManager, String name) {

        super(fragmentManager);
        mName=name;
        onboardingFragment1= new OnboardingFragment1();
        onboardingFragment1.setName(mName);
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
                return onboardingFragment1 ;

            case 1: // Fragment # 0 - This will show FirstFragment different title
                return onboardingFragment2;
            case 2: // Fragment # 1 - This will show SecondFragment
                return onboardingFragment3;
            default:
                return null;
        }
    }

    public boolean transition(){
      boolean x=onboardingFragment1.validateUserData();
      //notifyDataSetChanged();
      return x;
    }





}
