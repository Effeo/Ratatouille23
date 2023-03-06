package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.PiattoDto;
import com.ratatouill23.ratatouille23Server.Model.Piatto;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IPiattoService;
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

import java.util.Optional;

@RestController
@RequestMapping("/piatto")
public class PiattoController {
    @Autowired
    @Qualifier("ImplPiattoService")
    private IPiattoService iPiattoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/{id_piatto}")
    public PiattoDto findPiattoById(@PathVariable Integer id_piatto){
        Optional<Piatto> piatto = iPiattoService.findPiattoById(id_piatto);

        if(piatto.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        PiattoDto piattoDto = convertDto(piatto.get());
        return piattoDto;
    }

    public PiattoDto convertDto(Piatto piatto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PiattoDto piattoDto = new PiattoDto();
        piattoDto = modelMapper.map(piatto, PiattoDto.class);

        return piattoDto;
    }
}
