package com.mytechideas.bodytracker.activities.inputvoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mytechideas.bodytracker.R;
import com.mytechideas.bodytracker.activities.inputvoice.adapters.VoiceAdapterIngredients;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VoiceInputActivity extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;
    @BindView(R.id.fab_calculate)
    FloatingActionButton mFabCalculate;

    private List<String> ingredients=new ArrayList<>();

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_input);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new VoiceAdapterIngredients(ingredients);
        recyclerView.setAdapter(mAdapter);
        mFabCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySpeechRecognizer();
            }
        });


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
            // Do something with spokenText

            ingredients.add(spokenText);
            mAdapter.notifyDataSetChanged();
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
}
