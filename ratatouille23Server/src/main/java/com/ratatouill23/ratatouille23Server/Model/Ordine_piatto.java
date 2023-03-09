package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ordine_piatto")
public class Ordine_piatto {
    @Id
    @Column(name = "id_ordine_piatto")
    @GeneratedValue
    private int id_ordine_piatto;

    @Column(name = "qta")
    private int qta;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_ordine", referencedColumnName = "id_ordine")
    @JsonManagedReference
    private Ordine ordine;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_piatto", referencedColumnName = "id_piatto")
    @JsonManagedReference
    private Piatto piatto;

    public Ordine_piatto(int qta, Ordine ordine, Piatto piatto, int id_ordine_piatto) {
        this.qta = qta;
        this.ordine = ordine;
        this.piatto = piatto;
        this.id_ordine_piatto = id_ordine_piatto;
    }

    public int getId_ordine_piatto() {
        return id_ordine_piatto;
    }

    public void setId_ordine_piatto(int id_ordine_piatto) {
        this.id_ordine_piatto = id_ordine_piatto;
    }

    public Ordine_piatto() {
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public int getQta() {
        return qta;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public void setPiatto(Piatto piatto) {
        this.piatto = piatto;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public Piatto getPiatto() {
        return piatto;
    }
}
