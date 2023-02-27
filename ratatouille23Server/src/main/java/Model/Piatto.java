package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import Model.Ordine_piatto;

import java.util.ArrayList;

@Entity
@Table(name = "piatto")
public class Piatto {
    @Id
    @Column(name = "id_piatto")
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
    private ArrayList<Ordine_piatto> ordini_piatti;

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

    public void setOrdini_piatti(ArrayList<Ordine_piatto> ordini_piatti) {
        this.ordini_piatti = ordini_piatti;
    }

    public ArrayList<Ordine_piatto> getOrdini_piatti() {
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
