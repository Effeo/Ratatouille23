package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Piatto {

    @Expose
    @SerializedName("id_piatto")
    private int idPiatto;

    @Expose
    @SerializedName("nome")
    private String nome;

    @Expose
    @SerializedName("descizione")
    private String descrizione;

    @Expose
    @SerializedName("costo")
    private float costo;

    @Expose
    @SerializedName("costo")
    private int posto;

    @Expose
    @SerializedName("allergeni")
    private String allergeni;

    @Expose
    @SerializedName("categoria")
    private String categoria;

    public Piatto() {
    }

    public Piatto(int idPiatto, String nome, String descrizione, float costo, int posto, String allergeni, String categoria) {
        this.idPiatto = idPiatto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.costo = costo;
        this.posto = posto;
        this.allergeni = allergeni;
        this.categoria = categoria;
    }

    public int getIdPiatto() {
        return idPiatto;
    }

    public void setIdPiatto(int idPiatto) {
        this.idPiatto = idPiatto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    public String getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String allergeni) {
        this.allergeni = allergeni;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
