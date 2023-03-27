package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.functionanalyser.R;
import com.example.functionanalyser.frontend.contract.Forwards;

public class MainMenuActivity extends AppCompatActivity implements Forwards {
    int code = 22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button buttonInterfaceXaxis = findViewById(R.id.button2);
        buttonInterfaceXaxis.setOnClickListener(view -> goToInterfaceWithX());

        Button buttonInterfaceYaxis = findViewById(R.id.button3);
        buttonInterfaceYaxis.setOnClickListener(view -> goToInterfaceWithY());

        Button buttonParallimFunction = findViewById(R.id.button9);
        buttonParallimFunction.setOnClickListener(view -> goToParallelFunction());

        Button buttonGradientOfFunctions = findViewById(R.id.button4);
        buttonGradientOfFunctions.setOnClickListener(view -> goToGradiendOfFunction());

        Button buttonInterfacePoint = findViewById(R.id.button5);
        buttonInterfacePoint.setOnClickListener(view -> goToInterfacePoint());

        Button buttonOrthogonalFunction = findViewById(R.id.button8);
        buttonOrthogonalFunction.setOnClickListener(view -> goToOrthogonalFunction());

        Button buttonAngelOfGradiends = findViewById(R.id.button6);
        buttonAngelOfGradiends.setOnClickListener(view -> goToAngelOfGradiends());

        Button buttonAngelBetweenFunctions = findViewById(R.id.button11);
        buttonAngelBetweenFunctions.setOnClickListener(view -> goToAngelBetweenFunctions());

        ImageButton backButton = findViewById(R.id.imageButton10);
        backButton.setOnClickListener(view -> goBack());
    }

    public void goToInterfaceWithX(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfaceXaxisActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToInterfaceWithY(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfaceYaxisActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToParallelFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainParallelFunctionActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToGradiendOfFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainGradiendOfFunctionsActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToInterfacePoint(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfacePointActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToOrthogonalFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainOrthogonalFunctionActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToAngelOfGradiends(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainAngelOfGradiendsActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void goToAngelBetweenFunctions(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainAngelBetweenFunctionsActivity.class);
        startActivityForResult(newActivity, code);
    }

    public void showToast(){
        Toast toast = Toast.makeText(this, "First button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast2(){
        Toast toast = Toast.makeText(this, "Second button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast3(){
        Toast toast = Toast.makeText(this, "Third button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast4(){
        Toast toast = Toast.makeText(this, "Forth button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast5(){
        Toast toast = Toast.makeText(this, "Fivth. button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast6(){
        Toast toast = Toast.makeText(this, "Sixth. button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast7(){
        Toast toast = Toast.makeText(this, "Seventh. button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showToast8(){
        Toast toast = Toast.makeText(this, "Eighth. button selected.", Toast.LENGTH_LONG);
        toast.show();
    }

    public void goBack(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainThirdActivity.class);
        startActivityForResult(newActivity, code);
    }
}