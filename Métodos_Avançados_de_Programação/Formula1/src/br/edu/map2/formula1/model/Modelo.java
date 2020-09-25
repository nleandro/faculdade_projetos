package br.edu.map2.formula1.model;

public class Modelo {

    private String nome;
    private Montadora montadora;

    public Modelo(String nome, Montadora montadora) {
        this.nome = nome;
        this.montadora = montadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Montadora: " + montadora.toString();
    }
}
