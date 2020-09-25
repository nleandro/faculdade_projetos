package br.edu.map2.formula1.factorymethod;

import br.edu.map2.formula1.model.Carro;

public interface ICarroFactoryMethod {

    public Carro criarCarroF1(int montadora, int motor, int pneu);

}
