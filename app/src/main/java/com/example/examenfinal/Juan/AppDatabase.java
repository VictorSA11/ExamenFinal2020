package com.example.examenfinal.Juan;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Lote.class, Cambio.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    @SuppressWarnings("WeakerAccess")
    public abstract LoteDao potreroDao();
    public abstract CambioDao rotacionDao();
    private static AppDatabase sIntance;

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (sIntance == null) {
            sIntance =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                            AppDatabase.class).allowMainThreadQueries().build();
        }
        return sIntance;
    }
    public static void destroyInstance() {
        sIntance = null;
    }
}