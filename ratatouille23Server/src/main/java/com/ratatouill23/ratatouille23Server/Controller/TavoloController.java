package com.ratatouill23.ratatouille23Server.Controller;

import com.ratatouill23.ratatouille23Server.Model.Tavolo;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.ITavoloService;
import com.ratatouill23.ratatouille23Server.Services.Interfaces.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tavolo")
public class TavoloController {
    @Autowired
    @Qualifier("ImplTavoloService")
    private ITavoloService iTavoloService;

    @GetMapping("/get/getTavoli")
    public List<Tavolo> getTavoli(){
        List<Tavolo> tavoli = iTavoloService.getTavoli();

        if(!tavoli.isEmpty())
            return tavoli;
        else
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Errore: nessun tavolo");
    }
}
