package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class StudentLoginPage extends AppCompatActivity {
    TextView clickhere;
    EditText mail,password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);
        mail=findViewById(R.id.mail);
        password=findViewById(R.id.password);
        btn_login=findViewById(R.id.btn_student_login);
        DBHelper db =new DBHelper(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailTXT=mail.getText().toString();
                String passwordTXT=password.getText().toString();
                if(mail.equals("") || password.equals(""))
                {
                    Toast.makeText(StudentLoginPage.this,"Please Enter all the Details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkInserted = db.checkAuthentication(mailTXT, passwordTXT);
                    if (checkInserted) {
                        Toast.makeText(StudentLoginPage.this, "Successfully Logged in!", Toast.LENGTH_SHORT).show();
                        openStudentHomepage();
                    } else {
                        Toast.makeText(StudentLoginPage.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        clickhere=findViewById(R.id.clickhere);
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudentRegister();
            }
        });
    }
    public void openStudentRegister(){
        Intent intent1=new Intent(this, StudentRegister.class);
        startActivity(intent1);
    }
    public void openStudentHomepage(){
        String mailTXT=mail.getText().toString();
        Intent intent3=new Intent(getApplicationContext(), StudentLandingPage.class);
        intent3.putExtra("message_key", mailTXT);
        startActivity(intent3);
        finish();
    }
}