package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Conto {

    @Expose
    @SerializedName("id_conto")
    private int id_conto;

    @Expose
    @SerializedName("costo")
    private Float costo;

    @Expose
    @SerializedName("data")
    private String data;

    @Expose
    @SerializedName("chiuso")
    private int chiuso;

    @Expose
    @SerializedName("id_tavolo")
    private int id_tavolo;

    public int getChiuso() {
        return chiuso;
    }

    public void setChiuso(int chiuso) {
        this.chiuso = chiuso;
    }

    public Conto() {
    }

    public Conto(int id_conto, Float costo, String data, int chiuso, int id_tavolo) {
        this.id_conto = id_conto;
        this.costo = costo;
        this.data = data;
        this.chiuso = chiuso;
        this.id_tavolo = id_tavolo;
    }

    public int getId_conto() {
        return id_conto;
    }

    public void setId_conto(int id_conto) {
        this.id_conto = id_conto;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_tavolo() {
        return id_tavolo;
    }

    public void setId_tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }
}
