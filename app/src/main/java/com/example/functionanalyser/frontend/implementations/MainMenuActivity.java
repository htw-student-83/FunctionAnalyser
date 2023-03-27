package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.functionanalyser.R;
import com.example.functionanalyser.frontend.contract.Backward;
import com.example.functionanalyser.frontend.contract.Forward;

public class MainMenuActivity extends AppCompatActivity implements Forward, Backward {
    int code = 22;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("coefficient1");
        String c2 = intent.getStringExtra("coefficient2");
        String c3 = intent.getStringExtra("coefficient3");
        String c4 = intent.getStringExtra("coefficient4");

        Button buttonInterfaceXaxis = findViewById(R.id.button2);
        buttonInterfaceXaxis.setOnClickListener(view -> goToInterfaceWithX(c1, c2, c3, c4));

        Button buttonInterfaceYaxis = findViewById(R.id.button3);
        buttonInterfaceYaxis.setOnClickListener(view -> goToInterfaceWithY(c2, c4));

        Button buttonParallimFunction = findViewById(R.id.button9);
        buttonParallimFunction.setOnClickListener(view -> goToParallelFunction());

        Button buttonGradientOfFunctions = findViewById(R.id.button4);
        buttonGradientOfFunctions.setOnClickListener(view -> goToGradiendOfFunction());

        Button buttonInterfacePoint = findViewById(R.id.button5);
        buttonInterfacePoint.setOnClickListener(view -> goToInterfacePoint());

        Button buttonOrthogonalFunction = findViewById(R.id.button8);
        buttonOrthogonalFunction.setOnClickListener(view -> goToOrthogonalFunction());

        Button buttonAngelOfGradiends = findViewById(R.id.button6);
        buttonAngelOfGradiends.setOnClickListener(view -> goToAngelOfGradiends(c1, c3));

        Button buttonAngelBetweenFunctions = findViewById(R.id.button11);
        buttonAngelBetweenFunctions.setOnClickListener(view -> goToAngelBetweenFunctions(c1, c3));

        ImageButton backButton = findViewById(R.id.imageButton10);
        backButton.setOnClickListener(view -> goBack());
    }

    @Override
    public void goToInterfaceWithX(String coefficient, String coefficient2, String coefficient3, String coefficient4){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfaceXaxisActivity.class);
        newActivity.putExtra("coefficient1", coefficient);
        newActivity.putExtra("coefficient2", coefficient2);
        newActivity.putExtra("coefficient3", coefficient3);
        newActivity.putExtra("coefficient4", coefficient4);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToInterfaceWithY(String coefficient2, String coefficient4){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfaceYaxisActivity.class);
        newActivity.putExtra("coefficient2", coefficient2);
        newActivity.putExtra("coefficient4", coefficient4);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToParallelFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainParallelFunctionActivity.class);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToGradiendOfFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainGradiendOfFunctionsActivity.class);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToInterfacePoint(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfacePointActivity.class);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToOrthogonalFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainOrthogonalFunctionActivity.class);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToAngelOfGradiends(String coefficient1, String coefficient3){
        Intent newActivity = new Intent(MainMenuActivity.this, MainAngelOfGradiendsActivity.class);
        newActivity.putExtra("coefficient", coefficient1);
        newActivity.putExtra("coefficient3", coefficient3);
        startActivityForResult(newActivity, code);
    }

    @Override
    public void goToAngelBetweenFunctions(String coefficient1, String coefficient3){
        Intent newActivity = new Intent(MainMenuActivity.this, MainAngelBetweenFunctionsActivity.class);
        newActivity.putExtra("coefficient", coefficient1);
        newActivity.putExtra("coefficient3", coefficient3);
        startActivityForResult(newActivity, code);
    }


/*
    public void showToast8(){
        Toast toast = Toast.makeText(this, "Eighth. button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

 */
    @Override
    public void goBack(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainThirdActivity.class);
        startActivityForResult(newActivity, code);
    }
}