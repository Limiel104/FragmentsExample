package com.example.fragments;

import static com.example.fragments.MainActivity.EXTRA_ITEM_ID;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText et_nazwisko, et_imie, et_email;
    Button btnAddSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dodaj nowego studenta");

        dataBaseHelper = new DataBaseHelper(AddStudentActivity.this);
        btnAddSt = findViewById(R.id.btnAddStudent2);

        int przedmiotID = getIntent().getExtras().getInt(MainActivity.EXTRA_ITEM_ID);

        et_nazwisko = findViewById(R.id.addNazwisko);
        et_imie = findViewById(R.id.addImie);
        et_email = findViewById(R.id.addEMail);

        btnAddSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nazwisko = et_nazwisko.getText().toString();
                String imie = et_imie.getText().toString();
                String email = et_email.getText().toString();

                if (nazwisko.isEmpty() || imie.isEmpty() || email.isEmpty()) {
                    Toast.makeText(AddStudentActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Student student = new Student(-1, nazwisko, imie, email, przedmiotID);
                    dataBaseHelper.addStudent(student);

                    Intent intent = new Intent(AddStudentActivity.this, ListActivity.class);
                    intent.putExtra(EXTRA_ITEM_ID, przedmiotID);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}