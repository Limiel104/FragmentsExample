package com.example.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class PrzedmiotListFragment extends ListFragment {

    DataBaseHelper dataBaseHelper;

    public PrzedmiotListFragment() {
        // Required empty public constructor
    }

    static interface Listener{
        void itemClicked(long id);
    }

    private Listener listener;

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        listener = (Listener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int position, long id){
        if (listener != null){
            listener.itemClicked(id);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        dataBaseHelper = new DataBaseHelper(inflater.getContext());

        ArrayList<Przedmiot> przedmioty = new ArrayList();
        ArrayList<Przedmiot> przedmiotyDoPokazania = new ArrayList<>();
        przedmioty = dataBaseHelper.getAllPrzedmiots();

        Collections.sort(przedmioty, Przedmiot::compareTo);

        int czas = (int) (new Date().getTime()/1000);
        Log.e("czas",String.valueOf(czas));

        for (int j = 0; j < przedmioty.size(); j++){
            if (czas < przedmioty.get(j).getData()){
                przedmiotyDoPokazania.add(przedmioty.get(j));
            }
        }

        if(przedmioty != null) {

            for (int i = 0; i < przedmiotyDoPokazania.size(); i++) {
                String data = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date(przedmiotyDoPokazania.get(i).getData()*1000L));
                HashMap<String, String> maplist;
                maplist = new HashMap<String, String>();
                maplist.put("line1", przedmiotyDoPokazania.get(i).getNazwa());
                maplist.put("line2", data);
                list.add(maplist);
            }

            String[] from = {"line1", "line2"};
            int[] to = {android.R.id.text1, android.R.id.text2};

            SimpleAdapter adapter = new SimpleAdapter(inflater.getContext(), list, android.R.layout.simple_list_item_2, from, to);
            setListAdapter(adapter);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}