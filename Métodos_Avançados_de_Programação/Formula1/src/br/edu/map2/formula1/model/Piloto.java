package br.edu.map2.formula1.model;

public class Piloto {

    private String nome;
    private int experiencia;
    private float dinheiro;
    private Garagem garagem;

    public Piloto(String nome, int experiencia, float dinheiro) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.dinheiro = dinheiro;
    }

    public Piloto(String nome, int experiencia, float dinheiro, Garagem garagem) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.dinheiro = dinheiro;
        this.garagem = garagem;
    }

    public void evoluir(int xp, int kk) {
        experiencia += xp;
        dinheiro += kk;
    }
    
    @Override
    public Piloto clone() {
        return new Piloto(nome, experiencia, dinheiro, garagem);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Garagem getGaragem() {
        return garagem;
    }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem;
    }

}
