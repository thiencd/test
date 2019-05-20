package com.example.admin.hocsqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteSQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "mynote.db";
    public static final String TABLE_NAME="notes";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NOTE="note";
    public static final String COLUMN_DATETIME="datetime";
    public static final int DATABASE_VERSION=1;
    public static final String CREATE_DATABASE ="CREATE TABLE " +TABLE_NAME + "(" +COLUMN_ID +"INTEGER PRIMARY KEY autoincrement, " +COLUMN_NOTE+ "text not null, "
                                                                + COLUMN_DATETIME +"text)";
    public NoteSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
            onCreate(db);
    }
}
