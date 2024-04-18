package com.example.studentvoting;

import android.content.ContentValues;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DBNAME = "database1.db";
    public DBHandler(Context context) {
            super(context, "database1.db", null, 1);
        }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table leader1(Candidate_Name varchar(20) , Reg_NO TEXT,MObile_NO varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists leader1");
onCreate(MyDB);
    }
}