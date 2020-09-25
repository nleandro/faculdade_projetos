package br.edu.map2.formula1.factorymethod;

import br.edu.map2.formula1.model.Carro;
import br.edu.map2.formula1.model.Garagem;
import br.edu.map2.formula1.model.Piloto;
import java.util.ArrayList;

public class GaragemFactoryMethod implements IGaragemFactoryMethod{
    
    private ArrayList<Piloto> pilotos;
    
    @Override
    public Garagem criarGaragem(Piloto piloto1, Piloto piloto2, Carro carro) {
        pilotos = new ArrayList<>();
        pilotos.add(piloto1);
        pilotos.add(piloto2);
        
        return new Garagem(pilotos, carro);
    }
    
}
