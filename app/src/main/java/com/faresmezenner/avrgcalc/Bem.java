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

public class Bem extends AppCompatActivity {


    int SUBJECTS = 13;

    boolean saves = true;
    @Override
    public void onBackPressed() {


        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Bem.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(Bem.this).inflate(R.layout.save_before, viewGroup, false);
        Button yes=dialogView.findViewById(R.id.yes);
        Button no=dialogView.findViewById(R.id.no);
        alertBuilder.setView(dialogView);
        AlertDialog alerdialog = alertBuilder.create();



        Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);


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

    static int MATH = 4;
    static int SCIENCE = 2;
    static int PHYSIC = 2;
    static int ARABIC = 5;
    static int ISLAMIA = 2;
    static int HISTORY = 3;
    static int CIVIL = 1;
    static int ART = 1;
    static int MUSIC = 1;
    static int FRENCH = 3;
    static int ENGLISH = 2;
    static int SPORT = 1;
    static int KABYLE = 2;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bem);



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
        CheckBox art_checkbox = findViewById(R.id.art_checkbox);
        LinearLayout art = findViewById(R.id.art);
        CheckBox music_checkbox = findViewById(R.id.music_checkbox);
        LinearLayout music = findViewById(R.id.music);



        SharedPreferences prefs = getSharedPreferences("bem", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();




        EditText[] note = new EditText[13];

        note[0] = findViewById(R.id.exam_arabic);
        note[1] = findViewById(R.id.exam_math);
        note[2] = findViewById(R.id.exam_french);
        note[3] = findViewById(R.id.exam_science);
        note[4] = findViewById(R.id.exam_physic);
        note[5] = findViewById(R.id.exam_history);
        note[6] = findViewById(R.id.exam_islamia);
        note[7] = findViewById(R.id.exam_civil);
        note[8] = findViewById(R.id.exam_english);
        note[9] = findViewById(R.id.exam_kabyle);
        note[10] = findViewById(R.id.exam_art);
        note[11] = findViewById(R.id.exam_music);
        note[12] = findViewById(R.id.exam_sport);



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
            note[9].setOnFocusChangeListener(onFocusChangeListener);
            note[10].setOnFocusChangeListener(onFocusChangeListener);
            note[11].setOnFocusChangeListener(onFocusChangeListener);
            note[12].setOnFocusChangeListener(onFocusChangeListener);
            
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



        if(prefs.getBoolean("art", true)){
            art.setVisibility(View.VISIBLE);
            art_checkbox.setChecked(true);
        } else {
            art.setVisibility(View.GONE);
            art_checkbox.setChecked(false);
        }



        if(prefs.getBoolean("music", true)){
            music.setVisibility(View.VISIBLE);
            music_checkbox.setChecked(true);
        } else {
            music.setVisibility(View.GONE);
            music_checkbox.setChecked(false);
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


        art_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    art.setVisibility(View.VISIBLE);
                    art_checkbox.setChecked(true);
                } else {

                    art.setVisibility(View.GONE);
                    art_checkbox.setChecked(false);
                }
            }
        });


        music_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    music.setVisibility(View.VISIBLE);
                    music_checkbox.setChecked(true);
                } else {

                    music.setVisibility(View.GONE);
                    music_checkbox.setChecked(false);
                }
            }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWindow().getDecorView().clearFocus();
                onBackPressed();
            }
        });

        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(Bem.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup2 = findViewById(android.R.id.content);
        View dialogView2 = LayoutInflater.from(Bem.this).inflate(R.layout.repport_bem, viewGroup2, false);
        alertBuilder2.setView(dialogView2);
        Button buttonOk2 = dialogView2.findViewById(R.id.ok);
        AlertDialog alerdialog2 = alertBuilder2.create();

        TextView total_avrg = dialogView2.findViewById(R.id.total_avrg);



        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Bem.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(Bem.this).inflate(R.layout.fill_all, viewGroup, false);
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


                for(int i = 0; i<SUBJECTS-4; i++){

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

                    if (!note[12].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[12].getText().toString()) > 20 || Double.valueOf(note[12].getText().toString()) < 0) {
                            note[12].setTextColor(getResources().getColor(R.color.red));
                            note[12].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                        }
                    }
                    
                    
                }

                if(music_checkbox.isChecked()){

                    if (!note[11].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[11].getText().toString()) > 20 || Double.valueOf(note[11].getText().toString()) < 0) {
                            note[11].setTextColor(getResources().getColor(R.color.red));
                            note[11].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                        }
                    }


                }

                if(art_checkbox.isChecked()){

                    if (!note[10].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[10].getText().toString()) > 20 || Double.valueOf(note[10].getText().toString()) < 0) {
                            note[10].setTextColor(getResources().getColor(R.color.red));
                            note[10].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                        }
                    }


                }

                if(kabyle_checkbox.isChecked()){

                    if (!note[9].getText().toString().isEmpty()) {
                        if (Double.valueOf(note[9].getText().toString()) > 20 || Double.valueOf(note[9].getText().toString()) < 0) {
                            note[9].setTextColor(getResources().getColor(R.color.red));
                            note[9].setBackgroundResource(R.drawable.button_border_red);
                            toast.show();
                            good = false;
                        }
                    }


                }


                String sport_note = "";
                String music_note = "";
                String art_note = "";
                String kabyle_note = "";


                if(!note[12].getText().toString().isEmpty()){
                    sport_note = String.valueOf(note[12].getText());
                }
                if(!note[11].getText().toString().isEmpty()){
                    music_note = String.valueOf(note[11].getText());
                }
                if(!note[10].getText().toString().isEmpty()){
                    art_note = String.valueOf(note[10].getText());
                }
                if(!note[9].getText().toString().isEmpty()){
                    kabyle_note = String.valueOf(note[9].getText());
                }
                
                
                if(good){





                boolean success = true;
                
                



                int[] coefficients = new int[13];
                coefficients[0] = 5;
                coefficients[1] = 4;
                coefficients[2] = 3;
                coefficients[3] = 2;
                coefficients[4] = 2;
                coefficients[5] = 3;
                coefficients[6] = 2;
                coefficients[7] = 1;
                coefficients[8] = 2;
                coefficients[9] = 2;
                coefficients[10] = 1;
                coefficients[11] = 1;
                coefficients[12] = 1;


                if(!kabyle_checkbox.isChecked()){
                    coefficients[9] = 0;
                    note[9].setText("0");
                }

                if(!sport_checkbox.isChecked()){
                    coefficients[12] = 0;
                    note[12].setText("0");
                }

                if(!art_checkbox.isChecked()){
                    coefficients[10] = 0;
                    note[10].setText("0");
                }

                if(!music_checkbox.isChecked()){
                    coefficients[11] = 0;
                    note[11].setText("0");
                }



                for(int i = 0; i < SUBJECTS; i++){

                    if((TextUtils.isEmpty(note[i].getText().toString()))){
                        success = false;
                        alerdialog.show();
                        break;

                    }

                }


                if(success){

                    double bac = calculations.bacAvrg(note, coefficients, SUBJECTS);
                    Log.d("BAC:", String.valueOf(bac));

                    total_avrg.setText(String.valueOf(bac));
                    alerdialog2.show();
                }





                note[9].setText(kabyle_note);
                note[12].setText(sport_note);
                note[10].setText(art_note);
                note[11].setText(music_note);

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