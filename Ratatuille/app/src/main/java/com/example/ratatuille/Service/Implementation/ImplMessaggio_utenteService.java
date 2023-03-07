package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.Messaggio_utenteApi;
import com.example.ratatuille.Model.Messaggio_utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.IMessaggio_utenteService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplMessaggio_utenteService implements IMessaggio_utenteService {
    private Messaggio_utenteApi messaggio_utenteApi;

    public ImplMessaggio_utenteService(){
        this.messaggio_utenteApi = ApiService.getRetrofit().create(Messaggio_utenteApi.class);
    }

    @Override
    public void getAllMessaggioUtente(Callback callback, String user_name) {
        messaggio_utenteApi.getAllMessaggioUtente(user_name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Messaggio_utente>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<Messaggio_utente> messaggi_utenti) {
                        callback.returnResult(messaggi_utenti);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }
}
