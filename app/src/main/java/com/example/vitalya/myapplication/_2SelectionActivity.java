package com.example.vitalya.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class _2SelectionActivity extends AppCompatActivity {

    Button buttonFuel;
    Button buttonRepairs;
    Button buttonOil;
    Button buttonNotes;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2activity_selection);

        buttonFuel=findViewById(R.id.Fuel);
        buttonRepairs=findViewById(R.id.Repairs);
        buttonOil=findViewById(R.id.Oil);
        buttonNotes=findViewById(R.id.Notes);
        buttonMenu=findViewById(R.id.buttonMainMenu);

        buttonFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnRefuel=new Intent(_2SelectionActivity.this,_3RefuelingActivity.class);
                startActivity(opnRefuel);
            }
        });
        buttonRepairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnRepairs=new Intent(_2SelectionActivity.this,_4RepairsActivity.class);
                startActivity(opnRepairs);
            }
        });
        buttonOil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnOil=new Intent(_2SelectionActivity.this,_5OilActivity.class);
                startActivity(opnOil);
            }
        });
        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnNotes=new Intent(_2SelectionActivity.this,_6NotesActivity.class);
                startActivity(opnNotes);
            }
        });
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opnMenu=new Intent(_2SelectionActivity.this,_1HomeActivity.class);
                startActivity(opnMenu);
            }
        });
    }
}
