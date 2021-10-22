package com.faresmezenner.avrgcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), First.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent branchs = new Intent(getApplicationContext(), Branchs.class);
        Intent branchs_jd = new Intent(getApplicationContext(), Branchs_jd.class);
        Intent bem_intent = new Intent(getApplicationContext(), Bem.class);
        Intent am4_intent = new Intent(getApplicationContext(), Am4.class);
        Intent am3_intent = new Intent(getApplicationContext(), Am3.class);
        Intent am2_intent = new Intent(getApplicationContext(), Am2.class);
        Intent am1_intent = new Intent(getApplicationContext(), Am1.class);


        Button third_as = findViewById(R.id.three_as);
        Button second_as = findViewById(R.id.second_as);
        Button first_as = findViewById(R.id.first_as);

        Button bac = findViewById(R.id.bac);
        Button bem = findViewById(R.id.bem);

        Button am4 = findViewById(R.id.foorth_am);
        Button am3 = findViewById(R.id.third_am);
        Button am2 = findViewById(R.id.second_am);
        Button am1 = findViewById(R.id.first_am);




        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(MainActivity.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup2 = findViewById(android.R.id.content);
        View dialogView2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.wait, viewGroup2, false);
        alertBuilder2.setView(dialogView2);
        AlertDialog alerdialog2 = alertBuilder2.create();

        third_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                branchs.putExtra("year","third");
                startActivity(branchs);
                finish();
            }
        });


        second_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                branchs.putExtra("year","second");
                startActivity(branchs);
                finish();
            }
        });

        first_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(branchs_jd);
                finish();
            }
        });


        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                branchs.putExtra("year","bac");
                startActivity(branchs);
                finish();
            }
        });


        bem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(bem_intent);
                finish();
            }
        });

        am4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(am4_intent);
                finish();
            }
        });

        am3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(am3_intent);
                finish();
            }
        });

        am2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(am2_intent);
                finish();
            }
        });

        am1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.show();
                startActivity(am1_intent);
                finish();
            }
        });

    }
}