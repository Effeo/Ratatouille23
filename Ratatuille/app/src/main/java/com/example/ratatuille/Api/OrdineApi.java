package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Ordine;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OrdineApi {

    @POST("ordine/create")
    public Single<Ordine> create(@Body Ordine ordine);

    @GET("ordine/get/getGreatest")
    public Single<Ordine> getGreatest();
}
