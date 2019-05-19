package com.mp19.giotto;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.mp19.giotto.R;

import java.io.IOException;
import java.util.List;

//import static com.mp19.giotto.R.id.paintersView;
import static com.mp19.giotto.R.id.paintingsView;

public class ViewPaintingFragment extends Fragment {

    public ViewPaintingFragment(){
        super();
        setArguments(new Bundle());
    }

    public interface onPaintingSelected{
        public void selectedPainting(Dipinto dipinto);
    }

    onPaintingSelected paintingSelected;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            paintingSelected = (ViewPaintingFragment.onPaintingSelected) getActivity();

        }catch (ClassCastException e){

        }
    }

    private PaintingAdapter adapter;
    private ListView paintingList;

    private TextView biography;
    private Pittore painter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewdipinti, container, false);

        paintingList = (ListView) view.findViewById(paintingsView);
        painter = getPainter();

        biography = view.findViewById(R.id.biography);

        biography.setText(painter.getBio());
        try {
            setupPaintingList(painter);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return view;
    }

    private void setupPaintingList(Pittore painter) throws IOException {
        final List<Dipinto> dipinti;


        DatabaseManager dbm = new DatabaseManager(getActivity());
        dipinti = dbm.getDipinti(painter.getNome());
        adapter = new PaintingAdapter(getActivity(), R.layout.painting_item, dipinti);
        paintingList.setAdapter(adapter);

        paintingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                paintingSelected.selectedPainting(dipinti.get(position));
            }
        });
    }

    private Pittore getPainter(){
        Bundle bundle = this.getArguments();
        if(bundle != null){
            return bundle.getParcelable("Painter");

        }else{
            return null;
        }
    }



}
