package com.example.examenfinal.Juan;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoteDao {

    @Query("SELECT COUNT(*) FROM " + Lote.TABLE_NAME)
    int count(); //metodo
    //seleccionar todo
    @Query("SELECT * FROM "+ Lote.TABLE_NAME)
    List<Lote> getAll();
    //eliminar
    @Query("DELETE FROM " + Lote.TABLE_NAME + " WHERE " + Lote.COLUMN_ID + " = :ide")
    int deleteById(long ide);
    //actualizar
    @Update
    int updateEntidad(Lote obj);
    //insertar 2
    @Insert
    long insert(Lote potreros);
}