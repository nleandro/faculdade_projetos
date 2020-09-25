/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nellson
 */
public class VotacaoModel {
    
    private Map<String, Integer> pontuacao;
    
    public VotacaoModel() {
        this.pontuacao = new HashMap<String, Integer>();
        this.pontuacao.put("Opção 1", 0);
        this.pontuacao.put("Opção 2", 0);
        this.pontuacao.put("Opção 3", 0);
        this.pontuacao.put("Opção 4", 0);
        this.pontuacao.put("Opção 5", 0);
    }
    
    public String getVencedor(){
        int maiorPontuacao = 0;
        String vencedor = "";
        for (Map.Entry<String, Integer> entry : pontuacao.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value > maiorPontuacao){
                maiorPontuacao = value;
                vencedor = key;
            }
        }
        return vencedor;
    }
    
    public void atualizarPontos(String nome, Integer pontos) {
        this.pontuacao.replace(nome, pontos);
    }
    
    public int getPontos(String nome) {
        return this.pontuacao.get(nome);
    }
}
