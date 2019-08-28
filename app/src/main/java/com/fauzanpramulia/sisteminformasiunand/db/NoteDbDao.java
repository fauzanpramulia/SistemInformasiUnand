package com.fauzanpramulia.sisteminformasiunand.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDbDao {
    @Query("SELECT * FROM note")
    List<NoteDB> getAllNoteMahasiswa();

    @Query("SELECT * FROM note WHERE bp = :bp")
    NoteDB getByBp(String bp);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteDB noteDB);

    @Query("UPDATE note SET deskripsi=:deskripsi,date=:date WHERE bp = :bp")
    void updateNote(String deskripsi, String date, String bp);

    @Query("DELETE FROM note")
    void clear();
    @Delete
    void delete(NoteDB noteDB);


}
