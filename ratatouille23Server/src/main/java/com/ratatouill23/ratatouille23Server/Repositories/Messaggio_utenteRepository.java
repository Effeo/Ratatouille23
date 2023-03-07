package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Messaggio_utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface Messaggio_utenteRepository extends CrudRepository<Messaggio_utente, Integer> {

    @Query(value = "select * from messaggio_utente where letto = false and messaggio_utente.user_name =:user_name", nativeQuery = true)
    public List<Messaggio_utente> getAllMessaggioUtente(@PathVariable("user_name") String user_name);
}
