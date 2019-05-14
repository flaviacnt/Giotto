package com.mp19.giotto;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewPainterFragment extends Fragment {

    private PainterAdapter adapter;
    private ListView painterList;
    private AutoCompleteTextView actv;
    private Context mContext;

    public ViewPainterFragment() {
    }

    public interface onPainterSelected{
        public void selectedPainter(Pittore painter);
    }

    onPainterSelected painterSelected;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        try {
            painterSelected = (onPainterSelected) getActivity();

        }catch (ClassCastException e){

        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viewpittori, container, false);

        painterList = (ListView) view.findViewById(R.id.paintersView);

        try {
            List<String> list = setupPaintersList();



            //autocomplete
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, list);
            actv = view.findViewById(R.id.autocomplete);

            actv.setThreshold(1);

            actv.setAdapter(arrayAdapter);
            //listener per lavorare con il selected item
            actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Pittore p;
                    String selected = (String)parent.getItemAtPosition(position);
                    Toast.makeText(mContext,
                            selected,
                            Toast.LENGTH_SHORT).show();


                     }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }



    private List<String> setupPaintersList() throws IOException {
        final List<Pittore> pittori;

        DatabaseManager dbm = new DatabaseManager(getActivity());
        //pittori = dbm.getFilteredPainters("go");
        pittori = dbm.getAllPainters();

        List<String> names = new ArrayList<>(pittori.size());
        for (Pittore object : pittori) {
            names.add(object.getNome());
        }

        adapter = new PainterAdapter(getActivity(), R.layout.painter_item, pittori);
        painterList.setAdapter(adapter);



        painterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                painterSelected.selectedPainter(pittori.get(position));
            }
        });


        return names;
    }

}
