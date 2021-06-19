package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentRegisterEvent extends AppCompatActivity {
Button btn_back5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register_event);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        btn_back5=findViewById(R.id.btn_back5);
        btn_back5.setOnClickListener(new View.OnClickListener() {
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