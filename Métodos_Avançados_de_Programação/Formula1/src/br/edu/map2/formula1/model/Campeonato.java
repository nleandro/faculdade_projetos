package br.edu.map2.formula1.model;

import java.util.ArrayList;

public class Campeonato {

    private String nome;
    private String descricao;
    private ArrayList<Garagem> garagem;
    private ArrayList<Pista> pistas;
    private ArrayList<Premiacao> premiacoes;

    public Campeonato(String nome, String descricao, ArrayList<Garagem> garagem, ArrayList<Pista> pistas, ArrayList<Premiacao> premiacoes) {
        this.nome = nome;
        this.descricao = descricao;
        this.garagem = garagem;
        this.pistas = pistas;
        this.premiacoes = premiacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Garagem> getGaragem() {
        return garagem;
    }

    public void setGaragem(ArrayList<Garagem> garagem) {
        this.garagem = garagem;
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public void setPistas(ArrayList<Pista> pistas) {
        this.pistas = pistas;
    }

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }

    @Override
    public Campeonato clone() {
        return new Campeonato(nome, descricao, garagem, pistas, premiacoes);
    }

    @Override
    public String toString() {
        String garagemResults = "";
        for (Garagem g : garagem) {
            garagemResults += g.toString();
        }

        String pistasResults = "";
        for (Pista p : pistas) {
            pistasResults += p.toString();
        }

        String premiscoesResults = "";
        for (Premiacao p : premiacoes) {
            premiscoesResults += p.toString();
        }

        return "Campeonato: " + nome + "\nDescrição: " + descricao + "\nEquipes: "
                + garagemResults + "\nPistas: " + pistasResults + "\nPremiações: "
                + premiscoesResults;
    }

}
