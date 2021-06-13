package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentRegisterEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register_event);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}