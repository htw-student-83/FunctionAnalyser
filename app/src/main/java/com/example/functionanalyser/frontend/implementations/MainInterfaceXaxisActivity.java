package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.functionanalyser.R;

public class MainInterfaceXaxisActivity extends AppCompatActivity {

    int code = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface_xaxis);

        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(view -> goBackToMenu());
    }

    public void goBackToMenu(){
        Intent newActivity = new Intent(MainInterfaceXaxisActivity.this, MainMenuActivity.class);
        startActivityForResult(newActivity, code);
    }
}