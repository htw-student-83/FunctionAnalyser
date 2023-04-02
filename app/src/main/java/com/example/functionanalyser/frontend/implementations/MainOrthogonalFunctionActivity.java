package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.businesslogic.Logic;

public class MainOrthogonalFunctionActivity extends AppCompatActivity {
    private TextView functionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_orthogonal_function);
        functionText = findViewById(R.id.textView36);

        // - don't transport any datas, why?
        Intent intent = getIntent();
        String gradiend =  intent.getStringExtra("gradiend");
        String x = intent.getStringExtra("cX");
        String y = intent.getStringExtra("cY");

        createOrthogonalFunction(x, y, gradiend);

        ImageButton button = findViewById(R.id.imageButton7);
        button.setOnClickListener(view -> goBackToMenu());
    }


    public void createOrthogonalFunction(String numberX, String numberY, String gradiend_f){
        double gradiendD = Double.parseDouble(gradiend_f);
        double x = Double.parseDouble(numberX);
        double y = Double.parseDouble(numberY);
        Logic calculator = new Logic();
        String newFunction = calculator.calculateTheOrthogonalLine(gradiendD, x, y);
        functionText.setText(newFunction);
    }


    public void goBackToMenu(){
        Intent newActivity = new Intent(MainOrthogonalFunctionActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }
}