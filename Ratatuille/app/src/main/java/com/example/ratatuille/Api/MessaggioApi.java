package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Messaggio;

import io.reactivex.rxjava3.core.Completable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MessaggioApi {
    @POST("messaggio/create")
    Completable create(@Body Messaggio messaggio);
}
