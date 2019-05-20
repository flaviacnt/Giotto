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

    private List<Pittore> pittori = null;
    private ArrayList<Pittore> array;
    private int layoutResource;
    private Context aContext;


    public PainterAdapter(@NonNull Context context, int resource, @NonNull List<Pittore> objects) {
        super(context, resource, objects);

        /*For example, I have an instance of class call objectA. In objectA,
        I want to inflate a view onto the parent view (happen in ArrayAdapter that inflates customized row on the its listview.)
        In this case, context.getLayoutInflater does not work since there is no activity or windows associated with the context.
        Only getSystemService(Context.LAYOUT_INFLATER_SERVICE) is appropriate then.
         */

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutResource = resource;
        this.aContext = context;
        this.pittori = objects;
        array = new ArrayList<>();
        this.array.addAll(pittori);
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

    //Filter class
    public void filter(String characterText){
        characterText = characterText.toLowerCase(Locale.getDefault());
        pittori.clear();
        if( characterText.length() == 0){
            pittori.addAll(array);
        }
        else{
            pittori.clear();
            for(Pittore p: array){
                if(p.getNome().toLowerCase(Locale.getDefault()).contains(characterText)){
                    pittori.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }



}
