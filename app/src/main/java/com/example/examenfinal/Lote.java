package com.example.examenfinal;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Lote_table")
public class Lote {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "lote")
    private String mLote;

    public Lote(@NonNull String lote) {
        this.mLote = lote;
    }
    @NonNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NonNull
    public String getLote() {
        return this.mLote;
    }
}
