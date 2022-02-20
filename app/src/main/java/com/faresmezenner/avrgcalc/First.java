package com.faresmezenner.avrgcalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import javax.security.auth.Subject;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);




        MobileAds.initialize(this);


        Button about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(getApplicationContext(), About.class);
                startActivity(k);
            }
        });

        Button report = findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subj = "Error Report";
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setData(Uri.parse("mailto:tech.torch.cs@gmail.com")); // or just "mailto:" for blank
                intent.putExtra(Intent.EXTRA_SUBJECT, subj);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

                try {
                    startActivity(Intent.createChooser(intent, "Send email using..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button contact = findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Contact.class);
                startActivity(i);
            }
        });

        Button calculate = findViewById(R.id.calcualte);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });




        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(First.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(First.this).inflate(R.layout.privacy_and_terms, viewGroup, false);
        Button buttonOk=dialogView.findViewById(R.id.ok);
        WebView webView = dialogView.findViewById(R.id.view);
        TextView title = dialogView.findViewById(R.id.title);
        alertBuilder.setView(dialogView);


        AlertDialog alerdialog = alertBuilder.create();


        TextView privacy_terms = findViewById(R.id.terms);

        String text = "بإستخدامك للتطبيق فأنت توافق على سياسة الخصوصية و على شروط الاستخدام";

        SpannableString ss = new SpannableString(text);

        ClickableSpan policy = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getApplicationContext(), "policy", Toast.LENGTH_SHORT).show();
                title.setText("سياسة الخصوصية");
                webView.loadUrl("file:///android_asset/privacy.html");
                alerdialog.show();
                privacy_terms.setText(ss);
                privacy_terms.setMovementMethod(LinkMovementMethod.getInstance());

            }



        };

        ClickableSpan terms = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getApplicationContext(), "terms", Toast.LENGTH_SHORT).show();
                title.setText("شروط الإستخدام");
                webView.loadUrl("file:///android_asset/terms.html");
                alerdialog.show();
                privacy_terms.setText(ss);
                privacy_terms.setMovementMethod(LinkMovementMethod.getInstance());
            }
        };

        ss.setSpan(policy,33 , 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(terms,54 , 68, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        privacy_terms.setText(ss);
        privacy_terms.setMovementMethod(LinkMovementMethod.getInstance());

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerdialog.dismiss();
            }
        });


    }



}