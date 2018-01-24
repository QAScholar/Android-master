package com.example.vitalya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class _7StatsActivity extends AppCompatActivity {
    Button MainMenu;
    TextView TotalLitresValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._7activity_stats);




        MainMenu=findViewById(R.id.buttonMainMenu);
        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainMenu=new Intent(_7StatsActivity.this,_1HomeActivity.class);
                startActivity(MainMenu);
            }
        });
    }
}
