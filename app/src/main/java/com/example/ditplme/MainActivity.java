package com.example.ditplme;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView score, question;

    private Question mQuestion = new Question();
    private QuestionsDev questionsDev = new QuestionsDev();

    private String mAnswer;
    private int mScore = 0;

    private int mQuestionLength = mQuestion.Questions.length;
    private int QuestionsDevLength = questionsDev.Questions.length;

    private int thisQuestionsLength;
    private int actualQuestion = 0;

    Random r;

    private int selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        score.setText("Score: " + mScore);

        Bundle bundle = getIntent().getExtras();
        selectedCategory = bundle.getInt("CATEGORY");

        if (selectedCategory == 0){
            thisQuestionsLength = QuestionsDevLength;
            updateCurrentQuestionDev(actualQuestion);
        } else if (selectedCategory == 1) {
            thisQuestionsLength = mQuestionLength;
            updateCurrentQuestion(actualQuestion);
        }


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    answer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bonne_reponse));
                }
                if (answer1.getText() != mAnswer){
                    answer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_mauvaise_reponse));
                }
                actualQuestion++;
                if (actualQuestion == thisQuestionsLength) {
                    gameisover();
                } else if (selectedCategory == 0){
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestion(actualQuestion);
                                }
                            },
                            700);
                } else if (selectedCategory == 1) {
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestionDev(actualQuestion);
                                }
                            },
                            700);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    answer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bonne_reponse));
                }
                if (answer2.getText() != mAnswer){
                    answer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_mauvaise_reponse));
                }
                actualQuestion++;
                if (actualQuestion == thisQuestionsLength) {
                    gameisover();
                } else if (selectedCategory == 0){
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestion(actualQuestion);
                                }
                            },
                            700);
                } else if (selectedCategory == 1) {
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestionDev(actualQuestion);
                                }
                            },
                            700);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    answer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bonne_reponse));
                }
                if (answer3.getText() != mAnswer){
                    answer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_mauvaise_reponse));
                }
                actualQuestion++;
                if (actualQuestion == thisQuestionsLength) {
                    gameisover();
                } else if (selectedCategory == 0){
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestion(actualQuestion);
                                }
                            },
                            700);
                } else if (selectedCategory == 1) {
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestionDev(actualQuestion);
                                }
                            },
                            700);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    answer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bonne_reponse));
                }
                if (answer4.getText() != mAnswer){
                    answer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_mauvaise_reponse));
                }
                actualQuestion++;
                if (actualQuestion == thisQuestionsLength) {
                    gameisover();
                } else if (selectedCategory == 0){
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestion(actualQuestion);
                                }
                            },
                            700);
                } else if (selectedCategory == 1) {
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    answer4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button));
                                    updateCurrentQuestionDev(actualQuestion);
                                }
                            },
                            700);
                }
            }
        });
    }

    private void updateCurrentQuestion(int i) {
        question.setText(mQuestion.getQuestion(i));

        answer1.setText(mQuestion.getChoice(i));
        answer2.setText(mQuestion.getChoice2(i));
        answer3.setText(mQuestion.getChoice3(i));
        answer4.setText(mQuestion.getChoice4(i));

        mAnswer = mQuestion.getCorrectAnswer(i);
    }


    private void updateCurrentQuestionDev(int i) {
        question.setText(questionsDev.getQuestion(i));

        answer1.setText(questionsDev.getChoice(i));
        answer2.setText(questionsDev.getChoice2(i));
        answer3.setText(questionsDev.getChoice3(i));
        answer4.setText(questionsDev.getChoice4(i));

        mAnswer = questionsDev.getCorrectAnswer(i);
    }

    private void gameisover(){

        Intent intent = new Intent(MainActivity.this, Score.class);
        intent.putExtra("RESULTAT", mScore);
        startActivity(intent);

        /**AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogbuilder
                .setMessage("Your game is over " + mScore + "Score")
                .setPositiveButton("Start New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogbuilder.create();
        alertDialog.show();**/
    }
}
