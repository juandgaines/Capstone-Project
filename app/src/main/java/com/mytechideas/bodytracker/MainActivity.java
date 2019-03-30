package com.mytechideas.bodytracker;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Repo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytechideas.bodytracker.retrofit.EdamamService;
import com.mytechideas.bodytracker.retrofit.Example;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth=FirebaseAuth.getInstance();
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();


                if(user!=null){
                    Toast.makeText(MainActivity.this,"Bienvenido",Toast.LENGTH_LONG).show();
                     name= user.getDisplayName();
                       
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
