package com.mytechideas.bodytracker.activities.inputbarcode;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.inputbarcode.fragments.Camera2BasicFragment;


public class InputBarcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_barcode);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

}
