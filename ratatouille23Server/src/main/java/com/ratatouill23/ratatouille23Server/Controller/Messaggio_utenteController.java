package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.MessaggioDto;
import com.ratatouill23.ratatouille23Server.Dto.Messaggio_utenteDto;
import com.ratatouill23.ratatouille23Server.Dto.Ordine_Piatto_Dto;
import com.ratatouill23.ratatouille23Server.Dto.UtenteDto;
import com.ratatouill23.ratatouille23Server.Model.Messaggio;
import com.ratatouill23.ratatouille23Server.Model.Messaggio_utente;
import com.ratatouill23.ratatouille23Server.Model.Utente;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IMessaggio_utenteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messaggio_utente")
public class Messaggio_utenteController {

    @Autowired
    @Qualifier("ImplMessaggio_utenteSerice")
    private IMessaggio_utenteService iMessaggioUtenteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/getAllMessaggioUtente/{user_name}")
    public List<Messaggio_utenteDto> getAllMessaggioUtente(@PathVariable String user_name){
        List<Messaggio_utente> messaggi_utenti = iMessaggioUtenteService.getAllMessaggioUtente(user_name);
        List<Messaggio_utenteDto> messaggi_utentiDto = new ArrayList<>();

        for(Messaggio_utente messaggio_utente : messaggi_utenti)
            messaggi_utentiDto.add(convertDto(messaggio_utente));

        return messaggi_utentiDto;
    }

    private Messaggio_utenteDto convertDto(Messaggio_utente messaggio_utente){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Messaggio_utenteDto messaggio_utenteDto = new Messaggio_utenteDto();
        messaggio_utenteDto = modelMapper.map(messaggio_utente, Messaggio_utenteDto.class);

        messaggio_utenteDto.setMessaggio(convertDto(messaggio_utente.getMessaggio()));
        messaggio_utenteDto.setUtente(convertDto(messaggio_utente.getUtente()));

        return messaggio_utenteDto;
    }

    @PutMapping("/update")
    public void updateLetto(@RequestBody Messaggio_utenteDto messaggio_utenteDto){
        Messaggio_utente messaggio_utente = convertEntity(messaggio_utenteDto);
        iMessaggioUtenteService.update(messaggio_utente);
    }

    private Messaggio_utente convertEntity(Messaggio_utenteDto messaggio_utenteDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Messaggio_utente messaggio_utente = new Messaggio_utente();
        messaggio_utente = modelMapper.map(messaggio_utenteDto, Messaggio_utente.class);

        return messaggio_utente;
    }

    private UtenteDto convertDto(Utente utente) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UtenteDto utenteDto = new UtenteDto();
        utenteDto = modelMapper.map(utente, UtenteDto.class);

        return utenteDto;
    }

    private MessaggioDto convertDto(Messaggio messaggio) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        MessaggioDto messaggioDto = new MessaggioDto();
        messaggioDto = modelMapper.map(messaggio, MessaggioDto.class);

        return messaggioDto;
    }
}
