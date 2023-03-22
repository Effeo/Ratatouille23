package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Conto;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ContoApi {

    @GET("conto/get/getAll")
    Single<List<Conto>> getAllConti();

    @PUT("conto/update")
    Completable update(@Body Conto conto);

    @POST("conto/create")
    Completable create(@Body Conto conto);
}
