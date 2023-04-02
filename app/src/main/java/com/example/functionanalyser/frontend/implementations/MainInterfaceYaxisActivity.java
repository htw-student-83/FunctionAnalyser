package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.businesslogic.Logic;

public class MainInterfaceYaxisActivity extends AppCompatActivity {

    private TextView outputText, outputText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface_yaxis);
        outputText = findViewById(R.id.textView16);
        outputText2 = findViewById(R.id.textView17);

        Intent intent = getIntent();
        String c2 = intent.getStringExtra("coefficient2");
        String c4 = intent.getStringExtra("coefficient4");

        proceedInitialData(c2, c4);

        ImageButton button = findViewById(R.id.imageButton2);
        button.setOnClickListener(view -> goBackToMenu());
    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainInterfaceYaxisActivity.this, MainMenuActivity.class);
        startActivity(newActivity);
    }

    public void proceedInitialData(String coefficiend, String coefficiend2){
        double numberN_f1 = Double.parseDouble(coefficiend);
        double numberN_f2 = Double.parseDouble(coefficiend2);

        Logic calculateTheInterfce = new Logic();
        String interfacePoint_f1 = calculateTheInterfce.calculateTheIntersectionWithYaxis(numberN_f1);
        String interfacePoint_f2 = calculateTheInterfce.calculateTheIntersectionWithYaxis(numberN_f2);
        outputText.setText(interfacePoint_f1);
        outputText2.setText(interfacePoint_f2);
    }
}