 package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class viewsport extends AppCompatActivity {
    ContentValues val = new ContentValues();
    ListView lst;
    String arrname[], arrreg[], arrmobile[];
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsport);
        lst = findViewById(R.id.listview);
        db = openOrCreateDatabase("database4.db", Context.MODE_PRIVATE, null);
        Cursor c = db.query("leader4", null, null, null, null, null, null);
        arrname = new String[c.getCount()];
        arrreg = new String[c.getCount()];
        arrmobile = new String[c.getCount()];
        c.moveToFirst();
        for (int i = 0; i < arrname.length; i++) {
            arrname[i] = c.getString(0);
            arrreg[i] = c.getString(1);
            arrmobile[i]=c.getString(2);
            c.moveToNext();
        }
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrname);
        lst.setAdapter(adp);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str1=lst.getAdapter().getItem(position).toString();

                Intent in=new Intent(getApplicationContext(),viewsportsec.class);
                in.putExtra("name",arrname[position]);
                in.putExtra("reg",arrreg[position]);
                in.putExtra("mob",arrmobile[position]);

                startActivity(in);

            }
        });
    }
    public void click(View v){
        Intent in=new Intent(viewsport.this, voting4.class);
        startActivity(in);

    }

}


















