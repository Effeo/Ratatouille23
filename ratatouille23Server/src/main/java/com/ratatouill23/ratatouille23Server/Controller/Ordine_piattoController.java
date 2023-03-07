package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.OrdineDto;
import com.ratatouill23.ratatouille23Server.Dto.Ordine_Piatto_Dto;
import com.ratatouill23.ratatouille23Server.Dto.PiattoDto;
import com.ratatouill23.ratatouille23Server.Model.Ordine;
import com.ratatouill23.ratatouille23Server.Model.Ordine_piatto;
import com.ratatouill23.ratatouille23Server.Model.Piatto;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IOrdine_piattoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ordine_piatto")
public class Ordine_piattoController {
    @Autowired
    @Qualifier("ImplOrdine_piatto")
    private IOrdine_piattoService iOrdine_piatto;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/getOrdini_piatti")
    public List<Ordine_Piatto_Dto> getOrdini_Piatti(){
        List<Ordine_piatto> ordini_piatti = iOrdine_piatto.getOrdiniPiatti();
        List<Ordine_Piatto_Dto> ordini_piatti_dto = new ArrayList<>();

        for(Ordine_piatto ordine_piatto : ordini_piatti)
            ordini_piatti_dto.add(convertDto(ordine_piatto));

        return ordini_piatti_dto;
    }

    private Ordine_Piatto_Dto convertDto(Ordine_piatto element) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Ordine_Piatto_Dto ordine_piatto_dto = new Ordine_Piatto_Dto();
        ordine_piatto_dto = modelMapper.map(element, Ordine_Piatto_Dto.class);

        ordine_piatto_dto.setOrdine(convertDto(element.getOrdine()));
        ordine_piatto_dto.setPiatto(convertDto(element.getPiatto()));

        return ordine_piatto_dto;
    }

    private PiattoDto convertDto(Piatto piatto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PiattoDto piattoDto = new PiattoDto();
        piattoDto = modelMapper.map(piatto, PiattoDto.class);

        return piattoDto;
    }

    private OrdineDto convertDto(Ordine ordine){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        OrdineDto ordineDto = new OrdineDto();
        ordineDto = modelMapper.map(ordine, OrdineDto.class);

        ordineDto.setId_tavolo(ordine.getTavolo().getId_tavolo());
        return ordineDto;
    }
}
