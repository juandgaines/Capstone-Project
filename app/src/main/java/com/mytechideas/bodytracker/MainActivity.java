package com.mytechideas.bodytracker;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Repo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytechideas.bodytracker.mainviewpager.MainAdapterViewPager;
import com.mytechideas.bodytracker.onboarding.IntroPagerActivity;
import com.mytechideas.bodytracker.onboarding.SliderAdapter;
import com.mytechideas.bodytracker.retrofit.EdamamService;
import com.mytechideas.bodytracker.retrofit.Example;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1;
    private FirebaseAuth mFirebaseAuth;

    public static final String EXTRA_FIREBASE_UI="idfirebase";
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String name;



    @BindView(R.id.main_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.main_view_pager)
    ViewPager mViewPager;

    private MainAdapterViewPager mMainAdapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mFirebaseAuth=FirebaseAuth.getInstance();
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();


                if(user!=null){
                    Toast.makeText(MainActivity.this,"user:"+user.getUid(),Toast.LENGTH_LONG).show();
                     name= user.getDisplayName();
                     //Picasso.get().load(user.getPhotoUrl()).resize(400, 400).centerCrop().into(profileImageView);

                    mTabLayout.setupWithViewPager(mViewPager, true);

                    mMainAdapterViewPager= new MainAdapterViewPager(getSupportFragmentManager(), MainActivity.this);

                    mViewPager.setAdapter(mMainAdapterViewPager);

                    SharedPreferences sharedPreferences =
                            PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    // Check if we need to display our OnboardingFragment
                    if (!sharedPreferences.getBoolean(getResources().getString(R.string.first_time_app), false)) {
                        // The user hasn't seen the OnboardingFragment yet, so show it
                        Intent intent =new Intent(MainActivity.this, IntroPagerActivity.class);
                        intent.putExtra(Intent.EXTRA_TEXT,name);
                        intent.putExtra(EXTRA_FIREBASE_UI,user.getUid());
                        startActivity(intent);
                    }

                }
                else{
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setTheme(R.style.GreenTheme)
                                    .setLogo(R.drawable.logo_transparent)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.EmailBuilder().build()
                                    ))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== RC_SIGN_IN){
            if(resultCode==RESULT_OK){
                Toast.makeText(MainActivity.this,"Signed in!",Toast.LENGTH_LONG).show();
            }
            else if (resultCode==RESULT_CANCELED){
                Toast.makeText(MainActivity.this,"Sign in cancelled!",Toast.LENGTH_LONG).show();
                finish();

            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }
}
