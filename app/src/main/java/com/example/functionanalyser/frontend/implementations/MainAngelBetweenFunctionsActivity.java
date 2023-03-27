package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.functionanalyser.R;

public class MainAngelBetweenFunctionsActivity extends AppCompatActivity {

    int code = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_angel_between_functions);

        ImageButton button = findViewById(R.id.imageButton6);
        button.setOnClickListener(view -> goBackToMenu());

    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainAngelBetweenFunctionsActivity.this, MainMenuActivity.class);
        startActivityForResult(newActivity, code);
    }
}