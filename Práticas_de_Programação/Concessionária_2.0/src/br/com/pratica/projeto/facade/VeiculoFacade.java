/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.VeiculoDAO;
import br.com.pratica.projeto.model.Veiculo;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class VeiculoFacade {
    
    private VeiculoDAO veiculoDao = new VeiculoDAO();
    
    public void inserirVeiculo(Veiculo v) {
        veiculoDao.inserir(v);
    }
    
    public void editarVeiculo(Veiculo v) {
        veiculoDao.editar(v);
    }
    
    public void removerVeiculo(Veiculo v) {
        veiculoDao.remover(v);
    }
    
    public List<Veiculo> listaVeiculo() {
        return veiculoDao.lista();
    }
}