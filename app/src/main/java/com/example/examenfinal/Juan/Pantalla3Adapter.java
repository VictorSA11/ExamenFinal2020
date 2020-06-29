package com.example.examenfinal.Juan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.examenfinal.R;

import java.util.ArrayList;
import java.util.Map;

public class Pantalla3Adapter extends BaseExpandableListAdapter {

    private ArrayList<Lote>listaLote;
    private Map<Lote,ArrayList<Lote>> mapChild;
    private Context context;

    public Pantalla3Adapter(ArrayList<Lote> listaLote, Map<Lote, ArrayList<Lote>> mapChild, Context context) {
        this.listaLote = listaLote;
        this.mapChild = mapChild;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listaLote.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(listaLote.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listaLote.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listaLote.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Lote item = (Lote) getGroup(groupPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.expandable_group2, null);
        TextView tvGroup = (TextView) convertView.findViewById(R.id.nombre_lote);
        tvGroup.setText(item.getNombre());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        Lote item = (Lote) getChild(groupPosition, childPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.expandable_child2, null);
        TextView txtUser = convertView.findViewById(R.id.lote_nom);
        TextView txtf = convertView.findViewById(R.id.fecha);
        TextView txtm = convertView.findViewById(R.id.metros_cuadrados);
        txtUser.setText(item.getNombre());
        txtf.setText(item.getFecha());
        txtm.setText(item.getArea());


        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
