package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Piatto;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PiattoApi {

    @GET("piatto/get/{id_piatto}")
    Single<Piatto> findPiattoById(@Path("id_piatto") int id_piatto);

    @GET("piatto/get/getAll")
    Single<List<Piatto>> getAllPiatti();

    @POST("piatto/create")
    Completable create(@Body Piatto piatto);
}
