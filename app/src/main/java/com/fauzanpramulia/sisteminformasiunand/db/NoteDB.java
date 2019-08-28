package com.fauzanpramulia.sisteminformasiunand.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note")
public class NoteDB {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "bp")
    public String bp;

    @ColumnInfo(name = "deskripsi")
    public String deskripsi;

    @ColumnInfo(name = "date")
    public String date;
}
