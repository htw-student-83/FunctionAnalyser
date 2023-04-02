package com.example.functionanalyser.frontend.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.functionanalyser.R;

public class MainRegistrationActivity extends AppCompatActivity {

    private EditText firstname, lastname, email;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registration);
        firstname = findViewById(R.id.editTextTextPersonName);
        lastname = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextEmailAddress);
        output = findViewById(R.id.textView56);
        Button conformRegistration = findViewById(R.id.button17);
        conformRegistration.setOnClickListener(view -> checkData());
    }

    private void checkData() {
        String fName = firstname.getText().toString();
        String lName = lastname.getText().toString();
        String mail = email.getText().toString();
        int pin = 1000;
        if(fName.isEmpty() || lName.isEmpty() || mail.isEmpty()){
            output.setText("One or more fields are empty.");
        }else{
            if(!checkMailAddress(mail)){
                output.setText("Your mail is invalid.");
            }else{
                // - the datas will write into the database
                Database db = new Database(MainRegistrationActivity.this);
                db.addNewPerson(fName, lName, mail, pin);
                // - the new PIN will read from the database
                // - the PIN will send to the email
                //sendMail(mail, pin);
            }
        }
    }

    private void sendMail(String mail, String pin){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+mail));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your PIN");
        intent.putExtra(Intent.EXTRA_TEXT, pin);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    private boolean checkMailAddress(String mail){
        // - to check is the email valid or not
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }
}