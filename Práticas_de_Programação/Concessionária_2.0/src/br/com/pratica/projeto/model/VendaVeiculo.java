/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

/**
 *
 * @author Nellson
 */
public class VendaVeiculo {
 
    private long id;
    private String modelo;
    private int preco;
    private String comprador;
    private String formaPagamento;

    public VendaVeiculo() {
    
    }

    public VendaVeiculo(long id) {
        this.id = id;
    }

    public VendaVeiculo(String modelo, int preco, String comprador, String formaPagamento) {
        this.modelo = modelo;
        this.preco = preco;
        this.comprador = comprador;
        this.formaPagamento = formaPagamento;
    }

    public VendaVeiculo(long id, String modelo, int preco, String comprador, String formaPagamento) {
        this.id = id;
        this.modelo = modelo;
        this.preco = preco;
        this.comprador = comprador;
        this.formaPagamento = formaPagamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    @Override
    public String toString() {
        return "Id: " + id + " - Modelo: " + modelo + " - Preço: " + preco + 
               " - Comprador: " + comprador + " - Forma de Pagamento: " + formaPagamento;
    }
}
