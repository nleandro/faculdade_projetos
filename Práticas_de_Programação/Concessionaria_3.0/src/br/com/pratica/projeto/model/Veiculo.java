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
public class Veiculo {
    
    private long id;
    private String placa;
    private String modelo;
    private String chassi;
    private Fabricante fabricante;

    public Veiculo() {
        this.fabricante = new Fabricante();
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

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    @Override
    public String toString() {        
        return "Id: " + id + " - Placa: " + placa + " - Modelo: " + modelo + 
               " - Número do Chassi: " + chassi + " - Fabricante: " + fabricante;
    }
}
