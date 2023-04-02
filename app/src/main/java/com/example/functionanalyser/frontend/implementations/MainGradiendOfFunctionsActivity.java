package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.functionanalyser.R;

public class MainGradiendOfFunctionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gradiend_of_functions);

        ImageButton button = findViewById(R.id.imageButton3);
        button.setOnClickListener(view -> goBackToMenu());
    }


    public void goBackToMenu(){
        Intent newActivity = new Intent(MainGradiendOfFunctionsActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }
}