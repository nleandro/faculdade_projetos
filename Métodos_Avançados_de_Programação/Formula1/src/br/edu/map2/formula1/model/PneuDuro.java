package br.edu.map2.formula1.model;

public class PneuDuro implements IPneu {

    private int calibragem;
    private final String tipo = "Duro";

    @Override
    public int getCalibragem() {
        return calibragem;
    }

    @Override
    public void calibrar(int valor) {
        calibragem = valor;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
