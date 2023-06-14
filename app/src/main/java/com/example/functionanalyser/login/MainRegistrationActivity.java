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

public class MainRegistrationActivity extends AppCompatActivity {

    private EditText firstname, lastname, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registration);
        firstname = findViewById(R.id.editTextTextPersonName3);
        lastname = findViewById(R.id.editTextTextPersonName4);
        email = findViewById(R.id.editTextTextPersonName);
        Button conformRegistration = findViewById(R.id.button17);
        conformRegistration.setOnClickListener(view -> {
            try {
                checkData();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void checkData() throws InterruptedException {
        String fName = firstname.getText().toString();
        String lName = lastname.getText().toString();
        String mail = email.getText().toString();
        if(fName.isEmpty() || lName.isEmpty() || mail.isEmpty()){
            Toast.makeText(this, "One or more fields are empty.", Toast.LENGTH_LONG).show();
        }else{
            if(!checkMailAddress(mail)){
                Toast.makeText(this, "Your mail is invalid.", Toast.LENGTH_SHORT).show();
            }else{
                int pin = createNewPIN();
                // - the datas will write into the database
                Database db = new Database(MainRegistrationActivity.this);
                db.addNewPerson(fName, lName, mail, pin);
                // - the PIN will send to the email
                sendMail(mail, pin);
                Thread.sleep(2000);
                Intent newActivity = new Intent(MainRegistrationActivity.this, MainLoginActivity.class);
                startActivity(newActivity);
            }
        }
    }

    private int createNewPIN() {
        // - a new PIN get out if the code isn't already in the db otherwise increment to the next number
        int minRandomNumber = 1000;
        return ++minRandomNumber;
    }



    private void sendMail(String mail, int pin){
        String accessCode = String.valueOf(pin);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+mail));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your PIN");
        intent.putExtra(Intent.EXTRA_TEXT, accessCode);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private boolean checkMailAddress(String mail){
        // - to check is the email valid or not
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }
}