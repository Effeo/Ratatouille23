package com.ratatouill23.ratatouille23Server.Services.Interfaces;

import com.ratatouill23.ratatouille23Server.Model.Messaggio_utente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IMessaggio_utenteService {

    public List<Messaggio_utente> getAllMessaggioUtente(String user_name);

    public void update(Messaggio_utente messaggio_utente);
}
