package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.functionanalyser.R;

public class MainParallelFunctionActivity extends AppCompatActivity {
    int code = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parallel_function);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("coefficient1");
        String c2 = intent.getStringExtra("coefficient2");
        String c3 = intent.getStringExtra("coefficient3");
        String c4 = intent.getStringExtra("coefficient4");

        ImageButton backButton = findViewById(R.id.imageButton8);
        backButton.setOnClickListener(view -> goBack());
    }

    private void goBack(){
        Intent newActivity = new Intent(MainParallelFunctionActivity.this, MainMenuActivity.class);
        startActivityForResult(newActivity, code);
    }
}