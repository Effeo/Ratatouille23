package com.ratatouill23.ratatouille23Server.Dto;

import jakarta.persistence.Column;

public class PiattoDto {
    private int idPiatto;

    private String nome;

    private String descrizione;

    private float costo;

    private int posto;

    private String allergeni;

    private String categoria;

    public void setIdPiatto(int idPiatto) {
        this.idPiatto = idPiatto;
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

    public int getIdPiatto() {
        return idPiatto;
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

    public PiattoDto(int idPiatto, String nome, String descrizione, float costo, int posto, String allergeni, String categoria) {
        this.idPiatto = idPiatto;
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
