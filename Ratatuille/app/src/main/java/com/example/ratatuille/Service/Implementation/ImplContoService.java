package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.ContoApi;
import com.example.ratatuille.Model.Conto;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.IContoService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplContoService implements IContoService {
    private ContoApi contoApi;

    public ImplContoService(){
        this.contoApi = ApiService.getRetrofit().create(ContoApi.class);
    }

    @Override
    public void getAllConti(Callback callback) {
        contoApi.getAllConti()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Conto>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<Conto> conti) {
                        callback.returnResult(conti);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }

    @Override
    public void update(Callback callback, Conto conto) {
        contoApi.update(conto)
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
