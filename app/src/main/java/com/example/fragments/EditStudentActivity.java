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

public class EditStudentActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText et_nazwiskoEd, et_imieEd, et_emailEd;
    Button btnEditSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Edytuj Studenta");

        dataBaseHelper = new DataBaseHelper(EditStudentActivity.this);
        btnEditSt = findViewById(R.id.btnEditStudent2);

        int studentID = getIntent().getExtras().getInt(MainActivity.EXTRA_ITEM_ID);
        Student student = dataBaseHelper.findStudent(studentID);

        et_nazwiskoEd = findViewById(R.id.editNazwisko);
        et_nazwiskoEd.setText(student.getNazwisko());
        et_imieEd = findViewById(R.id.editImie);
        et_imieEd.setText(student.getImie());
        et_emailEd = findViewById(R.id.editEMail);
        et_emailEd.setText(student.getEmail());

        btnEditSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nazwisko = et_nazwiskoEd.getText().toString();
                String imie = et_imieEd.getText().toString();
                String email = et_emailEd.getText().toString();

                if (nazwisko.isEmpty() || imie.isEmpty() || email.isEmpty()) {
                    Toast.makeText(EditStudentActivity.this, "Wszystkie pola muszą być wypełnione!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Student studentNowy = new Student(student.getStudentID(), nazwisko, imie, email, student.getPrzedID());
                    dataBaseHelper.updateStudent(studentNowy);

                    Intent intent = new Intent(EditStudentActivity.this, ListActivity.class);
                    intent.putExtra(EXTRA_ITEM_ID, student.getPrzedID());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}