package com.ratatouill23.ratatouille23Server.Services.Implementation;

import com.ratatouill23.ratatouille23Server.Model.Messaggio;
import com.ratatouill23.ratatouille23Server.Repositories.MessaggioRepository;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IMessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ImplMessaggioService")
public class ImplMessaggioService implements IMessaggioService {
    @Autowired
    private MessaggioRepository messaggioRepository;

    @Override
    public void create(Messaggio messaggio) {
        messaggioRepository.save(messaggio);
    }
}
