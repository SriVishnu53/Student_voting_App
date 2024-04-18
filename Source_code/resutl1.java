package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class resutl1 extends AppCompatActivity {
    ImageView b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resutl1);
        b1=findViewById(R.id.imageView);
        b2=findViewById(R.id.imageView2);
        b3=findViewById(R.id.imageView3);
        b4=findViewById(R.id.imageView4);
    }
    public void sec(View v){
        Intent in=new Intent(resutl1.this,resultsec.class);
        startActivity(in);
    }
    public void join(View v){
        Intent in=new Intent(resutl1.this,Result2.class);
        startActivity(in);
    }
    public void dance(View v){
        Intent in=new Intent(resutl1.this,Result3.class);
        startActivity(in);
    }
    public void sport(View v){
        Intent in=new Intent(resutl1.this,Result4.class);
        startActivity(in);
    }

}