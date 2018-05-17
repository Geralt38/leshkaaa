package com.weather.alex.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {


    Button getWeatherButton;
    EditText cityEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWeatherButton = findViewById(R.id.get_button);
        cityEdittext = findViewById(R.id.city_edittext);


        getWeatherButton.setOnClickListener( new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                String city = cityEdittext.getText().toString();
                Intent intent = new Intent(v.getContext(),WeatherActivity.class);
                intent.putExtra("city", city);
                v.getContext().startActivity(intent);
            }
        });


    }


}
