package com.fauzanpramulia.sisteminformasiunand.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NoteDB.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDbDao noteDbDao();
}
