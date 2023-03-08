package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Messaggio_utente;
import com.ratatouill23.ratatouille23Server.Repositories.Messaggio_utenteRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IMessaggio_utenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ImplMessaggio_utenteSerice")
public class ImplMessaggio_utenteService implements IMessaggio_utenteService {
    @Autowired
    private Messaggio_utenteRepository messaggioUtenteRepository;

    @Override
    public List<Messaggio_utente> getAllMessaggioUtente(String user_name) {
        return messaggioUtenteRepository.getAllMessaggioUtente(user_name);
    }

    public void update(Messaggio_utente messaggio_utente){
        messaggioUtenteRepository.save(messaggio_utente);
    }
}
