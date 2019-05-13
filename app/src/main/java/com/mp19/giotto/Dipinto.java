package com.mp19.giotto;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Dipinto implements Parcelable {


    private String id;
    //nome dell'opera
    private String titolo;
    // nome dell'artista
    private String artista;
    //materiale
    private String materiale;
    //dimensioni
    private String dimensioni;
    //descrizione
    private String descrizione;
    //foto
    private String url;

    public Dipinto(String titolo, String artista, String materiale, String dimensioni, String descrizione, String url) {
        this.titolo = titolo;
        this.artista = artista;
        this.materiale = materiale;
        this.dimensioni = dimensioni;
        this.descrizione = descrizione;
        this.url = url;
    }

    protected Dipinto(Parcel in) {
        id = in.readString();
        titolo = in.readString();
        artista = in.readString();
        materiale = in.readString();
        dimensioni = in.readString();
        descrizione = in.readString();
        url = in.readString();
    }

    public static final Creator<Dipinto> CREATOR = new Creator<Dipinto>() {
        @Override
        public Dipinto createFromParcel(Parcel in) {
            return new Dipinto(in);
        }

        @Override
        public Dipinto[] newArray(int size) {
            return new Dipinto[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(String dimensioni) {
        this.dimensioni = dimensioni;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public String toString() {
        return  titolo + ", " + artista + ", " + materiale + ", " +  dimensioni;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(titolo);
        parcel.writeString(artista);
        parcel.writeString(materiale);
        parcel.writeString(dimensioni);
        parcel.writeString(descrizione);
        parcel.writeString(url);
    }
}
