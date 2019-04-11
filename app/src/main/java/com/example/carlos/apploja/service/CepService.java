package com.example.carlos.apploja.service;

import com.example.carlos.apploja.model.Endereco;
import com.example.carlos.apploja.model.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {
    @GET("ws/{cep}/json/")
    Call<Endereco> buscarCep(@Path("cep") String cep);
}
