package com.example.vitalya.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class _3RefuelingActivity extends AppCompatActivity implements View.OnClickListener  {
    EditText editTextL;
    EditText editTextR;
    EditText editTextKm;
    EditText editTextKm2;
    EditText editTextCalendar;
    TextView textViewRub;
    TextView textViewKml;
    Button buttonSave;
    Button buttonMainMenu;

    float num1 = 0;
    float num2 = 0;
    float num3 = 0;
    float result = 0;
    float result1 = 0;

    //Создаем переменные для вызова календаря
    private EditText callcalendar;
    private DatePickerDialog datepicker;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout._3activity_refueling);

        dateFormatter=new SimpleDateFormat("dd-MM-yyyy", Locale.US); //Указываем формат даты
        //Создаем методы для запуска календаря
        findViewsByID();
        setDateTimeField();

        editTextL = findViewById( R.id.editTextL );
        editTextR = findViewById( R.id.editTextR );
        editTextKm = findViewById( R.id.editTextKm );
        editTextKm2 = findViewById( R.id.editTextKm2 );
        editTextCalendar = findViewById( R.id.editTextCalendar );
        textViewRub = findViewById( R.id.textViewRub );
        textViewKml = findViewById( R.id.textViewKml );
        buttonSave = findViewById( R.id.buttonSave );

        buttonSave.setOnClickListener( new View.OnClickListener() {  //Кнопка для подсчета стоимости
            @Override
            public void onClick(View view) {
                //Проверяем если в поля "Заправлено" и "Цена за 1 литр" введены какие-либо значения и если нет, то выдаем предупреждения
                String warning1=editTextCalendar.getText().toString();//Переменная warning1 вводится для проверки поля "Даты"
                String warning2=editTextKm2.getText().toString(); //Переменная warning2 вводится для проверки поля "Общий пробег"
                String warning3=editTextKm.getText().toString(); //Переменная warning3 вводится для проверки поля "Пробег с последней заправки"
                String warning4=editTextL.getText().toString();  //Переменная warning4 вводится для проверки поля "Заправлено"
                String warning5=editTextR.getText().toString();  //Переменная warning5 вводится для проверки поля "Цена за 1 литр"

                String msgtext1="Введите дату";
                if(TextUtils.isEmpty(warning1)){
                    //Собственно само сообщение
                    editTextCalendar.setError(msgtext1);
                    return;
                }
                String msgtext2="Введите общий пробег";
                if(TextUtils.isEmpty(warning2)){
                    editTextKm2.setError(msgtext2);
                    return;
                }
                String msgtext3="Введите пробег с последней заправки";
                if(TextUtils.isEmpty(warning3)) {
                    editTextKm.setError( msgtext3);
                    return;
                }
                String msgtext4="Введите сколько заправлено";
                if(TextUtils.isEmpty(warning4)) {
                    editTextL.setError( msgtext4);
                    return;
                }
                String msgtext5="Введите цену за 1 литр";
                if(TextUtils.isEmpty(warning5)) {
                    editTextR.setError( msgtext5);
                    return;
                }
                //        http://blog.harrix.org/article/6706

                // читаем EditText и заполняем переменные числами
                num1 = Float.parseFloat(editTextL.getText().toString()); //Литры
                num2 = Float.parseFloat(editTextR.getText().toString()); //Литры
                num3 = Float.parseFloat(editTextKm.getText().toString()); //км
//                num4 = Float.parseFloat(editTextL.getText().toString());//Рубли

                result = num1 * num2;
                result1 = (num1/num3)*100;

                textViewKml.setText(result1+ " л./100км.");//Вывод на экран расхода
                textViewRub.setText(result + " руб. "); //Вывод на экран стоимости

                //Запись в файл
                try {
                    FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_APPEND);
//                    PrintStream printStream=new PrintStream(fileout);
//                    printStream.print(textViewRub.getText().toString()+"\n");
//                    fileout.close();
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    outputWriter.write(textViewRub.getText().toString()+"\n");
                    outputWriter.write(textViewKml.getText().toString()+"\n");
                    outputWriter.close();

                    //display file saved message
                    Toast.makeText(getBaseContext(), "Файл сохранен!",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        buttonMainMenu=findViewById(R.id.buttonMainMenu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToMainMenu=new Intent(_3RefuelingActivity.this,_1HomeActivity.class);
                startActivity(GoToMainMenu);
            }
        });
        // write text to file
        // add-write text into file
    }
    //Описываем методы
    private void findViewsByID(){
        callcalendar=(EditText) findViewById(R.id.editTextCalendar);
        callcalendar.setInputType(InputType.TYPE_NULL);
        callcalendar.requestFocus();
    }
    private void setDateTimeField(){
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








