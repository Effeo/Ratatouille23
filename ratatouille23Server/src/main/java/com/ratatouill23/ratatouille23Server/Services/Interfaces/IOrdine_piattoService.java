package com.ratatouill23.ratatouille23Server.Services.Interfaces;

import com.ratatouill23.ratatouille23Server.Model.Ordine_piatto;

import java.util.List;

public interface IOrdine_piattoService {

    public List<Ordine_piatto> getOrdiniPiatti();

    public void delete(Ordine_piatto ordine_piatto);
}
