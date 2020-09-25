package br.edu.map2.formula1.factorymethod;

import br.edu.map2.formula1.model.Clima;
import br.edu.map2.formula1.model.Pista;
import br.edu.map2.formula1.model.Terreno;

public class PistaFactoryMethod implements IPistaFactoryMethod {

    public static final int CLIMANEBLINA = 1;
    public static final int CLIMANENSOLARADO = 2;
    public static final int TERRENOPISTA = 3;

    private Clima clima;
    private Terreno terreno;

    @Override
    public Pista criarPista(String nome, int distancia, int curvas, int clima, int terreno, float tempo, int voltas) {

        switch (clima) {
            case PistaFactoryMethod.CLIMANEBLINA:
                this.clima = new Clima("Neblina");
                break;
            case PistaFactoryMethod.CLIMANENSOLARADO:
                this.clima = new Clima("Ensolarado");
                break;
            default:
                return null;
        }

        switch (terreno) {
            case PistaFactoryMethod.TERRENOPISTA:
                this.terreno = new Terreno("Pista");
                break;
            default:
                return null;
        }

        return new Pista(nome, distancia, curvas, this.clima, this.terreno, tempo, voltas);

    }

}
