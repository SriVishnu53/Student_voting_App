package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class admin extends AppCompatActivity {

    EditText un, ps;
    Button btnlogin, stureg;
    DBHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        un = (EditText) findViewById(R.id.adname);
        ps = (EditText) findViewById(R.id.adPassword);
        btnlogin = (Button) findViewById(R.id.button2);
        stureg = (Button) findViewById(R.id.button3);
        DB = new DBHelper2(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = un.getText().toString();
                String pass = ps.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(admin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkunamepassword(user, pass);
                    if (checkuserpass == true) {
                        Intent intent = new Intent(admin.this, admin2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(admin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        stureg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this, adregistration.class);
                startActivity(intent);
            }
        });
    }


}