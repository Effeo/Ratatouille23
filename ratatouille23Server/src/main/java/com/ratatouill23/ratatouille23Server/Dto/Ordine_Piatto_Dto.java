package com.ratatouill23.ratatouille23Server.Dto;

import com.ratatouill23.ratatouille23Server.Model.Piatto;

public class Ordine_Piatto_Dto {
    private int id_ordine_piatto;

    private int qta;

    private OrdineDto ordine;

    private PiattoDto piatto;

    public void setId_ordine_piatto(int id_ordine_piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public void setOrdine(OrdineDto ordine) {
        this.ordine = ordine;
    }

    public void setPiatto(PiattoDto piatto) {
        this.piatto = piatto;
    }

    public Ordine_Piatto_Dto() {
    }

    public int getId_ordine_piatto() {
        return id_ordine_piatto;
    }

    public int getQta() {
        return qta;
    }

    public OrdineDto getOrdine() {
        return ordine;
    }

    public PiattoDto getPiatto() {
        return piatto;
    }

    public Ordine_Piatto_Dto(int id_ordine_piatto, int qta, OrdineDto ordine, PiattoDto piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
        this.qta = qta;
        this.ordine = ordine;
        this.piatto = piatto;
    }
}
