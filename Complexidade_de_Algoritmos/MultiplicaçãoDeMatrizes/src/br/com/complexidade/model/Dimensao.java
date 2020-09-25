package br.com.complexidade.model;

public class Dimensao {
    
    private String d;
    private int valor;

    public Dimensao(String d, int valor) {
        this.d = d;
        this.valor = valor;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getD() {
        return d;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
        
}
