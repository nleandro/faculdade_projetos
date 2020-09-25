/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.util.DateUtil;
import java.util.Date;

/**
 *
 * @author Nellson
 */
public class Veiculo {
    
    private long id;
    private String placa;
    private String modelo;
    private String fabricante;
    private Date ano;

    public Veiculo() {
        
    }

    public Veiculo(long id) {
        this.id = id;
    }
    
    public Veiculo(String placa, String modelo, String fabricante, Date ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
    }

    public Veiculo(long id, String placa, String modelo, String fabricante, Date ano) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
    }

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        String dateStr = "";
        if(ano != null)
            dateStr = DateUtil.dateToString(ano);
        else
            dateStr = "null";
        
        return "Id: " + id + " - Placa: " + placa + " - Modelo: " + modelo + 
               " - Fabricante: " + fabricante + " - Ano: " + dateStr;
    }
}
