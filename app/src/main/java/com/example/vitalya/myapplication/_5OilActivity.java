package com.example.vitalya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class _5OilActivity extends AppCompatActivity {

    Button MainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._5activity_oil);

        MainMenu.findViewById(R.id.buttonMainMenu);
        MainMenu=findViewById(R.id.buttonMainMenu);
        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToMainMenu = new Intent(_5OilActivity.this, _1HomeActivity.class);
                startActivity(GoToMainMenu);
            }
        });
    }
}
