package com.ratatouill23.ratatouille23Server.Repositories;


import com.ratatouill23.ratatouille23Server.Model.Conto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContoRepository extends CrudRepository<Conto, Integer> {
    @Query(value = "select * from conto where chiuso = 0", nativeQuery = true)
    public List<Conto> findAll();
}
