package com.example.functionanalyser.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.functionanalyser.R;
import com.example.functionanalyser.frontend.implementations.MainFirstActivity;

public class MainLoginActivity extends AppCompatActivity {

    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        editPassword = findViewById(R.id.editTextNumberPassword2);

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
            Toast.makeText(this,"Input your PIN!", Toast.LENGTH_SHORT).show();
        }else if(codeArray.length!=6){
            Toast.makeText(this,"PIN is invalid", Toast.LENGTH_SHORT).show();
        }else{
            // - compare the inputPIN with all PINS in the dabase
            // - if the code is already in the db, than forward to the next page, otherwise Toast...
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