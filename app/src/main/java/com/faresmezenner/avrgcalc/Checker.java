package com.faresmezenner.avrgcalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class Checker {

    boolean checkIfCorrect (Context context, EditText editText, int num, SharedPreferences.Editor editor, String name, boolean hasFocus,boolean all_in, Toast toast) {

        String key = name + num;
        boolean Return = all_in;


        if (!hasFocus && !editText.getText().toString().isEmpty()) {
            if (Double.valueOf(editText.getText().toString()) > 20 || Double.valueOf(editText.getText().toString()) < 0) {
                editText.setTextColor(context.getResources().getColor(R.color.red));
                editText.setBackgroundResource(R.drawable.button_border_red);
                toast.show();
                Return = false;
            } else {

                editor.putString(key, editText.getText().toString());
                Return = true;
            }
        } else if (hasFocus) {
            toast.cancel();
            editText.setTextColor(context.getResources().getColor(R.color.blue));
            editText.setBackgroundResource(R.drawable.button_border);
        } else if (!hasFocus && editText.getText().toString().isEmpty()) {

            toast.cancel();
            editText.setTextColor(context.getResources().getColor(R.color.blue));
            editText.setBackgroundResource(R.drawable.button_border);

            Return = true;

        }


        return Return;


    }
}




