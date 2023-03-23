package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Dto.ContoDto;
import com.ratatouill23.ratatouille23Server.Dto.PiattoDto;
import com.ratatouill23.ratatouille23Server.Dto.UtenteDto;
import com.ratatouill23.ratatouille23Server.Model.Conto;
import com.ratatouill23.ratatouille23Server.Model.Utente;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IContoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conto")
public class ContoController {
    @Autowired
    @Qualifier("ImplContoService")
    private IContoService iContoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/getAllBeetween/{dataInizio}/{dataFine}")
    public List<ContoDto> findAllBeetween(@PathVariable String dataInizio, @PathVariable String dataFine){
        List<Conto> conti = iContoService.getAllBeetween(dataInizio, dataFine);
        List<ContoDto> contiDto = new ArrayList<>();

        for(Conto conto : conti)
            contiDto.add(convertDto(conto));

        return contiDto;
    }

    @GetMapping("/get/getAll")
    public List<ContoDto> findAll(){
        List<Conto> conti = iContoService.findAll();
        List<ContoDto> contiDto = new ArrayList<>();

        for(Conto conto : conti)
            contiDto.add(convertDto(conto));

        return contiDto;
    }

    @PutMapping("/update")
    public void update(@RequestBody ContoDto contoDto){
        Conto conto = convertEntity(contoDto);
        iContoService.update(conto);
    }

    @PostMapping("/create")
    public void create(@RequestBody ContoDto contoDto){
        iContoService.create(convertEntity(contoDto));
    }

    private Conto convertEntity(ContoDto contoDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Conto conto = new Conto();
        conto = modelMapper.map(contoDto, Conto.class);


        return conto;
    }

    public ContoDto convertDto(Conto conto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ContoDto contoDto = new ContoDto();
        contoDto = modelMapper.map(conto, ContoDto.class);

        contoDto.setId_tavolo(conto.getTavolo().getId_tavolo());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        contoDto.setData(simpleDateFormat.format(conto.getData()));

        return contoDto;
    }
}
