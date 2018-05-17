package com.weather.alex.weather.Retrofit;

import com.weather.alex.weather.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WeatherInterface {

    @GET("weather")
    Call<Weather> getWeather(@Query("q") String city, @Query("apikey") String apiKey);


}
