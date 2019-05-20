package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME="contact_db";
    public static final int DATABASE_VERSION=1;

    public static final String CREATE_TABLE="create table " +ContactContract.ContactEntry.TABLE_NAME+"(" +
            ContactContract.ContactEntry.CONTACT_ID+"number," + ContactContract.ContactEntry.NAME+"text,"
            + ContactContract.ContactEntry.EMAIL+" text);";

    public static String DROP_TABLE="drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper(Context context) {
        super(context,DATABASENAME,null,DATABASE_VERSION);
        Log.d("Databse operation","Database create...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        Log.d("Databse operation","Database create...");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);

    }

    public void addContact(String id,String name,String email,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTACT_ID,id);
        contentValues.put(ContactContract.ContactEntry.NAME,name);
        contentValues.put(ContactContract.ContactEntry.EMAIL,email);
        db.insert(ContactContract.ContactEntry.TABLE_NAME,null,contentValues);


    }
}
