package com.example.examenfinal.Juan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examenfinal.R;

public class CreateActivity extends AppCompatActivity {

    EditText nombre, fecha, area;
    AppDatabase db;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        nombre = (EditText)findViewById(R.id.edit_nombre);
        fecha = (EditText)findViewById(R.id.fecha);
        area = (EditText)findViewById(R.id.edit_medida);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Constante.BD_NAME).allowMainThreadQueries().build();

    }

    public void savePotrero(View view) {
        Lote obj = new Lote();
        obj.setNombre(nombre.getText().toString());
        obj.setFecha(fecha.getText().toString());
        obj.setArea(area.getText().toString());


        long resul = db.potreroDao().insert(obj);
        if (resul > 0 ){
            Toast.makeText(CreateActivity.this,"Agregado Correctamente",Toast.LENGTH_LONG).show();
            startActivity(new Intent(CreateActivity.this, MainActivity.class));
        }else{
            Toast.makeText(CreateActivity.this,"No ha sido Agregado",Toast.LENGTH_LONG).show();
        }
    }

    public void tomarVideo(View view) {
    }
}
