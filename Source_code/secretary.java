package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secretary extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2, b3;
    DBHandler4 db;
    SQLiteDatabase sq;
    String name;
    String reg;
    String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.regno);
        e3 = findViewById(R.id.mobile);
        b1 = findViewById(R.id.insert);
        b2 = findViewById(R.id.update);
        b3 = findViewById(R.id.delete);
        db = new DBHandler4(this);
        sq = db.getWritableDatabase();
        sq = db.getReadableDatabase();
    }

    public void Insert(View view) {
        name = e1.getText().toString();
        reg = e2.getText().toString();
        mobile = e3.getText().toString();
        if (isValidInput(name, reg, mobile)) {
            ContentValues values = new ContentValues();
            values.put("Candidate_Name", name);
            values.put("Reg_NO", reg);
            values.put("Mobile_NO", mobile);
            sq.insert("leader4", null, values);
            Toast.makeText(this, "Candidate Added", Toast.LENGTH_SHORT).show();
        }
    }

    public void Update(View view) {
        name = e1.getText().toString();
        reg = e2.getText().toString();
        mobile = e3.getText().toString();
        if (isValidInput(name, reg, mobile)) {
            ContentValues values = new ContentValues();
            values.put("Candidate_Name", name);
            values.put("Reg_NO", reg);
            values.put("Mobile_NO", mobile);
            sq.update("leader4", values, "Reg_NO=?", new String[]{reg});
            Toast.makeText(this, "Candidate Updated", Toast.LENGTH_SHORT).show();
        }
    }

    public void Delete(View view) {
        reg = e2.getText().toString();
        if (!reg.isEmpty()) {
            sq.delete("leader4", "Reg_NO=?", new String[]{reg});
            Toast.makeText(this, "Candidate Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidInput(String name, String reg, String mobile) {
        // Check if name is not empty, reg is in the correct format, mobile is 10 digits long, and mobile consists only of numbers
        if (name.isEmpty() || !reg.matches("[a-zA-Z]{2}\\d{6}") || mobile.isEmpty() || mobile.length() != 10 || !mobile.matches("\\d{10}")) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}