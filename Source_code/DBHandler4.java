package com.example.studentvoting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler4 extends SQLiteOpenHelper {
    public static final String DBNAME = "database4.db";
    public DBHandler4(Context context) {

        super(context, "database4.db", null,4);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table leader4(Candidate_Name varchar(20) , Reg_NO TEXT,MObile_NO varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists leader4");
        onCreate(MyDB);
    }
}
