package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ordine {

    @Expose
    @SerializedName("id_ordine")
    private int id_ordine;

    @Expose
    @SerializedName("tavolo")
    private int id_tavolo;

    public Ordine() {
    }

    public Ordine(int id_ordine, int id_tavolo) {
        this.id_ordine = id_ordine;
        this.id_tavolo = id_tavolo;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public int getIdTavolo() {
        return id_tavolo;
    }

    public void setId_Tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }
}
