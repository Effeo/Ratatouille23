package com.ratatouill23.ratatouille23Server.Dto;

public class OrdineDto {

    private int id_ordine;

    private int id_tavolo;

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public void setId_tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public int getId_tavolo() {
        return id_tavolo;
    }

    public OrdineDto(int id_ordine, int id_tavolo) {
        this.id_ordine = id_ordine;
        this.id_tavolo = id_tavolo;
    }

    public OrdineDto() {
    }
}

