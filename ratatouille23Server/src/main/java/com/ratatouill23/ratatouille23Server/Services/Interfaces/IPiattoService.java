package com.ratatouill23.ratatouille23Server.Services.Interfaces;

import com.ratatouill23.ratatouille23Server.Model.Piatto;

import java.util.List;
import java.util.Optional;

public interface IPiattoService {

    public Optional<Piatto> findPiattoById(Integer id_piatto);

    public List<Piatto> findAll();
}
