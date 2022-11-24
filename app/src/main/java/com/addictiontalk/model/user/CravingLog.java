package com.addictiontalk.model.user;

import android.location.Location;
import java.util.Date;

public class CravingLog {

    private Date date;
    private Location location;
    private String activity;
    private String craving;
    private Double cost;
    // Physical State
    private Integer hungerLevel;
    // Mental State
    // TODO: Should this be mood or should we track both? Track tiredness?
    private Integer stressLevel;
    private String thoughts;

    public CravingLog(Date date, Location location, Integer hungerLevel, Integer stressLevel,
        String activity, String thoughts, String craving, Double cost) {
        this.date = date;
        this.location = location;
        this.hungerLevel = hungerLevel;
        this.stressLevel = stressLevel;
        this.activity = activity;
        this.thoughts = thoughts;
        this.craving = craving;
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(Integer hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getCraving() {
        return craving;
    }

    public void setCraving(String craving) {
        this.craving = craving;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
