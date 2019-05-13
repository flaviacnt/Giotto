package com.mp19.giotto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Pittore implements Parcelable {


    //nome e cognome dell'artista
    private String nome;
    //nascita-morte
    private String vita;
    //corrente
    private String correnti;
    //nazionalità
    private String nazionalità;
    //biografia
    private String bio;


    public Pittore(String nome, String vita, String correnti, String nazionalità, String bio) {
        this.nome = nome;
        this.vita = vita;
        this.correnti = correnti;
        this.nazionalità = nazionalità;
        this.bio = bio;

    }

    protected Pittore(Parcel in) {
        nome = in.readString();
        vita = in.readString();
        correnti = in.readString();
        nazionalità = in.readString();
        bio = in.readString();
    }

    public static final Creator<Pittore> CREATOR = new Creator<Pittore>() {
        @Override
        public Pittore createFromParcel(Parcel in) {
            return new Pittore(in);
        }

        @Override
        public Pittore[] newArray(int size) {
            return new Pittore[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVita() {
        return vita;
    }

    public void setVita(String vita) {
        this.vita = vita;
    }

    public String getCorrenti() {
        return correnti;
    }

    public void setCorrenti(String correnti) {
        this.correnti = correnti;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Pittore{" +
                "nome='" + nome + '\'' +
                ", vita='" + vita + '\'' +
                ", correnti='" + correnti + '\'' +
                ", nazionalità='" + nazionalità + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(vita);
        parcel.writeString(correnti);
        parcel.writeString(nazionalità);
        parcel.writeString(bio);
    }
}
