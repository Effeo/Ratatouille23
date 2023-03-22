package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Ordine_piatto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface Ordine_piattoRepository extends CrudRepository<Ordine_piatto, Integer> {

    //@Query(value = "select * from ordine_piatto", nativeQuery = true)
    public List<Ordine_piatto> findAll();

}
