package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ordine {

    @Expose
    @SerializedName("id_ordine")
    private int id_ordine;

    @Expose
    @SerializedName("tavolo")
    private Tavolo tavolo;

    public Ordine() {
    }

    public Ordine(int id_ordine, Tavolo tavolo) {
        this.id_ordine = id_ordine;
        this.tavolo = tavolo;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }
}
