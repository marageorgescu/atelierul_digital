package com.example.journaltheworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "Journal";

    public SQLiteDatabaseHandler(@Nullable Context context) {
        super(context, "JournalDB", null, 11);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATION_TABLE = "CREATE TABLE Journal ( "
                + "title TEXT, "
                + "image TEXT, "
                + "date TEXT, "
                + "location TEXT, "
                + "story TEXT )";

        db.execSQL(CREATION_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public List<JournalStory> allJournalStories() {

        List<JournalStory> journalStories = new LinkedList<JournalStory>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        JournalStory journalStory = null;

        if (cursor.moveToFirst()) {
            do {
                journalStory = new JournalStory();
                journalStory.setTitle(cursor.getString(0));
                journalStory.setImage((cursor.getString(1)));
                journalStory.setDate(cursor.getString(2));
                journalStory.setLocation(cursor.getString(3));
                journalStory.setStory(cursor.getString(4));
                journalStories.add(journalStory);
            } while (cursor.moveToNext());
        }

        return journalStories;
    }

    public void addJournalStory(JournalStory journalStory) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", journalStory.getTitle());
        values.put("image", journalStory.getImage());
        values.put("date", journalStory.getDate());
        values.put("location", journalStory.getLocation());
        values.put("story", journalStory.getStory());
        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

}
