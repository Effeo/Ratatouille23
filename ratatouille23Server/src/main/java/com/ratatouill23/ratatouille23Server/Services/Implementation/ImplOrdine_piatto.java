package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Ordine_piatto;
import com.ratatouill23.ratatouille23Server.Repositories.Ordine_piattoRepository;
import com.ratatouill23.ratatouille23Server.Repositories.TavoloRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IOrdine_piatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ImplOrdine_piatto")
public class ImplOrdine_piatto implements IOrdine_piatto {
    @Autowired
    private Ordine_piattoRepository ordinePiattoRepository;

    @Override
    public List<Ordine_piatto> getOrdiniPiatti() {
        return ordinePiattoRepository.findAll();
    }
}
