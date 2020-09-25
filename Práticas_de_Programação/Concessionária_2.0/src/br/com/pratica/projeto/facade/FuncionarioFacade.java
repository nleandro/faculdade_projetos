/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.FuncionarioDAO;
import br.com.pratica.projeto.model.Funcionario;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class FuncionarioFacade {
    
    private FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    
    public void inserirFuncionario(Funcionario f) {
        funcionarioDao.inserir(f);
    }
    
    public void editarFuncionario(Funcionario f) {
        funcionarioDao.editar(f);
    }
    
    public void removerFuncionario(Funcionario f) {
        funcionarioDao.remover(f);
    }
    
    public List<Funcionario> listaFuncionario() {
        return funcionarioDao.lista();
    }
}
