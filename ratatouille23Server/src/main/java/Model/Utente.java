package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Utente() {
    }

    public Utente(String user_name, String password, String ruolo, int check_change_password) {
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
