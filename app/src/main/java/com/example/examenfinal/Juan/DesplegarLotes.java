package com.example.examenfinal.Juan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.examenfinal.R;

import java.util.List;

public class DesplegarLotes extends AppCompatActivity {
    AppDatabase myDataBase;
    private List<Lote> listpotreros;
    ListView viewPotrero;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        myDataBase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Constante.BD_NAME)
                .allowMainThreadQueries().build();
        listpotreros = myDataBase.potreroDao().getAll();
        viewPotrero= (ListView)findViewById(R.id.text_home);

        AdapterPotrero adapterPotrero = new AdapterPotrero(this);
        viewPotrero.setAdapter(adapterPotrero);
    }

    class AdapterPotrero extends ArrayAdapter<Lote>{
        AppCompatActivity appCompatActivity;

        public AdapterPotrero(AppCompatActivity context){
            super(context, R.layout.item_potrero, listpotreros);
            appCompatActivity = context;
        }

        public View getView(int pos, View convertView, ViewGroup container){
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.item_potrero, null);

            TextView nombre = (TextView)item.findViewById(R.id.textPotrero);
            String dato = listpotreros.get(pos).getNombre()+" "+listpotreros.get(pos).getImg();
            nombre.setText(dato);

            return item;
        }
    }
}