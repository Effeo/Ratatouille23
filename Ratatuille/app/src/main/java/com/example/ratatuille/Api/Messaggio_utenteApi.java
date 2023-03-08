package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Messaggio_utente;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Messaggio_utenteApi {

    @GET("messaggio_utente/get/getAllMessaggioUtente/{user_name}")
    Single<List<Messaggio_utente>> getAllMessaggioUtente(@Path("user_name") String user_name);

    @PUT("messaggio_utente/update")
    Completable update(@Body Messaggio_utente messaggio_utente);
}
