package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tavolo")
public class Tavolo {
    @Id
    @Column(name = "id_tavolo")
    private int id_tavolo;

    @OneToOne(mappedBy = "tavolo", fetch = FetchType.EAGER)
    @JsonBackReference
    private Conto conto;

    @OneToMany(mappedBy = "tavolo", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Ordine> ordini = new ArrayList<>();

    public Tavolo() {
    }

    public Tavolo(int id_tavolo, Conto conto, ArrayList<Ordine> ordini) {
        this.id_tavolo = id_tavolo;
        this.conto = conto;
        this.ordini = ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public Conto getConto() {
        return conto;
    }

    public void setConto(Conto conto) {
        this.conto = conto;
    }

    public int getId_tavolo() {
        return id_tavolo;
    }

    public void setId_tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }
}
