package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class ComicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_comics);

        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        try {
            int value = sharedPreferences.getInt("class", 5);

            switch (value) {
                case 5:
                    webView.loadUrl("https://docs.google.com/document/d/1ODZvH5UuJJgGwhqGtXcNDAeqsg308_fb");
                    break;
                case 6:
                    webView.loadUrl("https://docs.google.com/document/d/1TWL9Nw95XlrChC8YHi1yOMZW-c_z8YYi");
                    break;
                case 7:
                    webView.loadUrl("https://docs.google.com/document/d/16s1ObjjkiBMYke5Mz29nUWN5DLNRRk1a");
                    break;
                case 8:
                    webView.loadUrl("https://docs.google.com/document/d/10woF4SENiraAZkcyTKhjPOboW4gl3VCm");
                    break;
                case 9:
                    webView.loadUrl("https://docs.google.com/document/d/1v-wcZLxiKtnmhJlsBT7c9Ev_1l6kqt8o");
                    break;
                case 10:
                    webView.loadUrl("https://docs.google.com/document/d/1mL_vLzGzVhM6DRQ8UYlPmFV-OnuCNul9");
                    break;
                case 11:
                    webView.loadUrl("https://docs.google.com/document/d/1vb9mfQ8vEdHTdnyrFkupJflt7Y389rIW");
                    break;
            }

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        finish();

    }
}