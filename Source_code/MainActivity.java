package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent in=new Intent(MainActivity.this,Main.class);
                startActivity(in);
                finish();

            }
        },1000);
    }


}