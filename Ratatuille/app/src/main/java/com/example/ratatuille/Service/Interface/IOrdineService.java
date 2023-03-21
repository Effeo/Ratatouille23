package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Model.Ordine;
import com.example.ratatuille.Service.Callback;

public interface IOrdineService {

    public void create(Callback callback, Ordine ordine);

    public void getGreatest(Callback callback);
}
