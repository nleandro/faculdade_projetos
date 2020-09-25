package br.edu.map2.formula1.model;

import java.util.ArrayList;

public class Garagem {

    private ArrayList<Piloto> pilotos;
    private Carro carro;

    public Garagem(ArrayList<Piloto> pilotos, Carro carro) {
        this.pilotos = pilotos;
        this.carro = carro;
    }

    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(ArrayList<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        String pilotosResults = "";
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                pilotosResults += pilotos.get(i).getNome() + " e ";
            } else {
                pilotosResults += pilotos.get(i).getNome();
            }
        }

        return "\n      " + pilotosResults + " - Carro (modelo): " + carro;
    }

}
