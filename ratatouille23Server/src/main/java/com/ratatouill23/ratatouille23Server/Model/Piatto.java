package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "piatto")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPiatto", scope = Long.class)
public class Piatto {
    @Id
    @Column(name = "id_piatto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiatto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "costo")
    private float costo;
    @Column(name = "posto")
    private int posto;
    @Column(name = "allergeni")
    private String allergeni;
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(mappedBy = "piatto", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Ordine_piatto> ordini_piatti = new ArrayList<>();

    public Piatto() {
    }

    public Piatto(int idPiatto, String nome, String descrizione, float costo, int posto, String allergeni, String categoria, ArrayList<Ordine_piatto> ordini_piatti) {
        this.idPiatto = idPiatto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.costo = costo;
        this.posto = posto;
        this.allergeni = allergeni;
        this.categoria = categoria;
        this.ordini_piatti = ordini_piatti;
    }

    public void setOrdini_piatti(List<Ordine_piatto> ordini_piatti) {
        this.ordini_piatti = ordini_piatti;
    }

    public List<Ordine_piatto> getOrdini_piatti() {
        return ordini_piatti;
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
}
