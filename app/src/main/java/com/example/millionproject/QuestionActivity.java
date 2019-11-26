package com.example.millionproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    private Answer answeredAnswer = null;
    private RadioButton answeredBtn = null;
    private RadioButton modelAnswerBtn = null;
    final Handler handler = new Handler(); // timer handler
    private Button nextBtn = null;
    private Button submitBtn = null;
    private RadioGroup answerBtnGroup;
    private String username;
    private long timeUse;
    private int score = 0;
    private String temeType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        selectedTheme = getSelectedTheme();
        username = getIntent().getStringExtra("username");
        numberOfQuestion = selectedTheme.getQuestionNo();
        startTime = System.currentTimeMillis();


        TextView themeTitle = findViewById(R.id.question_theme);
        themeTitle.setText("Question Type: " + selectedTheme.getThemeTitle());
        temeType = selectedTheme.getThemeTitle();

        submitBtn = findViewById(R.id.btn_submit_answer);
        nextBtn = findViewById(R.id.btn_next_question);
        answerBtnGroup = findViewById(R.id.btn_group_answer);

        /**
         * Update Timer
         */
        handler.removeCallbacks(updateTimer);
        handler.postDelayed(updateTimer, 1000);

        /**
         * Handle Next Button
         */
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answeredBtn != null){
                    if(indexOfQuestion < numberOfQuestion){
                        updateQuestion(selectedTheme.getQuestionList().get(indexOfQuestion++), indexOfQuestion);
                    }else{
                        goResultActivity(username, timeUse, score, temeType);
                        finish();
                    }
                }
            }
        });

        /**
         * Handle answer option button click
         */
        answerBtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for(int z = 0 ; z < radioGroup.getChildCount(); z++ ){
                    RadioButton radioBtn = (RadioButton)radioGroup.getChildAt(z);
                    if(radioBtn.isChecked()){
                        radioBtn.setBackgroundColor(Color.YELLOW);
                        answeredAnswer = answeredQuestion.getOptions().get(z);
                        answeredBtn = radioBtn;
                    }else{
                        radioBtn.setBackgroundColor(Color.WHITE);
                    }
                }
            }
        });
        /**
         * Handle submit button click
         */
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(answeredAnswer == null){
                   showToast("You have not answer question!");
                   return;
               }else{
                   if(checkAnswer(answeredAnswer)){
                        answeredBtn.setBackgroundColor(Color.GREEN);
                        score++;
                   }else{
                       modelAnswerBtn.setBackgroundColor(Color.GREEN);
                       answeredBtn.setBackgroundColor(Color.RED);
                   }
                    // disable option after submit
                   setEnableToRadioGroup(answerBtnGroup, false);
                   view.setEnabled(false);


                   if(indexOfQuestion <= numberOfQuestion){
                       nextBtn.setEnabled(true);
                   }
               }
            }
        });

        /**
         * Update the first question during Activity start
         */
        updateQuestion(selectedTheme.getQuestionList().get(indexOfQuestion++), indexOfQuestion);

    }
    public boolean checkAnswer(Answer answer){
        return answer.getCorect();
    }
    public Theme getSelectedTheme(){
        Theme selectedTheme = (Theme) getIntent().getSerializableExtra("selectedTheme");
        return selectedTheme;
    }
    public void updateQuestion(Question question, int questionNo){
        TextView title = findViewById(R.id.question_title);
        RadioGroup answerBtnGroup = findViewById(R.id.btn_group_answer);
        TextView questionNumber = findViewById(R.id.question_no);
        ImageView questionTitleImg = findViewById(R.id.question_title_image);

        answeredQuestion = question;

        // Question no Update
        questionNumber.setText("Question No: " + questionNo);

        // uncheck the option
        answerBtnGroup.clearCheck();

        // Answer option update
        title.setText(question.getTitle());
        for(int i = 0 ; i < answerBtnGroup.getChildCount(); i++ ){
            RadioButton btn =  (RadioButton)answerBtnGroup.getChildAt(i);
            btn.setText(question.getOptions().get(i).getAnswer());

            if(question.getOptions().get(i).getCorect()){
                modelAnswerBtn = btn;
            }
        }

        // question img change
        if(question.getImgSrc() != null){
            questionTitleImg.setImageResource(getResources().getIdentifier(question.getImgSrc(), "drawable", getPackageName()));
        }else{
            questionTitleImg.setImageResource(R.drawable.qa_icon);
        }

        // init state of button when new question update
        setEnableToRadioGroup(answerBtnGroup, true);
        submitBtn.setEnabled(true);
        nextBtn.setEnabled(false);
        answeredAnswer = null;

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

            timeUse = spentTime;
        }
    };
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void setEnableToRadioGroup(RadioGroup radioGroup, boolean enable){
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(enable);
        }
    }
    public void goResultActivity(String username, long timeUse, int score, String themeType){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("username", username)
                .putExtra("timeUse", timeUse)
                .putExtra("score", score)
                .putExtra("theme", themeType);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure back to main menu?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        QuestionActivity.super.onBackPressed();
                    }
                })
                .setNeutralButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
