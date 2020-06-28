package com.example.examenfinal;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class LoteViewModel extends AndroidViewModel {
    private LoteRepository mRepository;

    private LiveData<List<Lote>> mAlllotes;

    public LoteViewModel(Application application) {
        super(application);
        mRepository = new LoteRepository(application);
       // mAlllotes = mRepository.getAlllotes();
    }

    LiveData<List<Lote>> getAllLotes() {
        return mAlllotes;
    }

    void insert(Lote lote) {

        mRepository.insert(lote);
    }
    void update(Lote lote) {
        mRepository.update(lote);
    }
   void delete(Lote lote) {
       mRepository.delete(lote);
    }
}
