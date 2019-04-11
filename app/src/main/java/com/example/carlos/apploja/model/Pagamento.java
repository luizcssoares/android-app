package com.example.carlos.apploja.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pagamento implements Serializable {
    @SerializedName("idpgto")
    private long idpgto;

    @SerializedName("nompgto")
    private String nompgto;

    public long getIdpgto() {
        return idpgto;
    }

    public void setIdpgto(long idpgto) {
        this.idpgto = idpgto;
    }

    public String getNompgto() {
        return nompgto;
    }

    public void setNompgto(String nompgto) {
        this.nompgto = nompgto;
    }
}
