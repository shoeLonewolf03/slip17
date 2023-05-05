package com.example.slip16q2;

import static java.util.Calendar.HOUR_OF_DAY;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    TimePicker timepicker;
    Button changetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=(TextView) findViewById(R.id.TV1);
        timepicker=(TimePicker) findViewById(R.id.TP);
        //uncomment the below line of code for 24 hour view
        timepicker.setIs24HourView(true);
        changetime=(Button)findViewById(R.id.B1);
        textview.setText(getCurrentTime());
        changetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(getCurrentTime());
            }
        });
    }

    public String getCurrentTime()
    {
        String currentTime="Current Time:"+timepicker.getCurrentHour()+":"+timepicker.getCurrentMinute();
        return currentTime;
    }



    }
