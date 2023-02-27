package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import Model.Conto;
import Model.Ordine;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table(name = "tavolo")
public class Tavolo {
    @Id
    @Column(name = "id_tavolo")
    private int id_tavolo;

    @OneToOne(mappedBy = "tavolo", fetch = FetchType.EAGER)
    @JsonBackReference
    private Conto conto;

    @OneToMany(mappedBy = "tavolo", fetch = FetchType.LAZY)
    @JsonBackReference
    private ArrayList<Ordine> ordini;
    public Tavolo() {
    }

    public Tavolo(int id_tavolo, Conto conto, ArrayList<Ordine> ordini) {
        this.id_tavolo = id_tavolo;
        this.conto = conto;
        this.ordini = ordini;
    }

    public void setOrdini(ArrayList<Ordine> ordini) {
        this.ordini = ordini;
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public Conto getConto() {
        return conto;
    }

    public void setConto(Conto conto) {
        this.conto = conto;
    }

    public int getId_tavolo() {
        return id_tavolo;
    }

    public void setId_tavolo(int id_tavolo) {
        this.id_tavolo = id_tavolo;
    }
}
