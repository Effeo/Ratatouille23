package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;

public interface IUtenteService {

    void findUtenteByUser_nameAndPassword(Callback callback, String user_name, String password);

    void update(Callback callback, Utente utente);

    void create(Callback callback, Utente utente);

    void getAll(Callback callback);
}
