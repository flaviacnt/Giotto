package com.mp19.giotto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PaintingAdapter extends ArrayAdapter<Dipinto> {

    private LayoutInflater inflater;
    private List<Dipinto> dipinti;
    private ArrayList<Dipinto> arrayDipinti;
    private int layoutResource;
    private Context aContext;


    public PaintingAdapter(@NonNull Context context, int resource, @NonNull List<Dipinto> objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutResource = resource;
        aContext = context;
        this.dipinti = objects;
        arrayDipinti = new ArrayList<>();
        this.arrayDipinti.addAll(dipinti);


    }

    private static class ViewHolder{
        TextView bio;
        TextView nome;
        ImageView image;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder holder;

        if (convertView == null){
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();

            holder.nome = (TextView) convertView.findViewById(R.id.title);
            holder.image = (ImageView) convertView.findViewById(R.id.paint);
            holder.bio = (TextView) convertView.findViewById(R.id.biography);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.nome.setText(getItem(position).getTitolo());
        Picasso.get().load(getItem(position).getUrl()).into(holder.image);

        return convertView;
    }



}
