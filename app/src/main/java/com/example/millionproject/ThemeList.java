package com.example.millionproject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ThemeList {
    private int themeCount = 0;
    private ArrayList<Theme> themeList;

    public ThemeList(){
        //Theme christmas = new Theme("Christmas");

    }

    /**
     * Hardcode question
     */
    public Answer[] christmasQ1Answer = {new Answer("Sing", false), new Answer("Swim", false), new Answer("Sauna", true), new Answer("Drink", false)};
    Question christmasQ1 =  new Question("In Finland, each family will do this activity before the night in Christmas. What is it?", christmasQ1Answer);
    ArrayList<Question> christmasQuestions = new ArrayList<>();
//    christmasQuestions.add(christmasQ1);

//    Theme Christmas = new Theme()
}
