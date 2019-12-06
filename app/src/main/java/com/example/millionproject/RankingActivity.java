package com.example.millionproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {
    private ArrayList<String> themeTitleList = new ArrayList<>();
    private Spinner themSpinner;
    private ArrayAdapter adapter;
    private ArrayList<User> selectedUserList = new ArrayList<>();
    private ArrayList<User> allUserList;
    private String selectedTheme;
    Button homeBtn;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);

        listView = findViewById(R.id.ranking_listview);

        // spinner prepare and handling
        themSpinner = findViewById(R.id.spinner_theme);
        showSpinner(new ThemeList().getThemeList());
        themSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTheme = themeTitleList.get(i);
                filterUserList(selectedTheme);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        // List view
        allUserList = getUserList();
        filterUserList(selectedTheme);
        adapter = new Ranking_User_Adapter(selectedUserList, getApplicationContext());
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.ranking_listview_empty));





        // Home button handling
        homeBtn = findViewById(R.id.btn_home);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHomeActivity();
            }
        });
    }


    public void showSpinner(ArrayList<Theme> themeList){
        // get the theme title and prepare array adapter
        for (Theme theme : themeList) {
            themeTitleList.add(theme.getThemeTitle());
        }

        // set data to spinner
        themSpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, themeTitleList));
    }

    public void showHomeActivity(){
        Intent intent = new Intent(this, MainMenu.class);
        RankingActivity.this.startActivity(intent);
    }

    public ArrayList<User> getUserList(){
        SharedPreferences userPreferences = getSharedPreferences(User.SHARED_PREFERENCES_USER_FILE, MODE_PRIVATE);
        String json = userPreferences.getString(User.SHARED_PREFERENCES_USER_KEY, null);
        String userJson = userPreferences.getString(User.SHARED_PREFERENCES_USER_KEY, null);

        ArrayList<User> userList = null;

        if(json != null){
            Log.d("Load json ", json);
            userList = new Gson().fromJson(json, new TypeToken<ArrayList<User>>(){}.getType());
        }else{
            Log.d("Load json ", "EMPTY");
        }

        return userList;
    }

    public void filterUserList(String selectedTheme){
        if(allUserList != null){
            selectedUserList.clear();
            for(User user: allUserList){
                if(user.getAnsweredTheme().equals(selectedTheme)){
                    selectedUserList.add(user);
                }
            }
        }
    }

}
