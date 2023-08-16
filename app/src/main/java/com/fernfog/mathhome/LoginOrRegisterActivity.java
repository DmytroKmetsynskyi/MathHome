package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginOrRegisterActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    Button forgotPasswordButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        int value = sharedPreferences.getInt("class", 5);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null && value >= 5) {
            Intent mIntent = new Intent(LoginOrRegisterActivity.this, MainActivity.class);
            startActivity(mIntent);

            finish();
        }


        setContentView(R.layout.activity_login_or_register);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);
        forgotPasswordButton = findViewById(R.id.forgotPasswordButton);

        tabLayout.getTabAt(0).select();
        replaceFragment(new LoginFragment());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        replaceFragment(new LoginFragment());
                        break;
                    case 1:
                        replaceFragment(new RegisterFragment());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frogotPasswordFragment frogotPasswordFragment = new frogotPasswordFragment();

                frogotPasswordFragment.show(getSupportFragmentManager(), "frogotPasswordFragment");
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}