package com.example.myapplication.model.user;

public class User {
    private Integer currentStreakDays = 0;

    public Integer getCurrentStreakDays() {
        return currentStreakDays;
    }

    public void incrementCurrentStreakDays(){
        currentStreakDays++;
    }

    public void resetCurrentStreakDays() {
        currentStreakDays = 0;
    }
}
