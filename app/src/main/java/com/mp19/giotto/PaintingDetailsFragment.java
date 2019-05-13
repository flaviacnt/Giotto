package com.mp19.giotto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PaintingDetailsFragment extends Fragment {

    private Dipinto painting;
    private ImageView image;
    private TextView details;
    private TextView description;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paintingdetails, container, false);
        painting = getPainting();

        image = view.findViewById(R.id.image);
        details = view.findViewById(R.id.informations);
        description = view.findViewById(R.id.description);

        Picasso.get().load(painting.getUrl()).into(image);
        details.setText(painting.toString());
        description.setText(painting.getDescrizione());



        return view;
    }


    private Dipinto getPainting(){
        Bundle bundle = this.getArguments();
        if(bundle != null){
            return bundle.getParcelable("Painting");

        }else{
            return null;
        }
    }
}
