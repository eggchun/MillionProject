package com.example.millionproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.millionproject.R;

public class ResultActivity extends Activity {
    private String username, theme;
    private long timeUse;
    private int score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView usernameTextTV, themeTV, timeTV, scoreTV;
        Button rankingBtn;

        usernameTextTV = findViewById(R.id.result_username);
        themeTV = findViewById(R.id.result_theme);
        timeTV = findViewById(R.id.result_time);
        scoreTV = findViewById(R.id.result_score);
        rankingBtn = findViewById(R.id.result_ranking_btn);

        // Get intent
        username = getIntent().getStringExtra("username");
        theme = getIntent().getStringExtra("theme");
        timeUse = getIntent().getLongExtra("timeUse", 0);
        score = getIntent().getIntExtra("score", 0);

        //Update UI
        usernameTextTV.setText(username);
        themeTV.setText(theme);
        scoreTV.setText(Integer.toString(score));
        //計算目前已過分鐘數
        Long minius = (timeUse/1000) / 60;
        //計算目前已過秒數
        Long seconds = (timeUse/1000) % 60;
        timeTV.setText(minius + ":" + seconds);


        rankingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRankingAcivity();
            }
        });
    }

    public void goRankingAcivity(){
        startActivity(new Intent(this, RankingActivity.class));
        finish();
    }

}
