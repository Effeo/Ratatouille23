package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Model.Messaggio;
import com.example.ratatuille.Service.Callback;

public interface IMessaggioService {

    public void create(Callback callback, Messaggio messaggio);
}
