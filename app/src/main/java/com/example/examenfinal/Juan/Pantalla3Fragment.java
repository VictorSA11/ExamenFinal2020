package com.example.examenfinal.Juan;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ExpandableListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examenfinal.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Pantalla3Fragment extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private Pantalla3Adapter adapter;
    private ArrayList<Lote> listLote;
    private Map<Lote, ArrayList<Lote>> mapChild;
    View root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

         expandableListView = root.findViewById(R.id.expandable_id);
         listLote = new ArrayList<>();
         mapChild = new HashMap<>();
    }

    private void cargarDatos(){
ArrayList<String> lote1 = new ArrayList<>();
ArrayList<String> lote2 = new ArrayList<>();




lote1.add("lote1");
lote1.add("20/02/2020");
lote1.add("200");

        lote2.add("lote1");
        lote2.add("20/3/2020");
        lote2.add("3500");
    }
}
