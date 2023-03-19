package com.ratatouill23.ratatouille23Server.Repositories;

import com.ratatouill23.ratatouille23Server.Model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, String> {

    @Query(value = "select * from utente where utente.user_name =:user_name and utente.password =:password", nativeQuery = true)
    public Optional<Utente> findUtenteByUser_nameAndPassword(@PathVariable("user_name") String user_name,@PathVariable("password") String password);

    @Query(value = "select * from utente where true", nativeQuery = true)
    public List<Utente> getAll();
}
