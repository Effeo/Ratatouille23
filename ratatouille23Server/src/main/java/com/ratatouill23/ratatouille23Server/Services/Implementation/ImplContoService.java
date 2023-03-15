package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Conto;
import com.ratatouill23.ratatouille23Server.Repositories.ContoRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IContoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ImplContoService")
public class ImplContoService implements IContoService {
    @Autowired
    private ContoRepository contoRepository;

    @Override
    public List<Conto> findAll() {
        return contoRepository.findAll();
    }

    @Override
    public void update(Conto conto) {
        contoRepository.save(conto);
    }
}
