package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Tavolo;
import com.ratatouill23.ratatouille23Server.Model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface TavoloRepository extends CrudRepository<Tavolo, Integer> {

    public List<Tavolo> findAll();


}
