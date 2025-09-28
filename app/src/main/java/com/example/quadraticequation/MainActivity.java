package com.example.quadraticequation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    }
}


double s=0;
double s1=0;
s= (-b+root(squer(b)-(4*a*c)))/2*a;
s1= (-b-root(squer(b)-(4*a*c)))/2*a;
