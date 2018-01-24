package com.example.vitalya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;

public class _1HomeActivity extends AppCompatActivity {
    Button buttonAdd;
    Button buttonStats;
    Button buttonReset;

    //переменные для отображения топлива

    TextView expenses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1activity_home);
        buttonAdd = findViewById(R.id.Add);
        buttonStats = findViewById(R.id.Stats);
        buttonReset = findViewById(R.id.Reset);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnSelect=new Intent(_1HomeActivity.this,_2SelectionActivity.class);
                startActivity(opnSelect);
            }
        });

        buttonStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnStats=new Intent(_1HomeActivity.this,_7StatsActivity.class);
                startActivity(opnStats);
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFile("mytextfile.txt");
                recreate();
            }
        });

//        //Отображаем значение стоимости заправленного топлива в поле editMoney
//        expenses = findViewById(R.id.textMoney);
//        try {
//            FileInputStream fileIn = openFileInput("mytextfile.txt");
//            InputStreamReader InputRead = new InputStreamReader(fileIn);
//
//            char[] inputBuffer = new char[READ_BLOCK_SIZE];
//            String s = "";
//            int charRead;
//            while ((charRead = InputRead.read(inputBuffer)) > 0) {
//                // char to string conversion
//                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
//                s += readstring;
//            }
//            InputRead.close();
//            // Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
//            expenses.setText(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        ResultSet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteFile("mytextfile.txt");
//                recreate();
//
    }
}







