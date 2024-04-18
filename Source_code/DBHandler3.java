package com.example.studentvoting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler3 extends SQLiteOpenHelper {
    public static final String DBNAME = "database3.db";

    public DBHandler3(Context context) {

        super(context, "database3.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table leader3(Candidate_Name varchar(20) , Reg_NO TEXT,MObile_NO varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists leader3");
        onCreate(MyDB);
    }
}
