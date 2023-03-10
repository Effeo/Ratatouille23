package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.UtenteApi;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Interface.IUtenteService;


import com.example.ratatuille.Service.Callback;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplUtenteService implements IUtenteService {

    private UtenteApi untenteApi;

    public ImplUtenteService(){
        this.untenteApi = ApiService.getRetrofit().create(UtenteApi.class);
    }

    @Override
    public void findUtenteByUser_nameAndPassword(Callback callback, String user_name, String password) {
        untenteApi.findUtenteByUser_nameAndPassword(user_name,password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Utente>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull Utente user) {
                        callback.returnResult(user);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }

    @Override
    public void update(Callback callback, Utente utente) {
        untenteApi.update(utente)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onComplete() {
                        callback.returnResult(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }
}
