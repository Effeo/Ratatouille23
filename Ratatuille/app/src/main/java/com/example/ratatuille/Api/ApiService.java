package com.example.ratatuille.Api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiService {

    private static Retrofit retrofit;
    private static Retrofit retrofitFood;

    private static final String BASE_URL = "http://35.91.181.174:8080";//inserire ip server macchina
    private static final String OpenFood_URL = "https://it.openfoodfacts.org";


    public ApiService() {}

    public static Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        return retrofit;
    }

    public static Retrofit getRetrofitFood(){
        retrofitFood = new Retrofit.Builder()
                .baseUrl(OpenFood_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofitFood;
    }

    public static String getBaseUrl(){
        return BASE_URL;
}

}
