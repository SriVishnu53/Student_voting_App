package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class admin2 extends AppCompatActivity {
ImageView c,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        c=findViewById(R.id.candidate);
        r=findViewById(R.id.result);
    }
    public void one(View v){
        Intent in=new Intent(admin2.this, candidates.class);
        startActivity(in);
    }
    public void two(View v){
        Intent in=new Intent(admin2.this, resutl1.class);
        startActivity(in);
    }
}