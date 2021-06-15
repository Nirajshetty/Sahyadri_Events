package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Student_Registrations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registrations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}