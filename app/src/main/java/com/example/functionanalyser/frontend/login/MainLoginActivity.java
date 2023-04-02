package com.example.functionanalyser.frontend.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.functionanalyser.R;
import com.example.functionanalyser.frontend.implementations.MainAdditionalCoordinateActivity;
import com.example.functionanalyser.frontend.implementations.MainFirstActivity;
import com.example.functionanalyser.frontend.implementations.MainKindOfFunctionsActivity;
import com.example.functionanalyser.frontend.implementations.MainThirdActivity;

public class MainLoginActivity extends AppCompatActivity {

    private EditText editPassword;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        editPassword = findViewById(R.id.editTextNumberPassword2);
        outputText = findViewById(R.id.textView55);

        Button registration = findViewById(R.id.button16);
        Button forgotPassword = findViewById(R.id.button18);
        Button login = findViewById(R.id.button13);

        login.setOnClickListener(view -> ckeckLoginData());
        registration.setOnClickListener(view -> goToRegistration());
        forgotPassword.setOnClickListener(view -> getPassword());
    }

    private void ckeckLoginData() {
        String code = editPassword.getText().toString();
        String[] codeArray = code.split("");
        if(code.isEmpty()){
            outputText.setText("Code eingeben!");
        }else if(codeArray.length<6){
            outputText.setText("Pin zu kurz");
        }else if(codeArray.length>6){
            outputText.setText("Pin zu lang");
        }else{
            Intent newActivity = new Intent(MainLoginActivity.this, MainFirstActivity.class);
            startActivity(newActivity);
        }
    }



    private void getPassword() {
        Intent newActivity = new Intent(MainLoginActivity.this, MainForgotPasswordActivity.class);
        startActivity(newActivity);
    }


    private void goToRegistration() {
        Intent newActivity = new Intent(MainLoginActivity.this, MainRegistrationActivity.class);
        startActivity(newActivity);
    }
}