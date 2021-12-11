package com.faresmezenner.avrgcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Bac_Lettre extends AppCompatActivity {


    static int MATH = 2;
    static int ARABIC = 6;
    static int ISLAMIA = 2;
    static int HISTORY = 4;
    static int FRENCH = 3;
    static int ENGLISH = 3;
    static int PHILO = 6;
    static int SPORT = 1;
    static int KABYLE = 2;
    
    
    int SUBJECTS = 9;

    boolean saves = true;
    @Override
    public void onBackPressed() {


        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Bac_Lettre.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(Bac_Lettre.this).inflate(R.layout.save_before, viewGroup, false);
        Button yes=dialogView.findViewById(R.id.yes);
        Button no=dialogView.findViewById(R.id.no);
        alertBuilder.setView(dialogView);
        AlertDialog alerdialog = alertBuilder.create();



        Intent backIntent = new Intent(getApplicationContext(), Branchs.class);
        backIntent.putExtra("year", "bac");


        if(saves){
            startActivity(backIntent);
            finish();

        } else {


            alerdialog.show();


        }

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog.dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(backIntent);
                finish();
            }
        });




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bac_lettre);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = findViewById(R.id.ad);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        CheckBox kabyle_checkbox = findViewById(R.id.kabyle_checkbox);
        LinearLayout kabyle = findViewById(R.id.kabyle);
        CheckBox sport_checkbox = findViewById(R.id.sport_checkbox);
        LinearLayout sport = findViewById(R.id.sport);



        SharedPreferences prefs = getSharedPreferences("bac_lettre", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();


        EditText[] note = new EditText[9];

        note[0] = findViewById(R.id.exam_arabic);
        note[1] = findViewById(R.id.exam_philo);
        note[2] = findViewById(R.id.exam_history);
        note[3] = findViewById(R.id.exam_islamia);
        note[4] = findViewById(R.id.exam_french);
        note[5] = findViewById(R.id.exam_english);
        note[6] = findViewById(R.id.exam_math);
        note[7] = findViewById(R.id.exam_sport);
        note[8] = findViewById(R.id.exam_kabyle);





        Toast toast = Toast.makeText(getApplicationContext(), "يرجى ادخال علامة بين 0 و 20", Toast.LENGTH_LONG);

        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {


                for(int i  = 0; i<SUBJECTS; i++){

                    String key = "note" + i;
                    if(!hasFocus && !note[i].getText().toString().isEmpty()){
                        if (Double.valueOf(note[i].getText().toString()) > 20 || Double.valueOf(note[i].getText().toString()) < 0) {
                            note[i].setTextColor(getResources().getColor(R.color.red));
                            note[i].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();

                        }else {

                            editor.putString(key, note[i].getText().toString());

                        }
                    }else if (hasFocus) {
                        toast.cancel();
                        note[i].setTextColor(getResources().getColor(R.color.blue));
                        note[i].setBackgroundResource(R.drawable.button_border);
                    } else if (!hasFocus && note[i].getText().toString().isEmpty()) {

                        toast.cancel();
                        note[i].setTextColor(getResources().getColor(R.color.blue));
                        note[i].setBackgroundResource(R.drawable.button_border);
                        editor.putString(key, "");


                    }

                }
                saves = false;
            }
        };

        {
            note[0].setOnFocusChangeListener(onFocusChangeListener);
            note[1].setOnFocusChangeListener(onFocusChangeListener);
            note[2].setOnFocusChangeListener(onFocusChangeListener);
            note[3].setOnFocusChangeListener(onFocusChangeListener);
            note[4].setOnFocusChangeListener(onFocusChangeListener);
            note[5].setOnFocusChangeListener(onFocusChangeListener);
            note[6].setOnFocusChangeListener(onFocusChangeListener);
            note[7].setOnFocusChangeListener(onFocusChangeListener);
            note[8].setOnFocusChangeListener(onFocusChangeListener);
        }

        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<SUBJECTS; i++){
                    note[i].requestFocus();
                }
                getWindow().getDecorView().clearFocus();
                editor.apply();

                Toast.makeText(getApplicationContext(), "تم حفظ جميع النقاط", Toast.LENGTH_LONG).show();


                saves = true;

            }
        });

        Button empty_all = findViewById(R.id.empty);

        empty_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i =0; i<SUBJECTS; i++){
                    note[i].setText("");
                }

                saves = false;
            }
        });


        if(prefs.getBoolean("kabyle", false)){
            kabyle.setVisibility(View.VISIBLE);
            kabyle_checkbox.setChecked(true);
        } else {
            kabyle.setVisibility(View.GONE);
            kabyle_checkbox.setChecked(false);
        }



        if(prefs.getBoolean("sport", true)){
            sport.setVisibility(View.VISIBLE);
            sport_checkbox.setChecked(true);
        } else {
            sport.setVisibility(View.GONE);
            sport_checkbox.setChecked(false);
        }


        kabyle_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    kabyle.setVisibility(View.VISIBLE);
                    kabyle_checkbox.setChecked(true);
                } else {
                    kabyle.setVisibility(View.GONE);
                    kabyle_checkbox.setChecked(false);
                }
            }
        });

        sport_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    sport.setVisibility(View.VISIBLE);
                    sport_checkbox.setChecked(true);
                } else {

                    sport.setVisibility(View.GONE);
                    sport_checkbox.setChecked(false);
                }
            }
        });



        ImageView back = findViewById(R.id.back);
        Intent backIntent = new Intent(getApplicationContext(), Branchs.class);
        backIntent.putExtra("year","bac");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().clearFocus();
                onBackPressed();
            }
        });

        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(Bac_Lettre.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup2 = findViewById(android.R.id.content);
        View dialogView2 = LayoutInflater.from(Bac_Lettre.this).inflate(R.layout.repport_bac, viewGroup2, false);
        alertBuilder2.setView(dialogView2);
        Button buttonOk2 = dialogView2.findViewById(R.id.ok);
        AlertDialog alerdialog2 = alertBuilder2.create();

        TextView total_avrg = dialogView2.findViewById(R.id.total_avrg);



        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Bac_Lettre.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(Bac_Lettre.this).inflate(R.layout.fill_all, viewGroup, false);
        Button buttonOk=dialogView.findViewById(R.id.ok);
        alertBuilder.setView(dialogView);
        alertBuilder.setView(dialogView);


        AlertDialog alerdialog = alertBuilder.create();

        Calculations calculations = new Calculations();
        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                boolean good = true;


                for(int i = 0; i<SUBJECTS-2; i++){

                    if (!note[i].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[i].getText().toString()) > 20 || Double.valueOf(note[i].getText().toString()) < 0) {
                            note[i].setTextColor(getResources().getColor(R.color.red));
                            note[i].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                            break;
                        }
                    }

                }

                if(sport_checkbox.isChecked()){

                    if (!note[SUBJECTS-2].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[SUBJECTS-2].getText().toString()) > 20 || Double.valueOf(note[SUBJECTS-2].getText().toString()) < 0) {
                            note[SUBJECTS-2].setTextColor(getResources().getColor(R.color.red));
                            note[SUBJECTS-2].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                        }
                    }


                }

                if(kabyle_checkbox.isChecked()){

                    if (!note[SUBJECTS-1].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[SUBJECTS-1].getText().toString()) > 20 || Double.valueOf(note[SUBJECTS-1].getText().toString()) < 0) {
                            note[SUBJECTS-1].setTextColor(getResources().getColor(R.color.red));
                            note[SUBJECTS-1].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                        }
                    }


                }


                String sport_note = "";
                String kabyle_note = "";


                if(!note[SUBJECTS-2].getText().toString().isEmpty()){
                    sport_note = String.valueOf(note[SUBJECTS-2].getText());
                }
                if(!note[SUBJECTS-1].getText().toString().isEmpty()){
                    kabyle_note = String.valueOf(note[SUBJECTS-1].getText());
                }


                if(good) {


                    int SUBJECTS = 9;

                    boolean success = true;


                    int[] coefficients = new int[9];
                    coefficients[0] = 6;
                    coefficients[1] = 6;
                    coefficients[2] = 4;
                    coefficients[3] = 2;
                    coefficients[4] = 3;
                    coefficients[5] = 3;
                    coefficients[6] = 2;
                    coefficients[7] = 1;
                    coefficients[8] = 2;


                    if (!kabyle_checkbox.isChecked()) {
                        coefficients[8] = 0;
                        note[8].setText("0");
                    }

                    if (!sport_checkbox.isChecked()) {
                        coefficients[7] = 0;
                        note[7].setText("0");
                    }


                    for (int i = 0; i < SUBJECTS; i++) {

                        if ((TextUtils.isEmpty(note[i].getText().toString()))) {
                            success = false;
                            alerdialog.show();
                            break;

                        }

                    }


                    if (success) {

                        double bac = calculations.bacAvrg(note, coefficients, SUBJECTS);
                        Log.d("BAC:", String.valueOf(bac));

                        total_avrg.setText(String.valueOf(bac));
                        alerdialog2.show();
                    }


                    note[SUBJECTS-1].setText(kabyle_note);
                    note[SUBJECTS-2].setText(sport_note);


                }

            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog.dismiss();
            }
        });

        buttonOk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog2.dismiss();
            }
        });


        for(int i = 0; i<SUBJECTS; i++){
            String key = "note" + i;
            note[i].setText(prefs.getString(key, ""));
        }

    }
}