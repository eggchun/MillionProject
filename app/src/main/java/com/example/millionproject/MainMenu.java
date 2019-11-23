package com.example.millionproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Main Menu page
 */
public class MainMenu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // Button list for handle
        ArrayList<Button> themeButtonList = new ArrayList<>();
        themeButtonList.add((Button)findViewById(R.id.btn_anime));
        themeButtonList.add((Button)findViewById(R.id.btn_christmas));
        themeButtonList.add((Button)findViewById(R.id.btn_festival));
        themeButtonList.add((Button)findViewById(R.id.btn_hongkong));

        for(Button button: themeButtonList){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showQuestionActivity();
                }
            });
        }
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        final String[] theme = {"Christmas", "Hong Kong", "Anime", "Festival"};
//        ArrayAdapter<String> themeList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, theme);
//        spinner.setAdapter(themeList);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void showQuestionActivity(){
        startActivity(new Intent(this, QuestionActivity.class));
    }
}
