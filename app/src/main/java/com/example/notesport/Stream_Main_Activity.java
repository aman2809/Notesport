package com.example.notesport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class Stream_Main_Activity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_stream_main);

        String Stream_Name=getIntent().getStringExtra("Stream_Name");
        toolbar = findViewById(R.id.toolbar_Stream_Page);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switch (Stream_Name)
        {
            case "Computer Science Engg.":
                fragment= new CSE_Stream_Fragment();
                break;
            case "Electrical Engg.":
                fragment=new ProfileFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container_for_stream_fragments,fragment).commit();
    }

}