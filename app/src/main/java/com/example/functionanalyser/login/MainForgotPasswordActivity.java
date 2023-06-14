package com.example.functionanalyser.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.functionanalyser.R;

public class MainForgotPasswordActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_forgot_password);
        email = findViewById(R.id.editTextTextEmailAddress2);

        Button sendButton = findViewById(R.id.button19);
        sendButton.setOnClickListener(view -> {
            try {
                sendPassword();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void sendPassword() throws InterruptedException {
        String emailaddress = email.getText().toString();
        // - The PIN will read from the database by the emailaddress
        String pinCode = "10";
        if (emailaddress.isEmpty()) {
            Toast.makeText(this,"Please input your address!", Toast.LENGTH_SHORT).show();
        } else {
            if (!checkMailAddress(emailaddress)) {
                Toast.makeText(this,"Your mail is invalid.", Toast.LENGTH_SHORT).show();
            } else {
                // - PIN will send to the exists mail address
                //  - Error -> the email wouldn't send, why?
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:student2683@web.de"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Your PIN");
                intent.putExtra(Intent.EXTRA_TEXT, pinCode);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    goBackToLogin();
                }
            }
        }
    }

    private void goBackToLogin() throws InterruptedException {
        Thread.sleep(3000);
        Intent newActivity = new Intent(MainForgotPasswordActivity.this, MainLoginActivity.class);
        startActivity(newActivity);
    }

    private boolean checkMailAddress(String mail) {
        // - to check is the email valid or not
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }
}