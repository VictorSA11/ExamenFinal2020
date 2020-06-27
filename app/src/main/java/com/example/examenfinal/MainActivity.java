package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                Fragment fragmentSelect = null;
                switch (pos){
                    case 0:
                        fragmentSelect = new ListaFragment();
                        break;
                    case 1:
                        fragmentSelect = new GridFragmento();
                }
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmento, fragmentSelect);
                transaction.commit();
                //comment
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







    }
}