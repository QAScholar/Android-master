package com.example.vitalya.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class _4RepairsActivity extends AppCompatActivity implements View.OnClickListener {
    final String LOG_TAG = "myLogs";
    final String FILENAME = "file";

    EditText editTextRep;
    EditText editDetal;

    Button buttonSave;
    Button buttonMainMenu;

    float num1 = 0;
    float num2 = 0;
    float result = 0;

    //Создаем переменные для вызова календаря
    private EditText callcalendar;
    private DatePickerDialog datepicker;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._4activity_repairs);

        //Указываем формат даты
        dateFormatter=new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        //Создаем методы для запуска календаря
        findViewsByID();
        setDateTimeField();

        editTextRep = findViewById( R.id.editTextRep );
        editDetal = findViewById( R.id.editDetal );

        buttonSave = findViewById( R.id.buttonSave );
        buttonMainMenu=findViewById(R.id.buttonMainMenu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToMainMenu = new Intent(_4RepairsActivity.this, _1HomeActivity.class);
                startActivity(GoToMainMenu);
            }
        });
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
    public void onClick(View v) {
        if(v == callcalendar) {
            datepicker.show();
        }
    }
}