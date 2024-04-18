package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class student extends AppCompatActivity {
    EditText username, password;
    Button btnlogin, stureg;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnlogin = findViewById(R.id.btnsignin1);
        stureg = findViewById(R.id.reg);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(student.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkuserpass = DB.checkstunamepassword(user, pass);
                    if (checkuserpass) {
                        Intent intent = new Intent(student.this, leader.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(student.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        stureg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student.this, sturegistration.class);
                startActivity(intent);
            }
        });
    }
}
