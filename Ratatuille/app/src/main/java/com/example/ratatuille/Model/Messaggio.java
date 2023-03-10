package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Messaggio {

    @Expose
    @SerializedName("id_messaggio")
    private int id_messaggio;

    @Expose
    @SerializedName("corpo")
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

    public Messaggio(int id_messaggio, String corpo) {
        this.id_messaggio = id_messaggio;
        this.corpo = corpo;
    }

    public Messaggio() {
    }
}
