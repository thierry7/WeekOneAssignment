package com.thierryoke.weeklyassignement_one;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NextPage extends AppCompatActivity {

    Spinner spnr_countries;
    DatePickerDialog datePicker;
    Button btn_pickdate;
    EditText et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        spnr_countries = findViewById(R.id.spn_countries);
        btn_pickdate = findViewById(R.id.btn_choosebrith);
        et_age =findViewById(R.id.et_user_age);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr_countries.setAdapter(adapter);

        btn_pickdate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int myear = cldr.get(Calendar.YEAR);
                int mmonth = cldr.get(Calendar.MONTH);
                int mday = cldr.get(Calendar.DAY_OF_MONTH);
                int current_year = cldr.get(Calendar.YEAR);

                datePicker = new DatePickerDialog(NextPage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_age.setText(" " + (current_year-year));}


                    }, myear, mmonth, mday);
                datePicker.show();



            }
        });

        }



}