package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.backend.Logic;

import java.text.StringCharacterIterator;

public class MainInterfaceXaxisActivity extends AppCompatActivity {

    int code = 22;

    private TextView outputText, outputText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface_xaxis);
        outputText = findViewById(R.id.textView11);
        outputText2 = findViewById(R.id.textView12);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("coefficient1");
        String c2 = intent.getStringExtra("coefficient2");
        String c3 = intent.getStringExtra("coefficient3");
        String c4 = intent.getStringExtra("coefficient4");

        proceedInitialData(c1, c2, c3, c4);

        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(view -> goBackToMenu());
    }

    //-- to get the data vom the third page
    public void proceedInitialData(String coefficiend1, String coefficiend2, String coefficiend3, String coefficiend4){
        double gradiend_f1 = Double.parseDouble(coefficiend1);
        double gradiend_f2 = Double.parseDouble(coefficiend3);

        double numberN_f1 = Double.parseDouble(coefficiend2);
        double numberN_f2 = Double.parseDouble(coefficiend4);

        Logic calculateTheInterfce = new Logic();
        String interfacePoint_f1 = calculateTheInterfce.calculateTheIntersectionWithXaxis(gradiend_f1, numberN_f1);
        String interfacePoint_f2 = calculateTheInterfce.calculateTheIntersectionWithXaxis(gradiend_f2, numberN_f2);
        outputText.setText(interfacePoint_f1);
        outputText2.setText(interfacePoint_f2);
    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainInterfaceXaxisActivity.this, MainMenuActivity.class);
        startActivityForResult(newActivity, code);
    }
}