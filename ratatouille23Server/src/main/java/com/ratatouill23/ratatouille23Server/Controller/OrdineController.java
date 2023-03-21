package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.OrdineDto;
import com.ratatouill23.ratatouille23Server.Model.Ordine;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IOrdineService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/ordine")
public class OrdineController {

    @Autowired
    @Qualifier("ImplOrdineService")
    private IOrdineService iOrdineService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/{id_ordine}")
    public OrdineDto findOrdineById(@PathVariable Integer id_ordine){
        Optional<Ordine> ordine = iOrdineService.findOrdineById(id_ordine);

        if(ordine.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        OrdineDto ordineDto = convertDto(ordine.get());
        return ordineDto;
    }

    @PostMapping("ordine/create")
    public void insert(@RequestBody OrdineDto ordineDto){
        System.out.println("id_tavolo: " + ordineDto.getId_tavolo());
        iOrdineService.create(ordineDto.getId_tavolo());
    }

    public OrdineDto convertDto(Ordine ordine){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        OrdineDto ordineDto = new OrdineDto();
        ordineDto = modelMapper.map(ordine, OrdineDto.class);

        return ordineDto;
    }
}
