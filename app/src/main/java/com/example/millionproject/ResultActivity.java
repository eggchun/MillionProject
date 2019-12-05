package com.example.millionproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.millionproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ResultActivity extends AppCompatActivity {
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

        // Save to shared preferences
        setSharedPreferences(new User(username, theme, score, timeUse));

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

    public void setSharedPreferences(User user){
        // prepare user array list
        ArrayList<User> userList = new ArrayList<>();
        Gson gson = new Gson();

        SharedPreferences userPreferences = getSharedPreferences(User.SHARED_PREFERENCES_USER_FILE, MODE_PRIVATE);
        SharedPreferences.Editor userEditor = userPreferences.edit();

        // get the previous user score list if exists
        String userJson = userPreferences.getString(User.SHARED_PREFERENCES_USER_KEY, null);
        if(userJson == null ){
            userList.add(user);

            String json = gson.toJson(userList);
            userEditor.putString(User.SHARED_PREFERENCES_USER_KEY, json);
            Log.d("Saved json is", json);
        }else{
            Type type = new TypeToken<ArrayList<User>>(){}.getType();
            userList = gson.fromJson(userJson, type);

            userList.add(user);

            String json = gson.toJson(userList);
            userEditor.putString(User.SHARED_PREFERENCES_USER_KEY, json);
            Log.d("Saved json is", json);
        }
        userEditor.commit();
    }
}
