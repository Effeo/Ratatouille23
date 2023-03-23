package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Conto;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ContoApi {

    @GET("conto/get/getAll")
    Single<List<Conto>> getAllConti();

    @GET("conto/get/getAllBeetween/{dataInizio}/{dataFine}")
    Single<List<Conto>> getAllContiBeetween(@Path("dataInizio") String dataInizio, @Path("dataFine") String dataFine);

    @PUT("conto/update")
    Completable update(@Body Conto conto);

    @POST("conto/create")
    Completable create(@Body Conto conto);
}
