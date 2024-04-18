package com.example.studentvoting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler2 extends SQLiteOpenHelper {
    public static final String DBNAME = "database2.db";
    public DBHandler2(Context context) {

        super(context, "database2.db", null,2 );
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table leader2(Candidate_Name varchar(20) , Reg_NO TEXT,MObile_NO varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists leader2");
        onCreate(MyDB);
    }
}
