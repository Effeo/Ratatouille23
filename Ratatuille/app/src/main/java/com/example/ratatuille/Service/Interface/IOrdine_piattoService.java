package com.example.ratatuille.Service.Interface;

import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Service.Callback;

public interface IOrdine_piattoService {
    void getOrdini_piatti(Callback callback);

    void delete(Callback callback, Ordine_piatto ordine_piatto);

    void create(Callback callback, Ordine_piatto ordine_piatto);
}
