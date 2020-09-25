package br.edu.map2.formula1.factorymethod;

import br.edu.map2.formula1.model.Carro;
import br.edu.map2.formula1.model.Garagem;
import br.edu.map2.formula1.model.Piloto;

public interface IGaragemFactoryMethod {

    public Garagem criarGaragem(Piloto piloto1, Piloto piloto2, Carro carro);
    
}
