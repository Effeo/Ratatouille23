package com.example.ratatuille.Api;

import com.example.ratatuille.Model.Conto;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ContoApi {

    @GET("conto/get/getAll")
    Single<List<Conto>> getAllConti();
}
