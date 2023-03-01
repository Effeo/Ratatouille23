package com.ratatouill23.ratatouille23Server.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "password")
    private String password;
    @Column(name = "ruolo")
    private String ruolo;
    @Column(name = "check_change_password")
    private int check_change_password;

    @OneToMany(mappedBy = "utente", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Messaggio_ordine> messaggi_ordini = new ArrayList<>();

    public Utente() {
    }

    public Utente(String user_name, String password, String ruolo, int check_change_password, ArrayList<Messaggio_ordine> messaggi_ordini) {
        this.user_name = user_name;
        this.password = password;
        this.ruolo = ruolo;
        this.check_change_password = check_change_password;
        this.messaggi_ordini = messaggi_ordini;
    }

    public void setMessaggi_ordini(List<Messaggio_ordine> messaggi_ordini) {
        this.messaggi_ordini = messaggi_ordini;
    }

    public List<Messaggio_ordine> getMessaggi_ordini() {
        return messaggi_ordini;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getRuolo() {
        return ruolo;
    }

    public int getCheck_change_password() {
        return check_change_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public void setCheck_change_password(int check_change_password) {
        this.check_change_password = check_change_password;
    }
}
