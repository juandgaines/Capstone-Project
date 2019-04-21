package com.mytechideas.bodytracker.mainviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.retrofit.EdamamService;
import com.mytechideas.bodytracker.retrofit.Example;
import com.mytechideas.bodytracker.retrofit.Food;
import com.mytechideas.bodytracker.retrofit.FoodAPI;
import com.mytechideas.bodytracker.retrofit.Ingredients;
import com.mytechideas.bodytracker.retrofit.NutrientsCall;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BarCodeScannerActivity extends AppCompatActivity {

    @BindView(R.id.preview_image)
    ImageView mPreviewImage;
    @BindView(R.id.serial)
    TextView mPreviwSerial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanner);
        ButterKnife.bind(this);
        Intent intent=getIntent();

        FirebaseVisionBarcodeDetectorOptions options =
                new FirebaseVisionBarcodeDetectorOptions.Builder()
                        .setBarcodeFormats(
                                FirebaseVisionBarcode.FORMAT_UPC_A,
                                FirebaseVisionBarcode.FORMAT_UPC_E)
                        .build();


        Gson gson= new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.edamam.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        EdamamService service = retrofit.create(EdamamService.class);


        if(intent!=null && intent.hasExtra("image")){


            String filePath=intent.getStringExtra("image");
            Bitmap bitmap = BitmapFactory.decodeFile(filePath);
            Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            //Bitmap bitmapRotated =rotateBitmap(mutableBitmap,90);

            File curFile = new File(filePath); // ... This is an image file from my device.
            Bitmap rotatedBitmap=null;

            try {
                ExifInterface exif = new ExifInterface(curFile.getPath());
                int rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                int rotationInDegrees = exifToDegrees(rotation);
                Matrix matrix = new Matrix();
                if (rotation != 0f) {matrix.preRotate(rotationInDegrees);}
                rotatedBitmap = Bitmap.createBitmap(bitmap,0,0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);


            }catch(IOException ex){

            }


            mPreviewImage.setImageBitmap(rotatedBitmap);

            FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(rotatedBitmap);

            FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance()
                    .getVisionBarcodeDetector();


            Task<List<FirebaseVisionBarcode>> result = detector.detectInImage(image)
                    .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                        @Override
                        public void onSuccess(List<FirebaseVisionBarcode> barcodes) {
                            // Task completed successfully

                            for (FirebaseVisionBarcode barcode: barcodes) {
                                Rect bounds = barcode.getBoundingBox();
                                Point[] corners = barcode.getCornerPoints();

                                String rawValue = barcode.getRawValue();

                                mPreviwSerial.setText(rawValue);

                                int formatType=barcode.getFormat();

                                int valueType = barcode.getValueType();
                                // See API reference for complete list of supported types
                                switch (formatType) {
                                    case FirebaseVisionBarcode.FORMAT_UPC_A:

                                        Toast.makeText(BarCodeScannerActivity.this,"Type UPC-A",Toast.LENGTH_LONG).show();
                                        break;
                                    case FirebaseVisionBarcode.FORMAT_UPC_E:
                                        Toast.makeText(BarCodeScannerActivity.this,"Type UPC-E",Toast.LENGTH_LONG).show();
                                        break;
                                }

                                service.listProductUPC(rawValue,"3c1df531","c5e9100c6e4c25c52c015c0293e2b3f1").enqueue(new Callback<FoodAPI>() {
                                    @Override
                                    public void onResponse(Call<FoodAPI> call, Response<FoodAPI> response) {
                                        Log.v("Retrofit", response.toString());


                                        Ingredients ingredients=new Ingredients();

                                        ingredients.setFoodId(response.body().getHints().get(0).getFood().getFoodId());
                                        ingredients.setMeasureURI(response.body().getHints().get(0).getMeasures().get(0).getUri());
                                        ingredients.setQuantity(1);

                                        List<Ingredients> mListNeeded= new ArrayList<Ingredients>();


                                        mListNeeded.add(ingredients);
                                        NutrientsCall mNutritionCall= new NutrientsCall(mListNeeded);
                                        service.getNutritionsFromUPC(mNutritionCall,"3c1df531","c5e9100c6e4c25c52c015c0293e2b3f1").enqueue(new Callback<NutrientsCall>() {
                                            @Override
                                            public void onResponse(Call<NutrientsCall> call, Response<NutrientsCall> response) {

                                            }

                                            @Override
                                            public void onFailure(Call<NutrientsCall> call, Throwable t) {

                                            }
                                        });

                                    }

                                    @Override
                                    public void onFailure(Call<FoodAPI> call, Throwable t) {
                                        Log.v("Retrofit", call.toString());
                                    }
                                });
                            }
                            // ...
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Task failed with an exception
                            // ...
                        }
                    });

        }
    }

    public Bitmap rotateBitmap(Bitmap original, float degrees) {
        int width = original.getWidth();
        int height = original.getHeight();

        Matrix matrix = new Matrix();
        matrix.preRotate(degrees);

        Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(original, 5.0f, 0.0f, null);

        return rotatedBitmap;
    }

    private static int exifToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) { return 90; }
        else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {  return 180; }
        else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {  return 270; }
        return 0;
    }
}
