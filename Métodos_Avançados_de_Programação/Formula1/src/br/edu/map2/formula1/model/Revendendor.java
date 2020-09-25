package br.edu.map2.formula1.model;

import java.util.ArrayList;

public class Revendendor {

    private String nome;
    private ArrayList<Carro> carros;

    public Revendendor(String nome, ArrayList<Carro> carros) {
        this.nome = nome;
        this.carros = carros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }

}
