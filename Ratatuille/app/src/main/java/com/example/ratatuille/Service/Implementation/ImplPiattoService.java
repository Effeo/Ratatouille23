package com.example.ratatuille.Service.Implementation;

import androidx.annotation.NonNull;

import com.example.ratatuille.Api.ApiService;
import com.example.ratatuille.Api.PiattoApi;
import com.example.ratatuille.Model.Piatto;
import com.example.ratatuille.Model.Utente;
import com.example.ratatuille.Service.Callback;
import com.example.ratatuille.Service.Interface.IPiattoService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImplPiattoService implements IPiattoService {

    private PiattoApi piattoApi;

    public ImplPiattoService(){
        this.piattoApi = ApiService.getRetrofit().create(PiattoApi.class);
    }

    @Override
    public void findPiattoById(Callback callback, int id_piatto) {
        piattoApi.findPiattoById(id_piatto)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Piatto>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull Piatto piatto) {
                        callback.returnResult(piatto);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }

    @Override
    public void getAllPiatti(Callback callback){
        piattoApi.getAllPiatti()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Piatto>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<Piatto> piatti) {
                        callback.returnResult(piatti);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(null);
                    }
                });
    }

    @Override
    public void create(Callback callback, Piatto piatto) {
        piattoApi.create(piatto)
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

    @Override
    public void update(Callback callback, Piatto piatto) {
        piattoApi.update(piatto)
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

    @Override
    public void delete(Callback callback, Piatto piatto) {
        piattoApi.delete(piatto)
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
                        callback.returnResult(false);
                    }
                });
    }
}
