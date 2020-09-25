package br.edu.map2.formula1.model;

public class Pista {
    
    private String nome;
    private int distancia;
    private int curvas;
    private Clima clima;
    private Terreno terreno;
    private float tempo;
    private int voltas;

    public Pista(String nome, int distancia, int curvas, Clima clima, Terreno terreno, float tempo, int voltas) {
        this.nome = nome;
        this.distancia = distancia;
        this.curvas = curvas;
        this.clima = clima;
        this.terreno = terreno;
        this.tempo = tempo;
        this.voltas = voltas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCurvas() {
        return curvas;
    }

    public void setCurvas(int curvas) {
        this.curvas = curvas;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }
    
    @Override
    public String toString(){
        return "\n      " + nome + " - Distância: " + distancia + "Km - Curvas: "
                + curvas + " - Clima: " + clima.getDescricao() + " - Terreno: "
                + terreno.getDescricao() + " - Tempo da volta: " + tempo + " segundos - Quantidade de Voltas: " + voltas;
    }
    
}
