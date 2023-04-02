package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.frontend.contract.Forward;

public class MainAdditionalCoordinateActivity extends AppCompatActivity {

    private TextView editNumberX, editNumberY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_additional_coordinate);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("coefficient");

        editNumberX = findViewById(R.id.editTextNumberDecimal2);
        editNumberY = findViewById(R.id.editTextNumberDecimal3);

        Button button = findViewById(R.id.button10);
        button.setOnClickListener(view -> goToChooseFunction(c1));

        Button buttonBack = findViewById(R.id.button14);
        buttonBack.setOnClickListener(view -> goBackToMenu());

    }


    public void goToChooseFunction(String c1){
        Intent newActivity = new Intent(MainAdditionalCoordinateActivity.this, MainKindOfFunctionsActivity.class);
        String numberX = editNumberX.getText().toString();
        String numberY = editNumberY.getText().toString();
        newActivity.putExtra("coefficient", c1);
        newActivity.putExtra("numberX", numberX);
        newActivity.putExtra("numberY", numberY);
        startActivity(newActivity);
    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainAdditionalCoordinateActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }
}