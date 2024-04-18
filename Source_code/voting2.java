package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class voting2  extends AppCompatActivity {
    Spinner spinner;
    SQLiteDatabase db;
    EditText e;
    Dbsectrayvote2 DBC;
    Button b1;
    DBHelper help2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting2);
        e = findViewById(R.id.votename);
        spinner = findViewById(R.id.spinner);
        DBC = new Dbsectrayvote2(this);
        b1 = findViewById(R.id.vtn);
        help2= new DBHelper(this);
        // Open or create your SQLite database
        db = openOrCreateDatabase("database2.db", Context.MODE_PRIVATE, null);

        // Fetch registration numbers from the database
        List<String> Reg_NO = fetchRegNumbersFromDatabase();

        // Create ArrayAdapter and set it to the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Reg_NO);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set the click listener for the button here
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Voter_id = e.getText().toString(); // Assuming 'e' is the EditText for the user
                int selectedPosition = spinner.getSelectedItemPosition();
                String Candidate_id = spinner.getItemAtPosition(selectedPosition).toString();
                boolean checkstuname = help2.checkstuname(Voter_id);
                if (checkstuname==false)  {
                    Toast.makeText(voting2.this, "Voter_id does not exist", Toast.LENGTH_SHORT).show();
                } else {
                    if (Voter_id.equals("") || Candidate_id.equals("")) {
                        Toast.makeText(voting2.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean insertData2 = DBC.insertData(Voter_id, Candidate_id);
                        if (insertData2 == true) {
                            Toast.makeText(voting2.this, "Voted Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(voting2.this, "Vote Not Successfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private List<String> fetchRegNumbersFromDatabase() {
        List<String> Reg_NO = new ArrayList<>();

        // Replace "your_table_name" with the actual table name
        Cursor cursor = db.query("leader2", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                // Assuming the registration number is in the first column (index 0)
                String regNumber = cursor.getString(1);
                Reg_NO.add(regNumber);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return Reg_NO;
    }
}