package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.businesslogic.Logic;

public class MainParallelFunctionActivity extends AppCompatActivity {

    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parallel_function);

        outputText = findViewById(R.id.textView39);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("gradiend");
        String x = intent.getStringExtra("cX");
        String y = intent.getStringExtra("cY");

        createParallelFunction(x, y, c1);

        ImageButton backButton = findViewById(R.id.imageButton8);
        backButton.setOnClickListener(view -> goBack());
    }

    public void createParallelFunction(String numberX, String numberY, String gradiend_f){
        double gradiend = Double.parseDouble(gradiend_f);
        double x = Double.parseDouble(numberX);
        double y = Double.parseDouble(numberY);
        Logic calculator = new Logic();
        String newFunction = calculator.calculateTheParallelFunction(gradiend, x, y);
        outputText.setText(newFunction);
    }

    private void goBack(){
        Intent newActivity = new Intent(MainParallelFunctionActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }
}