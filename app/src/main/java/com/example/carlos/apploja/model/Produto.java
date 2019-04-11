package com.example.carlos.apploja.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Produto implements Serializable {

    @SerializedName("id")
    private long id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("valor")
    private Double valor;
    @SerializedName("imagem")
    private String imagem;

    public Produto(){

    }
    /*
    public Produto(long id, String nome, Double valor, String imsgem){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.imagem = imagem;
    }
    */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}

