package com.example.carlos.apploja.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class ItemPedido implements Serializable {
    @SerializedName("idprod")
    private long idprod;
    @SerializedName("nome")
    private String nome;
    @SerializedName("valor")
    private Double valor;
    @SerializedName("qtde")
    private int qtde;
    @SerializedName("valoritem")
    private double valoritem;

    public long getIdprod() {
        return idprod;
    }

    public void setIdprod(long idprod) {
        this.idprod = idprod;
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

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValoritem() {
        return valoritem;
    }

    public void setValoritem(double valoritem) {
        this.valoritem = valoritem;
    }
}
