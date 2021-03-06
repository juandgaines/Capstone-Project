package com.mytechideas.bodytracker.activities.onboarding;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.mytechideas.bodytracker.activities.home.MainActivity;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.onboarding.adapters.SliderAdapter;


import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroPagerActivity extends AppCompatActivity {

    @BindView(R.id.slideViewPager)
    ViewPager mSlideViewPager;
    @BindView(R.id.prev_button)
    Button mPrevButton;
    @BindView(R.id.next_button)
    Button mNextButton;

    @BindView(R.id.tabDots)
    TabLayout mDotLayout;

    private SliderAdapter mSliderAdapter;
    private int mCurrentPage;
    private  String name,uidfirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_pager);
        ButterKnife.bind(this);


        Intent intent=getIntent();

        if(intent!=null ){
            if(intent.hasExtra(Intent.EXTRA_TEXT) ) {
                name = intent.getStringExtra(Intent.EXTRA_TEXT);
            }
            if (intent.hasExtra(Intent.EXTRA_TEXT)){
                uidfirebase = intent.getStringExtra(MainActivity.EXTRA_FIREBASE_UI);
            }
        }
        mDotLayout.setupWithViewPager(mSlideViewPager, true);

        mSliderAdapter= new SliderAdapter(getSupportFragmentManager(),name,uidfirebase);

        mSlideViewPager.setAdapter(mSliderAdapter);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentPage+=1;

                mSlideViewPager.setCurrentItem(mCurrentPage);
                if(mCurrentPage==3){
                    boolean z=mSliderAdapter.validateTransition3();
                    if(z) {

                        SharedPreferences.Editor sharedPreferencesEditor =
                                PreferenceManager.getDefaultSharedPreferences(IntroPagerActivity.this).edit();
                        sharedPreferencesEditor.putBoolean(
                                getResources().getString(R.string.first_time_app), true);

                        sharedPreferencesEditor.apply();
                        Intent intent = new Intent(IntroPagerActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        mCurrentPage=2;
                    }
                }
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentPage-=1;

                mSlideViewPager.setCurrentItem(mCurrentPage);
            }
        });

        ViewPager.OnPageChangeListener viewListemer= new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                mCurrentPage=i;
                switch (mCurrentPage){
                    case 0:
                        mNextButton.setEnabled(true);
                        mPrevButton.setEnabled(false);
                        mPrevButton.setVisibility(View.INVISIBLE);
                        mDotLayout.setupWithViewPager(mSlideViewPager,true);
                        mNextButton.setText(R.string.next_sentence);
                        mPrevButton.setText("");
                        break;
                    case 1:

                        boolean x=mSliderAdapter.validateTransition1();

                        if(!x){
                            mCurrentPage-=1;
                            mSlideViewPager.setCurrentItem(mCurrentPage);
                            mSlideViewPager.clearOnPageChangeListeners();
                            //mDotLayout.getTabAt(0).select();

                        }
                        else {

                            mSliderAdapter.setConfigurationForFragment2(mSliderAdapter.getUserDataForm());
                            mNextButton.setEnabled(true);
                            mPrevButton.setEnabled(true);
                            mPrevButton.setVisibility(View.VISIBLE);
                            mDotLayout.setupWithViewPager(mSlideViewPager,true);
                            mNextButton.setText(R.string.next_sentence);
                            mPrevButton.setText(R.string.prev_sentence);
                        }
                        break;
                    case 2:

                        boolean y=mSliderAdapter.validateTransition2();

                        if(!y){
                            mCurrentPage-=1;
                            mSlideViewPager.setCurrentItem(mCurrentPage);
                            mSlideViewPager.clearOnPageChangeListeners();
                            //mDotLayout.getTabAt(0).select();
                        }
                        else {
                            mSliderAdapter.setConfigurationForFragment3(mSliderAdapter.getUserDataForm2());
                            mNextButton.setEnabled(true);
                            mPrevButton.setEnabled(true);
                            mPrevButton.setVisibility(View.VISIBLE);
                            mDotLayout.setupWithViewPager(mSlideViewPager, true);
                            mNextButton.setText(R.string.finish_sentence);
                            mPrevButton.setText(R.string.prev_sentence);
                        }
                        break;
                    default:

                        mNextButton.setEnabled(true);
                        mPrevButton.setEnabled(true);
                        mPrevButton.setVisibility(View.VISIBLE);
                        mNextButton.setText(R.string.next_sentence);
                        mPrevButton.setText(R.string.prev_sentence);

                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        };
        mSlideViewPager.setOnPageChangeListener(viewListemer);
        //hideSystemUI();

    }
    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE|
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
