package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Ordine_piatto;
import com.ratatouill23.ratatouille23Server.Repositories.Ordine_piattoRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IOrdine_piattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ImplOrdine_piatto")
public class ImplOrdine_piattoService implements IOrdine_piattoService {
    @Autowired
    private Ordine_piattoRepository ordinePiattoRepository;

    @Override
    public List<Ordine_piatto> getOrdiniPiatti() {
        return ordinePiattoRepository.findAll();
    }

    @Override
    public void delete(Integer id_ordine_piatto) {
        ordinePiattoRepository.deleteById(id_ordine_piatto);
    }

    @Override
    public void create(Ordine_piatto ordine_piatto) {
        ordinePiattoRepository.save(ordine_piatto);
    }
}
