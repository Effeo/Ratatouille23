package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.PiattoDto;
import com.ratatouill23.ratatouille23Server.Model.Piatto;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IPiattoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("get/getAll")
    public List<PiattoDto> findAll(){
        List<Piatto> piatti = iPiattoService.findAll();
        List<PiattoDto> piattiDto = new ArrayList<>();

        for(Piatto piatto : piatti)
            piattiDto.add(convertDto(piatto));

        return piattiDto;
    }

    public PiattoDto convertDto(Piatto piatto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PiattoDto piattoDto = new PiattoDto();
        piattoDto = modelMapper.map(piatto, PiattoDto.class);

        return piattoDto;
    }

    private Piatto convertEntity(PiattoDto piattoDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Piatto piatto = new Piatto();
        piatto = modelMapper.map(piattoDto, Piatto.class);

        return piatto;
    }

    @PostMapping("/create")
    public void create(@RequestBody PiattoDto piattoDto){
        Piatto piatto = convertEntity(piattoDto);
        iPiattoService.create(piatto);
    }


}
