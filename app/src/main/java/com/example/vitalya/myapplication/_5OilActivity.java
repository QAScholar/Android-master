package com.example.vitalya.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class _5OilActivity extends AppCompatActivity implements View.OnClickListener {

    Button MainMenu;
    //private Spinner spinner1, spinner2;
    //Создаем переменные для вызова календаря
    private EditText callcalendar;
    private DatePickerDialog datepicker;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._5activity_oil);
        //Указываем формат даты
        dateFormatter=new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        //Создаем методы для запуска календаря
        findViewsByID();
        setDateTimeField();

        MainMenu = findViewById(R.id.buttonMainMenu);
        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToMainMenu = new Intent(_5OilActivity.this, _1HomeActivity.class);
                startActivity(GoToMainMenu);
            }
        });
//
    }
    private void findViewsByID() {
        callcalendar=(EditText) findViewById(R.id.editTextCalendar);
        callcalendar.setInputType(InputType.TYPE_NULL);
        callcalendar.requestFocus();
    }
    private void setDateTimeField() {
        callcalendar.setOnClickListener(this);
        Calendar newCalendar=Calendar.getInstance();
        datepicker=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate=Calendar.getInstance();
                newDate.set(year,month,dayOfMonth);
                callcalendar.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View view) {
        if(view == callcalendar) {
            datepicker.show();
        }
    }

    
}

