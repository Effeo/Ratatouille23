package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.OpenFoodApi;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.IOpenFoodService;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplOpenFoodService implements IOpenFoodService {
    private OpenFoodApi openFoodApi;

    public ImplOpenFoodService()  {
        this.openFoodApi = ApiService.getRetrofitFood().create(OpenFoodApi.class);
    }

    @Override
    public void getDescrizione(Callback callback, String nome) {
        openFoodApi.getProductList(nome,true,true,"generic_name")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull String string) {
                        callback.returnResult(string);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }
                });
    }

    @Override
    public void getAllergeni(Callback callback, String nome) {
        openFoodApi.getProductList(nome,true,true,"allergens")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull String string) {
                        callback.returnResult(string);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }
                });
    }
}
