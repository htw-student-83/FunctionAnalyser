package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.businesslogic.Logic;

public class MainAngelOfGradiendsActivity extends AppCompatActivity {

    private TextView outputText, outputText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_angel_of_gradiends);

        outputText = findViewById(R.id.textView26);
        outputText2 = findViewById(R.id.textView27);

        Intent intent = getIntent();
        String c = intent.getStringExtra("coefficient");
        String c3 = intent.getStringExtra("coefficient3");

        proceedInitialData(c, c3);

        ImageButton button = findViewById(R.id.imageButton4);
        button.setOnClickListener(view -> goBackToMenu());
    }


    //-- to get the data vom the third page
    public void proceedInitialData(String coefficiend, String coefficiend3){
        double gradiend_f1 = Double.parseDouble(coefficiend);
        double gradiend_f2 = Double.parseDouble(coefficiend3);

        Logic calculateTheAngels = new Logic();
        double angel1 = calculateTheAngels.calculateTheAngleToXaxis(gradiend_f1);
        double angel2 = calculateTheAngels.calculateTheAngleToXaxis(gradiend_f2);
        String angelF1 = angel1 +"°";
        String angelF2 = angel2 +"°";
        outputText.setText(angelF1);
        outputText2.setText(angelF2);
    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainAngelOfGradiendsActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }
}