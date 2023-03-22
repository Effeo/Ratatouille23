package com.ratatouill23.ratatouille23Server.Services.Interfaces;

import com.ratatouill23.ratatouille23Server.Model.Ordine;

import java.util.Optional;

public interface IOrdineService {
    public Optional<Ordine> findOrdineById(Integer id_ordine);

    public Ordine create(Ordine ordine);

    public Optional<Ordine> getGreatest();
}
