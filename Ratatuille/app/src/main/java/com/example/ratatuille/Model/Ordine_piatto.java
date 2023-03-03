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
    @SerializedName("id_ordine")
    private int id_ordine;

    @Expose
    @SerializedName("id_piatto")
    private int id_piatto;

    public Ordine_piatto() {
    }

    public Ordine_piatto(int id_ordine_piatto, int qta, int id_ordine, int id_piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
        this.qta = qta;
        this.id_ordine = id_ordine;
        this.id_piatto = id_piatto;
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

    public int getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public int getId_piatto() {
        return id_piatto;
    }

    public void setId_piatto(int id_piatto) {
        this.id_piatto = id_piatto;
    }
}
