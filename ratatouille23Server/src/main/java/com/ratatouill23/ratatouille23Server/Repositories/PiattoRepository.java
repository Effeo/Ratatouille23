package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Piatto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface PiattoRepository extends CrudRepository<Piatto, Integer> {

    @Query(value = "select * from piatto where piatto.id_piatto =:id_piatto", nativeQuery = true)
    public Optional<Piatto> findPiattoByID(@PathVariable("id_piatto") Integer id_piatto);

    public List<Piatto> findAll();
}
