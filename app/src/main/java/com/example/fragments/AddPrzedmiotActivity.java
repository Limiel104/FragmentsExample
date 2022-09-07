package com.example.fragments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class AddPrzedmiotActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DataBaseHelper dataBaseHelper;
    EditText et_nazwa, et_rok, et_temat, et_data, et_sala;
    Spinner et_typ;
    Button btnAdd;
    String selected = "Wykład";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_przedmiot);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dodaj nowy przedmiot");

        dataBaseHelper = new DataBaseHelper(AddPrzedmiotActivity.this);
        btnAdd = findViewById(R.id.btnAdd);

        et_nazwa = findViewById(R.id.addNazwa);
        et_rok = findViewById(R.id.addRok);
        et_temat = findViewById(R.id.addTemat);
        et_data = findViewById(R.id.addData);
        et_sala = findViewById(R.id.addSala);
        et_typ = (Spinner) findViewById(R.id.addTyp);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(AddPrzedmiotActivity.this, R.array.typy, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        et_typ.setAdapter(arrayAdapter);

        et_typ.setOnItemSelectedListener(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int rok = 0, sala =0;

                String nazwa = et_nazwa.getText().toString();
                String temat = et_temat.getText().toString();
                String data = et_data.getText().toString();


                if (nazwa.isEmpty() || temat.isEmpty() || data.isEmpty()) {
                    Toast.makeText(AddPrzedmiotActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                }
                else {
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    try {


                        if (!et_rok.getText().toString().isEmpty()) {
                            rok = Integer.valueOf(et_rok.getText().toString());
                        }
                        else {
                            Toast.makeText(AddPrzedmiotActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                        }


                        if (!et_sala.getText().toString().isEmpty()) {
                            sala = Integer.parseInt(et_sala.getText().toString());
                        }
                        else {
                            Toast.makeText(AddPrzedmiotActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();

                        }

                        if (sala > 0 && rok > 0) {

                            Date date1 = dateFormat.parse(data);
                            long date2 = date1.getTime() / 1000;
                            int data2 = (int) date2;
                            Przedmiot przedmiot = new Przedmiot(-1, nazwa, rok, temat, data2, sala, selected);
                            dataBaseHelper.addPrzedmiot(przedmiot);

                            Intent intent = new Intent(AddPrzedmiotActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selected = (String) parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        selected = "Ćwiczenia";
    }


}