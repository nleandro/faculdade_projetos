package br.com.web2.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Eduarda
 */
@Entity
public class Endereco {
    
    @Id
    @GeneratedValue
    private long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString(){
        return "Endereço:\n "
                + "Rua : " + rua + " Bairro: " + bairro + " Número: " + numero + " Cidade : " + cidade + "UF: " +uf;
    }
    
    
}

