package com.example.notesport;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class CSE_Stream_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CSE_Stream_Fragment() {

    }

    public static CSE_Stream_Fragment newInstance(String param1, String param2) {
        CSE_Stream_Fragment fragment = new CSE_Stream_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_c_s_e__stream_, container, false);
        String[] years ={"First Year","Second Year", "Third Year", "Fourth Year"};
        Spinner spinner_for_year = view.findViewById(R.id.spinner_for_year);
        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_dropdown_item_1line,years);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_for_year.setAdapter(adapter_year);
        spinner_for_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String year_selected = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity().getApplicationContext(),year_selected ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("CSE Stream");

    }
}