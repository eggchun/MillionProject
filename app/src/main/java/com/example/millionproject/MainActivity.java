package com.example.millionproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
