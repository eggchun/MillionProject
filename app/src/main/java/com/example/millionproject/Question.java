package com.example.millionproject;

import java.util.ArrayList;

/**
 * Question class
 */
public class Question {
    private  String title;
    private ArrayList<Answer> options;

    public Question(String title, Answer[] answers){
        this.title = title;
        for(Answer answer: answers){
            options.add(answer);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOptions(ArrayList<Answer> options) {
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Answer> getOptions() {
        return options;
    }
}
