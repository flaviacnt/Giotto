package com.mp19.giotto;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {




    private static final String DB_NAME = "giotto.db";
    private static final int DB_VERSION = 2;

    public static final String TABLE_PAINTERS = "painters";
    public static final String TABLE_PAINTINGS = "paintings";

    public static final String COL_NOME = "nome";
    public static final String COL_VITA = "vita";
    public static final String COL_CORRENTE = "corrente";
    public static final String COL_NAZIONALITA = "nazionalita";
    public static final String COL_BIO = "bio";


    public static final String COL_ID = "id";
    public static final String COL_TITOLO = "titolo";
    public static final String COL_ARTISTA = "artista";
    public static final String COL_MATERIALI = "materiali";
    public static final String COL_DIMENSIONI = "dimensioni";
    public static final String COL_DESCRIZIONE = "descrizione";
    public static final String COL_URL = "url";

    private Context myContext;
    private static final String SP_KEY_DB_VER = "db_ver";
    String mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        myContext = context;
        initialize();
    }

    /**
     * Initializes database. Creates database if doesn't exist.
     */
    private void initialize() {
        if (databaseExists()) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(myContext);
            int dbVersion = prefs.getInt(SP_KEY_DB_VER, 1);
            if (DB_VERSION != dbVersion) {
                File dbFile = myContext.getDatabasePath(DB_NAME);
                if (!dbFile.delete()) {
                    System.out.println("Unable to update database");
                }
            }
        }
        if (!databaseExists()) {
            createDatabase();
        }
    }

    /**
     * Returns true if database file exists, false otherwise.
     * @return
     */
    private boolean databaseExists() {
        File dbFile = myContext.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }

    /**
     * Creates database by copying it from assets directory.
     */
    public void createDatabase() {
        String parentPath = myContext.getDatabasePath(DB_NAME).getParent();
        String path = myContext.getDatabasePath(DB_NAME).getPath();

        File file = new File(parentPath);
        if (!file.exists()) {
            if (!file.mkdir()) {
                System.out.println("Unable to create database directory");
                return;
            }
        }

        InputStream is = null;
        OutputStream os = null;
        try {
            is = myContext.getAssets().open(DB_NAME);
            os = new FileOutputStream(path);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            os.flush();
            SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(myContext);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt(SP_KEY_DB_VER, DB_VERSION);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
    }
}


