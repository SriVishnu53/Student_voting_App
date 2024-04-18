package com.example.studentvoting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class Dbsectrayvote extends SQLiteOpenHelper {

    public static final String DBNAME = "voteinglist1.db";

    public Dbsectrayvote(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE IF NOT EXISTS stusecvote (Voter_id TEXT, Candidate_id TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXISTS stusecvote");
        onCreate(MyDB);
    }

    public Boolean insertData(String Voter_id, String Candidate_id) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Voter_id", Voter_id);
        contentValues.put("Candidate_id", Candidate_id);
        long result = MyDB.insert("stusecvote", null, contentValues);
        return result != -1;
    }

    public boolean checkstuname2(String voter_id) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM stusecvote WHERE Voter_id = ?", new String[]{voter_id});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }


    public List<String[]> getAllData() {
        List<String[]> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Candidate_id, COUNT(DISTINCT Voter_id) AS VoterCount FROM stusecvote GROUP BY Candidate_id", null);
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