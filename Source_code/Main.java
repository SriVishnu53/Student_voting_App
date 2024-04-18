package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends AppCompatActivity {
ImageView b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (ImageView) findViewById(R.id.imageView);
        b2 = (ImageView) findViewById(R.id.imageView2);

    }

    public void stu(View v) {
        Intent in = new Intent(Main.this, student.class);
        startActivity(in);
    }

    public void ad(View v) {
        Intent in = new Intent(Main.this, admin.class);
        startActivity(in);
    }
}