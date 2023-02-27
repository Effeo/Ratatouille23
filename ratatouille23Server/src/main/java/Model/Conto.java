package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import Model.Tavolo;
import java.util.Date;
@Entity
@Table(name = "conto")
public class Conto {
    @Id
    @Column(name = "id_conto")
    private int id_conto;
    @Column(name = "costo")
    private float costo;
    @Column(name = "data")
    private Date data;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_tavolo", referencedColumnName = "id_tavolo")
    private Tavolo tavolo;

    public Conto() {
    }

    public Conto(int id_conto, float costo, Date data, Tavolo tavolo) {
        this.id_conto = id_conto;
        this.costo = costo;
        this.data = data;
        this.tavolo = tavolo;
    }

    public int getId_conto() {
        return id_conto;
    }

    public float getCosto() {
        return costo;
    }

    public Date getData() {
        return data;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public void setId_conto(int id_conto) {
        this.id_conto = id_conto;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }
}

