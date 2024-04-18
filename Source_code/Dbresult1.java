package com.example.studentvoting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbresult1 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "your_database_name";
    private static final int DATABASE_VERSION = 1;

    public Dbresult1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your Student table here
        String createTableQuery = "CREATE TABLE Student (voter_id INTEGER PRIMARY KEY, candidate_id INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement if you need to upgrade your database schema
    }

    // Method to fetch voter ID and candidate ID from the Student table
    public Cursor getStudentData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"voter_id", "candidate_id"};
        return db.query("Student", columns, null, null, null, null, null);
    }



}