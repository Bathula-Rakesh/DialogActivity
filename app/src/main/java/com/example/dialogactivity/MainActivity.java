package com.example.dialogactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    TextView data,time;
    int day,month,year,hours,minutes;
    Calendar calendar;
    Long tsLong;
    String ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=findViewById(R.id.Date);
        time=findViewById(R.id.Time);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void selectDate(View view) {
        calendar=Calendar.getInstance();

        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                data.setText(""+dayOfMonth+"/"+(1+month)+"/"+year);

            }
        },year,month,day);

        datePickerDialog.show();
    }

    public void selectTime(View view) {
        calendar=Calendar.getInstance();

        hours=calendar.get(Calendar.HOUR);
        minutes=calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(""+hourOfDay+":"+minute);

            }
        },hours,minutes,false);

        timePickerDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();


        //Get TimeStamp
         tsLong= System.currentTimeMillis()/1000;
         ts = tsLong.toString();


         //Convert TimeStamp to Date and Time
         calendar = Calendar.getInstance(Locale.ENGLISH);
         calendar.setTimeInMillis(tsLong * 1000);
         String date = DateFormat.format("dd-MM-yyyy", calendar).toString();
         String time1 = DateFormat.format("HH:mm:ss", calendar).toString();
         data.setText(""+date);
         time.setText(""+time1);




    }
}