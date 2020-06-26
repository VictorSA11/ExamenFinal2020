package com.example.examenfinal;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface LoteDao {

    @Query("SELECT * from lote_table ORDER BY lote ASC")
    LiveData<List<Lote>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Lote lote);

    @Query("DELETE FROM lote_table")
    void deleteAll();
    @Delete
    void delete(Lote lote);
    @Update
    void update(Lote lote);
}
