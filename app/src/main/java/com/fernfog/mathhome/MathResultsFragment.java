package com.fernfog.mathhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MathResultsFragment extends DialogFragment {

    Button playAgainButton;
    Button exitFromFragmentButton;

    TextView someText, trueText, falseText;

    int totalAttempts = 0;
    int correctAttempts = 0;

    public MathResultsFragment(int totalAttempts, int correctAttempts) {
        this.correctAttempts = correctAttempts;
        this.totalAttempts = totalAttempts;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math_results, container, false);

        playAgainButton = view.findViewById(R.id.playAgainButton);
        exitFromFragmentButton = view.findViewById(R.id.exitFromFragmentButton);

        someText = view.findViewById(R.id.someText);
        trueText = view.findViewById(R.id.trueText);
        falseText = view.findViewById(R.id.falseText);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), ClassChooseActivity.class);
                startActivity(mIntent);

                dismiss();
            }
        });

        exitFromFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        someText.setText("За 60 секунд ви відповіли на "+ totalAttempts +" запитань.\nЗ них: ");
        trueText.setText("Вірно: " + correctAttempts);
        falseText.setText("Не вірно:" + (totalAttempts - correctAttempts));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        getActivity().finish();
    }
}