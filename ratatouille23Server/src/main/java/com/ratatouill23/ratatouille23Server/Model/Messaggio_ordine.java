package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "messaggio_ordine")
public class Messaggio_ordine {

    @Id
    @Column(name = "id_messaggio_ordine")
    private int id_messaggio_ordine;

    @Column(name = "letto")
    private boolean letto;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    @JsonManagedReference
    private Utente utente;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_messaggio", referencedColumnName = "id_messaggio")
    @JsonManagedReference
    private Messaggio messaggio;

    public Messaggio_ordine(int id_messaggio_ordine, boolean letto, Utente utente, Messaggio messaggio) {
        this.id_messaggio_ordine = id_messaggio_ordine;
        this.letto = letto;
        this.utente = utente;
        this.messaggio = messaggio;
    }

    public Messaggio_ordine() {
    }

    public int getId_messaggio_ordine() {
        return id_messaggio_ordine;
    }

    public boolean isLetto() {
        return letto;
    }

    public Utente getUtente() {
        return utente;
    }

    public Messaggio getMessaggio() {
        return messaggio;
    }

    public void setId_messaggio_ordine(int id_messaggio_ordine) {
        this.id_messaggio_ordine = id_messaggio_ordine;
    }

    public void setLetto(boolean letto) {
        this.letto = letto;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }
}
