package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.functionanalyser.R;

public class MainFirstActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        radioGroup = findViewById(R.id.group);

        ImageButton button = findViewById(R.id.numberconfirm);
        button.setOnClickListener(view -> checkRadioButton());
    }

    public void checkRadioButton(){
        int checkID = radioGroup.getCheckedRadioButtonId();
        if(checkID == -1){
        }else if((checkID%2)!=0){
            Intent newActivity = new Intent(MainFirstActivity.this, MainSecondActivity.class);
            startActivity(newActivity);
       }else{
            Intent newActivity = new Intent(MainFirstActivity.this, MainThirdActivity.class);
            startActivity(newActivity);
        }
    }

    public void showToast(int checkID){
        Toast toast = Toast.makeText(this, "Exponent " + checkID + " selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showNothingToast(int checkID){
        Toast toast = Toast.makeText(this, "Nothing selected.", Toast.LENGTH_LONG);
        toast.show();
    }
}