package com.ratatouill23.ratatouille23Server.Dto;

import java.util.Date;

public class ContoDto {

    private int id_conto;

    private Float costo;

    private String data;

    private int chiuso;

    private int id_tavolo;

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

    public int getChiuso() {
        return chiuso;
    }

    public void setChiuso(int chiuso) {
        this.chiuso = chiuso;
    }

    public int getId_tavolo() {
        return id_tavolo;
    }

    public void setId_tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }

    public ContoDto(int id_conto, Float costo, String data, int chiuso, int id_tavolo) {
        this.id_conto = id_conto;
        this.costo = costo;
        this.data = data;
        this.chiuso = chiuso;
        this.id_tavolo = id_tavolo;
    }

    public ContoDto() {
    }
}
