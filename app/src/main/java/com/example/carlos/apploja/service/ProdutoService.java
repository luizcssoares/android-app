package com.example.carlos.apploja.service;

import com.example.carlos.apploja.model.Produto;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoService {
    //@GET("my/api/path")
    @GET("api/Produto")
    Call<List<Produto>> listarProduto();
}
