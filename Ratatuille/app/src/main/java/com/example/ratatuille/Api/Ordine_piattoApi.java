package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Ordine_piatto;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Ordine_piattoApi {

    @GET("ordine_piatto/get/getOrdini_piatti")
    Single<List<Ordine_piatto>> getOrdiniPiatti();
}
