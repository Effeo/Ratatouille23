package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Service.Callback;

public interface IUtenteService {

    void findUtenteByUser_nameAndPassword(Callback callback, String user_name, String password);


}
