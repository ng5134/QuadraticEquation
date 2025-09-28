package com.example.quadraticequation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    TextView textSolution;
    Button btnGoBack;
    ImageView imageIllustration;
    private String solution = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textSolution= findViewById(R.id.textSolution);
        btnGoBack= findViewById(R.id.btnGoBack);
        imageIllustration= findViewById(R.id.ImageIllustration);

        double a = getIntent().getDoubleExtra("a",0);
        double b = getIntent().getDoubleExtra("b",0);
        double c = getIntent().getDoubleExtra("c",0);
        solution= solveQuadratic(a,b,c);
        textSolution.setText(solution);


    }

    public void goBack(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("solution", solution);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
    private String solveQuadratic(double a, double b, double c) {
        boolean isH = a > 0;
        if (a==0){
            if(b==0){
                if(isH){
                    imageIllustration.setImageResource(R.drawable.happy_no_root);
                }
                else {
                    imageIllustration.setImageResource(R.drawable.sad_no_root);
                }
                return (c==0)? "Infinite solutions": "No solution";
            }
            else {
                double x=-c/b;
                if (isH){
                    imageIllustration.setImageResource(R.drawable.happy_one_root);
                }
                else{
                    imageIllustration.setImageResource(R.drawable.sad_one_root);
                }
                return ("linear solution: x="+x);
            }
        }
        double d= b*b -4*a*c;
        if (d<0){
            if (isH){
                imageIllustration.setImageResource(R.drawable.happy_no_root);
            }
            else{
                imageIllustration.setImageResource(R.drawable.sad_no_root);
            }
        return("no real solutions(Discriminant <0)");
        } else if (d == 0) {
            double x = -b / (2 * a);
            if (isH){
                imageIllustration.setImageResource(R.drawable.happy_one_root);
            }
            else{
                imageIllustration.setImageResource(R.drawable.sad_one_root);
            }
            return "One solution: x = " + x;
        }
        else {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            if(isH){
                imageIllustration.setImageResource(R.drawable.happy_two_roots);
            }
            else{
                imageIllustration.setImageResource(R.drawable.sad_two_roots);
            }
            return "Two solutions:\nx1 = " + x1 + "\nx2 = " + x2;
        }
    }
}