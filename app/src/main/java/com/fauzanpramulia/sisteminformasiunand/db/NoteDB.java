package com.fauzanpramulia.sisteminformasiunand.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
