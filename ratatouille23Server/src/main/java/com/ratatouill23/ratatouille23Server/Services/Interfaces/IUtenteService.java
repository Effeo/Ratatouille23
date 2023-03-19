package com.ratatouill23.ratatouille23Server.Services.Interfaces;

import com.ratatouill23.ratatouille23Server.Model.Utente;

import java.util.List;
import java.util.Optional;


public interface IUtenteService {

    public Optional<Utente> findUtenteByUser_nameAndPassword(String user_name, String password);

    public void update(Utente utente);

    public void create(Utente utente);

    public List<Utente> findAll();
}
