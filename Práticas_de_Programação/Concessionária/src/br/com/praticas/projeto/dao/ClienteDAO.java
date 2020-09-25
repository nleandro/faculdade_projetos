/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.dao;

import br.com.praticas.projeto.model.Cliente;
import br.com.praticas.projeto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
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
    
    public void salvar(Cliente c) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "insert into cliente (nome, endereco, telefone, data_nascimento) "
                + "values (?,?,?,?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, c.getNome());
        st.setString(2, c.getEndereco());
        st.setLong(3, c.getTelefone());
        Date dataNascimentoSQL = new Date(c.getDataNascimento().getTime());
        st.setDate(4, dataNascimentoSQL);
        
        st.executeUpdate();
        
        con.close();
    }
    
        public void editar(Cliente c) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "update cliente SET nome = ?, endereco = ?, telefone = ?, "
                + "data_nascimento = ? WHERE id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, c.getNome());
        st.setString(2, c.getEndereco());
        st.setLong(3, c.getTelefone());
        Date dataNascimentoSQL = new Date(c.getDataNascimento().getTime());
        st.setDate(4, dataNascimentoSQL);
        st.setLong(5, c.getId());
        
        st.executeUpdate();
        
        con.close();
    }

    public void excluir(Cliente c) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "delete from cliente where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setLong(1, c.getId());
        
        st.executeUpdate();
        
        con.close();
    }

    public List<Cliente> listar() throws SQLException {
        con = ConnectionFactory.getConnection();
        
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente c;
        
        String sql = "select * from cliente";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            long id = rs.getLong("id");
            String nome = rs.getString("nome");
            String endereco = rs.getString("endereco");
            long telefone = rs.getLong("telefone");
            Date dataSQL = rs.getDate("data_nascimento");
            
            c = new Cliente();
            c.setId(id);
            c.setNome(nome);
            c.setEndereco(endereco);
            c.setTelefone(telefone);
            if(dataSQL != null)
                c.setDataNascimento(new java.util.Date(dataSQL.getTime()));
            lista.add(c);
        }
        
        con.close();
        return lista;
    }
}
