package com.example.hw4ex3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void incrementOnClick(View view) {
        //Create Intent to Send Data
        Intent sendCurrentNumberIntent = new Intent (this, BackActivity.class);
        //Assign Button with Id
        Button greenButton = findViewById(R.id.btn_green);
        //Create String variable to hold string of greenbutton
        String greenButtonText = greenButton.getText().toString();
        //send data with callingActivity
        sendCurrentNumberIntent.putExtra("callingActivity", greenButtonText);

        final int result = 1;
        //Start the Back Activity
        startActivityForResult(sendCurrentNumberIntent, result);
    }


   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Button greenButton = findViewById(R.id.btn_green);

        String passedIncrementedData = data.getStringExtra("IncrementedValue");

        greenButton.setText(passedIncrementedData);

    }
}