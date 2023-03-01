package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private List<Messaggio_ordine> messaggi_ordini = new ArrayList<>();

    public Messaggio(int id_messaggio, String corpo, ArrayList<Messaggio_ordine> messaggi_ordini) {
        this.id_messaggio = id_messaggio;
        this.corpo = corpo;
        this.messaggi_ordini = messaggi_ordini;
    }

    public List<Messaggio_ordine> getMessaggi_ordini() {
        return messaggi_ordini;
    }

    public void setMessaggi_ordini(List<Messaggio_ordine> messaggi_ordini) {
        this.messaggi_ordini = messaggi_ordini;
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
