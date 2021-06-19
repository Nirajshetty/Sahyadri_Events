package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_Registrations extends AppCompatActivity {
Button btn_back4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registrations);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        btn_back4=findViewById(R.id.btn_back4);
        btn_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentHome(str);
            }
        });
    }
    public void openStudentHome(String str){
        Intent intent4=new Intent(getApplicationContext(), StudentLandingPage.class);
        intent4.putExtra("message_key", str);
        startActivity(intent4);
        finish();
    }
}