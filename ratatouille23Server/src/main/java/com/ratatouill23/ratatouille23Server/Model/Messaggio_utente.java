package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "messaggio_utente")
public class Messaggio_utente {

    @Id
    @Column(name = "id_messaggio_utente")
    private int id_messaggio_utente;

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

    public Messaggio_utente(int id_messaggio_utente, boolean letto, Utente utente, Messaggio messaggio) {
        this.id_messaggio_utente = id_messaggio_utente;
        this.letto = letto;
        this.utente = utente;
        this.messaggio = messaggio;
    }

    public Messaggio_utente() {
    }

    public int getId_messaggio_utente() {
        return id_messaggio_utente;
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

    public void setId_messaggio_utente(int id_messaggio_utente) {
        this.id_messaggio_utente = id_messaggio_utente;
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
