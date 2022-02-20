package com.faresmezenner.avrgcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Branchs extends AppCompatActivity {


    @Override
    public void onBackPressed() {

        Intent backIntent = new Intent(Branchs.this, MainActivity.class);
        startActivity(backIntent);
        finish();

        //super.onBackPressed();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branchs);



        String action = getIntent().getStringExtra("year");


        Intent backIntent = new Intent(Branchs.this, MainActivity.class);
        Intent math_intent_3 = new Intent(getApplicationContext(), Math_3as.class);
        Intent math_intent_2 = new Intent(getApplicationContext(), Math_2as.class);
        Intent math_intent_bac = new Intent(getApplicationContext(), Bac_math.class);
        Intent science_intent_3 = new Intent(getApplicationContext(), Science_3as.class);
        Intent science_intent_2 = new Intent(getApplicationContext(), Science_2as.class);
        Intent science_intent_bac = new Intent(getApplicationContext(), Bac_science.class);
        Intent tech_intent_3 = new Intent(getApplicationContext(), Tech_3as.class);
        Intent tech_intent_2 = new Intent(getApplicationContext(), Tech_2as.class);
        Intent tech_intent_bac = new Intent(getApplicationContext(), Bac_tech.class);
        Intent languages_intent_3 = new Intent(getApplicationContext(), Languages_3as.class);
        Intent languages_intent_2 = new Intent(getApplicationContext(), Languages_2as.class);
        Intent languages_intent_bac = new Intent(getApplicationContext(), Bac_languages.class);
        Intent lettre_intent_3 = new Intent(getApplicationContext(), Lettre_3as.class);
        Intent lettre_intent_2 = new Intent(getApplicationContext(), Lettre_2as.class);
        Intent lettre_intent_bac = new Intent(getApplicationContext(), Bac_Lettre.class);
        Intent gestion_intent_3 = new Intent(getApplicationContext(), Gestion_3as.class);
        Intent gestion_intent_2 = new Intent(getApplicationContext(), Gestion_2as.class);
        Intent gestion_intent_bac = new Intent(getApplicationContext(), Bac_gestion.class);
        math_intent_3.putExtra("year", action);


        ImageView back = findViewById(R.id.back);
        TextView year_title = findViewById(R.id.year_title);
        Button math = findViewById(R.id.math);
        Button science = findViewById(R.id.science);
        Button tech = findViewById(R.id.tech);
        Button languages = findViewById(R.id.languages);
        Button lettre = findViewById(R.id.lettre);
        Button gestion = findViewById(R.id.gestion);

        if(action.equals(Classes.THIRD)){

            year_title.setText("السنة الثالثة ثانوي");

        } else if(action.equals(Classes.SECOND)){

            year_title.setText("السنة الثانية ثانوي");
        } else if (action.equals(Classes.BAC)){
            year_title.setText("الباكالوريا");
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
                finish();
            }
        });



        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(Branchs.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup2 = findViewById(android.R.id.content);
        View dialogView2 = LayoutInflater.from(Branchs.this).inflate(R.layout.wait, viewGroup2, false);
        alertBuilder2.setView(dialogView2);
        AlertDialog alerdialog2 = alertBuilder2.create();



{
    math.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            alerdialog2.show();

            if(action.equals(Classes.THIRD)){

                startActivity(math_intent_3);

                finish();

            } else if(action.equals(Classes.SECOND)) {

                startActivity(math_intent_2);
                finish();

            } else if (action.equals(Classes.BAC)){
                startActivity(math_intent_bac);
                finish();
            }

        }
    });
}

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();

                if(action.equals(Classes.THIRD)){

                    startActivity(science_intent_3);
                    finish();

                } else if(action.equals(Classes.SECOND)) {

                    startActivity(science_intent_2);
                    finish();

                } else if (action.equals(Classes.BAC)){
                    startActivity(science_intent_bac);
                    finish();
                }
            }
        });

        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                if(action.equals(Classes.THIRD)){

                    startActivity(tech_intent_3);
                    finish();

                }else if(action.equals(Classes.SECOND)) {

                    startActivity(tech_intent_2);
                    finish();

                }else if (action.equals(Classes.BAC)){
                    startActivity(tech_intent_bac);
                    finish();
                }
            }
        });

        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();

                if(action.equals(Classes.THIRD)){

                    startActivity(languages_intent_3);
                    finish();

                }else if(action.equals(Classes.SECOND)) {

                    startActivity(languages_intent_2);
                    finish();

                }else if (action.equals(Classes.BAC)){
                    startActivity(languages_intent_bac);
                    finish();
                }

            }
        });


        lettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                if(action.equals(Classes.THIRD)){

                    startActivity(lettre_intent_3);
                    finish();

                }else if(action.equals(Classes.SECOND)) {

                    startActivity(lettre_intent_2);
                    finish();

                }else if (action.equals(Classes.BAC)){
                    startActivity(lettre_intent_bac);
                    finish();
                }
            }
        });



        gestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                if(action.equals(Classes.THIRD)){

                    startActivity(gestion_intent_3);
                    finish();

                } else if(action.equals(Classes.SECOND)) {

                    startActivity(gestion_intent_2);
                    finish();

                } else if (action.equals(Classes.BAC)){
                    startActivity(gestion_intent_bac);
                    finish();
                }
            }
        });





    }
}