package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassChooseActivity extends AppCompatActivity {

    byte classChosen = 0;

    Button fiveClassButton;
    Button sixClassButton;
    Button sevenClassButton;
    Button eightClassButton;
    Button nineClassButton;
    Button tenClassButton;
    Button elevenClassButton;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        setContentView(R.layout.activity_class_choose);

        fiveClassButton = findViewById(R.id.fiveClassButton);
        sixClassButton = findViewById(R.id.sixClassButton);
        sevenClassButton = findViewById(R.id.sevenClassButton);
        eightClassButton = findViewById(R.id.eightClassButton);
        nineClassButton = findViewById(R.id.nineClassButton);
        tenClassButton = findViewById(R.id.tenClassButton);
        elevenClassButton = findViewById(R.id.elevenClassButton);

        fiveClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(5);
            }
        });

        sixClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(6);
            }
        });

        sevenClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(7);
            }
        });

        eightClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(8);
            }
        });

        nineClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(9);
            }
        });

        tenClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(10);
            }
        });

        elevenClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeClassToSharedPref(11);
            }
        });
    }

    public void writeClassToSharedPref(int studentClass) {
        editor.putInt("class", studentClass);
        editor.apply();

        Intent mIntent = new Intent(ClassChooseActivity.this, MainActivity.class);
        startActivity(mIntent);

        finish();
    }
}