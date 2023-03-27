package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.functionanalyser.R;

public class MainThirdActivity extends AppCompatActivity {
    int code = 23;
    private EditText editCoefficient1, editCoefficient2, editCoefficient3, editCoefficient4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_third);
        editCoefficient1 = findViewById(R.id.editNumber1);
        editCoefficient2 = findViewById(R.id.editNumber2);
        editCoefficient3 = findViewById(R.id.editNumber3);
        editCoefficient4 = findViewById(R.id.editNumber4);

        Button confirmButton = findViewById(R.id.button12);
        confirmButton.setOnClickListener(view -> checkallfield());

        Button backButton = findViewById(R.id.button);
        backButton.setOnClickListener(view -> moveBack());
    }

    public void checkallfield(){
        boolean result1 = editCoefficient1.getText().toString().isEmpty();
        boolean result2  = editCoefficient2.getText().toString().isEmpty();
        boolean result3  = editCoefficient3.getText().toString().isEmpty();
        boolean result4 = editCoefficient4.getText().toString().isEmpty();

        if(!(result1 || result2 || result3 || result4)){
            Intent newActivity = new Intent(MainThirdActivity.this, MainMenuActivity.class);
            startActivityForResult(newActivity, code);
        }else{
            showToast();
        }
    }

    public void moveBack(){
        Intent newActivity = new Intent(MainThirdActivity.this, MainFirstActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void showToast(){
        Toast toast = Toast.makeText(this, "One or more fields are empty..", Toast.LENGTH_LONG);
        toast.show();
    }
}