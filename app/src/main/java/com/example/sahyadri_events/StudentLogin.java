package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentLogin extends AppCompatActivity {
    TextView clickhere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        clickhere=findViewById(R.id.clickhere);
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentRegister();
            }
        });
    }
    public void openStudentRegister(){
        Intent intent=new Intent(this, StudentRegister.class);
        startActivity(intent);
    }
}