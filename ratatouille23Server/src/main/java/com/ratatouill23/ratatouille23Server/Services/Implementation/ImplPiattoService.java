package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Piatto;
import com.ratatouill23.ratatouille23Server.Repositories.PiattoRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IPiattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ImplPiattoService")
public class ImplPiattoService implements IPiattoService {
    @Autowired
    private PiattoRepository piattoRepository;
    @Override
    public Optional<Piatto> findPiattoById(Integer id_piatto) {
        return piattoRepository.findPiattoByID(id_piatto);
    }
}