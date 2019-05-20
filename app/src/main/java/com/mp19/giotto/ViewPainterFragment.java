package com.mp19.giotto;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewPainterFragment extends Fragment {

    private PainterAdapter adapter;
    private ListView painterList;
    private EditText search;
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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viewpittori, container, false);

        painterList = (ListView) view.findViewById(R.id.paintersView);
        search = (EditText) view.findViewById(R.id.search);

        try {
            List<String> list = setupPaintersList();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return view;
    }



    private List<String> setupPaintersList() throws IOException {
        final List<Pittore> pittori;

        DatabaseManager dbm = new DatabaseManager(getActivity());
        pittori = dbm.getAllPainters();

        List<String> names = new ArrayList<>(pittori.size());
        for (Pittore object : pittori) {
            names.add(object.getNome());
        }

        adapter = new PainterAdapter(getActivity(), R.layout.painter_item, pittori);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = search.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
