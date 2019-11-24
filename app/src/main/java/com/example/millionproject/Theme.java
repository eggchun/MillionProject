package com.example.millionproject;

import java.io.Serializable;
import java.util.ArrayList;

public class Theme implements Serializable {
    private String themeTitle;
    private ArrayList<Question> questionList = new ArrayList<>();
    private int questionNo = 0;

    public Theme(String themeTitle, ArrayList<Question> questions){
        this.themeTitle = themeTitle;
        for(Question question: questions){
            questionList.add(question);
            questionNo++;
        }
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public int getQuestionNo() {
        return questionNo;
    }
}
