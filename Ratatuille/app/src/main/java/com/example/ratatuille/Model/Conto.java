package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Conto {

    @Expose
    @SerializedName("id_conto")
    private int id_conto;

    @Expose
    @SerializedName("conto")
    private Float costo;

    @Expose
    @SerializedName("data")
    private Date data;

    @Expose
    @SerializedName("chiuso")
    private int chiuso;

    @Expose
    @SerializedName("tavolo")
    private Tavolo tavolo;

    public int getChiuso() {
        return chiuso;
    }

    public void setChiuso(int chiuso) {
        this.chiuso = chiuso;
    }

    public Conto() {
    }

    public Conto(int id_conto, Float costo, Date data, int chiuso, Tavolo tavolo) {
        this.id_conto = id_conto;
        this.costo = costo;
        this.data = data;
        this.chiuso = chiuso;
        this.tavolo = tavolo;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }
}
