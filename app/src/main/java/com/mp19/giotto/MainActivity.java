package com.mp19.giotto;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ViewPainterFragment.onPainterSelected, ViewPaintingFragment.onPaintingSelected{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        ViewPainterFragment fragment = new ViewPainterFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

    }

    @Override
    public void selectedPainter(Pittore painter) {
        ViewPaintingFragment vpf = new ViewPaintingFragment();
        Bundle args = new Bundle();
        args.putParcelable("Painter", painter);
        vpf.setArguments(args);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        //animazioni fragment
        transaction.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_out_right);

        transaction.replace(R.id.fragment_container, vpf);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    @Override
    public void selectedPainting(Dipinto painting) {
        PaintingDetailsFragment pdf = new PaintingDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("Painting", painting);
        pdf.setArguments(args);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.replace(R.id.fragment_container, pdf);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
