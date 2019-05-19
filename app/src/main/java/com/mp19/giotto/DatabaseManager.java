package com.mp19.giotto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.mp19.giotto.DatabaseHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;

    public DatabaseManager(Context context) throws IOException {
        this.context = context;
        dbHelper = new DatabaseHelper(context);

        dbHelper.createDatabase();
        //dbHelper.openDatabase();
    }

    public void open() throws IOException {


        db = dbHelper.getReadableDatabase();


    }

    public void close() {

        dbHelper.close();
    }

    public Pittore getFilteredPainter(String str) throws IOException {
        List<Pittore> pittori = new ArrayList<Pittore>();
        Pittore p = null;

        open();

        Cursor cursor = db.rawQuery("SELECT *  FROM " + dbHelper.TABLE_PAINTERS + " WHERE " + dbHelper.COL_NOME + " LIKE '%" + str + "%' ", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String nome = cursor.getString(cursor.getColumnIndex(dbHelper.COL_NOME));
            String vita = cursor.getString(cursor.getColumnIndex(dbHelper.COL_VITA));
            String correnti = cursor.getString(cursor.getColumnIndex(dbHelper.COL_CORRENTE));
            String nazionalita = cursor.getString(cursor.getColumnIndex(dbHelper.COL_NAZIONALITA));
            String bio = cursor.getString(cursor.getColumnIndex(dbHelper.COL_BIO));

            p = new Pittore(nome, vita, correnti, nazionalita, bio);

        }
        cursor.close();
        close();
        return p;
    }

    public List<Pittore> getAllPainters() throws IOException {
        List<Pittore> pittori = new ArrayList<Pittore>();

        open();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ dbHelper.TABLE_PAINTERS +" ORDER BY " + dbHelper.COL_NOME, null);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String nome = cursor.getString(cursor.getColumnIndex(dbHelper.COL_NOME));
            String vita = cursor.getString(cursor.getColumnIndex(dbHelper.COL_VITA));
            String correnti = cursor.getString(cursor.getColumnIndex(dbHelper.COL_CORRENTE));
            String nazionalita = cursor.getString(cursor.getColumnIndex(dbHelper.COL_NAZIONALITA));
            String bio = cursor.getString(cursor.getColumnIndex(dbHelper.COL_BIO));

            Pittore p = new Pittore(nome, vita, correnti, nazionalita, bio);
            pittori.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return pittori;
    }

    public List<Dipinto> getDipinti(String artista) throws IOException {
        List<Dipinto> dipinti = new ArrayList<Dipinto>();

        open();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ dbHelper.TABLE_PAINTINGS + " WHERE " + dbHelper.COL_ARTISTA + " = " + "'" + artista + "'", null);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String titolo = cursor.getString(cursor.getColumnIndex(dbHelper.COL_TITOLO));
            String materiali = cursor.getString(cursor.getColumnIndex(dbHelper.COL_MATERIALI));
            String dimensioni = cursor.getString(cursor.getColumnIndex(dbHelper.COL_DIMENSIONI));
            String descrizione = cursor.getString(cursor.getColumnIndex(dbHelper.COL_DESCRIZIONE));
            String url = cursor.getString(cursor.getColumnIndex(dbHelper.COL_URL));


            Dipinto d = new Dipinto(titolo, artista, materiali, dimensioni, descrizione, url);
            System.out.println(url);
            dipinti.add(d);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return dipinti;
    }
}
