package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Service.Callback;

public interface IPiattoService {
    public void findPiattoById(Callback callback, int id_piatto);

    public void getAllPiatti(Callback callback);

    public void create(Callback callback, Piatto piatto);
}
