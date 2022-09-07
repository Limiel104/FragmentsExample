package com.example.fragments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements PrzedmiotListFragment.Listener {

    Button buttonAdd, buttonEdit, buttonDelete;
    public final static String EXTRA_ITEM_ID = "Item id";
    DataBaseHelper dataBaseHelper;

    @Override
    public void itemClicked(long id) {

        PrzedmiotDetailFragment przedmiotDetailFragment = new PrzedmiotDetailFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        przedmiotDetailFragment.setPrzedmiotID(id);

        fragmentTransaction.replace(R.id.fragmentMain2, przedmiotDetailFragment);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lista Przedmiotów");

        buttonAdd = findViewById(R.id.btnAddPrzedmiot);
        buttonDelete = findViewById(R.id.btnDeletePrzedmiot);
        buttonEdit = findViewById(R.id.btnEditPrzedmiot);
        dataBaseHelper = new DataBaseHelper(MainActivity.this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPrzedmiotActivity.class);
                startActivity(intent);
            }
        });


    }
}