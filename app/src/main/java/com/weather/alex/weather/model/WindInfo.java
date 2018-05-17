package com.weather.alex.weather.model;

import com.google.gson.annotations.SerializedName;

public class WindInfo {

    @SerializedName("speed")
    private int speed;

    public WindInfo(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
