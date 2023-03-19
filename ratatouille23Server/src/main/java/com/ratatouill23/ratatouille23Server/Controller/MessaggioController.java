package com.ratatouill23.ratatouille23Server.Controller;


import com.ratatouill23.ratatouille23Server.Dto.MessaggioDto;
import com.ratatouill23.ratatouille23Server.Model.Messaggio;
import com.ratatouill23.ratatouille23Server.Model.Piatto;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IMessaggioService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaggio")
public class MessaggioController {
    @Autowired
    @Qualifier("ImplMessaggioService")
    private IMessaggioService iMessaggioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    public void create(@RequestBody MessaggioDto messaggioDto){
        Messaggio messaggio = convertEntity(messaggioDto);
        iMessaggioService.create(messaggio);
    }

    private Messaggio convertEntity(MessaggioDto messaggioDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Messaggio messaggio = new Messaggio();
        messaggio = modelMapper.map(messaggioDto, Messaggio.class);

        return messaggio;
    }

}
