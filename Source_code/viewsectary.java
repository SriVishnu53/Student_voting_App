package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewsectary extends AppCompatActivity {
    TextView t1,t2,t3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsectary);
        t1=findViewById(R.id.s2);
        t1.setText(getIntent().getExtras().getString("name"));
        t2=findViewById(R.id.s3);
        t2.setText(getIntent().getExtras().getString("reg"));
        t3=findViewById(R.id.s4);
        t3.setText(getIntent().getExtras().getString("mob"));
    }
    public void click(View v) {
        Intent in=new Intent(viewsectary.this,viewsecretary.class);
        startActivity(in);

    }
}