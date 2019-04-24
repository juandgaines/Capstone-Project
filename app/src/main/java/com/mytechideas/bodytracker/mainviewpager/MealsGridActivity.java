package com.mytechideas.bodytracker.mainviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mytechideas.bodytracker.R;

public class MealsGridActivity extends AppCompatActivity {


    @BindView(R.id.meals_list_recycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_grid);
        ButterKnife.bind(this);

        Intent intent=getIntent();

        if(intent!=null && intent.hasExtra(MainMealsFragment.QUERY_TEXT_KEY)){

            String query =intent.getStringExtra(MainMealsFragment.QUERY_TEXT_KEY);
            Toast.makeText(this,query,Toast.LENGTH_LONG).show();

        }
    }
}
