package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class AdditionalTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_additional_tasks);

        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        try {
            int value = sharedPreferences.getInt("class", 5);

            switch (value) {
                case 5:
                    webView.loadUrl("https://docs.google.com/document/d/1FnMz4ylniYUtumBgCxqZ6F4m-MVOpWA3");
                    break;
                case 6:
                    webView.loadUrl("https://docs.google.com/document/d/1DJkV-vWMaKwWxk-inRvvvd8YNahecYgW");
                    break;
                case 7:
                    webView.loadUrl("https://docs.google.com/document/d/1vQk8VLwMAdz3elFEHYzhDNs2KgRsESBv");
                    break;
                case 8:
                    webView.loadUrl("https://docs.google.com/document/d/1pxYhHFBWHryAz1NaXwVbDwBcuWXQNY5t");
                    break;
                case 9:
                    webView.loadUrl("https://docs.google.com/document/d/1PSbf9NQNvzyvdzFeQnqX1AbpPkeuRdvt");
                    break;
                case 10:
                    webView.loadUrl("https://docs.google.com/document/d/18z0jSuO1eCbrdth6F1sRhho_xMXBXRTS");
                    break;
                case 11:
                    webView.loadUrl("https://docs.google.com/document/d/17prwLs2snAYONQ5adWuDNYUTsXS9Av0c");
                    break;
            }

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        finish();

    }
}