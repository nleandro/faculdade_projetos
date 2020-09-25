/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.dao;

import br.com.praticas.projeto.model.Funcionario;
import br.com.praticas.projeto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class FuncionarioDAO {
    private Connection con;
    
    public void salvar(Funcionario f) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "insert into funcionario (nome, telefone, data_nascimento) "
                + "values (?,?,?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, f.getNome());
        st.setLong(2, f.getTelefone());
        Date dataNascimentoSQL = new Date(f.getDataNascimento().getTime());
        st.setDate(3, dataNascimentoSQL);
        
        st.executeUpdate();
        
        con.close();
    }
    
        public void editar(Funcionario f) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "update funcionario SET nome = ?, telefone = ?, data_nascimento = ? "
                + "WHERE id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, f.getNome());
        st.setLong(2, f.getTelefone());
        Date dataNascimentoSQL = new Date(f.getDataNascimento().getTime());
        st.setDate(3, dataNascimentoSQL);
        st.setLong(4, f.getId());
        
        st.executeUpdate();
        
        con.close();
    }

    public void excluir(Funcionario f) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "delete from funcionario where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setLong(1, f.getId());
        
        st.executeUpdate();
        
        con.close();
    }

    public List<Funcionario> listar() throws SQLException {
        con = ConnectionFactory.getConnection();
        
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario f;
        
        String sql = "select * from funcionario";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            long id = rs.getLong("id");
            String nome = rs.getString("nome");
            long telefone = rs.getLong("telefone");
            Date dataSQL = rs.getDate("data_nascimento");
            
            f = new Funcionario();
            f.setId(id);
            f.setNome(nome);
            f.setTelefone(telefone);
            if(dataSQL != null)
                f.setDataNascimento(new java.util.Date(dataSQL.getTime()));
            lista.add(f);
        }
        
        con.close();
        return lista;
    }
}
