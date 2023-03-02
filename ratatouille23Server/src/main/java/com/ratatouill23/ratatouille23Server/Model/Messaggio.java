package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "messaggio")
public class Messaggio {
    @Id
    @Column(name = "id_messaggio")
    private int id_messaggio;

    @Column(name = "corpo")
    private String corpo;

    @OneToMany(mappedBy = "messaggio", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Messaggio_utente> messaggi_utenti = new ArrayList<>();

    public Messaggio(int id_messaggio, String corpo, ArrayList<Messaggio_utente> id_messaggio_utente) {
        this.id_messaggio = id_messaggio;
        this.corpo = corpo;
        this.messaggi_utenti = id_messaggio_utente;
    }

    public List<Messaggio_utente> getMessaggi_utenti() {
        return messaggi_utenti;
    }

    public void setMessaggi_utenti(List<Messaggio_utente> messaggi_utenti) {
        this.messaggi_utenti = messaggi_utenti;
    }

    public Messaggio() {
    }

    public int getId_messaggio() {
        return id_messaggio;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setId_messaggio(int id_messaggio) {
        this.id_messaggio = id_messaggio;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
