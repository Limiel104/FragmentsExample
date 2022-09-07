package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrzedmiotDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrzedmiotDetailFragment extends Fragment {

    private long przedmiotID;
    DataBaseHelper dataBaseHelper;
    Button btnEdit, btnList, btnDelete;
    public final static String EXTRA_ITEM_ID = "Item id";


    public void setPrzedmiotID(long id){
        this.przedmiotID = id;
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PrzedmiotDetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PrzedmiotDetailFragment newInstance(String param1, String param2) {
        PrzedmiotDetailFragment fragment = new PrzedmiotDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_przedmiot_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        btnList = view.findViewById(R.id.btnList);
        btnDelete = view.findViewById(R.id.btnDeletePrzedmiot);
        btnEdit = view.findViewById(R.id.btnEditPrzedmiot);
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        dataBaseHelper = new DataBaseHelper(view.getContext());
        ArrayList<Przedmiot> przedmioty = dataBaseHelper.getAllPrzedmiots();
        ArrayList<Przedmiot> przedmiotyDoPokazania = new ArrayList<>();

        Collections.sort(przedmioty, Przedmiot::compareTo);

        int czas = (int) (new Date().getTime()/1000);
        Log.e("czas2",String.valueOf(czas));

        for (int j = 0; j < przedmioty.size(); j++){
            if (czas < przedmioty.get(j).getData()){
                przedmiotyDoPokazania.add(przedmioty.get(j));
            }
        }

        if(przedmioty != null) {

            for (int i = 0; i < przedmiotyDoPokazania.size(); i++) {
                String data = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date(przedmioty.get(i).getData() * 1000L));
                HashMap<String, String> maplist;
                maplist = new HashMap<String, String>();
                maplist.put("line1", przedmiotyDoPokazania.get(i).getNazwa());
                maplist.put("line2", data);
                list.add(maplist);
            }
        }

        if (view != null) {

            TextView textView = (TextView) view.findViewById(R.id.txtNAME);
            textView.setText(przedmiotyDoPokazania.get((int) przedmiotID).getNazwa());
            textView = view.findViewById(R.id.txtDATA);
            String data = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date(przedmiotyDoPokazania.get((int) przedmiotID).getData()*1000L));
            textView.setText(data);
            textView = view.findViewById(R.id.txtSALA);
            textView.setText("Sala: " + String.valueOf(przedmiotyDoPokazania.get((int) przedmiotID).getSala()));
            textView = view.findViewById(R.id.txtTYP);
            textView.setText("Typ Zajęć: " + przedmiotyDoPokazania.get((int) przedmiotID).getRodzajZajec());
            textView = view.findViewById(R.id.txtROK);
            textView.setText("Rok: " + String.valueOf(przedmiotyDoPokazania.get((int) przedmiotID).getRok()));
            textView = view.findViewById(R.id.txtTEMAT);
            textView.setText(przedmiotyDoPokazania.get((int) przedmiotID).getTematZajec());


            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), EditPrzedmiotActivity.class);
                    intent.putExtra(EXTRA_ITEM_ID, przedmiotyDoPokazania.get((int) przedmiotID).getPrzedmiotID());
                    startActivity(intent);
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dataBaseHelper.deletePrzedmiot(przedmiotyDoPokazania.get((int) przedmiotID));
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

            btnList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ListActivity.class);
                    intent.putExtra(EXTRA_ITEM_ID, przedmiotyDoPokazania.get((int) przedmiotID).getPrzedmiotID());
                    startActivity(intent);
                }
            });

        }

    }
}