package com.fernfog.mathhome;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MathGameActivity extends AppCompatActivity {

    private TextView questionTextView, secondsUntilFinishedText;
    private Button option1Button, option2Button, option3Button;

    private int correctAnswer;
    private int totalAttempts;
    private int correctAttempts;

    private CountDownTimer quizTimer;
    private static final long TOTAL_QUIZ_DURATION = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);

        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(Integer.parseInt(option1Button.getText().toString()));
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(Integer.parseInt(option2Button.getText().toString()));
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(Integer.parseInt(option3Button.getText().toString()));
            }
        });

        startGame();
    }

    private void startGame() {
        totalAttempts = 0;
        correctAttempts = 0;
        generateQuestion();

        quizTimer = new CountDownTimer(TOTAL_QUIZ_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsUntilFinishedText = findViewById(R.id.secondsUntilFinishedText);
                secondsUntilFinishedText.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                MathResultsFragment mathResultsFragment = new MathResultsFragment(totalAttempts, correctAttempts);
                mathResultsFragment.setRetainInstance(true);
                mathResultsFragment.show(getSupportFragmentManager(), "mathResultsFragment");;
            }
        }.start();
    }

    private void generateQuestion() {
        Random random = new Random();
        int operand1 = random.nextInt(100);
        int operand2 = random.nextInt(100);

        int i = random.nextInt(4);

        switch (i) {
            case 0: {
                correctAnswer = operand1 + operand2;
                questionTextView.setText(operand1 + " + " + operand2 + " = ?");
                break;
            }
            case 1: {
                correctAnswer = operand1 - operand2;
                questionTextView.setText(operand1 + " - " + operand2 + " = ?");
                break;
            }
            case 2: {
                if (operand2 == 0) {
                    operand2 = 1;
                }
                correctAnswer = operand1 / operand2;
                questionTextView.setText(operand1 + " ÷ " + operand2 + " = ?");
                break;
            }
            case 3: {
                correctAnswer = operand1 * operand2;
                questionTextView.setText(operand1 + " × " + operand2 + " = ?");
                break;
            }
        }

        List<Integer> options = generateOptions(correctAnswer);
        option1Button.setText(String.valueOf(options.get(0)));
        option2Button.setText(String.valueOf(options.get(1)));
        option3Button.setText(String.valueOf(options.get(2)));
    }

    private List<Integer> generateOptions(int correctAnswer) {
        Random random = new Random();
        int incorrect1 = correctAnswer + random.nextInt(10) + 1;
        int incorrect2 = correctAnswer - random.nextInt(10) - 1;

        List<Integer> options = new ArrayList<>();
        options.add(correctAnswer);
        options.add(incorrect1);
        options.add(incorrect2);

        Collections.shuffle(options);

        return options;
    }

    private void checkAnswer(int selectedOption) {
        totalAttempts++;
        if (selectedOption == correctAnswer) {
            correctAttempts++;
        }
        generateQuestion();
    }

}