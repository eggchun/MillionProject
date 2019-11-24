package com.example.millionproject;

import java.io.Serializable;

/**
 * Answer class
 */
public class Answer implements Serializable {
    private String answer;
    private boolean correct;

    public Answer(String answer, boolean correct){
        this.answer = answer;
        this.correct = correct;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public void setCorrect(boolean correct){
        this.correct = correct;
    }
    public String getAnswer(){
        return answer;
    }
    public boolean getCorect(){
        return correct;
    }
}
