package com.ratatouill23.ratatouille23Server.Dto;


public class Messaggio_utenteDto {
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

    public Messaggio_utenteDto(boolean letto, UtenteDto utente, MessaggioDto messaggio) {
        this.letto = letto;
        this.utente = utente;
        this.messaggio = messaggio;
    }

    public Messaggio_utenteDto() {
    }
}
