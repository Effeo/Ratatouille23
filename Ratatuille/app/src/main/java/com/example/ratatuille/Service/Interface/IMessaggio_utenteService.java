package com.example.ratatuille.Service.Interface;

import android.telecom.Call;

import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Service.Callback;

public interface IMessaggio_utenteService {

    void getAllMessaggioUtente(Callback callback, String user_name);

    void update(Callback callback, Messaggio_utente messaggio_utente);
}
