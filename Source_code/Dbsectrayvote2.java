package com.example.studentvoting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Dbsectrayvote2 extends SQLiteOpenHelper {


    public static final String DBNAME = "voteinglist2.db";

    public Dbsectrayvote2(Context context) {
        super(context, "voteinglist2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {


        MyDB.execSQL("create Table joinsecvotes(Voter_id TEXT,Candidate_id TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("drop Table if exists joinsecvotes");

    }

    public Boolean insertData(String Voter_id, String Candidate_id) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("voter_id", Voter_id);
        contentValues.put("candidate_id", Candidate_id);

        long result = MyDB.insert("joinsecvotes", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }
    public List<String[]> getAllData() {
        List<String[]> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Candidate_id, COUNT(DISTINCT Voter_id) AS VoterCount FROM joinsecvotes GROUP BY Candidate_id", null);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                int candidateIdIndex = cursor.getColumnIndexOrThrow("Candidate_id");
                int voterCountIndex = cursor.getColumnIndexOrThrow("VoterCount");

                do {
                    String candidateId = cursor.getString(candidateIdIndex);
                    String voterCount = cursor.getString(voterCountIndex);
                    // Add the data to an array
                    String[] rowData = {candidateId, voterCount};
                    dataList.add(rowData);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return dataList;
    }
}


