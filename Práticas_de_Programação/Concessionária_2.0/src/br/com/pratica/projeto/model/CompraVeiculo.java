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
public class CompraVeiculo {
    
    private long id;
    private String fabricante;
    private String modelo;
    private int preco;

    public CompraVeiculo() {
    
    }

    public CompraVeiculo(long id) {
        this.id = id;
    }

    public CompraVeiculo(String fabricante, String modelo, int preco) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.preco = preco;
    }

    public CompraVeiculo(long id, String fabricante, String modelo, int preco) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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
    
    @Override
    public String toString() {
        return "Id: " + id + " - Fabricante: " + fabricante + " - Modelo: " + modelo + 
               " - Preço: " + preco;
    }
}