package com.weather.alex.weather.model;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("main")
    private MainInfo mainInfo;
    @SerializedName("wind")
    private WindInfo windInfo;

    public Weather(MainInfo mainInfo, WindInfo windInfo) {
        this.mainInfo = mainInfo;
        this.windInfo = windInfo;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public WindInfo getWindInfo() {
        return windInfo;
    }

    public void setWindInfo(WindInfo windInfo) {
        this.windInfo = windInfo;
    }
}
