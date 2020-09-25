package br.edu.map2.formula1.model;

import java.util.ArrayList;

public abstract class Carro {

    private IMotor motor;
    private IFreio freio;
    private int ano;
    private Modelo modelo;
    private boolean nitroxido;
    private int nitroQt;
    private ISuspensao suspensao;
    private ArrayList<IPneu> pneus;
    private int velocidadeAtual;

    public Carro(IMotor motor, IFreio freio, Modelo modelo, ISuspensao suspensao, ArrayList<IPneu> pneus) {
        this.motor = motor;
        this.freio = freio;
        this.modelo = modelo;
        this.suspensao = suspensao;
        this.pneus = pneus;
    }

    protected abstract void acelerar();

    protected abstract void freiar();

    public IMotor getMotor() {
        return motor;
    }

    public void setMotor(IMotor motor) {
        this.motor = motor;
    }

    public IFreio getFreio() {
        return freio;
    }

    public void setFreio(IFreio freio) {
        this.freio = freio;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public boolean isNitroxido() {
        return nitroxido;
    }

    public void setNitroxido(boolean nitroxido) {
        this.nitroxido = nitroxido;
    }

    public int getNitroQt() {
        return nitroQt;
    }

    public void setNitroQt(int nitroQt) {
        this.nitroQt = nitroQt;
    }

    public ISuspensao getSuspensao() {
        return suspensao;
    }

    public void setSuspensao(ISuspensao suspensao) {
        this.suspensao = suspensao;
    }

    public ArrayList<IPneu> getPneus() {
        return pneus;
    }

    public void setPneus(ArrayList<IPneu> pneus) {
        this.pneus = pneus;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(int velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    @Override
    public String toString() {
        return modelo.getNome() + " - Montadora: " + modelo.getMontadora().getNome() + " - Motor: " + motor.getDescricao() + " - Pneu: " + pneus.get(0).getTipo();
    }

}
