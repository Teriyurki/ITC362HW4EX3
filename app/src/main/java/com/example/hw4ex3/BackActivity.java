package com.example.hw4ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BackActivity extends AppCompatActivity {

    public String newGreenButtonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        Intent getMainActivityIntent = getIntent();

        String currentGreenButtonString = getMainActivityIntent.getExtras().getString("callingActivity");
         int incrementButton = Integer.parseInt(currentGreenButtonString);
        incrementButton++;

        newGreenButtonString = String.valueOf(incrementButton);


    }


    public void onBackClick(View view) {
        //incrementGreenButton();

        Intent sendIncrementDataBack = new Intent();

        sendIncrementDataBack.putExtra("IncrementedValue", newGreenButtonString);

        setResult(RESULT_OK, sendIncrementDataBack);

        finish();

    }
}