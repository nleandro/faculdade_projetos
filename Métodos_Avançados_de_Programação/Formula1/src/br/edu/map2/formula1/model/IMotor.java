package br.edu.map2.formula1.model;

public interface IMotor {

    public boolean ligar();

    public boolean desligar();

    public int getCV();

    public String getDescricao();

    public boolean getStatus();
    
    public int acelerar();
}
