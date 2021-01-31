package com.example.classactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private Button go_button;
    private EditText editText_city;

    private static final String api_key = "8c8635879855e02e04a57ffa2607a6c0";
    private static String api_url = "http://api.openweathermap.org/data/2.5/weather?q=";
//    api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_button = findViewById(R.id.go_button);
        editText_city = findViewById(R.id.city_editText);

        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });
    }

    public void launchNextActivity(View view) {
        // create an intent and pass the city name to the next activity
        Intent intent = new Intent(this, SecondActivity.class);
        String city = editText_city.getText().toString();

        String city_url = api_url + city + "&units=imperial&appid=" + api_key;

        // set the header because of the api endpoint
        client.addHeader("Accept", "application/json");
        // send a get request to the api url
        client.get(city_url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                // when you get a 200 status code

                try {
                    JSONObject json = new JSONObject(new String(responseBody));
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("city_name", json.getString("name"));
                    intent.putExtra("country_name", json.getJSONObject("sys").getString("country"));
                    intent.putExtra("city_weather", json.getJSONArray("weather").getJSONObject(0).getString("description"));
                    intent.putExtra("city_high", json.getJSONObject("main").getString("temp_max"));
                    intent.putExtra("city_low", json.getJSONObject("main").getString("temp_min"));
                    intent.putExtra("city_feels", json.getJSONObject("main").getString("feels_like"));

                    Log.d("api_error", "error with intent");
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                // when you get a 400-499 status code
                Log.e("api error", new String(responseBody));
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String message = "No city found.";
                intent.putExtra("no_city", message);

                startActivity(intent);
            }
        });
    }
}