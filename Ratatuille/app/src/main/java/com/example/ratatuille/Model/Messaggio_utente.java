package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Messaggio_utente {

    @Expose
    @SerializedName("id_messaggio_ordine")
    private int id_messaggio_ordine;

    @Expose
    @SerializedName("letto")
    private boolean letto;

    @Expose
    @SerializedName("utente")
    private Utente utente;

    @Expose
    @SerializedName("messaggio")
    private Messaggio messaggio;

    public void setId_messaggio_ordine(int id_messaggio_ordine) {
        this.id_messaggio_ordine = id_messaggio_ordine;
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

    public int getId_messaggio_ordine() {
        return id_messaggio_ordine;
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

    public Messaggio_utente(int id_messaggio_ordine, boolean letto, Utente utente, Messaggio messaggio) {
        this.id_messaggio_ordine = id_messaggio_ordine;
        this.letto = letto;
        this.utente = utente;
        this.messaggio = messaggio;
    }

    public Messaggio_utente() {
    }
}
