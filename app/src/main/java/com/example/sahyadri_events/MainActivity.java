package com.example.sahyadri_events;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_admin=  findViewById(R.id.btn_admin);
        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAdminLogin();
            }
        });
    }
    public void openAdminLogin(){
        Intent intent=new Intent(this,AdminLogin.class);
        startActivity(intent);
    }
}