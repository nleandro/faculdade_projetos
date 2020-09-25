/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Cliente;
import br.com.pratica.projeto.util.ConnectionFactory;
import br.com.pratica.projeto.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Nellson
 */
public class ClienteDAO {
    
    private Connection con;
    
    public long inserir(Cliente c) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        long idEndereco = enderecoDAO.inserir(c.getEndereco());
        
        String sql = "INSERT INTO cliente(nome, cpf, dtnascimento, idendereco) "
                + "VALUES(?, ?, ?, ?);";
        
        PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        st.setString(1, c.getNome());
        st.setInt(2, c.getCpf());
        st.setDate(3, DateUtil.parseSql(c.getDtNascimento()));
        st.setLong(4, idEndereco);
        
        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        long idCliente = 0;
        
        if (rs.next())
            idCliente = rs.getLong(1);
        
        con.close();
        
        return idCliente;
        
    }
    
    public void editar(Cliente c) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        enderecoDAO.editar(c.getEndereco());
        
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, dtnascimento = ? WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1, c.getNome());
        st.setInt(2, c.getCpf());
        st.setDate(3, DateUtil.parseSql(c.getDtNascimento()));
        st.setLong(4, c.getId());
        
        st.executeUpdate();
        
        con.close();
    }
    
    public Cliente buscar(long id) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM cliente c, endereco e WHERE c.idendereco = e.id AND c.id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        
        Cliente c = null;
        
        while (rs.next()){
            c = new Cliente();
            
            c.setId(rs.getLong(1));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getInt("cpf"));
            c.setDtNascimento(DateUtil.parseUtil(rs.getDate("dtnascimento")));
            c.getEndereco().setId(rs.getLong("idendereco"));
            c.getEndereco().setRua(rs.getString("rua"));
            c.getEndereco().setBairro(rs.getString("bairro"));
            c.getEndereco().setNumero(rs.getInt("numero"));
            c.getEndereco().setCidade(rs.getString("cidade"));
            c.getEndereco().setEstado(rs.getString("estado"));
        }
        
        con.close();
        
        return c;
    }
    
    public void remover(Cliente c) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM cliente WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, c.getId());
        
        st.executeUpdate();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        enderecoDAO.remover(c.getEndereco());
        
        con.close();
        
    }
    
    public List<Cliente> listar() throws SQLException {

        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM cliente c, endereco e WHERE c.idendereco = e.id;";

        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        List<Cliente> lista = new ArrayList<Cliente>();
        Cliente c;
        
        while (rs.next()) {
            c = new Cliente();
            
            c.setId(rs.getLong(1));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getInt("cpf"));
            c.setDtNascimento(DateUtil.parseUtil(rs.getDate("dtnascimento")));
            c.getEndereco().setRua(rs.getString("rua"));
            c.getEndereco().setBairro(rs.getString("bairro"));
            c.getEndereco().setNumero(rs.getInt("numero"));
            c.getEndereco().setCidade(rs.getString("cidade"));
            c.getEndereco().setEstado(rs.getString("estado"));
            
            lista.add(c);
        }

        con.close();
        
        return lista;
    }
}
