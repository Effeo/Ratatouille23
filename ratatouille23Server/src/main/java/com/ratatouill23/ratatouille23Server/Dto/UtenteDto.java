package com.ratatouill23.ratatouille23Server.Dto;

public class UtenteDto {
    private String user_name;
    private String password;
    private String ruolo;
    private int check_change_password;

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

    public UtenteDto(String user_name, String password, String ruolo, int check_change_password) {
        this.user_name = user_name;
        this.password = password;
        this.ruolo = ruolo;
        this.check_change_password = check_change_password;
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

    public UtenteDto() {
    }
}
