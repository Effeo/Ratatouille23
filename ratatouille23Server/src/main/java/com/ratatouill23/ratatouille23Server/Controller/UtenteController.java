package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.UtenteDto;
import com.ratatouill23.ratatouille23Server.Model.Utente;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IUtenteService;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    @Qualifier("ImplUtenteService")
    private IUtenteService utenteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/{user_name}/{password}")
    public Optional<Utente> findUtenteByUser_nameAndPassword(@PathVariable String user_name, @PathVariable String password){
        Optional<Utente> utente = utenteService.findUtenteByUser_nameAndPassword(user_name, password);

        if(utente.isPresent())
            return utente;
        else
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Errore: user name o password errata");
    }

    @PutMapping("/update")
    public void updatePasswordUtente(@RequestBody UtenteDto utenteDto){
        Utente utente = this.convertEntity(utenteDto);
        utenteService.update(utente);
    }

    private UtenteDto convertDTO(Utente utente) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UtenteDto utenteDto = new UtenteDto();
        utenteDto = modelMapper.map(utente, UtenteDto.class);

        return utenteDto;
    }

    private Utente convertEntity(UtenteDto userDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Utente user = new Utente();
        user = modelMapper.map(userDTO, Utente.class);


        return user;
    }
}
