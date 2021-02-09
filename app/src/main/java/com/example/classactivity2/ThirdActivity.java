package com.example.classactivity2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private TextView no_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        no_city = findViewById(R.id.no_city);
        Intent intent = getIntent();
        no_city.setText(intent.getStringExtra("no_city"));
    }
}
