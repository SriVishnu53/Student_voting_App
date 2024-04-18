package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sturegistration extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sturegistration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup = findViewById(R.id.btnsignup);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String repass = repassword.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                    Toast.makeText(sturegistration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidUsername(user)) {
                    Toast.makeText(sturegistration.this, "Invalid username format", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidPassword(pass)) {
                    Toast.makeText(sturegistration.this, "Invalid password format", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass.equals(repass)) {
                    Toast.makeText(sturegistration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean checkuser = DB.checkstuname(user);
                if (checkuser) {
                    Toast.makeText(sturegistration.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insert = DB.insertData(user, pass, repass);
                    if (insert) {
                        Intent intent = new Intent(sturegistration.this, student.class);
                        startActivity(intent);
                        Toast.makeText(sturegistration.this, "Registered successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(sturegistration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean isValidUsername(String user) {
        // Check if username consists of 2 alphabets followed by 6 digits
        return user.matches("[a-zA-Z]{2}\\d{6}");
    }

    private boolean isValidPassword(String pass) {
        // Check if password contains only numbers and '/' and has a length of 10 characters
        return pass.matches("[0-9/]{10}");
    }
}
