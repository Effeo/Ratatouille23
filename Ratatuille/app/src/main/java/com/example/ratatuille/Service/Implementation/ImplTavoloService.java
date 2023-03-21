package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.PiattoApi;
import com.example.ratatuille.Api.TavoloApi;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Model.Tavolo;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.ITavoloService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplTavoloService implements ITavoloService {
    private TavoloApi tavoloApi;

    public ImplTavoloService(){
        this.tavoloApi = ApiService.getRetrofit().create(TavoloApi.class);
    }

    @Override
    public void getTavoli(Callback callback) {
        tavoloApi.getTavoli()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Tavolo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<Tavolo> tavoli) {
                        callback.returnResult(tavoli);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }
}
