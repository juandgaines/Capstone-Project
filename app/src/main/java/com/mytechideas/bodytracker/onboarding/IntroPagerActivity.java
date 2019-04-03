package com.mytechideas.bodytracker.onboarding;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.mytechideas.bodytracker.MainActivity;
import com.mytechideas.bodytracker.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class IntroPagerActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private Button mPrevButton;
    private Button mNextButton;
    private TabLayout mDotLayout;
    private SliderAdapter mSliderAdapter;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_pager);


        mSlideViewPager=(ViewPager) findViewById(R.id.slideViewPager);
        mPrevButton =(Button) findViewById(R.id.prev_button);
        mNextButton =(Button) findViewById(R.id.next_button);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mSlideViewPager, true);

        mSliderAdapter= new SliderAdapter(getSupportFragmentManager());

        mSlideViewPager.setAdapter(mSliderAdapter);


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentPage+=1;

                mSlideViewPager.setCurrentItem(mCurrentPage);
                if(mCurrentPage==3){
                    Intent intent = new Intent(IntroPagerActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
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

                        mNextButton.setText(R.string.next_sentence);
                        mPrevButton.setText("");

                        break;
                    case 2:
                        mNextButton.setEnabled(true);
                        mPrevButton.setEnabled(true);
                        mPrevButton.setVisibility(View.VISIBLE);

                        mNextButton.setText(R.string.finish_sentence);
                        mPrevButton.setText(R.string.prev_sentence);
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
