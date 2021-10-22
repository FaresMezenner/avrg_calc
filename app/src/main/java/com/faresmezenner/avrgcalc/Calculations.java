package com.faresmezenner.avrgcalc;

import android.util.Log;
import android.widget.EditText;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculations {

    double subjectNote(EditText[] notes, int devider){


        double sum = 0;
        double tests = 0;
        boolean two = false;

        for(int i = 0; i<notes.length; i++){

            if(!(notes[i]==null)){

                if( i == 2){

                    tests = tests + Double.valueOf(String.valueOf(notes[i].getText()));

                } else if(i == 3){
                    two = true;
                    tests = (tests + Double.valueOf(String.valueOf(notes[i].getText())))/2;
                    sum = sum + tests;

                } else if(i == 4) {
                    sum = sum + (Double.valueOf(String.valueOf(notes[i].getText()))*2);

                } else {
                    sum = sum + Double.valueOf(String.valueOf(notes[i].getText()));

                }

            }


        }


        if(!two){
            sum = sum + tests;

        }

        double result = sum/devider;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return result;


    }

    double completeNote(double[] avrgs, int[] coefficients, int subjects, double reading, double projects){

        double sum = 0;
        int devider = 0;

        for(int i = 0; i<subjects; i++){

            sum = sum + (avrgs[i]*coefficients[i]);
            devider = devider + coefficients[i];

        }

        if(reading > 10){
            reading = reading - 10;

        } else {
            reading = 0;
        }


        if(projects > 10){
            projects = projects - 10;

        } else {
            projects = 0;
        }




        sum = sum + reading + projects;



        double result = sum/devider;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return result;

    }

    double bacAvrg(EditText[] notes, int[] coefficients, int subjects){

        double sum = 0;
        int devider = 0;


        for(int i = 0; i<subjects; i++){

            sum = sum + ((Double.valueOf(String.valueOf(notes[i].getText())))*coefficients[i]);

            Log.d("total:", String.valueOf(((Double.valueOf(String.valueOf(notes[i].getText())))*coefficients[i])));

            devider = devider + coefficients[i];
        }



        Log.d("total:", String.valueOf(devider));


        double result = sum/devider;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return result;
    }


    double subjectNoteCem(EditText[] notes){


        double exam = 0;
        double appliaction = 0;

        for(int i = 0; i<notes.length; i++){

            if(!(notes[i]==null)){

                if( i == 0 || i == 1){


                    appliaction = appliaction + Double.valueOf(String.valueOf(notes[i].getText()));

                } else if(i == 2){

                    appliaction = appliaction + Double.valueOf(String.valueOf(notes[i].getText()));

                    appliaction = (appliaction*40)/60;

                } else if(i == 3) {
                    exam = (Double.valueOf(String.valueOf(notes[i].getText()))*3);

                }

            }


        }

        double sum = exam + appliaction;




        double result = sum/5;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return result;


    }


}