package com.example.studentvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class resultsec extends AppCompatActivity {
    ListView listView;
    private Dbsectrayvote dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultsec);

        // Create an instance of Dbsectrayvote
        dbHelper = new Dbsectrayvote(this);

        // Initialize ListView
        listView = findViewById(R.id.listView);

        // Load data from database
        loadData();
    }

    private void loadData() {
        // Retrieve data from the database
        List<String[]> dataList = dbHelper.getAllData();
        if (dataList.isEmpty()) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] candidateIds = new String[dataList.size()];
        String[] voterCounts = new String[dataList.size()];

        for (int i = 0; i < dataList.size(); i++) {
            candidateIds[i] = dataList.get(i)[0];
            voterCounts[i] = dataList.get(i)[1];
        }

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, candidateIds) {
            @Override
            public int getCount() {
                return candidateIds.length;
            }

            @Override
            public String getItem(int position) {
                return candidateIds[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String candidateId = candidateIds[position];
            String voterCount = voterCounts[position];
            Toast.makeText(resultsec.this, "Candidate ID: " + candidateId + "\nVoter Count: " + voterCount, Toast.LENGTH_SHORT).show();
        });
    }
}
