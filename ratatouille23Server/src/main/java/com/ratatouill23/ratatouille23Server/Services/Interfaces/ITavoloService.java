package com.ratatouill23.ratatouille23Server.Services.Interfaces;


import com.ratatouill23.ratatouille23Server.Model.Tavolo;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ITavoloService {

    public List<Tavolo> getTavoli();
}
