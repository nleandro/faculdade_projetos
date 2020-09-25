package br.edu.map2.formula1.model;

public class MotorV8Turbo implements IMotor {

    private final String descricao;
    private boolean status = false;
    private final int cv = 100;

    public MotorV8Turbo(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public boolean ligar() {
        if (status) {
            System.out.println("Motor já ligado.");
        } else {
            System.out.println("Ligando motor.");
            status = true;
        }
        return status;
    }

    @Override
    public boolean desligar() {
        if (status) {
            System.out.println("Desligando motor.");
            status = false;
        } else {
            System.out.println("Motor já desligado.");
        }
        return status;
    }

    @Override
    public int getCV() {
        return cv;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public int acelerar() {
        return 25;
    }

}
