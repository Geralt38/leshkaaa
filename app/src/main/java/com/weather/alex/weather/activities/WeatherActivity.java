package com.weather.alex.weather.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weather.alex.weather.R;
import com.weather.alex.weather.Retrofit.ApiClient;
import com.weather.alex.weather.Retrofit.ServiceGenerator;
import com.weather.alex.weather.Retrofit.WeatherInterface;
import com.weather.alex.weather.model.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.weather.alex.weather.Retrofit.ApiClient.BASE_URL;

public class WeatherActivity extends AppCompatActivity {

    String API_KEY = "f3ecd8e78a6572e44ae81fef78654bbd";

    TextView temp;
    TextView humidity;
    TextView wind;
    TextView cityLabel;
    RelativeLayout container;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        String city = getIntent().getExtras().getString("city");

        container = findViewById(R.id.weather_container);
        temp = findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        wind = findViewById(R.id.wind);
        cityLabel = findViewById(R.id.city);
        getWeather(city);
    }

    private void getWeather(final String city) {

        WeatherInterface apiService = ServiceGenerator.createService(WeatherInterface.class, BASE_URL);
        ApiClient.getClient().create(WeatherInterface.class);


        Call<Weather> call = apiService.getWeather(city , API_KEY);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                int statusCode = response.code();
                Weather weather = response.body();

                if (weather != null) {
                    cityLabel.setText(city);
                    temp.setText(Integer.toString((int)weather.getMainInfo().getTemp() - 273));
                    humidity.setText(weather.getMainInfo().getHumidity() + "%");
                    wind.setText(weather.getWindInfo().getSpeed() + " ");
                    container.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "Can't find city", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e("main", t.toString());

            }
        });
    }
}
