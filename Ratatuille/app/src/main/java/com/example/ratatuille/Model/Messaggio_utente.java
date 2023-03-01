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
}
