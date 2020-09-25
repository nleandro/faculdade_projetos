/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map2.formula1.model;

/**
 *
 * @author Nellson
 */
public class PneuMacio implements IPneu {

    private int calibragem;
    private final String tipo = "Macio";

    @Override
    public int getCalibragem() {
        return calibragem;
    }

    @Override
    public void calibrar(int valor) {
        calibragem = valor;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

}
