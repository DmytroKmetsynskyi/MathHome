package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView classText;
    Button changeClassButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_main);

        classText = findViewById(R.id.classText);
        changeClassButton = findViewById(R.id.changeClassButton);

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
    }
}