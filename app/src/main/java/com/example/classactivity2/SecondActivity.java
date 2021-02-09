package com.example.classactivity2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private String city_name, country_name, city_weather, city_high, city_low, city_feels;
    private TextView name_text,date_time, desc_text, feels_text, temp_text;
    private RecyclerView recyclerView;
    private ArrayList<Day> days;
    private ArrayList<String> date_time_arr, desc_arr, feels_arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // look up the recycler view in the main activity xml
        recyclerView = findViewById(R.id.recyclerView_days);
        days = new ArrayList<>();


        name_text = findViewById(R.id.city_state);
        date_time = findViewById(R.id.date_time);
        desc_text = findViewById(R.id.description);
//        high_text = findViewById(R.id.high_num);
//        low_text = findViewById(R.id.low_num);
        feels_text = findViewById(R.id.feels_like);
        temp_text = findViewById(R.id.temp);

        Intent intent = getIntent();



            city_name = intent.getStringExtra("city_name");
            country_name = intent.getStringExtra("country_name");
            date_time_arr = intent.getStringArrayListExtra("city_dateTime");
            desc_arr = intent.getStringArrayListExtra("city_desc");
            feels_arr = intent.getStringArrayListExtra("city_feels");

            name_text.setText(city_name + ", " + country_name);

            for(int i = 0; i < date_time_arr.size(); i++) {
                Day day = new Day(date_time_arr.get(i),
                        desc_arr.get(i),
                        feels_arr.get(i));
                days.add(day);
            }

            // create a day adapter
            DayAdapter adapter = new DayAdapter(days);
            System.out.println(adapter.getItemCount());
            // attach the adapter to the recyclerView
            recyclerView.setAdapter(adapter);

            // set layoumanager
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            // use the method to load the data
            // for each JSONObject, create a Villager object and add to the list
//            JSONObject daysJSON = null;
//        try {
//            daysJSON = new JSONObject(loadJSONFromAsset("villagers.json"));
//            JSONArray daysArray = daysJSON.getJSONArray("villagers");
//            for(int i = 0; i < daysArray.length(); i++) {
//                JSONObject villagerObject = daysArray.getJSONObject(i);
//                Day day = new Day(villagerObject.getString("name"),
//                        villagerObject.getString("birthday"),
//                        villagerObject.getString("phrase"),
//                        villagerObject.getString("villager"),
//                        villagerObject.getString("house"));
//                villagers.add(villager);
//            }



//            city_weather = intent.getStringExtra("city_weather");
//            city_high = intent.getStringExtra("city_high");
//            city_low = intent.getStringExtra("city_low");
//            city_feels = intent.getStringExtra("city_feels");


//            desc_text.setText(city_weather);
//            high_text.setText(city_high);
//            low_text.setText(city_low);
//            feels_text.setText(city_feels);
    }
}
