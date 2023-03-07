package com.ratatouill23.ratatouille23Server.Dto;

public class MessaggioDto {
    private int id_messaggio;
    private String corpo;

    public void setId_messaggio(int id_messaggio) {
        this.id_messaggio = id_messaggio;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public int getId_messaggio() {
        return id_messaggio;
    }

    public String getCorpo() {
        return corpo;
    }

    public MessaggioDto(int id_messaggio, String corpo) {
        this.id_messaggio = id_messaggio;
        this.corpo = corpo;
    }

    public MessaggioDto() {
    }
}
