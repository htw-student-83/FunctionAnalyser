package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.businesslogic.Logic;

public class MainAngelBetweenFunctionsActivity extends AppCompatActivity {

    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_angel_between_functions);

        outputText = findViewById(R.id.textView33);

        Intent intent = getIntent();
        String c = intent.getStringExtra("coefficient");
        String c3 = intent.getStringExtra("coefficient3");

        proceedInitialData(c, c3);

        ImageButton button = findViewById(R.id.imageButton6);
        button.setOnClickListener(view -> goBackToMenu());

    }

    public void proceedInitialData(String coefficiend, String coefficiend3){
        double gradiend_f1 = Double.parseDouble(coefficiend);
        double gradiend_f2 = Double.parseDouble(coefficiend3);

        Logic calculateTheAngels = new Logic();
        double angelString = calculateTheAngels.calculateTheAngleEpsilon(gradiend_f1, gradiend_f2);
        String angel = angelString+"°";
        outputText.setText(angel);
    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainAngelBetweenFunctionsActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }
}