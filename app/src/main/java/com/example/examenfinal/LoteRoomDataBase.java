package com.example.examenfinal;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Lote.class}, version = 1)
public abstract class LoteRoomDataBase extends RoomDatabase {

    public abstract LoteDao loteDao();

    private static volatile LoteRoomDataBase INSTANCE;

    static LoteRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LoteRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LoteRoomDataBase.class, "lote_database")

                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final LoteDao lDao;

        PopulateDbAsync(LoteRoomDataBase db) {
            lDao = db.loteDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            lDao.deleteAll();

            Lote lote = new Lote("Lote 1");
            lDao.insert(lote);

            lote = new Lote("Lote 2");
            lDao.insert(lote);

            lote = new Lote("Lote 3");
            lDao.insert(lote);

            lote = new Lote("Lote 4");
            lDao.insert(lote);

            lote = new Lote("Lote 5");
            lDao.insert(lote);

            return null;
        }
    }
}
