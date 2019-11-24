package com.example.millionproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionActivity extends Activity {
    private int indexOfQuestion = 0;
    private int numberOfQuestion = 0;
    private Theme selectedTheme;
    private Long startTime;
    private Question answeredQuestion;
    private Answer answeredAnswer;
    final Handler handler = new Handler(); // timer handler


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        selectedTheme = getSelectedTheme();
        numberOfQuestion = selectedTheme.getQuestionNo();
        startTime = System.currentTimeMillis();
        TextView themeTitle = findViewById(R.id.question_theme);
        themeTitle.setText("Question Type: " + selectedTheme.getThemeTitle());

        /**
         * Update the first question during Activity start
         */
        updateQuestion(selectedTheme.getQuestionList().get(indexOfQuestion++), indexOfQuestion);

        /**
         * Update Timer
         */
        handler.removeCallbacks(updateTimer);
        handler.postDelayed(updateTimer, 1000);

        /**
         * Handle Next Button
         */
        Button nextBtn = findViewById(R.id.btn_next_question);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexOfQuestion < numberOfQuestion){
                    updateQuestion(selectedTheme.getQuestionList().get(indexOfQuestion++), indexOfQuestion);
                }

            }
        });

        /**
         * Handle option button click
         */
        RadioGroup answerBtnGroup = findViewById(R.id.btn_group_answer);
        answerBtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for(int z = 0 ; z < radioGroup.getChildCount(); z++ ){
                    RadioButton radioBtn = (RadioButton)radioGroup.getChildAt(z);
                    if(radioBtn.isChecked()){
                        radioBtn.setBackgroundColor(Color.YELLOW);
                        answeredAnswer = answeredQuestion.getOptions().get(z);
                    }else{
                        radioBtn.setBackgroundColor(Color.WHITE);
                    }
                }
            }
        });
        /**
         * Handle submit button click
         */
        Button submitBtn = findViewById(R.id.btn_submit_answer);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public Theme getSelectedTheme(){
        Theme selectedTheme = (Theme) getIntent().getSerializableExtra("SELECTED THEME");
        return selectedTheme;
    }
    public void updateQuestion(Question question, int questionNo){
        TextView title = findViewById(R.id.question_title);
        RadioGroup answerBtnGroup = findViewById(R.id.btn_group_answer);
        TextView questionNumber = findViewById(R.id.question_no);

        answeredQuestion = question;
        // Question no Update
        questionNumber.setText("Question No: " + questionNo);

        // Answer option update
        title.setText(question.getTitle());
        for(int i = 0 ; i < answerBtnGroup.getChildCount(); i++ ){
            RadioButton btn =  (RadioButton)answerBtnGroup.getChildAt(i);
            btn.setText(question.getOptions().get(i).getAnswer());
            btn.setChecked(false);
        }

        // Check question length
        if(numberOfQuestion == questionNo){
            findViewById(R.id.btn_next_question).setVisibility(View.INVISIBLE);
        }
    }

    private Runnable updateTimer = new Runnable(){
        public void run() {
            final TextView timer = (TextView) findViewById(R.id.question_timer);
            Long spentTime = System.currentTimeMillis() - startTime;
            //計算目前已過分鐘數
            Long minius = (spentTime/1000) / 60;
            //計算目前已過秒數
            Long seconds = (spentTime/1000) % 60;
            timer.setText(minius + ":" + seconds);
            handler.postDelayed(this, 1000);
        }
    };

}
