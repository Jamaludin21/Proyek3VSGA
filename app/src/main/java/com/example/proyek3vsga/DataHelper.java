package com.example.proyek3vsga;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "datadiri.db";
    private static final int DATABASE_VERISON = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERISON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table datadiri(username text null,password text null,email text null,nama_lengkap text null,asal_sekolah text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
