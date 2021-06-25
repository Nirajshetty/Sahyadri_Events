package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentRegisterEvent extends AppCompatActivity {
Button btn_back5,btn_student_event_register;
private AutoCompleteTextView student_event_id;
    private ArrayList<String> event_ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register_event);
        student_event_id=findViewById(R.id.student_event_id);
        DBHelper db =new DBHelper(this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        event_ids=db.getAllEventId();
        ArrayAdapter<String> array=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,event_ids);
        student_event_id.setAdapter(array);


        btn_student_event_register=findViewById(R.id.btn_student_event_register);
        btn_back5=findViewById(R.id.btn_back5);
        btn_back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentHome(str);
            }
        });

        btn_student_event_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sEvent_id=student_event_id.getText().toString();
                if(sEvent_id.equals(""))
                {
                    Toast.makeText(StudentRegisterEvent.this,"Please Enter all the Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUser=db.checkEvent_id(sEvent_id);
                    if(checkUser) {
                        Boolean checkInserted = db.insertRegisterDetails(str, sEvent_id);
                        if (checkInserted == true) {
                            Toast.makeText(StudentRegisterEvent.this, "Event Registered Successfully!", Toast.LENGTH_SHORT).show();
                            openStudentHome(str);
                        } else {
                            Toast.makeText(StudentRegisterEvent.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(StudentRegisterEvent.this, "Invalid Event-ID", Toast.LENGTH_SHORT).show();
                    }
                }
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