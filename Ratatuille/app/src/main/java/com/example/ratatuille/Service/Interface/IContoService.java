package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Model.Conto;
import com.example.ratatuille.Service.Callback;

public interface IContoService {

    public void getAllConti(Callback callback);

    public void update(Callback callback, Conto conto);
}
