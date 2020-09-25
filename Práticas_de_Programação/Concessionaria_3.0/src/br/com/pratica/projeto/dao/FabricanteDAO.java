/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Fabricante;
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
public class FabricanteDAO {
    
    private Connection con;
    
    public FabricanteDAO(Connection con) {
        this.con = con;
    }
    
    public long inserir(Fabricante f) throws SQLException {
        
        String sql = "INSERT INTO fabricante(nome, cnpj) VALUES(?, ?);";
        
        PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        st.setString(1, f.getNome());
        st.setInt(2, f.getCnpj());
        
        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        long idEndereco = 0;

        if (rs.next()) {
            idEndereco = rs.getLong(1);
        }

        return idEndereco;       
    }
    
    public void editar(Fabricante f) throws SQLException {
        
        String sql = "UPDATE fabricante SET nome = ?, cnpj = ? WHERE id = ?;";
            
        PreparedStatement st = con.prepareStatement(sql);
            
        st.setString(1, f.getNome());
        st.setInt(2, f.getCnpj());
        st.setLong(3, f.getId());
            
        st.executeUpdate();
        
    }
    
    public Fabricante buscar(long id) throws SQLException {
        
        String sql = "SELECT * FROM fabricante WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        
        Fabricante f = null;
        
        while (rs.next()){
            f = new Fabricante();
            
            f.setId(rs.getLong("id"));
            f.setNome(rs.getString("nome"));
            f.setCnpj(rs.getInt("cnpj"));
        }
        
        return f;
    }
    
    public void remover(Fabricante f) throws SQLException {
        
        String sql = "DELETE FROM fabricante WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, f.getId());
        
        st.executeUpdate();
        
    }
    
    public List<Fabricante> listar() throws SQLException {

        String sql = "SELECT * FROM fabricante;";

        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        List<Fabricante> lista = new ArrayList<Fabricante>();
        Fabricante f;
        
        while (rs.next()) {
            f = new Fabricante();
            
            f.setNome(rs.getString("nome"));
            f.setCnpj(rs.getInt("cnpj"));
            
            lista.add(f);
        }
        
        return lista;
    }
}
