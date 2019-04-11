package com.example.carlos.apploja.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ServiceGenerator {

    // URL base do endpoint do GITHUB
    //public static final String API_BASE_URL = "https://luizcsoares.free.beeceptor.com/";

    public static <S> S createService(Class<S> serviceClass, String url) {

        // Instancia do interceptador das requisições
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS);

        httpClient.addInterceptor(loggingInterceptor);

        // Instância do retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl(API_BASE_URL)
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
        //.addConverterFactory(GsonConverterFactory.create(new Gson()))
        return retrofit.create(serviceClass);
    }
}

