package com.example.admin.hocsqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NoteDataSource {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private String[] allColums ={NoteSQLiteHelper.COLUMN_ID,NoteSQLiteHelper.COLUMN_NOTE,NoteSQLiteHelper.COLUMN_DATETIME};
    private Context context;

    public NoteDataSource(Context c) {
        this.context =c;
        sqLiteOpenHelper =new NoteSQLiteHelper(c);
     }

     public void open() throws SQLException {
         sqLiteDatabase =sqLiteOpenHelper.getWritableDatabase();
     }

     public void close() throws SQLException {
        sqLiteOpenHelper.close();
     }

     public void addNewNote(String note) {
        String dateTime =DateFormat.getDateTimeInstance().format(new Date());
         ContentValues values =new ContentValues();
         values.put(NoteSQLiteHelper.COLUMN_NOTE,note);
         values.put(NoteSQLiteHelper.COLUMN_DATETIME,dateTime);
         sqLiteDatabase.insert(NoteSQLiteHelper.TABLE_NAME,null,values);
         Toast.makeText(this.context,"add new note success",Toast.LENGTH_LONG).show();
     }

     public void deleteNote(NoteModel note) {
        sqLiteDatabase.delete(NoteSQLiteHelper.TABLE_NAME,NoteSQLiteHelper.COLUMN_ID+"="+note.getId(),null);
         Toast.makeText(this.context, "Delete note succed", Toast.LENGTH_LONG).show();

     }

     public ArrayList<NoteModel> getAllNotes() {
        ArrayList<NoteModel> list =new ArrayList<>();

         Cursor cursor =sqLiteDatabase.query(NoteSQLiteHelper.TABLE_NAME,allColums,null,null,null,null,null);
         if (cursor==null) return null;

         cursor.moveToFirst();
         while(!cursor.isAfterLast()) {
             NoteModel note =cursorToModel(cursor);
             list.add(note);
             cursor.moveToNext();

         }
         return list;
     }

    private NoteModel cursorToModel( Cursor cursor) {
        NoteModel note =new NoteModel();
        note.setId(cursor.getInt(0));
        note.setNote(cursor.getString(1));
        note.setDateTime(cursor.getString(2));
        return note;
    }


}
