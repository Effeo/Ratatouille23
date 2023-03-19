package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.MessaggioApi;
import com.example.ratatuille.Api.PiattoApi;
import com.example.ratatuille.Model.Messaggio;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.IMessaggioService;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplMessaggioService implements IMessaggioService {
    private MessaggioApi messaggioApi;

    public ImplMessaggioService(){
        this.messaggioApi = ApiService.getRetrofit().create(MessaggioApi.class);
    }

    @Override
    public void create(Callback callback, Messaggio messaggio) {
        messaggioApi.create(messaggio)
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
