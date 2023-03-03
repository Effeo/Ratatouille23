package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.Ordine_piattoApi;
import com.example.ratatuille.Api.UtenteApi;
import com.example.ratatuille.Model.Ordine_piatto;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.IOrdine_piattoService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplOrdine_piattoService implements IOrdine_piattoService {
    Ordine_piattoApi ordine_piattoApi;

    public ImplOrdine_piattoService(){
        this.ordine_piattoApi = ApiService.getRetrofit().create(Ordine_piattoApi.class);
    }

    @Override
    public void getOrdini_piatti(Callback callback) {
        ordine_piattoApi.getOrdiniPiatti()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Ordine_piatto>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<Ordine_piatto> ordini_piatti) {
                        callback.returnResult(ordini_piatti);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }
}
