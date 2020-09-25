package br.edu.map2.formula1.ui;

import br.edu.map2.formula1.factorymethod.CarroFactoryMethod;
import br.edu.map2.formula1.factorymethod.GaragemFactoryMethod;
import br.edu.map2.formula1.factorymethod.ICarroFactoryMethod;
import br.edu.map2.formula1.factorymethod.IGaragemFactoryMethod;
import br.edu.map2.formula1.factorymethod.IPistaFactoryMethod;
import br.edu.map2.formula1.factorymethod.PistaFactoryMethod;
import br.edu.map2.formula1.model.Campeonato;
import br.edu.map2.formula1.model.Carro;
import br.edu.map2.formula1.model.Garagem;
import br.edu.map2.formula1.model.Piloto;
import br.edu.map2.formula1.model.Pista;
import br.edu.map2.formula1.model.Premiacao;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Criar Carros
        ICarroFactoryMethod carroFactoryMethod = new CarroFactoryMethod();

        Carro carroFerrari = carroFactoryMethod.criarCarroF1(
                CarroFactoryMethod.FERRARI,
                CarroFactoryMethod.MOTORV6TURBOHIBRIDO,
                CarroFactoryMethod.PNEUMACIO
        );
        Carro carroMercedes = carroFactoryMethod.criarCarroF1(
                CarroFactoryMethod.MERCEDES,
                CarroFactoryMethod.MOTORV8TURBO,
                CarroFactoryMethod.PNEUDURO
        );
        Carro carroRenault = carroFactoryMethod.criarCarroF1(
                CarroFactoryMethod.RENAULT,
                CarroFactoryMethod.MOTORV8TURBO,
                CarroFactoryMethod.PNEUMACIO
        );
        Carro carroMcLaren = carroFactoryMethod.criarCarroF1(
                CarroFactoryMethod.MCLAREN,
                CarroFactoryMethod.MOTORV6TURBOHIBRIDO,
                CarroFactoryMethod.PNEUDURO
        );

        //Criar os pilotos
        Piloto piloto1 = new Piloto("Arthur", 1000, 10000);
        Piloto piloto2 = piloto1.clone();
        piloto2.setNome("Bernardo");
        Piloto piloto3 = piloto1.clone();
        piloto3.setNome("Miguel");
        Piloto piloto4 = piloto1.clone();
        piloto4.setNome("Pedro");
        Piloto piloto5 = piloto1.clone();
        piloto5.setNome("Lucas");
        Piloto piloto6 = piloto1.clone();
        piloto6.setNome("Davi");
        Piloto piloto7 = piloto1.clone();
        piloto7.setNome("Gabriel");
        Piloto piloto8 = piloto1.clone();
        piloto8.setNome("Guilherme");

        //Criar a garagens
        IGaragemFactoryMethod garagemFactoryMethod = new GaragemFactoryMethod();

        Garagem garagemFerrari = garagemFactoryMethod.criarGaragem(
                piloto1,
                piloto2,
                carroFerrari
        );
        Garagem garagemMercedes = garagemFactoryMethod.criarGaragem(
                piloto3,
                piloto4,
                carroMercedes
        );
        Garagem garagemRenault = garagemFactoryMethod.criarGaragem(
                piloto5,
                piloto6,
                carroRenault
        );
        Garagem garagemMcLaren = garagemFactoryMethod.criarGaragem(
                piloto7,
                piloto8,
                carroMcLaren
        );

        //Atualizar pilotos com a nova garagem
        piloto1.setGaragem(garagemFerrari);
        piloto2.setGaragem(garagemFerrari);
        piloto3.setGaragem(garagemMercedes);
        piloto4.setGaragem(garagemMercedes);
        piloto5.setGaragem(garagemRenault);
        piloto6.setGaragem(garagemRenault);
        piloto7.setGaragem(garagemMcLaren);
        piloto8.setGaragem(garagemMcLaren);

        //Criar pistas
        IPistaFactoryMethod pistaFactoryMethod = new PistaFactoryMethod();

        Pista gpBrasil = pistaFactoryMethod.criarPista(
                "GP do Brasil",
                4,
                15,
                PistaFactoryMethod.CLIMANENSOLARADO,
                PistaFactoryMethod.TERRENOPISTA,
                1.07f,
                71
        );
        Pista gpAustralia = pistaFactoryMethod.criarPista(
                "GP da Austrália",
                5,
                16,
                PistaFactoryMethod.CLIMANEBLINA,
                PistaFactoryMethod.TERRENOPISTA,
                1.20f,
                58
        );
        Pista gpAlemanha = pistaFactoryMethod.criarPista(
                "GP da Alemanha",
                4,
                17,
                PistaFactoryMethod.CLIMANENSOLARADO,
                PistaFactoryMethod.TERRENOPISTA,
                1.11f,
                67
        );

        //Criar Premiações
        Premiacao premiacao1 = new Premiacao(500000, gpBrasil);
        Premiacao premiacao2 = premiacao1.clone();
        premiacao2.setPista(gpAustralia);
        Premiacao premiacao3 = premiacao1.clone();
        premiacao3.setPista(gpAlemanha);

        //Criar Campeonato
        ArrayList<Garagem> garagem = new ArrayList<>();
        garagem.add(garagemFerrari);
        garagem.add(garagemMercedes);
        garagem.add(garagemRenault);
        garagem.add(garagemMcLaren);

        ArrayList<Pista> pistas = new ArrayList<>();
        pistas.add(gpBrasil);
        pistas.add(gpAustralia);
        pistas.add(gpAlemanha);

        ArrayList<Premiacao> premiacoes = new ArrayList<>();
        premiacoes.add(premiacao1);
        premiacoes.add(premiacao2);
        premiacoes.add(premiacao3);

        Campeonato formula1 = new Campeonato(
                "Formula 1",
                "F1 Temporada 2019",
                garagem,
                pistas,
                premiacoes
        );

        System.out.println(formula1.toString());

    }

}
