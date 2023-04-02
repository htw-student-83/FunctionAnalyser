package com.example.functionanalyser.frontend.implementations;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.functionanalyser.R;
import com.example.functionanalyser.frontend.contract.Backward;
import com.example.functionanalyser.frontend.contract.Forward;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainMenuActivity extends AppCompatActivity implements Forward, Backward {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        String c1 = intent.getStringExtra("coefficient");
        String c2 = intent.getStringExtra("coefficient2");
        String c3 = intent.getStringExtra("coefficient3");
        String c4 = intent.getStringExtra("coefficient4");

        int zahl = Integer.parseInt(c1);
        int zahl2 = Integer.parseInt(c2);
        int zahl3 = Integer.parseInt(c3);
        int zahl4 = Integer.parseInt(c4);
/*
        byte[] coefficiendAsBytes = c1.getBytes();
        byte[] coefficiendAsBytes2 = c2.getBytes();
        byte[] coefficiendAsBytes3 = c3.getBytes();
        byte[] coefficiendAsBytes4 = c4.getBytes();
 */

        try {
            persistiereData(zahl, "coefficient.txt");
            persistiereData(zahl2, "coefficient2.txt");
            persistiereData(zahl3, "coefficient3.txt");
            persistiereData(zahl4, "coefficient4.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Button buttonInterfaceXaxis = findViewById(R.id.button2);
        buttonInterfaceXaxis.setOnClickListener(view -> {
            try {
                goToInterfaceWithX();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Button buttonInterfaceYaxis = findViewById(R.id.button3);
        buttonInterfaceYaxis.setOnClickListener(view -> {
            try {
                goToInterfaceWithY();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Button buttonNewFunction = findViewById(R.id.button9);
        buttonNewFunction.setOnClickListener(view -> goToAdditionalPageForOrthogonalFunction());

        Button buttonGradientOfFunctions = findViewById(R.id.button4);
        buttonGradientOfFunctions.setOnClickListener(view -> goToGradiendOfFunction());

        Button buttonInterfacePoint = findViewById(R.id.button5);
        buttonInterfacePoint.setOnClickListener(view -> goToInterfacePoint());

        Button buttonAngelOfGradiends = findViewById(R.id.button6);
        buttonAngelOfGradiends.setOnClickListener(view -> {
            try {
                goToAngelOfGradiends();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Button buttonAngelBetweenFunctions = findViewById(R.id.button11);
        buttonAngelBetweenFunctions.setOnClickListener(view -> {
            try {
                goToAngelBetweenFunctions();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ImageButton backButton = findViewById(R.id.imageButton10);
        backButton.setOnClickListener(view -> goBack());

    }

    @Override
    public void goToInterfaceWithX() throws IOException {
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfaceXaxisActivity.class);
        // - Datas read from a file for sending to an other activity
        int inputData = loadData("coefficient.txt");
        String inputDataNumber = String.valueOf(inputData);
        int inputData2 = loadData("coefficient2.txt");
        String inputDataNumber2 = String.valueOf(inputData2);
        int inputData3 = loadData("coefficient3.txt");
        String inputDataNumber3 = String.valueOf(inputData3);
        int inputData4 = loadData("coefficient4.txt");
        String inputDataNumber4 = String.valueOf(inputData4);
        newActivity.putExtra("coefficient", inputDataNumber);
        newActivity.putExtra("coefficient2", inputDataNumber2);
        newActivity.putExtra("coefficient3", inputDataNumber3);
        newActivity.putExtra("coefficient4", inputDataNumber4);
        startActivity(newActivity);
    }

    @Override
    public void goToInterfaceWithY() throws IOException {
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfaceYaxisActivity.class);
        int inputData2 = loadData("coefficient2.txt");
        String inputDataNumber2 = String.valueOf(inputData2);
        int inputData4 = loadData("coefficient4.txt");
        String inputDataNumber4 = String.valueOf(inputData4);
        newActivity.putExtra("coefficient2", inputDataNumber2);
        newActivity.putExtra("coefficient4", inputDataNumber4);
        startActivity(newActivity);
    }

    @Override
    public void goToGradiendOfFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainGradiendOfFunctionsActivity.class);
        startActivity(newActivity);
    }

    @Override
    public void goToInterfacePoint(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainInterfacePointActivity.class);
        startActivity(newActivity);
    }

    @Override
    public void goToAdditionalPageForOrthogonalFunction(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainAdditionalCoordinateActivity.class);
        startActivity(newActivity);
    }


    @Override
    public void goToAngelOfGradiends() throws IOException {
        Intent newActivity = new Intent(MainMenuActivity.this, MainAngelOfGradiendsActivity.class);
        int inputData2 = loadData("coefficient2.txt");
        int inputData4 = loadData("coefficient4.txt");
        newActivity.putExtra("coefficient2", inputData2);
        newActivity.putExtra("coefficient4", inputData4);
        startActivity(newActivity);
    }

    @Override
    public void goToAngelBetweenFunctions() throws IOException {
        Intent newActivity = new Intent(MainMenuActivity.this, MainAngelBetweenFunctionsActivity.class);
        int inputData = loadData("coefficient.txt");
        int inputData3 = loadData("coefficient3.txt");
        newActivity.putExtra("coefficient", inputData);
        newActivity.putExtra("coefficient3", inputData3);
        startActivity(newActivity);
    }


    /*
        public void showToast8(){
            Toast toast = Toast.makeText(this, "Eighth. button selected.", Toast.LENGTH_LONG);
            toast.show();
        }

     */

    public void persistiereData(int dataNumber, String filename) throws IOException {
        // - with getApplication().getFilesDir() you'll get the way, where your datas saved
        File file = new File(getApplication().getFilesDir(), filename);
        OutputStream outputStream = new FileOutputStream(file, true);
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.write(dataNumber);
        dos.close();
    }



    public int loadData(String filename) throws IOException {
        File file = new File(getApplication().getFilesDir(), filename);
        FileInputStream fis = new FileInputStream(file);
        InputStream inputStream = new DataInputStream(fis);
        return inputStream.read();
    }


    @Override
    public void goBack(){
        Intent newActivity = new Intent(MainMenuActivity.this, MainThirdActivity.class);
        startActivity(newActivity);
    }
}