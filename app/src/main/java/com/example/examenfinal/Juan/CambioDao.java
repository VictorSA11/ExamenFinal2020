package com.example.examenfinal.Juan;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CambioDao {
    //seleccionar todo
    @Query("SELECT * FROM "+ Cambio.TABLE_NAME)
    List<Cambio> getAllR();



    //eliminar
    @Query("DELETE FROM " + Cambio.TABLE_NAME + " WHERE " + Cambio.COLUMN_ID + " = :ide")
    int deleteByIdR(long ide);

    //actualizar
    @Update
    int updateEntidadR(Cambio obj);


    //insertar 2
    @Insert
    long insertR(Cambio rotar);

}