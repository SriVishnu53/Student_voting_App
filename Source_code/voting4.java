package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

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

public class voting4 extends AppCompatActivity {
    Spinner spinner;
    SQLiteDatabase db;
    EditText e;
    Dbsectrayvote4 DBC;
    Button b1;
    DBHelper help2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting4);
        e = findViewById(R.id.votename);
        spinner = findViewById(R.id.spinner);
        DBC = new Dbsectrayvote4(this);
        b1 = findViewById(R.id.vtn);
        help2= new DBHelper(this);
        // Open or create your SQLite database
        db = openOrCreateDatabase("database4.db", Context.MODE_PRIVATE, null);

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
                    Toast.makeText(voting4.this, "Voter_id does not exist", Toast.LENGTH_SHORT).show();
                } else {
                    if (Voter_id.equals("") || Candidate_id.equals("")) {
                        Toast.makeText(voting4.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean insertData3 = DBC.insertData(Voter_id, Candidate_id);
                        if (insertData3 == true) {
                            Toast.makeText(voting4.this, "Voted Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(voting4.this, "Vote Not Successfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private List<String> fetchRegNumbersFromDatabase() {
        List<String> Reg_NO = new ArrayList<>();

        // Replace "your_table_name" with the actual table name
        Cursor cursor = db.query("leader4", null, null, null, null, null, null);

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