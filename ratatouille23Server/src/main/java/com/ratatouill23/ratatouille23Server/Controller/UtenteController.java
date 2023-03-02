package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.UtenteDto;
import com.ratatouill23.ratatouille23Server.Model.Utente;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    @Qualifier("ImplUtenteService")
    private IUtenteService utenteService;

    @GetMapping("/get/{user_name}/{password}")
    public Optional<Utente> findUtenteByUser_nameAndPassword(@PathVariable String user_name, @PathVariable String password){
        Optional<Utente> utente = utenteService.findUtenteByUser_nameAndPassword(user_name, password);

        if(utente.isPresent())
            return utente;
        else
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Errore: user name o password errata");
    }

    @PutMapping("/update")
    public void updatePasswordUtente(@RequestBody Utente utente){
        utenteService.update(utente);
    }

    /*private UtenteDto convertDTO(Utente utente) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UtenteDto utenteDto = new UtenteDto();
        utenteDto = modelMapper.map(utente, UtenteDto.class);

        //String restaurant_name = utente.getRestaurant().getName();
        //utenteDto.setRestaurantName(restaurant_name);
        return utente;
    }*/
}
