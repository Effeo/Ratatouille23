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
    private List<Messaggio_utente> messaggi_utenti = new ArrayList<>();

    public Utente() {
    }

    public Utente(String user_name, String password, String ruolo, int check_change_password, ArrayList<Messaggio_utente> messaggi_utenti) {
        this.user_name = user_name;
        this.password = password;
        this.ruolo = ruolo;
        this.check_change_password = check_change_password;
        this.messaggi_utenti = messaggi_utenti;
    }

    public void setMessaggi_utenti(List<Messaggio_utente> messaggi_utenti) {
        this.messaggi_utenti = messaggi_utenti;
    }

    public List<Messaggio_utente> getMessaggi_utenti() {
        return messaggi_utenti;
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
