package com.ratatouill23.ratatouille23Server.Dto;


public class Messaggio_utenteDto {
    private int id_messaggi_utente;
    private boolean letto;
    private UtenteDto utente;
    private MessaggioDto messaggio;

    public boolean isLetto() {
        return letto;
    }

    public UtenteDto getUtente() {
        return utente;
    }

    public MessaggioDto getMessaggio() {
        return messaggio;
    }

    public void setLetto(boolean letto) {
        this.letto = letto;
    }

    public void setUtente(UtenteDto utente) {
        this.utente = utente;
    }

    public void setMessaggio(MessaggioDto messaggio) {
        this.messaggio = messaggio;
    }

    public void setId_messaggi_utente(int id_messaggi_utente) {
        this.id_messaggi_utente = id_messaggi_utente;
    }

    public int getId_messaggi_utente() {
        return id_messaggi_utente;
    }

    public Messaggio_utenteDto(int id_messaggi_utente, boolean letto, UtenteDto utente, MessaggioDto messaggio) {
        this.letto = letto;
        this.utente = utente;
        this.messaggio = messaggio;
        this.id_messaggi_utente = id_messaggi_utente;
    }

    public Messaggio_utenteDto() {
    }
}
