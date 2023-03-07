package com.example.ratatuille.Service.Interface;

import android.telecom.Call;

import com.example.ratatuille.Service.Callback;

public interface IMessaggio_utenteService {

    void getAllMessaggioUtente(Callback callback, String user_name);
}
