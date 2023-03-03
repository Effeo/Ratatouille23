package com.ratatouill23.ratatouille23Server.Dto;

public class Ordine_Piatto_Dto {
    private int id_ordine_piatto;

    private int qta;

    private int id_ordine;

    private int id_piatto;

    public void setId_ordine_piatto(int id_ordine_piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public void setId_piatto(int id_piatto) {
        this.id_piatto = id_piatto;
    }

    public Ordine_Piatto_Dto() {
    }

    public int getId_ordine_piatto() {
        return id_ordine_piatto;
    }

    public int getQta() {
        return qta;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public int getId_piatto() {
        return id_piatto;
    }

    public Ordine_Piatto_Dto(int id_ordine_piatto, int qta, int id_ordine, int id_piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
        this.qta = qta;
        this.id_ordine = id_ordine;
        this.id_piatto = id_piatto;
    }
}
