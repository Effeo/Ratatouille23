package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Ordine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface OrdineRepository extends CrudRepository<Ordine, Integer> {
    @Query(value = "select * from ordine where ordine.id_ordine =:id_ordine", nativeQuery = true)
    public Optional<Ordine> findOrdineById(@PathVariable("id_ordine") Integer id_ordine);

    /*@Modifying
    @Query(value = "insert into ordine(id_tavolo) values (:idTavolo)", nativeQuery = true)
    @Transactional
    public void insert(@Param("idTavolo") Integer id_tavolo);*/
}
