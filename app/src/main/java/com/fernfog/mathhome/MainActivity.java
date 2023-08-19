package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView classText;
    Button changeClassButton;
    ImageButton videosButton, gamesButton, comicsButton, bonusTasksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_main);

        classText = findViewById(R.id.classText);
        changeClassButton = findViewById(R.id.changeClassButton);
        gamesButton = findViewById(R.id.gamesButton);
        videosButton = findViewById(R.id.videosButton);
        comicsButton = findViewById(R.id.comicsButton);
        bonusTasksButton = findViewById(R.id.bonusTasksButton);

        int value = sharedPreferences.getInt("class", 5);
        classText.setText(value + " клас");

        changeClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, ClassChooseActivity.class);
                startActivity(mIntent);

                finish();
            }
        });

        gamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, MathGameActivity.class);
                startActivity(mIntent);
            }
        });
        videosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, VideosActivity.class);
                startActivity(mIntent);
            }
        });
        comicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, ComicsActivity.class);
                startActivity(mIntent);
            }
        });
        bonusTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, AdditionalTasksActivity.class);
                startActivity(mIntent);
            }
        });
    }
}