package com.mytechideas.bodytracker.activities.splash;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.home.MainActivity;

import butterknife.BindView;


import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.slogan_view) TextView sloganTextView;
    @BindView(R.id.logo_view) ImageView logoImageView;
    //private TextView sloganTextView;
    //private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //logoImageView= (ImageView)findViewById(R.id.logo_view) ;
        //sloganTextView= (TextView)findViewById(R.id.slogan_view) ;
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.fadein_transition);
        logoImageView.startAnimation(animation);

        sloganTextView.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}
