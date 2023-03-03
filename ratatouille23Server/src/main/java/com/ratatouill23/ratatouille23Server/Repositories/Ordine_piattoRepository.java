package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Ordine_piatto;
import com.ratatouill23.ratatouille23Server.Model.Tavolo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ordine_piattoRepository extends CrudRepository<Ordine_piatto, Integer> {

    public List<Ordine_piatto> findAll();
}
