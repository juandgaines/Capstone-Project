package com.mytechideas.bodytracker.activities.inputvoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.barcodescanner.BarCodeScannerActivity;
import com.mytechideas.bodytracker.activities.inputvoice.adapters.VoiceAdapterIngredients;
import com.mytechideas.bodytracker.models.FoodDataForFireBase;
import com.mytechideas.bodytracker.retrofit.nutritionix.Food;
import com.mytechideas.bodytracker.retrofit.nutritionix.Foods;
import com.mytechideas.bodytracker.retrofit.nutritionix.NutritionixNaturalCall;
import com.mytechideas.bodytracker.retrofit.nutritionix.NutritionixService;
import com.mytechideas.bodytracker.retrofit.nutritionix.RetrofitNutritionixInstance;
import com.mytechideas.bodytracker.retrofit.nutritionix.TextQuery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoiceInputActivity extends AppCompatActivity {

    private static final String TAG = VoiceInputActivity.class.getSimpleName();
    private static final int SPEECH_REQUEST_CODE = 0;
    @BindView(R.id.fab_calculate)
    FloatingActionButton mFabCalculate;
    @BindView(R.id.fab_insert)
    FloatingActionButton mFabInsert;

    private List<String> ingredients = new ArrayList<>();

    @BindView(R.id.coordinatorlayout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.upc_chart_product)
    PieChart mPieChart;

    private VoiceAdapterIngredients mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mCaloriesDataReference;
    private String mUserID;

    private int[] colorArray=new int[] {R.color.carbs,R.color.fats,R.color.protein};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_input);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(VoiceInputActivity.this);

        mUserID=sharedPreferences.getString(getString(R.string.id_user_firebase_app),"");

        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mCaloriesDataReference=mFirebaseDatabase.getReference().child("calories").child(mUserID);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new VoiceAdapterIngredients(ingredients);
        recyclerView.setAdapter(mAdapter);

        attachItemTouchHelper();
        NutritionixService service = RetrofitNutritionixInstance.getNutritionixService();

        mFabInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySpeechRecognizer();
            }
        });


        mFabCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchDataFromQueryOfAdapter(service);
            }
        });

    }

    private void fetchDataFromQueryOfAdapter(NutritionixService service) {
        TextQuery textQuery= new TextQuery(mAdapter.toString());

        service.getNutrientsByQuery(textQuery, "1cf1c784", "d2f6e52115ea7dca4b2ae122a784c6fc").enqueue(new Callback<NutritionixNaturalCall>() {
            @Override
            public void onResponse(Call<NutritionixNaturalCall> call, Response<NutritionixNaturalCall> response) {
                Log.d(TAG,"Response->"+ response.body().getFoods().get(0).getFoodName());

                int sumCalories=0;
                int sumCarbs=0;
                int sumFats=0;
                int sumProtein=0;

                List<Food> list= response.body().getFoods();
                for(Food l:list){
                    sumCalories+=l.getNfCalories();
                    sumCarbs+= l.getNfTotalCarbohydrate() * 4;
                    sumFats+=l.getNfTotalFat() * 9;
                    sumProtein+=l.getNfProtein()* 4;

                }

                Calendar calendar= Calendar.getInstance();

                FoodDataForFireBase foodDataForFireBase= new FoodDataForFireBase(textQuery.getQuery(), sumCalories, sumCarbs,sumFats,sumProtein,calendar);

                List<PieEntry> entries = new ArrayList<>();

                entries.add(new PieEntry(sumCarbs, "Carbs"));
                entries.add(new PieEntry(sumFats * 9, "Fats"));
                entries.add(new PieEntry(sumProtein* 4, "Proteins"));

                PieDataSet set = new PieDataSet(entries, "Calories distribution");

                set.setColors(colorArray, VoiceInputActivity.this);
                PieData data = new PieData(set);
                mPieChart.setData(data);

                mPieChart.invalidate(); // refresh
                showProductFoundMessage(foodDataForFireBase);
            }

            @Override
            public void onFailure(Call<NutritionixNaturalCall> call, Throwable t) {
                Log.d(TAG,"Error->"+ t.toString());
            }
        });
    }

    private void attachItemTouchHelper() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                int id= viewHolder.getAdapterPosition();
                Toast.makeText(VoiceInputActivity.this,"num:"+id,Toast.LENGTH_SHORT).show();
                mAdapter.deleteItem(id);
                mAdapter.notifyDataSetChanged();

            }
        }).attachToRecyclerView(recyclerView);
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            mAdapter.add(spokenText);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.sign_out_item:
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
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
}
