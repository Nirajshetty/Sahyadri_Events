package com.example.sahyadri_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRegister extends AppCompatActivity {
    EditText mail,name,password;
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        mail=findViewById(R.id.mail);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);

        btn_register=findViewById(R.id.btn_admin_login);
        DBHelper db =new DBHelper(this);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailTXT=mail.getText().toString();
                String nameTXT=name.getText().toString();
                String passwordTXT=password.getText().toString();
                if(mailTXT.equals("") || nameTXT.equals("") || passwordTXT.equals(""))
                {
                    Toast.makeText(StudentRegister.this,"Please Enter all the Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUser=db.checkMail(mailTXT);
                    if(checkUser==false)
                    {
                        Boolean checkInserted =db.insertStudentDetails(mailTXT,nameTXT,passwordTXT);
                        if(checkInserted==true)
                        {
                            Toast.makeText(StudentRegister.this,"Successfully Registered!",Toast.LENGTH_SHORT).show();
                            openStudentLogin();
                        }
                        else
                        {
                            Toast.makeText(StudentRegister.this,"Registration failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(StudentRegister.this,"User Already Exists!",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
    public void openStudentLogin(){
        Intent intent=new Intent(this, StudentLogin.class);
        startActivity(intent);
    }
}