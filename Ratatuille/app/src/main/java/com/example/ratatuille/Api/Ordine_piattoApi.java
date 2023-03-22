package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Ordine_piatto;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Ordine_piattoApi {

    @GET("ordine_piatto/get/getOrdini_piatti")
    Single<List<Ordine_piatto>> getOrdiniPiatti();

    @HTTP(method = "DELETE", path="/ordine_piatto/delete",hasBody = true)
    public Completable delete(@Body Ordine_piatto ordine_piatto);

    @POST("ordine_piatto/create")
    public Completable create(@Body Ordine_piatto ordine_piatto);
}
