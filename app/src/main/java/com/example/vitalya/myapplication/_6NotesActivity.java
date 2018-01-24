package com.example.vitalya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class _6NotesActivity extends AppCompatActivity {
    Button buttonSave;
    Button buttonMainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._6activity_notes);
        buttonMainMenu=findViewById(R.id.buttonMainMenu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToMainMenu=new Intent(_6NotesActivity.this,_1HomeActivity.class);
                startActivity(GoToMainMenu);
            }
        });
    }
}
