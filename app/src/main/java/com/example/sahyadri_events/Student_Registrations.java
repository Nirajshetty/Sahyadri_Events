package com.example.sahyadri_events;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Student_Registrations extends AppCompatActivity {
Button btn_back4;
int i=1;
RecyclerView student_recycler;
ArrayList<String>  id,event_name,event_id_recycler,event_link;
    CustomAdapter customAdapter;
    DBHelper db=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registrations);

        Intent intent = getIntent();
        String mail = intent.getStringExtra("message_key");

        student_recycler=findViewById(R.id.student_recycler);

        btn_back4=findViewById(R.id.btn_back4);
        btn_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentHome(mail);
            }
        });

        event_name = new ArrayList<>();
        event_id_recycler = new ArrayList<>();
        event_link= new ArrayList<>();
        id=new ArrayList<>();

        storeDataInArrays(mail);

        customAdapter = new CustomAdapter(Student_Registrations.this,this,id,event_name,event_id_recycler,event_link);
        student_recycler.setHasFixedSize(true);
        student_recycler.setLayoutManager(new LinearLayoutManager(this));
        student_recycler.setAdapter(customAdapter);
    }

    void storeDataInArrays(String mail){
        Cursor cursor = db.readStudentRegisteredEventData(mail);
        if(cursor.getCount() == 0){
            Toast.makeText(Student_Registrations.this,"No Registrations found",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()) {
                id.add(String.valueOf(i++));
                event_name.add(cursor.getString(0));
                event_id_recycler.add(cursor.getString(2));
                event_link.add(cursor.getString(4));
            }
        }
    }
    public void openStudentHome(String str){
        Intent intent4=new Intent(getApplicationContext(), StudentLandingPage.class);
        intent4.putExtra("message_key", str);
        startActivity(intent4);
        finish();
    }
}