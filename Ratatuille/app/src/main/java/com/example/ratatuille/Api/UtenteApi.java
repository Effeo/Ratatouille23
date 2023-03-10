package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Utente;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UtenteApi {

    @GET("utente/get/{user_name}/{password}")
    Single<Utente> findUtenteByUser_nameAndPassword(@Path("user_name") String user_name, @Path("password") String password);

    @PUT("utente/update")
    Completable update(@Body Utente utente);
}
