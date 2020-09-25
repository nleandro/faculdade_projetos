package br.edu.map2.formula1.model;

import java.util.ArrayList;

public class Premiacao {

    private float valorPremio;
    private Pista pista;
    private ArrayList<Piloto> resultado;
    private Carro premio;

    public Premiacao(float valorPremio, Pista pista) {
        this.valorPremio = valorPremio;
        this.pista = pista;
    }

    public float getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(float valorPremio) {
        this.valorPremio = valorPremio;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public ArrayList<Piloto> getResultado() {
        return resultado;
    }

    public void setResultado(ArrayList<Piloto> resultado) {
        this.resultado = resultado;
    }

    public Carro getPremio() {
        return premio;
    }

    public void setPremio(Carro premio) {
        this.premio = premio;
    }

    @Override
    public Premiacao clone(){
        return new Premiacao(valorPremio, pista);
    }
    
    @Override
    public String toString() {
        return "\n      Pista: " + pista.getNome() + " - Valor do prêmio: $" + valorPremio;
    }
}
