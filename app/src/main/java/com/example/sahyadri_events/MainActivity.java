package com.example.sahyadri_events;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_admin;
    private Button btn_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_admin=  findViewById(R.id.btn_admin);
        btn_student=  findViewById(R.id.btn_stu);
        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAdminLogin();
            }
        });
        btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentLogin();
            }
        });
    }
    public void openAdminLogin(){
        Intent intent=new Intent(this,AdminLogin.class);
        startActivity(intent);
    }
    public void openStudentLogin(){
        Intent intents=new Intent(this, StudentLoginPage.class);
        startActivity(intents);
    }
}