package com.mp19.giotto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PainterAdapter extends ArrayAdapter<Pittore> {

    private LayoutInflater inflater;

    private List<Pittore> pittori;
    private ArrayList<Pittore> array;
    private int layoutResource;
    private Context aContext;


    public PainterAdapter(@NonNull Context context, int resource, @NonNull List<Pittore> objects) {
        super(context, resource, objects);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        layoutResource = resource;
        aContext = context;
        this.pittori = objects;
    }

    private static class ViewHolder{
        TextView nome;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder holder;

        if (convertView == null){
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();

            holder.nome = (TextView) convertView.findViewById(R.id.painter);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nome.setText(getItem(position).getNome());


        return convertView;
    }



}
