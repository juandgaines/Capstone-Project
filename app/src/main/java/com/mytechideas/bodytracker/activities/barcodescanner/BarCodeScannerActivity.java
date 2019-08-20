package com.mytechideas.bodytracker.activities.barcodescanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.preference.PreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.home.fragments.MainHomeFragment;
import com.mytechideas.bodytracker.models.FoodDataForFireBase;
import com.mytechideas.bodytracker.retrofit.nutritionix.Foods;
import com.mytechideas.bodytracker.retrofit.nutritionix.NutritionixService;
import com.mytechideas.bodytracker.retrofit.nutritionix.NutritionixUPCCall;
import com.mytechideas.bodytracker.retrofit.nutritionix.RetrofitNutritionixInstance;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BarCodeScannerActivity extends AppCompatActivity {

    @BindView(R.id.preview_image)
    ImageView mPreviewImage;
    @BindView(R.id.upc_value)
    TextView mPreviwSerial;
    @BindView(R.id.upc_name_product_value)
    TextView mUpcProductName;
    @BindView(R.id.upc_calories_product_value)
    TextView mUpcProductCalories;

    @BindView(R.id.upc_carbs_product_value)
    TextView mUpcProductCarbs;
    @BindView(R.id.upc_fats_product_value)
    TextView mUpcProductFats;
    @BindView(R.id.upc_protein_product_value)
    TextView mUpcProductProt;

    @BindView(R.id.coordinatorlayout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.upc_chart_product)
    PieChart mPieChart;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mCaloriesDataReference;
    private String mUserID;

    private int[] colorArray=new int[] {R.color.carbs,R.color.fats,R.color.protein};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanner);
        ButterKnife.bind(this);
        Intent intent=getIntent();

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(BarCodeScannerActivity.this);

        mUserID=sharedPreferences.getString(getString(R.string.id_user_firebase_app),"");

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mCaloriesDataReference=mFirebaseDatabase.getReference().child("calories").child(mUserID);




        FirebaseVisionBarcodeDetectorOptions options =
                new FirebaseVisionBarcodeDetectorOptions.Builder()
                        .setBarcodeFormats(
                                FirebaseVisionBarcode.FORMAT_UPC_A,
                                FirebaseVisionBarcode.FORMAT_UPC_E)
                        .build();

        NutritionixService service = RetrofitNutritionixInstance.getNutritionixService();


        if(intent!=null && intent.hasExtra(MainHomeFragment.EXTRA_PICTURE_TO_BARCODE_SCANNER)){


            Bitmap rotatedBitmap = getBitmap(intent);

            FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(rotatedBitmap);

            FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance()
                    .getVisionBarcodeDetector();


            Bitmap finalRotatedBitmap = rotatedBitmap;

            Task<List<FirebaseVisionBarcode>> result = detector.detectInImage(image)
                    .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                        @Override
                        public void onSuccess(List<FirebaseVisionBarcode> barcodes) {
                            // Task completed successfully

                            if(barcodes.size()!=0) {
                                for (FirebaseVisionBarcode barcode : barcodes) {
                                    Rect bounds = barcode.getBoundingBox();
                                    Point[] corners = barcode.getCornerPoints();

                                    String rawValue = barcode.getRawValue();

                                    mPreviwSerial.setText(rawValue);
                                    int formatType = barcode.getFormat();

                                    int valueType = barcode.getValueType();
                                    // See API reference for complete list of supported types
                                    switch (formatType) {
                                        case FirebaseVisionBarcode.FORMAT_UPC_A:

                                            Toast.makeText(BarCodeScannerActivity.this, "Type UPC-A", Toast.LENGTH_LONG).show();
                                            break;
                                        case FirebaseVisionBarcode.FORMAT_UPC_E:
                                            Toast.makeText(BarCodeScannerActivity.this, "Type UPC-E", Toast.LENGTH_LONG).show();
                                            break;

                                        default:
                                            showIncompatibleEncoding();
                                            break;


                                    }


                                    service.getProductbyUPC(rawValue, "1cf1c784", "d2f6e52115ea7dca4b2ae122a784c6fc").enqueue(new Callback<NutritionixUPCCall>() {
                                        @Override
                                        public void onResponse(Call<NutritionixUPCCall> call, Response<NutritionixUPCCall> response) {

                                            Log.v("Retrofit", response.toString());

                                            if(response.code()!=404) {
                                                Foods mFood = response.body().getFoods().get(0);
                                                String urlImage = mFood.getPhoto().getThumb();
                                                String name = mFood.getFoodName();
                                                String calories = mFood.getNfCalories().toString() + " cal";
                                                String fats = mFood.getNfTotalFat().toString() + " g";
                                                String carbs = mFood.getNfTotalCarbohydrate().toString() + " g";
                                                String protein = mFood.getNfProtein().toString() + " g";

                                                Calendar calendar= Calendar.getInstance();

                                                FoodDataForFireBase foodDataForFireBase= new FoodDataForFireBase(mFood.getFoodName(), mFood.getNfCalories(), mFood.getNfTotalCarbohydrate(),mFood.getNfTotalFat(),mFood.getNfProtein(),calendar);

                                                mUpcProductName.setText(name);
                                                mUpcProductCalories.setText(calories);
                                                mUpcProductCarbs.setText(carbs);
                                                mUpcProductFats.setText(fats);
                                                mUpcProductProt.setText(protein);

                                                List<PieEntry> entries = new ArrayList<>();

                                                entries.add(new PieEntry(mFood.getNfTotalCarbohydrate() * 4, "Carbs"));
                                                entries.add(new PieEntry(mFood.getNfTotalFat() * 9, "Fats"));
                                                entries.add(new PieEntry(mFood.getNfProtein() * 4, "Proteins"));

                                                PieDataSet set = new PieDataSet(entries, "Calories distribution");

                                                set.setColors(colorArray, BarCodeScannerActivity.this);
                                                PieData data = new PieData(set);
                                                mPieChart.setData(data);

                                                mPieChart.invalidate(); // refresh

                                                Picasso.get().load(urlImage).into(mPreviewImage);
                                                showProductFoundMessage(foodDataForFireBase);

                                            }
                                            else{
                                                if(formatType==FirebaseVisionBarcode.FORMAT_UPC_A||formatType==FirebaseVisionBarcode.FORMAT_UPC_E)
                                                    Toast.makeText(BarCodeScannerActivity.this, "Product do not exist on database", Toast.LENGTH_LONG).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<NutritionixUPCCall> call, Throwable t) {
                                            Log.v("Retrofit", t.getMessage());
                                            showNoInternetMessage(finalRotatedBitmap);
                                        }
                                    });


                                }
                            }
                            else{

                                showProductNotFoundMessage(finalRotatedBitmap);

                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Task failed with an exception
                            // ...
                            showProductNotFoundMessage(finalRotatedBitmap);

                        }
                    });

        }
    }

    private void showIncompatibleEncoding() {
        Snackbar mySnackbar = Snackbar.make(mCoordinatorLayout, R.string.incompatible_encoding, Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction(R.string.try_again_text, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarCodeScannerActivity.this.finish();
            }
        });
        mySnackbar.show();
    }

    private void showNoInternetMessage(Bitmap finalRotatedBitmap) {
        mPreviewImage.setImageBitmap(finalRotatedBitmap);
        Snackbar mySnackbar = Snackbar.make(mCoordinatorLayout, R.string.no_internet_connection_message, Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction(R.string.ok_text, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarCodeScannerActivity.this.finish();
            }
        });
        mySnackbar.show();
    }

    private Bitmap getBitmap(Intent intent) {
        String filePath=intent.getStringExtra(MainHomeFragment.EXTRA_PICTURE_TO_BARCODE_SCANNER);
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        Bitmap mutableBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

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
        return rotatedBitmap;
    }

    private void showProductFoundMessage(FoodDataForFireBase food) {
        Snackbar mySnackbar = Snackbar.make(mCoordinatorLayout, R.string.product_found, Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction(R.string.yes_text, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCaloriesDataReference.push().setValue(food);
                finish();
            }
        });
        mySnackbar.show();
    }

    private void showProductNotFoundMessage(Bitmap finalRotatedBitmap) {
        mPreviewImage.setImageBitmap(finalRotatedBitmap);
        Snackbar mySnackbar = Snackbar.make(mCoordinatorLayout, R.string.product_not_found, Snackbar.LENGTH_INDEFINITE);

        mySnackbar.setAction(R.string.ok_text, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarCodeScannerActivity.this.finish();
            }
        });
        mySnackbar.show();
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
