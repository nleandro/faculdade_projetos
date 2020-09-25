/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.facade;

import br.com.pratica.projeto.dao.ClienteDAO;
import br.com.pratica.projeto.dao.EnderecoDAO;
import br.com.pratica.projeto.dao.FabricanteDAO;
import br.com.pratica.projeto.dao.FuncionarioDAO;
import br.com.pratica.projeto.dao.ManutencaoDAO;
import br.com.pratica.projeto.dao.VeiculoDAO;
import br.com.pratica.projeto.model.Cliente;
import br.com.pratica.projeto.model.Endereco;
import br.com.pratica.projeto.model.Fabricante;
import br.com.pratica.projeto.model.Funcionario;
import br.com.pratica.projeto.model.Manutencao;
import br.com.pratica.projeto.model.Veiculo;
import br.com.pratica.projeto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class ConcessionariaFacade {
    
    private Connection con;
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private VeiculoDAO veiculoDAO = new VeiculoDAO();
    private ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
    private EnderecoDAO enderecoDAO;
    private FabricanteDAO fabricanteDAO;
    
    // Funcionário
    public long inserirFuncionario(Funcionario f) throws SQLException {
        return funcionarioDAO.inserir(f);
    }
    
    public void editarFuncionario(Funcionario f) throws SQLException {
        funcionarioDAO.editar(f);
    }
    
    public void removerFuncionario(Funcionario f) throws SQLException {
        funcionarioDAO.remover(f);
    }
    
    public List<Funcionario> listarFuncionario() throws SQLException {
        return funcionarioDAO.listar();
    }
    
    public Funcionario buscarFuncionario(long id) throws SQLException {
        return funcionarioDAO.buscar(id);
    }
    
    // Cliente
    public long inserirCliente(Cliente c) throws SQLException {
        return clienteDAO.inserir(c);
    }
    
    public void editarCliente(Cliente c) throws SQLException {
        clienteDAO.editar(c);
    }
    
    public void removerCliente(Cliente c) throws SQLException {
        clienteDAO.remover(c);
    }
    
    public List<Cliente> listarCliente() throws SQLException {
        return clienteDAO.listar();
    }
    
    public Cliente buscarCliente(long id) throws SQLException {
        return clienteDAO.buscar(id);
    }
    
    // Veículo
    public long inserirVeiculo(Veiculo v) throws SQLException {
        return veiculoDAO.inserir(v);
    }
    
    public void editarVeiculo(Veiculo v) throws SQLException {
        veiculoDAO.editar(v);
    }
    
    public void removerVeiculo(Veiculo v) throws SQLException {
        veiculoDAO.remover(v);
    }
    
    public List<Veiculo> listarVeiculo() throws SQLException {
        return veiculoDAO.listar();
    }
    
    public Veiculo buscarVeiculo(long id) throws SQLException {
        return veiculoDAO.buscar(id);
    }
    
    // Manutencão
    public long inserirManutencao(Manutencao m) throws SQLException {
        return manutencaoDAO.inserir(m);
    }
    
    public void editarManutencao(Manutencao m) throws SQLException {
        manutencaoDAO.editar(m);
    }
    
    public void removerManutencao(Manutencao m) throws SQLException {
        manutencaoDAO.remover(m);
    }
    
    public List<Manutencao> listarManutencao() throws SQLException {
        return manutencaoDAO.lista();
    }
    
    public Manutencao buscarManutencao(long id) throws SQLException {
        return manutencaoDAO.buscar(id);
    }
    
    // Endereço
    public long inserirEndereco(Endereco e) throws SQLException {
        con = ConnectionFactory.getConnection();
        enderecoDAO = new EnderecoDAO(con);
        long endereco = enderecoDAO.inserir(e);
        con.close();
        return endereco;
    }
    
    public void editarEndereco(Endereco e) throws SQLException {
        con = ConnectionFactory.getConnection();
        enderecoDAO = new EnderecoDAO(con);
        enderecoDAO.editar(e);
        con.close();
    }
    
    public void removerEndereco(Endereco e) throws SQLException {
        con = ConnectionFactory.getConnection();
        enderecoDAO = new EnderecoDAO(con);
        enderecoDAO.remover(e);
        con.close();
    }
    
    public List<Endereco> listarEndereco() throws SQLException {
        con = ConnectionFactory.getConnection();
        enderecoDAO = new EnderecoDAO(con);
        List<Endereco> lista = enderecoDAO.listar();
        con.close();
        return lista;
    }
    
    public Endereco buscarEndereco(long id) throws SQLException {
        con = ConnectionFactory.getConnection();
        enderecoDAO = new EnderecoDAO(con);
        Endereco e = enderecoDAO.buscar(id);
        con.close();
        return e;
    }
    
    // Fabricante
    public long inserirFabricante(Fabricante f) throws SQLException {
        con = ConnectionFactory.getConnection();
        fabricanteDAO = new FabricanteDAO(con);
        long fabricante =  fabricanteDAO.inserir(f);
        con.close();
        return fabricante;
    }
    
    public void editarFabricante(Fabricante f) throws SQLException {
        con = ConnectionFactory.getConnection();
        fabricanteDAO = new FabricanteDAO(con);
        fabricanteDAO.editar(f);
        con.close();
    }
    
    public void removerFabricante(Fabricante f) throws SQLException {
        con = ConnectionFactory.getConnection();
        fabricanteDAO = new FabricanteDAO(con);
        fabricanteDAO.remover(f);
        con.close();
    }
    
    public List<Fabricante> listarFabricante() throws SQLException {
        con = ConnectionFactory.getConnection();
        fabricanteDAO = new FabricanteDAO(con);
        List<Fabricante> lista = fabricanteDAO.listar();
        con.close();
        return lista;
    }
    
    public Fabricante buscarFabricante(long id) throws SQLException {
        con = ConnectionFactory.getConnection();
        fabricanteDAO = new FabricanteDAO(con);
        Fabricante f = fabricanteDAO.buscar(id);
        con.close();
        return f;
    }
}
