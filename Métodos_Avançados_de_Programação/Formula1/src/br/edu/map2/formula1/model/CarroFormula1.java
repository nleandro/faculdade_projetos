package br.edu.map2.formula1.model;

import java.util.ArrayList;

public class CarroFormula1 extends Carro {

    public CarroFormula1(IMotor motor, IFreio freio, Modelo modelo, ISuspensao suspensao, ArrayList<IPneu> pneus) {
        super(motor, freio, modelo, suspensao, pneus);
    }

    @Override
    protected void acelerar() {
        if (getMotor().getStatus()) {
            setVelocidadeAtual(getVelocidadeAtual() + getMotor().acelerar());
            System.out.println("Velocidade atual: " + getVelocidadeAtual());
        } else {
            System.out.println("Veículo desligado.");
        }
    }

    @Override
    protected void freiar() {
        System.out.println("Ativando o freio");
        setVelocidadeAtual(getFreio().acionar(getVelocidadeAtual()));
        System.out.println("Velocidade atual: " + getVelocidadeAtual());
    }

}
