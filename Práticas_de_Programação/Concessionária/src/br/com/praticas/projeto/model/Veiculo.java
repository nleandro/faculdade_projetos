/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nellson
 */
public class Veiculo {
    private long id;
    private String placa;
    private String marca;
    private String modelo;
    private Date ano;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String anoString = "";
        if(ano != null)
            anoString = formatter.format(ano);
        else
            anoString = "null";
        return "ID: " + id + " - Placa: " + placa + " - Marca: " + marca + 
                " - Modelo: " + modelo + " - Ano: " + anoString;
    }
}
