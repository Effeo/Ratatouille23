package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.TavoloDto;
import com.ratatouill23.ratatouille23Server.Model.Tavolo;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.ITavoloService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tavolo")
public class TavoloController {
    @Autowired
    @Qualifier("ImplTavoloService")
    private ITavoloService iTavoloService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/getTavoli")
    public List<Tavolo> getTavoli(){
        List<Tavolo> tavoli = iTavoloService.getTavoli();

        if(!tavoli.isEmpty())
            return tavoli;
        else
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Errore: nessun tavolo");
    }

    public TavoloDto convertDto(Tavolo tavolo){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TavoloDto tavoloDto = new TavoloDto();
        tavoloDto = modelMapper.map(tavolo, TavoloDto.class);

        return tavoloDto;
    }
}
