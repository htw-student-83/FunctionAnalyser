package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.functionanalyser.R;

public class MainOrthogonalFunctionActivity extends AppCompatActivity {
    int code = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_orthogonal_function);

        ImageButton button = findViewById(R.id.imageButton7);
        button.setOnClickListener(view -> goBackToMenu());
    }


    public void goBackToMenu(){
        Intent newActivity = new Intent(MainOrthogonalFunctionActivity.this, MainMenuActivity.class);
        startActivityForResult(newActivity, code);
    }
}