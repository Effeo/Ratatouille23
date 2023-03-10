package com.example.ratatuille.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Utente implements Serializable {

    @Expose
    @SerializedName("user_name")
    private String user_name;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("ruolo")
    private String ruolo;

    @Expose
    @SerializedName("check_change_password")
    private int check_change_password;

    public Utente(String user_name, String password, String ruolo, int check_change_password) {
        this.user_name = user_name;
        this.password = password;
        this.ruolo = ruolo;
        this.check_change_password = check_change_password;
    }

    public Utente() {
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public void setCheck_change_password(int check_change_password) {
        this.check_change_password = check_change_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
