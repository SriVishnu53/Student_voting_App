package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adregistration extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    DBHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adregistration);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        DB = new DBHelper2(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String repass = repassword.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                    Toast.makeText(adregistration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidUsername(user)) {
                    Toast.makeText(adregistration.this, "Invalid username format", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidPassword(pass)) {
                    Toast.makeText(adregistration.this, "Invalid password format", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass.equals(repass)) {
                    Toast.makeText(adregistration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean checkuser = DB.checkusername(user);
                if (checkuser) {
                    Toast.makeText(adregistration.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insert = DB.insertData(user, pass, repass);
                    if (insert) {
                        Intent intent = new Intent(adregistration.this, admin.class);
                        startActivity(intent);
                        Toast.makeText(adregistration.this, "Registered successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(adregistration.this, "Registration failed", Toast.LENGTH_SHORT).show();
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
