package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ordine_piatto {

    @Expose
    @SerializedName("id_ordine_piatto")
    private int id_ordine_piatto;

    @Expose
    @SerializedName("qta")
    private int qta;

    @Expose
    @SerializedName("ordine")
    private Ordine ordine;

    @Expose
    @SerializedName("piatto")
    private Piatto piatto;

    public Ordine_piatto() {
    }

    public Ordine_piatto(int id_ordine_piatto, int qta, Ordine ordine, Piatto piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
        this.qta = qta;
        this.ordine = ordine;
        this.piatto = piatto;
    }

    public int getId_ordine_piatto() {
        return id_ordine_piatto;
    }

    public void setId_ordine_piatto(int id_ordine_piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Piatto getPiatto() {
        return piatto;
    }

    public void setPiatto(Piatto piatto) {
        this.piatto = piatto;
    }
}
