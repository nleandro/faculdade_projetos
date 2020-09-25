/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.controller;

import br.com.map.model.VotacaoModel;
import br.com.map.view.VotacaoView;

/**
 *
 * @author Nellson
 */
public class VotacaoController {
    
    private VotacaoModel votacaoModel;
    
    public VotacaoController() {
        this.votacaoModel = new VotacaoModel();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotacaoView(VotacaoController.this).setVisible(true);
            }
        });
    }
    
    public void atualizarPontos(String nome, Integer pontos) {
        this.votacaoModel.atualizarPontos(nome, pontos);
    }
    
    public String getVencedor(){
        return this.votacaoModel.getVencedor();
    }
    
    public int getPontos(String nome) {
        return this.votacaoModel.getPontos(nome);
    }
}
