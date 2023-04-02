package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.functionanalyser.R;

public class MainKindOfFunctionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kind_of_functions);

        Intent intent = getIntent();
        String gradiend = intent.getStringExtra("coefficient");
        String coordinateX = intent.getStringExtra("numberX");
        String coordinateY = intent.getStringExtra("numberY");

        Button confirmOrthogonal = findViewById(R.id.button8);
        Button confirmParallel = findViewById(R.id.button15);

        confirmOrthogonal.setOnClickListener(view -> goToOrthogonalFunction(gradiend, coordinateX, coordinateY));
        confirmParallel.setOnClickListener(view -> goToParallelFunction(gradiend, coordinateX, coordinateY));
    }

    public void goToOrthogonalFunction(String gradiend_f, String cX, String cY){
        Intent newActivity = new Intent(MainKindOfFunctionsActivity.this, MainOrthogonalFunctionActivity.class);
        newActivity.putExtra("gradiend", gradiend_f);
        newActivity.putExtra("cX", cX);
        newActivity.putExtra("cY", cY);
        startActivity(newActivity);
    }

    public void goToParallelFunction(String gradiend_f, String cX, String cY){
        Intent newActivity = new Intent(MainKindOfFunctionsActivity.this, MainParallelFunctionActivity.class);
        newActivity.putExtra("gradiend", gradiend_f);
        newActivity.putExtra("cX", cX);
        newActivity.putExtra("cY", cY);
        startActivity(newActivity);
    }
}