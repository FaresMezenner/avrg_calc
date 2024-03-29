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

public class Gestion_3as extends AppCompatActivity {


    static int ARABIC = 3;
    static int MATH = 5;
    static int ACCOUNTING = 6;
    static int GESTION = 5;
    static int LAW = 2;
    static int ISLAMIA = 2;
    static int HISTORY = 4;
    static int FRENCH = 2;
    static int ENGLISH = 2;
    static int PHILO = 2;
    static int SPORT = 1;
    static int KABYLE = 2;


    boolean saves = true;
    @Override
    public void onBackPressed() {


        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Gestion_3as.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(Gestion_3as.this).inflate(R.layout.save_before, viewGroup, false);
        Button yes=dialogView.findViewById(R.id.yes);
        Button no=dialogView.findViewById(R.id.no);
        alertBuilder.setView(dialogView);
        AlertDialog alerdialog = alertBuilder.create();



        Intent backIntent = new Intent(getApplicationContext(), Branchs.class);
        backIntent.putExtra("year","third");


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
        setContentView(R.layout.gestion_3as);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = findViewById(R.id.ad);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(Gestion_3as.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup2 = findViewById(android.R.id.content);
        View dialogView2 = LayoutInflater.from(Gestion_3as.this).inflate(R.layout.repport_gestion, viewGroup2, false);
        Button buttonOk2 =dialogView2.findViewById(R.id.ok);
        alertBuilder2.setView(dialogView2);
        AlertDialog alerdialog2 = alertBuilder2.create();

        LinearLayout sport_layout2 = dialogView2.findViewById(R.id.sport_layout);
        LinearLayout kabyle_layout2 = dialogView2.findViewById(R.id.kabyle_layout);




        TextView kabyle = findViewById(R.id.kabyle);
        TextView kabyle_coefficient = findViewById(R.id.coefficient_kabyle);
        EditText kabyle_ta9wim = findViewById(R.id.ta9wim_kabyle);
        TextView kabyle_application = findViewById(R.id.application_kabyle);
        EditText kabyle_test1 = findViewById(R.id.test1_kabyle);
        EditText kabyle_test2 = findViewById(R.id.test2_kabyle);
        EditText kabyle_exam = findViewById(R.id.exam_kabyle);
        LinearLayout kabyle_layout = findViewById(R.id.kabyle_layout);
        CheckBox kabyle_checkbox = findViewById(R.id.kabyle_checkbox);


        CheckBox[] checkboxs = new CheckBox[12];
        String[] checkboxs_keys = new String[12];


        EditText[] test2 = new EditText[12];
        EditText[] exam = new EditText[12];
        EditText[] test1 = new EditText[12];
        EditText[] application = new EditText[12];
        EditText[] ta9wim = new EditText[12];




        checkboxs[0] = findViewById(R.id.test2_arabic_checkbox);
        checkboxs[1] = findViewById(R.id.test2_math_checkbox);
        checkboxs[2] = findViewById(R.id.test2_accounting_checkbox);
        checkboxs[3] = findViewById(R.id.test2_gestion_checkbox);
        checkboxs[4] = findViewById(R.id.test2_law_checkbox);
        checkboxs[5] = findViewById(R.id.test2_islamia_checkbox);
        checkboxs[6] = findViewById(R.id.test2_history_checkbox);
        checkboxs[7] = findViewById(R.id.test2_french_checkbox);
        checkboxs[8] = findViewById(R.id.test2_english_checkbox);
        checkboxs[9] = findViewById(R.id.test2_philo_checkbox);
        checkboxs[10] = findViewById(R.id.test2_sport_checkbox);
        checkboxs[11] = findViewById(R.id.test2_kabyle_checkbox);



        checkboxs_keys[0] = "test2_arabic";
        checkboxs_keys[1] = "test2_math";
        checkboxs_keys[2] = "test2_accounting";
        checkboxs_keys[3] = "test2_gestion";
        checkboxs_keys[4] = "test2_law";
        checkboxs_keys[5] = "test2_islamia";
        checkboxs_keys[6] = "test2_history";
        checkboxs_keys[7] = "test2_french";
        checkboxs_keys[8] = "test2_english";
        checkboxs_keys[9] = "test2_philo";
        checkboxs_keys[10] = "test2_sport";
        checkboxs_keys[11] = "test2_kabyle";

        exam[0] = findViewById(R.id.exam_arabic);
        exam[1] = findViewById(R.id.exam_math);
        exam[2] = findViewById(R.id.exam_accounting);
        exam[3] = findViewById(R.id.exam_gestion);
        exam[4] = findViewById(R.id.exam_law);
        exam[5] = findViewById(R.id.exam_islamia);
        exam[6] = findViewById(R.id.exam_history);
        exam[7] = findViewById(R.id.exam_french);
        exam[8] = findViewById(R.id.exam_english);
        exam[9] = findViewById(R.id.exam_philo);
        exam[10] = findViewById(R.id.exam_sport);
        exam[11] = findViewById(R.id.exam_kabyle);



        test2[0] = findViewById(R.id.test2_arabic);
        test2[1] = findViewById(R.id.test2_math);
        test2[2] = findViewById(R.id.test2_accounting);
        test2[3] = findViewById(R.id.test2_gestion);
        test2[4] = findViewById(R.id.test2_law);
        test2[5] = findViewById(R.id.test2_islamia);
        test2[6] = findViewById(R.id.test2_history);
        test2[7] = findViewById(R.id.test2_french);
        test2[8] = findViewById(R.id.test2_english);
        test2[9] = findViewById(R.id.test2_philo);
        test2[10] = findViewById(R.id.test2_sport);
        test2[11] = findViewById(R.id.test2_kabyle);



        test1[0] = findViewById(R.id.test1_arabic);
        test1[1] = findViewById(R.id.test1_math);
        test1[2] = findViewById(R.id.test1_accounting);
        test1[3] = findViewById(R.id.test1_gestion);
        test1[4] = findViewById(R.id.test1_law);
        test1[5] = findViewById(R.id.test1_islamia);
        test1[6] = findViewById(R.id.test1_history);
        test1[7] = findViewById(R.id.test1_french);
        test1[8] = findViewById(R.id.test1_english);
        test1[9] = findViewById(R.id.test1_philo);
        test1[10] = findViewById(R.id.test1_sport);
        test1[11] = findViewById(R.id.test1_kabyle);



        application[0] = findViewById(R.id.application_arabic);
        application[1] = null;
        application[2] = findViewById(R.id.application_accounting);
        application[3] = findViewById(R.id.application_gestion);
        application[4] = findViewById(R.id.application_law);
        application[5] = null;
        application[6] = null;
        application[7] = findViewById(R.id.application_french);
        application[8] = findViewById(R.id.application_english);
        application[9] = null;
        application[10] =null;
        application[11] =null;



        ta9wim[0] = findViewById(R.id.ta9wim_arabic);
        ta9wim[1] = findViewById(R.id.ta9wim_math);
        ta9wim[2] = findViewById(R.id.ta9wim_accounting);
        ta9wim[3] = findViewById(R.id.ta9wim_gestion);
        ta9wim[4] = findViewById(R.id.ta9wim_law);
        ta9wim[5] = findViewById(R.id.ta9wim_islamia);
        ta9wim[6] = findViewById(R.id.ta9wim_history);
        ta9wim[7] = findViewById(R.id.ta9wim_french);
        ta9wim[8] = findViewById(R.id.ta9wim_english);
        ta9wim[9] = findViewById(R.id.ta9wim_philo);
        ta9wim[10] = findViewById(R.id.ta9wim_sport);
        ta9wim[11] = findViewById(R.id.ta9wim_kabyle);




        TextView sport = findViewById(R.id.sport);
        TextView sport_coefficient = findViewById(R.id.coefficient_sport);
        EditText sport_ta9wim = findViewById(R.id.ta9wim_sport);
        TextView sport_application = findViewById(R.id.application_sport);
        EditText sport_test1 = findViewById(R.id.test1_sport);
        EditText sport_test2 = findViewById(R.id.test2_sport);
        EditText sport_exam = findViewById(R.id.exam_sport);
        LinearLayout sport_layout = findViewById(R.id.sport_layout);
        CheckBox sport_checkbox = findViewById(R.id.sport_checkbox);

        SharedPreferences prefs = getSharedPreferences("gestion_3as", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();



        EditText[] lasts = new EditText[2];
        lasts[0] = findViewById(R.id.projects);
        lasts[1] = findViewById(R.id.readind);

        int Subjects = 12;


        Toast toast = Toast.makeText(getApplicationContext(), "يرجى ادخال علامة بين 0 و 20", Toast.LENGTH_LONG);


        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                for(int i = 0; i<Subjects; i++){
                    int finalI = i;
                    String key1 = "exam" + i;
                    exam[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {

                            if (!hasFocus && !exam[finalI].getText().toString().isEmpty() && !exam[finalI].getText().toString().equals(".")) {
                                if (Double.valueOf(exam[finalI].getText().toString()) > 20 || Double.valueOf(exam[finalI].getText().toString()) < 0) {
                                    exam[finalI].setTextColor(getResources().getColor(R.color.red));
                                    exam[finalI].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();
                                } else {

                                    editor.putString(key1, exam[finalI].getText().toString());

                                }
                            } else if (hasFocus) {
                                toast.cancel();
                                exam[finalI].setTextColor(getResources().getColor(R.color.blue));
                                exam[finalI].setBackgroundResource(R.drawable.button_border);
                            } else if (!hasFocus && exam[finalI].getText().toString().isEmpty()) {

                                toast.cancel();
                                exam[finalI].setTextColor(getResources().getColor(R.color.blue));
                                exam[finalI].setBackgroundResource(R.drawable.button_border);
                                editor.putString(key1, "");


                            }

                        }
                    });

                    String key2 = "test2" + i;
                    test2[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {

                            if (!hasFocus && !test2[finalI].getText().toString().isEmpty() && !test2[finalI].getText().toString().equals(".")) {
                                if (Double.valueOf(test2[finalI].getText().toString()) > 20 || Double.valueOf(test2[finalI].getText().toString()) < 0) {
                                    test2[finalI].setTextColor(getResources().getColor(R.color.red));
                                    test2[finalI].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();

                                } else {

                                    editor.putString(key2, test2[finalI].getText().toString());

                                }
                            } else if (hasFocus) {
                                toast.cancel();
                                test2[finalI].setTextColor(getResources().getColor(R.color.blue));
                                test2[finalI].setBackgroundResource(R.drawable.button_border);
                            } else if (!hasFocus && test2[finalI].getText().toString().isEmpty()) {

                                toast.cancel();
                                test2[finalI].setTextColor(getResources().getColor(R.color.blue));
                                test2[finalI].setBackgroundResource(R.drawable.button_border);

                                editor.putString(key2, "");


                            }

                        }
                    });

                    String key3 = "test1" + i;
                    test1[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {

                            if (!hasFocus && !test1[finalI].getText().toString().isEmpty() && !test1[finalI].getText().toString().equals(".")) {
                                if (Double.valueOf(test1[finalI].getText().toString()) > 20 || Double.valueOf(test1[finalI].getText().toString()) < 0) {
                                    test1[finalI].setTextColor(getResources().getColor(R.color.red));
                                    test1[finalI].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();

                                } else {

                                    editor.putString(key3, test1[finalI].getText().toString());

                                }
                            } else if (hasFocus) {
                                toast.cancel();
                                test1[finalI].setTextColor(getResources().getColor(R.color.blue));
                                test1[finalI].setBackgroundResource(R.drawable.button_border);
                            } else if (!hasFocus && test1[finalI].getText().toString().isEmpty()) {

                                toast.cancel();
                                test1[finalI].setTextColor(getResources().getColor(R.color.blue));
                                test1[finalI].setBackgroundResource(R.drawable.button_border);
                                editor.putString(key3, "");


                            }

                        }
                    });


                    String key4 = "application" + i;
                    if(application[i] != null){

                        application[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {

                                if (!hasFocus && !application[finalI].getText().toString().isEmpty() && !application[finalI].getText().toString().equals(".")) {
                                    if (Double.valueOf(application[finalI].getText().toString()) > 20 || Double.valueOf(application[finalI].getText().toString()) < 0) {
                                        application[finalI].setTextColor(getResources().getColor(R.color.red));
                                        application[finalI].setBackgroundResource(R.drawable.button_border_red);
                                        toast.show();

                                    } else {

                                        editor.putString(key4, application[finalI].getText().toString());

                                    }
                                } else if (hasFocus) {
                                    toast.cancel();
                                    application[finalI].setTextColor(getResources().getColor(R.color.blue));
                                    application[finalI].setBackgroundResource(R.drawable.button_border);
                                } else if (!hasFocus && application[finalI].getText().toString().isEmpty()) {

                                    toast.cancel();
                                    application[finalI].setTextColor(getResources().getColor(R.color.blue));
                                    application[finalI].setBackgroundResource(R.drawable.button_border);
                                    editor.putString(key4, "");


                                }

                            }
                        });

                    }

                    String key5 = "ta9wim" + i;
                    ta9wim[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {

                            if (!hasFocus && !ta9wim[finalI].getText().toString().isEmpty() && !ta9wim[finalI].getText().toString().equals(".")) {
                                if (Double.valueOf(ta9wim[finalI].getText().toString()) > 20 || Double.valueOf(ta9wim[finalI].getText().toString()) < 0) {
                                    ta9wim[finalI].setTextColor(getResources().getColor(R.color.red));
                                    ta9wim[finalI].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();

                                } else {

                                    editor.putString(key5, ta9wim[finalI].getText().toString());

                                }
                            } else if (hasFocus) {
                                toast.cancel();
                                ta9wim[finalI].setTextColor(getResources().getColor(R.color.blue));
                                ta9wim[finalI].setBackgroundResource(R.drawable.button_border);
                            } else if (!hasFocus && ta9wim[finalI].getText().toString().isEmpty()) {

                                toast.cancel();
                                ta9wim[finalI].setTextColor(getResources().getColor(R.color.blue));
                                ta9wim[finalI].setBackgroundResource(R.drawable.button_border);
                                editor.putString(key5, "");


                            }

                        }
                    });



                }

                lasts[0].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {

                        if (!hasFocus && !lasts[0].getText().toString().isEmpty() && !lasts[0].getText().toString().equals(".")) {
                            if (Double.valueOf(lasts[0].getText().toString()) > 20 || Double.valueOf(lasts[0].getText().toString()) < 0) {
                                lasts[0].setTextColor(getResources().getColor(R.color.red));
                                lasts[0].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();

                            } else {

                                editor.putString("lasts0", lasts[0].getText().toString());

                            }
                        } else if (hasFocus) {
                            toast.cancel();
                            lasts[0].setTextColor(getResources().getColor(R.color.blue));
                            lasts[0].setBackgroundResource(R.drawable.button_border);
                        } else if (!hasFocus && lasts[0].getText().toString().isEmpty()) {

                            toast.cancel();
                            lasts[0].setTextColor(getResources().getColor(R.color.blue));
                            lasts[0].setBackgroundResource(R.drawable.button_border);
                            editor.putString("lasts0", "");


                        }

                    }
                });
                lasts[1].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {

                        if (!hasFocus && !lasts[1].getText().toString().isEmpty() && !lasts[1].getText().toString().equals(".")) {
                            if (Double.valueOf(lasts[1].getText().toString()) > 20 || Double.valueOf(lasts[1].getText().toString()) < 0) {
                                lasts[1].setTextColor(getResources().getColor(R.color.red));
                                lasts[1].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();

                            } else {

                                editor.putString("lasts1", lasts[1].getText().toString());

                            }
                        } else if (hasFocus) {
                            toast.cancel();
                            lasts[1].setTextColor(getResources().getColor(R.color.blue));
                            lasts[1].setBackgroundResource(R.drawable.button_border);
                        } else if (!hasFocus && lasts[1].getText().toString().isEmpty()) {

                            toast.cancel();
                            lasts[1].setTextColor(getResources().getColor(R.color.blue));
                            lasts[1].setBackgroundResource(R.drawable.button_border);
                            editor.putString("lasts1", "");


                        }

                    }
                });

                saves = false;

            }
        };

        {


            {
                exam[0].setOnFocusChangeListener(onFocusChangeListener);
                exam[1].setOnFocusChangeListener(onFocusChangeListener);
                exam[2].setOnFocusChangeListener(onFocusChangeListener);
                exam[3].setOnFocusChangeListener(onFocusChangeListener);
                exam[4].setOnFocusChangeListener(onFocusChangeListener);
                exam[5].setOnFocusChangeListener(onFocusChangeListener);
                exam[6].setOnFocusChangeListener(onFocusChangeListener);
                exam[7].setOnFocusChangeListener(onFocusChangeListener);
                exam[8].setOnFocusChangeListener(onFocusChangeListener);
                exam[9].setOnFocusChangeListener(onFocusChangeListener);
                exam[10].setOnFocusChangeListener(onFocusChangeListener);
                exam[11].setOnFocusChangeListener(onFocusChangeListener);
            }
            {
                test2[0].setOnFocusChangeListener(onFocusChangeListener);
                test2[1].setOnFocusChangeListener(onFocusChangeListener);
                test2[2].setOnFocusChangeListener(onFocusChangeListener);
                test2[3].setOnFocusChangeListener(onFocusChangeListener);
                test2[4].setOnFocusChangeListener(onFocusChangeListener);
                test2[5].setOnFocusChangeListener(onFocusChangeListener);
                test2[6].setOnFocusChangeListener(onFocusChangeListener);
                test2[7].setOnFocusChangeListener(onFocusChangeListener);
                test2[8].setOnFocusChangeListener(onFocusChangeListener);
                test2[9].setOnFocusChangeListener(onFocusChangeListener);
                test2[10].setOnFocusChangeListener(onFocusChangeListener);
                test2[11].setOnFocusChangeListener(onFocusChangeListener);
            }
            {
                test1[0].setOnFocusChangeListener(onFocusChangeListener);
                test1[1].setOnFocusChangeListener(onFocusChangeListener);
                test1[2].setOnFocusChangeListener(onFocusChangeListener);
                test1[3].setOnFocusChangeListener(onFocusChangeListener);
                test1[4].setOnFocusChangeListener(onFocusChangeListener);
                test1[5].setOnFocusChangeListener(onFocusChangeListener);
                test1[6].setOnFocusChangeListener(onFocusChangeListener);
                test1[7].setOnFocusChangeListener(onFocusChangeListener);
                test1[8].setOnFocusChangeListener(onFocusChangeListener);
                test1[9].setOnFocusChangeListener(onFocusChangeListener);
                test1[10].setOnFocusChangeListener(onFocusChangeListener);
                test1[11].setOnFocusChangeListener(onFocusChangeListener);
            }
            {
                application[0].setOnFocusChangeListener(onFocusChangeListener);
                application[2].setOnFocusChangeListener(onFocusChangeListener);
                application[3].setOnFocusChangeListener(onFocusChangeListener);
                application[4].setOnFocusChangeListener(onFocusChangeListener);
                application[7].setOnFocusChangeListener(onFocusChangeListener);
                application[8].setOnFocusChangeListener(onFocusChangeListener);
            }
            {
                ta9wim[0].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[1].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[2].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[3].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[4].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[5].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[6].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[7].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[8].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[9].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[10].setOnFocusChangeListener(onFocusChangeListener);
                ta9wim[11].setOnFocusChangeListener(onFocusChangeListener);
            }

            lasts[0].setOnFocusChangeListener(onFocusChangeListener);
            lasts[1].setOnFocusChangeListener(onFocusChangeListener);



        }

        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0; i<Subjects; i++){
                    exam[i].requestFocus();
                    if(checkboxs[i].isChecked()){
                        test2[i].requestFocus();
                    }
                    test1[i].requestFocus();
                    if(application[i] != null){
                        application[i].requestFocus();
                    }
                    ta9wim[i].requestFocus();


                }

                lasts[0].requestFocus();
                lasts[1].requestFocus();
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

                for(int i =0; i<Subjects; i++){
                    exam[i].setText("");

                    if(checkboxs[i].isChecked()){

                        test2[i].setText("");
                    }
                    test1[i].setText("");
                    if(application[i] != null){
                        application[i].setText("");
                    }
                    ta9wim[i].setText("");

                }

                lasts[0].setText("");
                lasts[1].setText("");

                saves = false;
            }
        });




        if(prefs.getBoolean("kabyle", false)){
            kabyle.setVisibility(View.VISIBLE);
            kabyle_coefficient.setVisibility(View.VISIBLE);
            kabyle_ta9wim.setVisibility(View.VISIBLE);
            kabyle_application.setVisibility(View.VISIBLE);
            kabyle_test1.setVisibility(View.VISIBLE);
            kabyle_layout.setVisibility(View.VISIBLE);
            kabyle_layout2.setVisibility(View.VISIBLE);
            kabyle_exam.setVisibility(View.VISIBLE);
            kabyle_checkbox.setChecked(true);
        } else {
            kabyle.setVisibility(View.GONE);
            kabyle_coefficient.setVisibility(View.GONE);
            kabyle_ta9wim.setVisibility(View.GONE);
            kabyle_application.setVisibility(View.GONE);
            kabyle_test1.setVisibility(View.GONE);
            kabyle_exam.setVisibility(View.GONE);
            kabyle_layout.setVisibility(View.GONE);
            kabyle_layout2.setVisibility(View.GONE);
            kabyle_checkbox.setChecked(false);
        }



        if(prefs.getBoolean("sport", true)){
            sport.setVisibility(View.VISIBLE);
            sport_coefficient.setVisibility(View.VISIBLE);
            sport_ta9wim.setVisibility(View.VISIBLE);
            sport_application.setVisibility(View.VISIBLE);
            sport_test1.setVisibility(View.VISIBLE);
            sport_exam.setVisibility(View.VISIBLE);
            sport_layout.setVisibility(View.VISIBLE);
            sport_layout2.setVisibility(View.VISIBLE);
            sport_checkbox.setChecked(true);
        } else {
            sport.setVisibility(View.GONE);
            sport_coefficient.setVisibility(View.GONE);
            sport_ta9wim.setVisibility(View.GONE);
            sport_application.setVisibility(View.GONE);
            sport_test1.setVisibility(View.GONE);
            sport_exam.setVisibility(View.GONE);
            sport_layout.setVisibility(View.GONE);
            sport_layout2.setVisibility(View.GONE);
            sport_checkbox.setChecked(false);
        }

        for(int i = 0; i<checkboxs.length; i++){
            if(!prefs.getBoolean(checkboxs_keys[i], false)){
                blockInput(test2[i], editor, checkboxs_keys[i]);
                checkboxs[i].setChecked(false);
            } else {
                allowInput(prefs, i,test2[i], editor, checkboxs_keys[i]);
                checkboxs[i].setChecked(true);

            }

        }






        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().clearFocus();
                onBackPressed();
            }
        });

        kabyle_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean("kabyle", true);
                    kabyle.setVisibility(View.VISIBLE);
                    kabyle_coefficient.setVisibility(View.VISIBLE);
                    kabyle_ta9wim.setVisibility(View.VISIBLE);
                    kabyle_application.setVisibility(View.VISIBLE);
                    kabyle_test1.setVisibility(View.VISIBLE);
                    kabyle_exam.setVisibility(View.VISIBLE);
                    kabyle_layout.setVisibility(View.VISIBLE);
                    kabyle_layout2.setVisibility(View.VISIBLE);
                    kabyle_checkbox.setChecked(true);
                } else {

                    editor.putBoolean("kabyle", false);
                    kabyle.setVisibility(View.GONE);
                    kabyle_coefficient.setVisibility(View.GONE);
                    kabyle_ta9wim.setVisibility(View.GONE);
                    kabyle_application.setVisibility(View.GONE);
                    kabyle_test1.setVisibility(View.GONE);
                    kabyle_exam.setVisibility(View.GONE);
                    kabyle_layout.setVisibility(View.GONE);
                    kabyle_layout2.setVisibility(View.GONE);
                    kabyle_checkbox.setChecked(false);
                }

                editor.apply();
            }
        });



        sport_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    editor.putBoolean("sport", true);
                    sport.setVisibility(View.VISIBLE);
                    sport_coefficient.setVisibility(View.VISIBLE);
                    sport_ta9wim.setVisibility(View.VISIBLE);
                    sport_application.setVisibility(View.VISIBLE);
                    sport_test1.setVisibility(View.VISIBLE);
                    sport_exam.setVisibility(View.VISIBLE);

                    sport_layout.setVisibility(View.VISIBLE);
                    sport_layout2.setVisibility(View.VISIBLE);
                    sport_checkbox.setChecked(true);
                } else {

                    editor.putBoolean("sport", false);
                    sport.setVisibility(View.GONE);
                    sport_coefficient.setVisibility(View.GONE);
                    sport_ta9wim.setVisibility(View.GONE);
                    sport_application.setVisibility(View.GONE);
                    sport_test1.setVisibility(View.GONE);
                    sport_exam.setVisibility(View.GONE);
                    sport_layout.setVisibility(View.GONE);
                    sport_layout2.setVisibility(View.GONE);
                    sport_checkbox.setChecked(false);
                }

                editor.apply();
            }
        });





        checkboxs[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    blockInput(test2[0], editor, checkboxs_keys[0]);
                } else {
                    allowInput(prefs, 0,test2[0], editor, checkboxs_keys[0]);
                }
            }
        });

        checkboxs[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[1], editor, checkboxs_keys[1]);
                } else {
                    allowInput(prefs, 1,test2[1], editor, checkboxs_keys[1]);
                }
            }
        });

        checkboxs[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[2], editor, checkboxs_keys[2]);
                } else {
                    allowInput(prefs, 2,test2[2], editor, checkboxs_keys[2]);
                }
            }
        });

        checkboxs[3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[3], editor, checkboxs_keys[3]);
                } else {
                    allowInput(prefs, 3,test2[3], editor, checkboxs_keys[3]);
                }
            }
        });

        checkboxs[4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[4], editor, checkboxs_keys[4]);
                } else {
                    allowInput(prefs, 4,test2[4], editor, checkboxs_keys[4]);
                }
            }
        });

        checkboxs[5].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[5], editor, checkboxs_keys[5]);
                } else {
                    allowInput(prefs, 5,test2[5], editor, checkboxs_keys[5]);
                }
            }
        });

        checkboxs[6].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[6], editor, checkboxs_keys[6]);
                } else {
                    allowInput(prefs, 6,test2[6], editor, checkboxs_keys[6]);
                }
            }
        });

        checkboxs[7].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[7], editor, checkboxs_keys[7]);
                } else {
                    allowInput(prefs, 7,test2[7], editor, checkboxs_keys[7]);
                }
            }
        });

        checkboxs[8].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[8], editor, checkboxs_keys[8]);
                } else {
                    allowInput(prefs, 8,test2[8], editor, checkboxs_keys[8]);
                }
            }
        });


        checkboxs[9].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[9], editor, checkboxs_keys[9]);
                } else {
                    allowInput(prefs, 9,test2[9], editor, checkboxs_keys[9]);
                }
            }
        });


        checkboxs[10].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[10], editor, checkboxs_keys[10]);
                } else {
                    allowInput(prefs, 10,test2[10], editor, checkboxs_keys[10]);
                }
            }
        });


        checkboxs[11].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    blockInput(test2[11], editor, checkboxs_keys[11]);
                } else {
                    allowInput(prefs, 11,test2[11], editor, checkboxs_keys[11]);
                }
            }
        });







        TextView[] avrgs_show = new TextView[12];
        avrgs_show[0] = dialogView2.findViewById(R.id.arabic_avrg);
        avrgs_show[1] = dialogView2.findViewById(R.id.math_avrg);
        avrgs_show[2] = dialogView2.findViewById(R.id.accounting_avrg);
        avrgs_show[3] = dialogView2.findViewById(R.id.gestion_avrg);
        avrgs_show[4] = dialogView2.findViewById(R.id.law_avrg);
        avrgs_show[5] = dialogView2.findViewById(R.id.islamia_avrg);
        avrgs_show[6] = dialogView2.findViewById(R.id.history_avrg);
        avrgs_show[7] = dialogView2.findViewById(R.id.french_avrg);
        avrgs_show[8] = dialogView2.findViewById(R.id.english_avrg);
        avrgs_show[9] = dialogView2.findViewById(R.id.philo_avrg);
        avrgs_show[10] = dialogView2.findViewById(R.id.sport_avrg);
        avrgs_show[11] = dialogView2.findViewById(R.id.kabyle_avrg);

        TextView total_avrg = dialogView2.findViewById(R.id.total_avrg);





        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Gestion_3as.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(Gestion_3as.this).inflate(R.layout.fill_all, viewGroup, false);
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

                {


                for (int i = 0; i < Subjects - 2; i++) {
                    int finalI = i;


                        if (!exam[finalI].getText().toString().isEmpty() && !exam[finalI].getText().toString().equals(".")) {
                            if (Double.valueOf(exam[finalI].getText().toString()) > 20 || Double.valueOf(exam[finalI].getText().toString()) < 0) {
                                exam[finalI].setTextColor(getResources().getColor(R.color.red));
                                exam[finalI].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;
                                break;
                            }
                        }


                        if(checkboxs[i].isChecked()){


                            if (!test2[finalI].getText().toString().isEmpty() && !test2[finalI].getText().toString().equals(".")) {
                                if (Double.valueOf(test2[finalI].getText().toString()) > 20 || Double.valueOf(test2[finalI].getText().toString()) < 0) {
                                    test2[finalI].setTextColor(getResources().getColor(R.color.red));
                                    test2[finalI].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();
                                    good = false;
                                    break;

                                }
                            }



                        }

                        if (!test1[finalI].getText().toString().isEmpty() && !test1[finalI].getText().toString().equals(".")) {
                            if (Double.valueOf(test1[finalI].getText().toString()) > 20 || Double.valueOf(test1[finalI].getText().toString()) < 0) {
                                test1[finalI].setTextColor(getResources().getColor(R.color.red));
                                test1[finalI].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();

                                good = false;
                                break;
                            }
                        }

                        if (application[i] != null) {

                            if (!application[finalI].getText().toString().isEmpty() && !application[finalI].getText().toString().equals(".")) {
                                if (Double.valueOf(application[finalI].getText().toString()) > 20 || Double.valueOf(application[finalI].getText().toString()) < 0) {
                                    application[finalI].setTextColor(getResources().getColor(R.color.red));
                                    application[finalI].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();

                                    good = false;
                                    break;
                                }
                            }

                        }

                        if (!ta9wim[finalI].getText().toString().isEmpty() && !ta9wim[finalI].getText().toString().equals(".")) {
                            if (Double.valueOf(ta9wim[finalI].getText().toString()) > 20 || Double.valueOf(ta9wim[finalI].getText().toString()) < 0) {
                                ta9wim[finalI].setTextColor(getResources().getColor(R.color.red));
                                ta9wim[finalI].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;
                                break;

                            }
                        }











                }


                    if(sport_checkbox.isChecked()){

                        if (!exam[Subjects - 2].getText().toString().isEmpty() && !exam[Subjects - 2].getText().toString().equals(".")) {
                            if (Double.valueOf(exam[Subjects - 2].getText().toString()) > 20 || Double.valueOf(exam[Subjects - 2].getText().toString()) < 0) {
                                exam[Subjects - 2].setTextColor(getResources().getColor(R.color.red));
                                exam[Subjects - 2].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;
                            }
                        }


                        if(checkboxs[Subjects - 2].isChecked()){


                            if (!test2[Subjects - 2].getText().toString().isEmpty() && !test2[Subjects - 2].getText().toString().equals(".")) {
                                if (Double.valueOf(test2[Subjects - 2].getText().toString()) > 20 || Double.valueOf(test2[Subjects - 2].getText().toString()) < 0) {
                                    test2[Subjects - 2].setTextColor(getResources().getColor(R.color.red));
                                    test2[Subjects - 2].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();
                                    good = false;

                                }
                            }



                        }

                        if (!test1[Subjects - 2].getText().toString().isEmpty() && !test1[Subjects - 2].getText().toString().equals(".")) {
                            if (Double.valueOf(test1[Subjects - 2].getText().toString()) > 20 || Double.valueOf(test1[Subjects - 2].getText().toString()) < 0) {
                                test1[Subjects - 2].setTextColor(getResources().getColor(R.color.red));
                                test1[Subjects - 2].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();

                                good = false;
                            }
                        }

                        if (application[Subjects - 2] != null) {

                            if (!application[Subjects - 2].getText().toString().isEmpty() && !application[Subjects - 2].getText().toString().equals(".")) {
                                if (Double.valueOf(application[Subjects - 2].getText().toString()) > 20 || Double.valueOf(application[Subjects - 2].getText().toString()) < 0) {
                                    application[Subjects - 2].setTextColor(getResources().getColor(R.color.red));
                                    application[Subjects - 2].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();

                                    good = false;
                                }
                            }

                        }

                        if (!ta9wim[Subjects - 2].getText().toString().isEmpty() && !ta9wim[Subjects - 2].getText().toString().equals(".")) {
                            if (Double.valueOf(ta9wim[Subjects - 2].getText().toString()) > 20 || Double.valueOf(ta9wim[Subjects - 2].getText().toString()) < 0) {
                                ta9wim[Subjects - 2].setTextColor(getResources().getColor(R.color.red));
                                ta9wim[Subjects - 2].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;

                            }
                        }


                    }



                    if(kabyle_checkbox.isChecked()){

                        if (!exam[Subjects - 1].getText().toString().isEmpty() && !exam[Subjects - 1].getText().toString().equals(".")) {
                            if (Double.valueOf(exam[Subjects - 1].getText().toString()) > 20 || Double.valueOf(exam[Subjects - 1].getText().toString()) < 0) {
                                exam[Subjects - 1].setTextColor(getResources().getColor(R.color.red));
                                exam[Subjects - 1].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;
                            }
                        }


                        if(checkboxs[Subjects - 1].isChecked()){


                            if (!test2[Subjects - 1].getText().toString().isEmpty() && !test2[Subjects - 1].getText().toString().equals(".")) {
                                if (Double.valueOf(test2[Subjects - 1].getText().toString()) > 20 || Double.valueOf(test2[Subjects - 1].getText().toString()) < 0) {
                                    test2[Subjects - 1].setTextColor(getResources().getColor(R.color.red));
                                    test2[Subjects - 1].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();
                                    good = false;

                                }
                            }



                        }

                        if (!test1[Subjects - 1].getText().toString().isEmpty() && !test1[Subjects - 1].getText().toString().equals(".")) {
                            if (Double.valueOf(test1[Subjects - 1].getText().toString()) > 20 || Double.valueOf(test1[Subjects - 1].getText().toString()) < 0) {
                                test1[Subjects - 1].setTextColor(getResources().getColor(R.color.red));
                                test1[Subjects - 1].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();

                                good = false;
                            }
                        }

                        if (application[Subjects - 1] != null) {

                            if (!application[Subjects - 1].getText().toString().isEmpty() && !application[Subjects - 1].getText().toString().equals(".")) {
                                if (Double.valueOf(application[Subjects - 1].getText().toString()) > 20 || Double.valueOf(application[Subjects - 1].getText().toString()) < 0) {
                                    application[Subjects - 1].setTextColor(getResources().getColor(R.color.red));
                                    application[Subjects - 1].setBackgroundResource(R.drawable.button_border_red);
                                    toast.show();

                                    good = false;
                                }
                            }

                        }

                        if (!ta9wim[Subjects - 1].getText().toString().isEmpty() && !ta9wim[Subjects - 1].getText().toString().equals(".")) {
                            if (Double.valueOf(ta9wim[Subjects - 1].getText().toString()) > 20 || Double.valueOf(ta9wim[Subjects - 1].getText().toString()) < 0) {
                                ta9wim[Subjects - 1].setTextColor(getResources().getColor(R.color.red));
                                ta9wim[Subjects - 1].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;

                            }
                        }

                    }



                    if (!lasts[0].getText().toString().isEmpty() && !lasts[0].getText().toString().equals(".")) {
                            if (Double.valueOf(lasts[0].getText().toString()) > 20 || Double.valueOf(lasts[0].getText().toString()) < 0) {
                                lasts[0].setTextColor(getResources().getColor(R.color.red));
                                lasts[0].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;

                            }
                        }


                        if (!lasts[1].getText().toString().isEmpty() && !lasts[1].getText().toString().equals(".")) {
                            if (Double.valueOf(lasts[1].getText().toString()) > 20 || Double.valueOf(lasts[1].getText().toString()) < 0) {
                                lasts[1].setTextColor(getResources().getColor(R.color.red));
                                lasts[1].setBackgroundResource(R.drawable.button_border_red);
                                toast.show();
                                good = false;

                            }
                        }
            }

                String ta9wim_kabyle = "";
                String test1_kabyle= "";
                String test2_kabyle= "";
                String exam_kabyle= "";


                    if(!exam[Subjects - 1].getText().toString().isEmpty() && !exam[Subjects - 1].getText().toString().equals(".")){
                        exam_kabyle = String.valueOf(exam[Subjects - 1].getText());
                    }
                    if(!test1[Subjects - 1].getText().toString().isEmpty() && !test1[Subjects - 1].getText().toString().equals(".")){
                        test1_kabyle = String.valueOf(test1[Subjects - 1].getText());
                    }
                    if(!test2[Subjects - 1].getText().toString().isEmpty() && !test2[Subjects - 1].getText().toString().equals(".")){
                        test2_kabyle= String.valueOf(test2[Subjects - 1].getText());
                    }
                    if(!ta9wim[Subjects - 1].getText().toString().isEmpty() && !ta9wim[Subjects - 1].getText().toString().equals(".")){
                        ta9wim_kabyle = String.valueOf(ta9wim[Subjects - 1].getText());
                    }






                String ta9wim_sport= "";
                String test1_sport= "";
                String test2_sport= "";
                String exam_sport= "";


                    if (!exam[Subjects - 2].getText().toString().isEmpty() && !exam[Subjects - 2].getText().toString().equals(".")) {
                        exam_sport = String.valueOf(exam[Subjects - 2].getText());
                    }
                    if (!test1[Subjects - 2].getText().toString().isEmpty() && !test1[Subjects - 2].getText().toString().equals(".")) {
                        test1_sport = String.valueOf(test1[Subjects - 2].getText());
                    }
                    if (!test2[Subjects - 2].getText().toString().isEmpty() && !test2[Subjects - 2].getText().toString().equals(".")) {
                        test2_sport = String.valueOf(test2[Subjects - 2].getText());
                    }
                    if (!ta9wim[Subjects - 2].getText().toString().isEmpty() && !ta9wim[Subjects - 2].getText().toString().equals(".")) {
                        ta9wim_sport = String.valueOf(ta9wim[Subjects - 2].getText());
                    }


                getWindow().getDecorView().clearFocus();




                if(good) {

                    int SUBJECTS = 12;

                    boolean success = true;


                    double[] avrgs = new double[SUBJECTS];
                    int[] coefficients = new int[12];
                    coefficients[0] = 3;
                    coefficients[1] = 5;
                    coefficients[2] = 6;
                    coefficients[3] = 5;
                    coefficients[4] = 2;
                    coefficients[5] = 2;
                    coefficients[6] = 4;
                    coefficients[7] = 2;
                    coefficients[8] = 2;
                    coefficients[9] = 2;
                    coefficients[10] = 1;
                    coefficients[11] = 2;


                    if (!kabyle_checkbox.isChecked()) {
                        coefficients[11] = 0;
                        ta9wim[11].setText("0");
                        test1[11].setText("0");
                        test2[11].setText("0");
                        exam[11].setText("0");
                        kabyle_layout2.setVisibility(View.GONE);
                    }

                    if (!sport_checkbox.isChecked()) {
                        coefficients[10] = 0;
                        ta9wim[10].setText("0");
                        test1[10].setText("0");
                        test2[10].setText("0");
                        exam[10].setText("0");
                        sport_layout2.setVisibility(View.GONE);
                    }


                    EditText[][] notes = new EditText[SUBJECTS][5];

                    for (int i = 0; i < SUBJECTS; i++) {

                        int devider = 5;

                        if (!TextUtils.isEmpty(ta9wim[i].getText().toString()) && !ta9wim[i].getText().toString().equals(".")) {

                            notes[i][0] = ta9wim[i];

                        } else {
                            alerdialog.show();

                            SUBJECTS = 12;

                            success = false;
                            break;


                        }


                        if (!(application[i] == null)) {


                            if (!TextUtils.isEmpty(application[i].getText().toString()) && !application[i].getText().toString().equals(".")) {

                                notes[i][1] = application[i];

                            } else {
                                Log.d("d", "d");
                                alerdialog.show();
                                SUBJECTS = 12;
                                success = false;
                                break;

                            }


                        } else {
                            notes[i][1] = application[i];
                            devider = devider - 1;

                        }


                        if (!TextUtils.isEmpty(test1[i].getText().toString()) && !test1[i].getText().toString().equals(".")) {

                            notes[i][2] = test1[i];

                        } else {
                            alerdialog.show();
                            SUBJECTS = 12;
                            success = false;
                            break;

                        }


                        if (checkboxs[i].isChecked()) {


                            if (!TextUtils.isEmpty(test2[i].getText().toString()) && !test2[i].getText().toString().equals(".")) {

                                notes[i][3] = test2[i];

                            } else {
                                alerdialog.show();
                                SUBJECTS = 12;
                                success = false;
                                break;

                            }


                        } else {

                            notes[i][3] = null;
                        }


                        if (!TextUtils.isEmpty(exam[i].getText().toString()) && !exam[i].getText().toString().equals(".")) {

                            notes[i][4] = exam[i];

                        } else {
                            alerdialog.show();
                            SUBJECTS = 12;
                            success = false;
                            break;

                        }


                        avrgs[i] = calculations.subjectNote(notes[i], devider);

                        Log.d("avrgs:", String.valueOf(avrgs[i]));


                        avrgs_show[i].setText(String.valueOf(avrgs[i]));


                    }


                    double reading_note = 0;
                    EditText reading = findViewById(R.id.readind);
                    if (!TextUtils.isEmpty(reading.getText().toString()) && !reading.getText().toString().equals(".")) {

                        reading_note = Double.valueOf(String.valueOf(reading.getText()));

                    } else {
                        alerdialog.show();
                        SUBJECTS = 12;
                        success = false;

                    }

                    double projects_note = 0;
                    EditText projects = findViewById(R.id.projects);
                    if (!TextUtils.isEmpty(projects.getText().toString()) && !projects.getText().toString().equals(".")) {

                        projects_note = Double.valueOf(String.valueOf(projects.getText()));

                    } else {
                        alerdialog.show();
                        SUBJECTS = 12;
                        success = false;
                    }


                    if (success) {
                        double final_avrg = calculations.completeNote(avrgs, coefficients, SUBJECTS, reading_note, projects_note);


                        Log.d("final:", String.valueOf(final_avrg));


                        total_avrg.setText(String.valueOf(final_avrg));

                        alerdialog2.show();


                    }


                    SUBJECTS = 12;

                    ta9wim[Subjects - 1].setText(ta9wim_kabyle);
                    test1[Subjects - 1].setText(test1_kabyle);
                    if (checkboxs[Subjects - 1].isChecked()) {

                        test2[Subjects - 1].setText(test2_kabyle);

                    } else {

                        test2[Subjects - 1].setText("-/-");
                    }
                    exam[Subjects - 1].setText(exam_kabyle);


                    ta9wim[Subjects - 2].setText(ta9wim_sport);
                    test1[Subjects - 2].setText(test1_sport);
                    if (checkboxs[Subjects - 2].isChecked()) {

                        test2[Subjects - 2].setText(test2_sport);

                    } else {

                        test2[Subjects - 2].setText("-/-");
                    }
                    exam[Subjects - 2].setText(exam_sport);
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



        for(int i = 0; i<Subjects; i++){

            String key = "exam" + i;

            exam[i].setText(prefs.getString(key, ""));





            if(checkboxs[i].isChecked()){

                String key2 = "test2" + i;
                test2[i].setText(prefs.getString(key2, ""));
                Log.d("note:" , key);
            } else {

                test2[i].setText("-/-");
            }



            String key3 = "test1" + i;
            test1[i].setText(prefs.getString(key3, ""));


            String key4 = "application" + i;
            if(application[i] != null){
                application[i].setText(prefs.getString(key4, ""));

            }



            String key5 = "ta9wim" + i;
            ta9wim[i].setText(prefs.getString(key5, ""));

        }
        lasts[0].setText(prefs.getString("lasts0", ""));
        lasts[1].setText(prefs.getString("lasts1", ""));


    }


    void blockInput(EditText editText, SharedPreferences.Editor editor, String checkbox_key){
        editText.setFocusable(false);
        editText.setClickable(false);
        editText.setTextColor(getResources().getColor(R.color.blue));

        editText.setBackground(getDrawable(R.drawable.button_filled2));
        editText.setText("-/-");
        editor.putBoolean(checkbox_key, false);
        editor.apply();


    }



    void allowInput(SharedPreferences prefs, int num, EditText editText, SharedPreferences.Editor editor, String checkbox_key){
        SharedPreferences prefs1 = getSharedPreferences("gestion_3as", MODE_PRIVATE);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setClickable(true);
        editText.setBackground(getDrawable(R.drawable.button_border));
        String key = "test2" + num;
        editText.setText(prefs1.getString(key, ""));
        editor.putBoolean(checkbox_key, true);
        editor.apply();


    }
}
