package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Service.Callback;

public interface IOpenFoodService {

    public void getDescrizione(Callback callback, String nome);

    public void getAllergeni(Callback callback, String nome);
}
