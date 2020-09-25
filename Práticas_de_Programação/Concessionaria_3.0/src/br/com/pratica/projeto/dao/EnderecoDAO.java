/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Endereco;
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
public class EnderecoDAO {
    
    private Connection con;
    
    public EnderecoDAO(Connection con) {
        this.con = con;
    }
    
    public long inserir(Endereco e) throws SQLException {
        
        String sql = "INSERT INTO endereco(rua, bairro, numero, cidade, estado) "
                + "VALUES(?, ?, ?, ?, ?);";
        
        PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        st.setString(1, e.getRua());
        st.setString(2, e.getBairro());
        st.setInt(3, e.getNumero());
        st.setString(4, e.getCidade());
        st.setString(5, e.getEstado());
        
        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        long idEndereco = 0;
        
        if (rs.next()) {
            idEndereco = rs.getLong(1);
        }

        return idEndereco;       
    }
    
    public void editar(Endereco e) throws SQLException {
        
        String sql = "UPDATE endereco SET rua = ?, bairro = ?, numero = ?, "
                + "cidade = ?, estado = ? WHERE id = ?;";
            
        PreparedStatement st = con.prepareStatement(sql);
            
        st.setString(1, e.getRua());
        st.setString(2, e.getBairro());
        st.setInt(3, e.getNumero());
        st.setString(4, e.getCidade());
        st.setString(5, e.getEstado());
        st.setLong(6, e.getId());
            
        st.executeUpdate();
        
    }
    
    public Endereco buscar(long id) throws SQLException {
        
        String sql = "SELECT * FROM endereco WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        
        Endereco e = null;
        
        while (rs.next()){
            e = new Endereco();
            
            e.setId(rs.getLong("id"));
            e.setRua(rs.getString("rua"));
            e.setBairro(rs.getString("bairro"));
            e.setNumero(rs.getInt("numero"));
            e.setCidade(rs.getString("cidade"));
            e.setEstado(rs.getString("estado"));
        }
        
        return e;
    }
    
    public void remover(Endereco e) throws SQLException {
        
        String sql = "DELETE FROM endereco WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, e.getId());
        
        st.executeUpdate();
        
    }
    
    public List<Endereco> listar() throws SQLException {

        String sql = "SELECT * FROM endereco;";

        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        List<Endereco> lista = new ArrayList<Endereco>();
        Endereco e;
        
        while (rs.next()) {
            e = new Endereco();
            
            e.setRua(rs.getString("rua"));
            e.setBairro(rs.getString("bairro"));
            e.setNumero(rs.getInt("numero"));
            e.setCidade(rs.getString("cidade"));
            e.setEstado(rs.getString("estado"));
            
            lista.add(e);
        }
        
        return lista;
    }
}
