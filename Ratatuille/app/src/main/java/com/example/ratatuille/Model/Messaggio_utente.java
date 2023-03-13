package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Messaggio_utente {

    @Expose
    @SerializedName("id_messaggi_utente")
    private int id_messaggio_utente;

    @Expose
    @SerializedName("letto")
    private boolean letto;

    @Expose
    @SerializedName("utente")
    private Utente utente;

    @Expose
    @SerializedName("messaggio")
    private Messaggio messaggio;

    public void setId_messaggio_utente(int id_messaggio_utente) {
        this.id_messaggio_utente = id_messaggio_utente;
    }

    public void setLetto(boolean letto) {
        this.letto = letto;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    public int getId_messaggio_utente() {
        return id_messaggio_utente;
    }

    public boolean isLetto() {
        return letto;
    }

    public Utente getUtente() {
        return utente;
    }

    public Messaggio getMessaggio() {
        return messaggio;
    }

    public Messaggio_utente(int id_messaggio_utente, boolean letto, Utente utente, Messaggio messaggio) {
        this.id_messaggio_utente = id_messaggio_utente;
        this.letto = letto;
        this.utente = utente;
        this.messaggio = messaggio;
    }

    public Messaggio_utente() {
    }
}
