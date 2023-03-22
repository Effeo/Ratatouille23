package com.ratatouill23.ratatouille23Server.Services.Interfaces;

import com.ratatouill23.ratatouille23Server.Model.Conto;
import java.util.List;

public interface IContoService {

    public List<Conto> findAll();

    public void update(Conto conto);

    public void create(Conto conto);
}
