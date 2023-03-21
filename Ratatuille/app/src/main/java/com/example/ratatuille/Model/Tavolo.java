package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tavolo {

    @Expose
    @SerializedName("id_tavolo")
    private int id_tavolo;

    @Expose
    @SerializedName("conto")
    private Conto conto;

    public Tavolo() {
    }

    public Tavolo(int id_tavolo, Conto conto) {
        this.id_tavolo = id_tavolo;
        this.conto = conto;
    }

    public int getId_tavolo() {
        return id_tavolo;
    }

    public void setId_tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }

    public Conto getConto() {
        return conto;
    }

    public void setConto(Conto conto) {
        this.conto = conto;
    }
}
