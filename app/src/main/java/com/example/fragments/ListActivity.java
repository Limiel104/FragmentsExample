package com.example.fragments;

import static com.example.fragments.MainActivity.EXTRA_ITEM_ID;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    Button buttonDodaj;
    ListView listView;
    boolean lock = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lista Studentów");

        dataBaseHelper = new DataBaseHelper(ListActivity.this);
        buttonDodaj = findViewById(R.id.btnAddStudent);
        listView = findViewById(R.id.list);

        int przedmiotID = getIntent().getExtras().getInt(EXTRA_ITEM_ID);

        ArrayList<Student> arrayList = dataBaseHelper.getAllStudentsFromPrzedmiot(przedmiotID);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < arrayList.size(); i++) {
            HashMap<String, String> maplist;
            maplist = new HashMap<String, String>();
            maplist.put("line1", arrayList.get(i).getNazwisko() + " " + arrayList.get(i).getImie());
            maplist.put("line2", arrayList.get(i).getEmail());
            list.add(maplist);
        }

        String[] from = {"line1", "line2"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(ListActivity.this, list, android.R.layout.simple_list_item_2, from, to);
        listView.setAdapter(adapter);
        Log.e("sad", "" + arrayList.toString());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if (lock != true) {
                    int studentID = arrayList.get(position).getStudentID();
                    Intent intent = new Intent(ListActivity.this, EditStudentActivity.class);
                    intent.putExtra(EXTRA_ITEM_ID, studentID);
                    startActivity(intent);
                    finish();
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                lock = true;

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListActivity.this);
                alertDialog.setMessage("Czy napewno chcesz usunąć rekord?").setCancelable(false).setPositiveButton("TAK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int studentID = arrayList.get(position).getStudentID();
                        dataBaseHelper.deleteStudent(dataBaseHelper.findStudent(studentID));

                        Intent intent = new Intent(ListActivity.this, ListActivity.class);
                        intent.putExtra(EXTRA_ITEM_ID, przedmiotID);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("NIE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lock = false;
                    }
                });

                AlertDialog alertDialog1 = alertDialog.create();
                alertDialog1.show();
                return false;
            }
        });

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, AddStudentActivity.class);
                intent.putExtra(EXTRA_ITEM_ID, przedmiotID);
                startActivity(intent);
                finish();
            }
        });

    }
}