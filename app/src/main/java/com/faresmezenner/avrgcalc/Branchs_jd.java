package com.faresmezenner.avrgcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Branchs_jd extends AppCompatActivity {


    @Override
    public void onBackPressed() {

        Intent backIntent = new Intent(Branchs_jd.this, MainActivity.class);
        startActivity(backIntent);
        finish();

        //super.onBackPressed();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branchs_jd);




        ImageView back = findViewById(R.id.back);

        Button science = findViewById(R.id.science);
        Button lettre = findViewById(R.id.lettre);

        Intent[] intents = new Intent[2];
        intents[0] = new Intent(getApplicationContext(), Science_jd.class);
        intents[1] = new Intent(getApplicationContext(), Lettre_jd.class);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(Branchs_jd.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });



        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(Branchs_jd.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup2 = findViewById(android.R.id.content);
        View dialogView2 = LayoutInflater.from(Branchs_jd.this).inflate(R.layout.wait, viewGroup2, false);
        alertBuilder2.setView(dialogView2);
        AlertDialog alerdialog2 = alertBuilder2.create();


        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(intents[0]);
                finish();
            }
        });



        lettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(intents[1]);
                finish();
            }
        });

    }
}