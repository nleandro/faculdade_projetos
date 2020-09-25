/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.CompraVeiculoDAO;
import br.com.pratica.projeto.model.CompraVeiculo;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class CompraVeiculoFacade {
    
    private CompraVeiculoDAO compraVeiculoDao = new CompraVeiculoDAO();
    
    public void inserirCompraVeiculo(CompraVeiculo c) {
        compraVeiculoDao.inserir(c);
    }
    
    public void editarCompraVeiculo(CompraVeiculo c) {
        compraVeiculoDao.editar(c);
    }
    
    public void removerCompraVeiculo(CompraVeiculo c) {
        compraVeiculoDao.remover(c);
    }
    
    public List<CompraVeiculo> listaCompraVeiculo() {
        return compraVeiculoDao.lista();
    }
}
