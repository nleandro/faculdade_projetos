package br.edu.map2.formula1.model;

public class FreioABS implements IFreio {

    @Override
    public int acionar(int velocidadeAtual) {
        if (velocidadeAtual > 0) {
            return velocidadeAtual - 15;
        } else {
            return 0;
        }
    }

}
