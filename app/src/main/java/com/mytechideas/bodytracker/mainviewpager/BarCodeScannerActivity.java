package com.mytechideas.bodytracker.mainviewpager;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.mytechideas.bodytracker.R;

public class BarCodeScannerActivity extends AppCompatActivity {

    @BindView(R.id.preview_image)
    ImageView mPreviewImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanner);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        if(intent!=null && intent.hasExtra("image")){

            String filePath=intent.getStringExtra("image");
            Bitmap bitmap = BitmapFactory.decodeFile(filePath);

            mPreviewImage.setImageBitmap(bitmap);



        }
    }
}
