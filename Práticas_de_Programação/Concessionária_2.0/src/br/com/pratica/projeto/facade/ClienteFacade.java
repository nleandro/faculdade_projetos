/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.ClienteDAO;
import br.com.pratica.projeto.model.Cliente;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class ClienteFacade {
    
    private ClienteDAO clienteDao = new ClienteDAO();
    
    public void inserirCliente(Cliente c) {
        clienteDao.inserir(c);
    }
    
    public void editarCliente(Cliente c) {
        clienteDao.editar(c);
    }
    
    public void removerCliente(Cliente c) {
        clienteDao.remover(c);
    }
    
    public List<Cliente> listaCliente() {
        return clienteDao.lista();
    }
}
