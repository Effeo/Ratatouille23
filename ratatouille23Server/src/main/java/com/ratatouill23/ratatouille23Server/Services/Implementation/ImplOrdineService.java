package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Ordine;
import com.ratatouill23.ratatouille23Server.Repositories.OrdineRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IOrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ImplOrdineService")
public class ImplOrdineService implements IOrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    @Override
    public Optional<Ordine> findOrdineById(Integer id_ordine) {
        return ordineRepository.findOrdineById(id_ordine);
    }
}
