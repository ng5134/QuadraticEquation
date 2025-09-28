package com.example.quadraticequation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText inputA, inputB, inputC;
    Button btnSolve, btnRandom;
    TextView lastResult;

    String lastSolution="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputA= findViewById(R.id.inputA);
        inputB= findViewById(R.id.inputB);
        inputC= findViewById(R.id.inputC);
        btnSolve= findViewById(R.id.btnSolve);
        btnRandom= findViewById(R.id.btnRandom);
        lastResult= findViewById(R.id.LastResult);

        btnSolve.setOnClickListener(v -> {
            try{
                double a= Double.parseDouble(inputA.getText().toString());
                double b= Double.parseDouble(inputB.getText().toString());
                double c= Double.parseDouble(inputC.getText().toString());

                Intent intent= new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("a", a);
                intent.putExtra("b", b);
                intent.putExtra("c", c);
                startActivityForResult(intent, 1);
            }
            catch (NumberFormatException e){
                Toast.makeText(this, "please enter valid numbers", Toast.LENGTH_SHORT ).show();
            }
        });

        btnRandom.setOnClickListener(v -> {
            Random rand= new Random();
            int a= rand.nextInt(9)+1;
            int b= rand.nextInt(20)-10;
            int c= rand.nextInt(20)-10;

            inputA.setText(String.valueOf(a));
            inputB.setText(String.valueOf(b));
            inputC.setText(String.valueOf(c));
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode== RESULT_OK){
            lastSolution= data.getStringExtra("solution");
            lastResult.setText("Last solution:"+ lastSolution);
        }
    }
}
