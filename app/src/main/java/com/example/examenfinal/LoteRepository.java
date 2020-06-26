package com.example.examenfinal;

import android.app.Application;

import androidx.lifecycle.LiveData;
import android.os.AsyncTask;
import java.util.List;

public class LoteRepository {
    private LoteDao mLoteDao;
    private LiveData<List<Lote>> mAllLote;

    LoteRepository(Application application) {
        LoteRoomDataBase db = LoteRoomDataBase.getDatabase(application);
        mLoteDao = db.loteDao();
        mAllLote = mLoteDao.getAlphabetizedWords();
    }
    LiveData<List<Lote>> getAllWords() {
        return mAllLote;
    }
    void insert(Lote lote) {

        new insertAsyncTask(mLoteDao).execute(lote);
    }
    void update(Lote lote) { new updateAsyncTask(mLoteDao).execute(lote); }
    void delete(Lote lote){new deleteAsyncTask(mLoteDao).execute(lote);}

    private static class deleteAsyncTask extends AsyncTask<Lote, Void, Void> {
        private LoteDao mAsyncTaskDao;

        deleteAsyncTask(LoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Lote... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }

    private  static  class  updateAsyncTask extends  AsyncTask<Lote, Void, Void>{
        private  LoteDao mAsyncTaskDao;

        updateAsyncTask(LoteDao dao){ mAsyncTaskDao = dao;}
        @Override
        protected Void doInBackground(Lote... lote) {
            mAsyncTaskDao.update(lote[0]);
            return null;
        }
    }




    private static class insertAsyncTask extends AsyncTask<Lote, Void, Void> {

        private LoteDao mAsyncTaskDao;

        insertAsyncTask(LoteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Lote... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
