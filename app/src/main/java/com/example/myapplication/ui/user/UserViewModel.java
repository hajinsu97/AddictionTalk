package com.example.myapplication.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserViewModel {
    private final MutableLiveData<Integer> currentStreakDays;

    public UserViewModel() {
        currentStreakDays = new MutableLiveData<>();
        currentStreakDays.setValue(0);
    }

    public LiveData<Integer> getCurrentStreakDays() {
        return currentStreakDays;
    }

    public void setCurrentStreakDays(Integer currentStreakDays) {
        this.currentStreakDays.setValue(currentStreakDays);
    }
}
