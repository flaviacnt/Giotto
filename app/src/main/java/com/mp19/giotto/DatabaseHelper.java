package com.mp19.giotto;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {




    private static final String DB_NAME = "giotto.db";
    private static final int DB_VERSION = 1;

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






    /*public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

   /* @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create1 = "CREATE TABLE " + TABLE_PAINTERS + "( " +
                COL_NOME + " TEXT PRIMARY KEY, " +
                COL_VITA + " TEXT , " +
                COL_CORRENTE + " TEXT , " +
                COL_NAZIONALITA + " TEXT ," +
                COL_BIO + " TEXT " +
                ");";
        String create2 = "CREATE TABLE " +  TABLE_PAINTINGS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TITOLO + " TEXT NOT NULL, " +
                COL_ARTISTA + " TEXT NOT NULL, " +
                COL_MATERIALI + " TEXT ,"+
                COL_DIMENSIONI + " TEXT ," +
                COL_DESCRIZIONE + " TEXT ," +
                COL_URL + " TEXT " +
                ");";

        String insert1 = "INSERT INTO " + TABLE_PAINTERS + "(" +
                COL_NOME + ", " +
                COL_VITA + ", " +
                COL_CORRENTE + ", " +
                COL_NAZIONALITA + ", " +
                COL_BIO + ") " +

                "VALUES " +
                " ('Vincent Van Gogh', '1853-1890', 'Post-Impressionism', 'Dutch', " +
                "'Vincent Willem van Gogh (30 March 1853 – 29 July 1890) " +
                "was a Dutch Post-Impressionist painter who is among the most famous and influential figures in the history of Western art. " +
                "In just over a decade he created about 2,100 artworks, including around 860 oil paintings, most of them in the last two years of his life. " +
                "They include landscapes, still lifes, portraits and self-portraits, and are characterised by bold colours and dramatic, impulsive and expressive brushwork that contributed to the foundations of modern art. " +
                "However, he was not commercially successful, and his suicide at 37 followed years of mental illness and poverty.');";

        String insert2 = "INSERT INTO " + TABLE_PAINTERS + "(" +
                COL_NOME + ", " +
                COL_VITA + ", " +
                COL_CORRENTE + ", " +
                COL_NAZIONALITA + ", " +
                COL_BIO + ") " +

                "VALUES (" +
                "'Francisco Goya', '1746 - 1828', 'Romanticism', 'Spanish', " +
                "'Francisco José de Goya y Lucientes  " +
                "(30 March 1746–16 April 1828) " +
                "was a Spanish romantic painter and printmaker. " +
                "He is considered the most important Spanish artist of the late 18th and early 19th centuries and throughout his long career was a commentator and chronicler of his era. " +
                "Immensely successful in his lifetime, Goya is often referred to as both the last of the Old Masters and the first of the moderns.  He was also one of the great contemporary portraitists.He was born to a modest family in 1746 in the village of Fuendetodos in Aragon. " +
                "He studied painting from age 14 under José Luzán y Martinez and moved to Madrid to study with Anton Raphael Mengs. He married Josefa Bayeu in 1773; " +
                "their life was characterised by an almost constant series of pregnancies and miscarriages, and only one child, a son, survived into adulthood. " +
                "Goya became a court painter to the Spanish Crown in 1786 and this early portion of his career is marked by portraits of the Spanish aristocracy and royalty, and Rococo style tapestry cartoons designed for the royal palace.');" ;


        String insert3 = "INSERT INTO " + TABLE_PAINTINGS + "(" +
                COL_ID + ", " +
                COL_TITOLO + ", " +
                COL_ARTISTA + ", " +
                COL_MATERIALI + ", " +
                COL_DIMENSIONI + ", " +
                COL_DESCRIZIONE + ", " +
                COL_URL + ") " +

                "VALUES (" +
                "1, 'The Starry Night', 'Vincent Van Gogh', 'Oil on canvas', '73.7 cm × 92.1 cm', " +
                "'Although painted from memory, this masterpiece depicts the view outside Van Gogh’s sanitarium room window at Saint-Remy-de-Provence in France. The work shows the artist’s interest in astronomy and a study made by the Griffith Park Observatory demonstrated that Vincent represented the Moon, " +
                "Venus, and several stars in the exact position they occupied that clear night. " +
                "The painting is considered among the greatest works in western art and is definitely the most famous work of Vincent Van Gogh.'," +
                "'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/1024px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg'  )";

        sqLiteDatabase.execSQL(create1);
        sqLiteDatabase.execSQL(create2);
        sqLiteDatabase.execSQL(insert1);
        sqLiteDatabase.execSQL(insert2);
        sqLiteDatabase.execSQL(insert3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String drop = "DROP IF TABLE EXISTS ";

        sqLiteDatabase.execSQL(drop +  TABLE_PAINTERS);
        sqLiteDatabase.execSQL(drop +  TABLE_PAINTINGS);

        onCreate(sqLiteDatabase);
     }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }*/

    //The Android's default system path of your application database.
    //public static String DB_PATH = "/data/data/com.mp19.giotto/databases/";
    //private static String MYDB_NAME = "giotto.db";
    //private SQLiteDatabase myDataBase;
    //private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the  application assets and resources.
     * @param context
     */

    private Context myContext;
    String mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();

    private String DB_PATH;

    //private static String DB_NAME = "giotto.db";
    public SQLiteDatabase myDataBase;


    public DatabaseHelper(Context context) throws IOException {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = context.getDatabasePath(DB_NAME).toString();
    }

    public void createDatabase() throws IOException {
        boolean dbexist = checkDatabase();
        if(!dbexist) {
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch(IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDatabase() {

        File databasePath = myContext.getDatabasePath(DB_NAME);
        return databasePath.exists();
    }

    private void copyDatabase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer byte to inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0) {
            myOutput.write(buffer,0,length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDatabase() throws SQLException {
        //Open the database

        String myPath = DB_PATH;
        System.out.println(myPath);
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if(myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
