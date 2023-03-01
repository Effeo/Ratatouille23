package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @Column(name = "id_ordine")
    private int id_ordine;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_tavolo", referencedColumnName = "id_tavolo")
    @JsonManagedReference
    private Tavolo tavolo;

    @OneToMany(mappedBy = "ordine", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Ordine_piatto> ordini_piatti = new ArrayList<>();

    public Ordine(int id_ordine, Tavolo tavolo, ArrayList<Ordine_piatto> ordini_piatti) {
        this.id_ordine = id_ordine;
        this.tavolo = tavolo;
        this.ordini_piatti = ordini_piatti;
    }

    public List<Ordine_piatto> getOrdini_piatti() {
        return ordini_piatti;
    }

    public void setOrdini_piatti(List<Ordine_piatto> ordini_piatti) {
        this.ordini_piatti = ordini_piatti;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public Ordine() {
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public int getId_ordine() {
        return id_ordine;
    }

}
