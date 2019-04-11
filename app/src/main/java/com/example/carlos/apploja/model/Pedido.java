package com.example.carlos.apploja.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
    @SerializedName("numped")
    private long numped;
    @SerializedName("data")
    private Date data;
    @SerializedName("valor")
    private Double valor;
    @SerializedName("frete")
    private Double frete;
    @SerializedName("cliente")
    private Cliente cliente;
    @SerializedName("pagamento")
    private Pagamento pagamento;
    @SerializedName("endereco")
    private Endereco endereco;
    @SerializedName("itens")
    private List<ItemPedido> itens;

    public long getNumped() {
        return numped;
    }

    public void setNumped(long numped) {
        this.numped = numped;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}