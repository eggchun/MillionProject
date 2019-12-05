package com.example.millionproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

/**
 * Main Menu page
 */
public class MainMenu extends AppCompatActivity implements UsernameDialogFragment.UsernameDialogListener {
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


        // Ranking button
        Button rankingBtn = findViewById(R.id.btn_ranking);
        rankingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRankingActivity();
            }
        });
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

    public void showRankingActivity(){
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("About the app.")
                .setMessage("2019 Android Development Group Project by Michael, KK and Emma.")
                .setPositiveButton("OK" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .show();

        return super.onOptionsItemSelected(item);
    }

}
