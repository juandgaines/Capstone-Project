package com.mytechideas.bodytracker.onboarding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SliderAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public SliderAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new OnboardingFragment1();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new OnboardingFragment2();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new OnboardingFragment3();
            default:
                return null;
        }
    }


}
