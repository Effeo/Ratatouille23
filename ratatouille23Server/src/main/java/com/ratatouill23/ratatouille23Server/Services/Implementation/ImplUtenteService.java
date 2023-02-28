package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Utente;
import com.ratatouill23.ratatouille23Server.Repositories.UtenteRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ImplUtenteService")
public class ImplUtenteService implements IUtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public Optional<Utente> findUtenteByUser_nameAndPassword(String user_name, String password) {
        return utenteRepository.findUtenteByUser_nameAndPassword(user_name, password);
    }

    @Override
    public void update(Utente utente) {
        utenteRepository.save(utente);
    }
}
