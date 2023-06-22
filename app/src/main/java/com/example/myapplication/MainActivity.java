package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    HistoryQuestions historyQuestions = new HistoryQuestions();

     TextView scoreView;
     TextView questionView;
     Button buttonChoice1;
     Button buttonChoice2;
     Button buttonChoice3;
     Button startButton, recyclerButton;
     int scoreCount=0, questionCount=0;
     String correctChoice;
     int amountQuestions = historyQuestions.questions.length;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionView = findViewById(R.id.textQuestion);
        buttonChoice1 = findViewById(R.id.button2);
        buttonChoice2 = findViewById(R.id.button3);
        buttonChoice3 = findViewById(R.id.button4);
        startButton = findViewById(R.id.button);
        recyclerButton=findViewById(R.id.buttonRecycler);
        scoreView = findViewById(R.id.scoreView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonChoice1.setVisibility(View.VISIBLE);
                buttonChoice2.setVisibility(View.VISIBLE);
                buttonChoice3.setVisibility(View.VISIBLE);
                scoreView.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.INVISIBLE);
                recyclerButton.setVisibility(View.INVISIBLE);
                continueQuestion();


            }
        });


            buttonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonChoice1.getText() == correctChoice) {
                        scoreCount++;
                        incrementScore(scoreCount);
                        continueQuestion();
                        Toast.makeText(MainActivity.this, "Correct! Good Job!", Toast.LENGTH_SHORT).show();


                    } else {
                        wrongAlert(correctChoice);
                    }
                }
            });

            buttonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonChoice2.getText() == correctChoice) {
                        scoreCount++;
                        incrementScore(scoreCount);
                        continueQuestion();
                        Toast.makeText(MainActivity.this, "Correct! Good Job!", Toast.LENGTH_SHORT).show();


                    } else {
                        wrongAlert(correctChoice);
                    }
                }
            });

            buttonChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonChoice3.getText() == correctChoice) {
                        scoreCount++;
                        incrementScore(scoreCount);
                        continueQuestion();
                        Toast.makeText(MainActivity.this, "Correct! Good Job!", Toast.LENGTH_SHORT).show();

                    } else {
                        wrongAlert(correctChoice);
                    }
                }
            });

        recyclerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);

    }

    private void continueQuestion(){
        if (questionCount == amountQuestions) {
            finishedQuestions();

        } else {
            questionView.setText(historyQuestions.getQuestion(questionCount));
            buttonChoice1.setText(historyQuestions.getChoice1(questionCount));
            buttonChoice2.setText(historyQuestions.getChoice2(questionCount));
            buttonChoice3.setText(historyQuestions.getChoice3(questionCount));
            correctChoice = historyQuestions.getCorrectChoice(questionCount);
            questionCount++;
        }

    }


    private void incrementScore(int scoreCount){
        String str = "Score:" + scoreCount;
        scoreView.setText(str);


    }

    private void finishedQuestions(){
        String flag;
        if(scoreCount > amountQuestions*0.60){
            flag = "You Passed:)";
        }else{
            flag = "You Failed:(";
        }
        new AlertDialog.Builder(this)
                .setTitle(flag)
                .setMessage("Your Score is "+ scoreCount+" Out of "+ amountQuestions)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }

    private void wrongAlert(String str){
        if (questionCount != amountQuestions) {
            new AlertDialog.Builder(this)
                    .setTitle("This Answer was Incorrect")
                    .setMessage("The Correct Answer was: " + str)
                    .setPositiveButton("Continue to the Next Question", (dialogInterface, i) -> continueQuestion())
                    .setCancelable(false)
                    .show();
        }
        else{
            finishedQuestions();
        }
    }

    void restartQuiz(){
        scoreCount = 0;
        questionCount =0;
        continueQuestion();
    }
}