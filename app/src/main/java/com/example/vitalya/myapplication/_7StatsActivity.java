package com.example.vitalya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class _7StatsActivity extends AppCompatActivity {
    Button MainMenu;
    TextView TotalLitresValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._7activity_stats);

        TotalLitresValue=findViewById(R.id.TotalLitresValue);
        String a = "";
        try {
            FileInputStream fis = new FileInputStream("file.txt");

            fis.read(a.toString().getBytes());
            fis.close();
        }catch (IOException e) {
            e.toString();
        }
        TotalLitresValue.setText(a);
        MainMenu=findViewById(R.id.buttonMainMenu2);
        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainMenu=new Intent(_7StatsActivity.this,_1HomeActivity.class);
                startActivity(MainMenu);
            }
        });
    }
}
