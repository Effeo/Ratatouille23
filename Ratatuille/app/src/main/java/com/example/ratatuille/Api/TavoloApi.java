package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Tavolo;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface TavoloApi {

    @GET("tavolo/get/getTavoli")
    public Single<List<Tavolo>> getTavoli();
}
