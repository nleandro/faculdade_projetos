/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.VendaVeiculoDAO;
import br.com.pratica.projeto.model.VendaVeiculo;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class VendaVeiculoFacade {
    
    private VendaVeiculoDAO vendaVeiculoDao = new VendaVeiculoDAO();
    
    public void inserirVendaVeiculo(VendaVeiculo v) {
        vendaVeiculoDao.inserir(v);
    }
    
    public void editarVendaVeiculo(VendaVeiculo v) {
        vendaVeiculoDao.editar(v);
    }
    
    public void removerVendaVeiculo(VendaVeiculo v) {
        vendaVeiculoDao.remover(v);
    }
    
    public List<VendaVeiculo> listaVendaVeiculo() {
        return vendaVeiculoDao.lista();
    }
}
