package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText admin_id,admin_password;
    Button btn_admin_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        admin_id=findViewById(R.id.admin_id);
        admin_password=findViewById(R.id.admin_password);
        btn_admin_login=findViewById(R.id.btn_admin_login);
        DBHelper db =new DBHelper(this);
        btn_admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String admin_id_TXT=admin_id.getText().toString();
                String admin_password_TXT=admin_password.getText().toString();
                if(admin_id_TXT.equals("") || admin_password_TXT.equals(""))
                {
                    Toast.makeText(AdminLogin.this,"Please Enter all the Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkInserted = db.checkAdminAuthentication(admin_id_TXT, admin_password_TXT);
                    if (checkInserted == true) {
                        Toast.makeText(AdminLogin.this, "Successfully Logged in!", Toast.LENGTH_SHORT).show();
                        openAdminHome();
                    } else {
                        Toast.makeText(AdminLogin.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void openAdminHome(){
        Intent intent=new Intent(this, AdminHomePage.class);
        startActivity(intent);
        finish();
    }
}