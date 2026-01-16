package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
ListView cityList;
ArrayAdapter<String> cityAdapter;

EditText input_city;
ArrayList<String> dataList;
    Button addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        input_city = findViewById(R.id.input_city);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        cityList = findViewById(R.id.city_list);
        String[] cities = {"Edmonton", "Calgary", "Toronto", "Winniepeg", "London"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        addbutton = findViewById(R.id.button_add);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String city = input_city.getText().toString().trim();

                if (city.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a city", Toast.LENGTH_SHORT).show();
                    return;
                }

                dataList.add(city);
                cityAdapter.notifyDataSetChanged();
                input_city.setText(""); //empty after enter
            }

        });


    }

}