package com.example.classactivity2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SecondActivity extends AppCompatActivity {

    private String city_name, country_name, city_weather, city_high, city_low, city_feels;
    private TextView no_city, name_text, desc_text, high_text, low_text, feels_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        no_city = findViewById(R.id.no_city);
        name_text = findViewById(R.id.city_state);
        desc_text = findViewById(R.id.weather_desc);
        high_text = findViewById(R.id.high_num);
        low_text = findViewById(R.id.low_num);
        feels_text = findViewById(R.id.feels_num);

        Intent intent = getIntent();

        if(intent.hasExtra("no_city")) {
            no_city.setText(intent.getStringExtra("no_city"));
        }
        else {
            city_name = intent.getStringExtra("city_name");
            country_name = intent.getStringExtra("country_name");
            city_weather = intent.getStringExtra("city_weather");
            city_high = intent.getStringExtra("city_high");
            city_low = intent.getStringExtra("city_low");
            city_feels = intent.getStringExtra("city_feels");

            name_text.setText(city_name + ", " + country_name);
            desc_text.setText(city_weather);
            high_text.setText(city_high);
            low_text.setText(city_low);
            feels_text.setText(city_feels);
        }
    }
}