package com.ratatouill23.ratatouille23Server.Dto;

import jakarta.persistence.Column;

public class PiattoDto {
    private int id_piatto;

    private String nome;

    private String descrizione;

    private float costo;

    private int posto;

    private String allergeni;

    private String categoria;

    public void setId_piatto(int id_piatto) {
        this.id_piatto = id_piatto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_piatto() {
        return id_piatto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getCosto() {
        return costo;
    }

    public int getPosto() {
        return posto;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public String getCategoria() {
        return categoria;
    }

    public PiattoDto(int id_piatto, String nome, String descrizione, float costo, int posto, String allergeni, String categoria) {
        this.id_piatto = id_piatto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.costo = costo;
        this.posto = posto;
        this.allergeni = allergeni;
        this.categoria = categoria;
    }

    public PiattoDto() {
    }
}
