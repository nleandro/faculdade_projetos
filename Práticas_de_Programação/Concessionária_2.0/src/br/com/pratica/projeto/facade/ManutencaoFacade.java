/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.ManutencaoDAO;
import br.com.pratica.projeto.model.Manutencao;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class ManutencaoFacade {
    
    private ManutencaoDAO manutencaoDao = new ManutencaoDAO();
    
    public void inserirManutencao(Manutencao m) {
        manutencaoDao.inserir(m);
    }
    
    public void editarManutencao(Manutencao m) {
        manutencaoDao.editar(m);
    }
    
    public void removerManutencao(Manutencao m) {
        manutencaoDao.remover(m);
    }
    
    public List<Manutencao> listaManutencao() {
        return manutencaoDao.lista();
    }
}
