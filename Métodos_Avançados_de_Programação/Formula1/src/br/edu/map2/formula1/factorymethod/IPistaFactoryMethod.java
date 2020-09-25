package br.edu.map2.formula1.factorymethod;

import br.edu.map2.formula1.model.Pista;

public interface IPistaFactoryMethod {
    
    public Pista criarPista(String nome, int distancia, int curvas, int clima, int terreno, float tempo, int voltas);
    
}
