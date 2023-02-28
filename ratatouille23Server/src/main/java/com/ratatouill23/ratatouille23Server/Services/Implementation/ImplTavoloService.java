package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Tavolo;
import com.ratatouill23.ratatouille23Server.Repositories.TavoloRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.ITavoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ImplTavoloService")
public class ImplTavoloService implements ITavoloService {

    @Autowired
    private TavoloRepository tavoloRepository;

    @Override
    public List<Tavolo> getTavoli() {
        return tavoloRepository.findAll();
    }
}
