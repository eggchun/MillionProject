package com.example.millionproject;

import java.io.Serializable;

public class User implements Serializable {
    public static final String SHARED_PREFERENCES_USER_FILE = "USER";
    public static final String SHARED_PREFERENCES_USER_KEY = "USER_KEY";
    private String username, answeredTheme;
    private int score;
    private long timeUsed;

    public User(String username, String answeredTheme, int score, long timeUsed){
        this.username = username;
        this.answeredTheme = answeredTheme;
        this.score = score;
        this.timeUsed = timeUsed;
    }

    public int getScore() {
        return score;
    }

    public long getTimeUsed() {
        return timeUsed;
    }

    public String getAnsweredTheme() {
        return answeredTheme;
    }

    public String getUsername() {
        return username;
    }

    public void setAnsweredTheme(String answeredTheme) {
        this.answeredTheme = answeredTheme;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTimeUsed(long timeUsed) {
        this.timeUsed = timeUsed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
