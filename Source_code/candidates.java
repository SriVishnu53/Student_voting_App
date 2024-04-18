package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class candidates extends AppCompatActivity {
    ImageView b1,b2,b3,b4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);
        b1=findViewById(R.id.leader1);
        b2=findViewById(R.id.leader2);
        b3= findViewById(R.id.leader3);
        b4=findViewById(R.id.leader4);

    }
    public void sec(View v){
        Intent in= new Intent(candidates.this, secretary.class);
        startActivity(in);
    }
    public void join(View v){
        Intent in= new Intent(candidates.this, joinsec.class);
        startActivity(in);
    }
    public void dance(View v){
        Intent in= new Intent(candidates.this, cluture.class);
        startActivity(in);
    }
    public void sport(View v){
        Intent in= new Intent(candidates.this, sports.class);
        startActivity(in);
    }
}