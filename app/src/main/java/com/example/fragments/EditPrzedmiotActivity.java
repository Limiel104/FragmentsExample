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
import java.util.Date;

public class EditPrzedmiotActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DataBaseHelper dataBaseHelper;
    EditText et_nazwaEd, et_rokEd, et_tematEd, et_dataEd, et_salaEd;
    Spinner et_typEd;
    Button btnEdit;
    String selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_przedmiot);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Edytuj przedmiot");

        int przedmiotID = getIntent().getExtras().getInt(MainActivity.EXTRA_ITEM_ID);

        dataBaseHelper = new DataBaseHelper(EditPrzedmiotActivity.this);

        Przedmiot przedmiot = dataBaseHelper.findPrzedmiot(przedmiotID);

        selected = przedmiot.tematZajec;

        btnEdit = findViewById(R.id.btnEdit);

        et_nazwaEd = findViewById(R.id.editNazwa);
        et_nazwaEd.setText(przedmiot.getNazwa());
        et_rokEd = findViewById(R.id.editRok);
        et_rokEd.setText(String.valueOf(przedmiot.getRok()));
        et_tematEd = findViewById(R.id.editTemat);
        et_tematEd.setText(przedmiot.getTematZajec());
        et_salaEd = findViewById(R.id.editSala);
        et_salaEd.setText(String.valueOf(przedmiot.getSala()));
        et_typEd = findViewById(R.id.editTyp);
        et_dataEd = findViewById(R.id.editData);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(EditPrzedmiotActivity.this, R.array.typy, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        et_typEd.setAdapter(arrayAdapter);

        et_typEd.setOnItemSelectedListener(this);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String data = dateFormat.format(przedmiot.getData()*1000L);
        et_dataEd.setText(data);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int rok = przedmiot.getRok(), sala = przedmiot.getSala();

                String nazwa = et_nazwaEd.getText().toString();
                String temat = et_tematEd.getText().toString();
                String data = et_dataEd.getText().toString();

                if (nazwa.isEmpty() || temat.isEmpty() || data.isEmpty()) {
                    Toast.makeText(EditPrzedmiotActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                }
                else {
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    try {


                        if (!et_rokEd.getText().toString().isEmpty()) {
                            rok = Integer.valueOf(et_rokEd.getText().toString());
                        }
                        else {
                            Toast.makeText(EditPrzedmiotActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                        }


                        if (!et_salaEd.getText().toString().isEmpty()) {
                            sala = Integer.parseInt(et_salaEd.getText().toString());
                        }
                        else {
                            Toast.makeText(EditPrzedmiotActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                        }

                        if (sala > 0 && rok > 0) {

                            Date date1 = dateFormat.parse(data);
                            long date2 = date1.getTime() / 1000;
                            int data2 = (int) date2;
                            Przedmiot przedmiotNowy = new Przedmiot(przedmiotID, nazwa, rok, temat, data2, sala, selected);
                            dataBaseHelper.updatePrzedmiot(przedmiotNowy);

                            Intent intent = new Intent(EditPrzedmiotActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
        selected = (String) parent.getItemAtPosition(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}