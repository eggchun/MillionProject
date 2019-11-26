package com.example.millionproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

/**
 * Main Menu page
 */
public class MainMenu extends FragmentActivity implements UsernameDialogFragment.UsernameDialogListener {
    private String username = "";
    private ThemeList themeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        themeList = new ThemeList();

        // Button list for handle
        ArrayList<Button> themeButtonList = new ArrayList<>();
        themeButtonList.add((Button)findViewById(R.id.btn_animal));
        themeButtonList.add((Button)findViewById(R.id.btn_christmas));
        themeButtonList.add((Button)findViewById(R.id.btn_festival));
        themeButtonList.add((Button)findViewById(R.id.btn_hongkong));

        for(Button button: themeButtonList){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // show dialog and get username
                    if(username.isEmpty()){
                        showUsernameInputDialog();
                    }else{
                        if(view.getId() == R.id.btn_christmas){
                            showQuestionActivity(themeList.getThemeList().get(0)); // index 0 => christmas
                        }else if(view.getId() == R.id.btn_hongkong){
                            showQuestionActivity(themeList.getThemeList().get(1)); //index 1 => hong kong
                        }else if(view.getId() == R.id.btn_animal) {
                            showQuestionActivity(themeList.getThemeList().get(2)); //index 2 => animal
                        }else if(view.getId() == R.id.btn_festival) {
                            showQuestionActivity(themeList.getThemeList().get(3)); //index 3 => festival
                        }
                    }
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

    public void showQuestionActivity(Theme selectedTheme){
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("selectedTheme", selectedTheme);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void showUsernameInputDialog(){
        DialogFragment dialog = new UsernameDialogFragment();
        dialog.show(getSupportFragmentManager(), "UsernameDialogFragment");
    }

    @Override
    public void onUsernameInput(String username) {
        this.username = username.trim();
        if(!this.username.isEmpty()){
            Toast.makeText(this, "Welcome " + this.username + "!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please re-entry your name!", Toast.LENGTH_SHORT).show();
        }

    }
}
