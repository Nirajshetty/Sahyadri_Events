package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Admin_Registrations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registrations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}