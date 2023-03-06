package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Piatto;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PiattoApi {

    @GET("piatto/get/{id_piatto}")
    Single<Piatto> findPiattoById(@Path("id_piatto") int id_piatto);
}
