/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Veiculo;
import br.com.pratica.projeto.util.ConnectionFactory;
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
public class VeiculoDAO {
    
    private Connection con;
    
    public long inserir(Veiculo v) throws SQLException {
        
        con = ConnectionFactory.getConnection();
            
        FabricanteDAO fabricanteDAO = new FabricanteDAO(con);
        long idFabricante = fabricanteDAO.inserir(v.getFabricante());
        
        String sql = "INSERT INTO veiculo(placa, modelo, chassi, idfabricante) " 
                + "VALUES(?, ?, ?, ?);";
        
        PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
        st.setString(1, v.getPlaca());
        st.setString(2, v.getModelo());
        st.setString(3, v.getChassi());
        st.setLong(4, idFabricante);

        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        long idVeiculo = 0;
        
        if (rs.next())
            idVeiculo = rs.getLong(1);
        
        con.close();
        
        return idVeiculo;
           
    }
    
    public void editar(Veiculo v) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        FabricanteDAO FabricanteDAO = new FabricanteDAO(con);
        FabricanteDAO.editar(v.getFabricante());
                
        String sql = "UPDATE veiculo SET placa = ?, modelo = ?, chassi = ? WHERE id = ?;";
            
        PreparedStatement st = con.prepareStatement(sql);
            
        st.setString(1, v.getPlaca());
        st.setString(2, v.getModelo());
        st.setString(3, v.getChassi());
        st.setLong(4, v.getId());
            
        st.executeUpdate();
        
        con.close();
    }
    
    public Veiculo buscar(long id) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM veiculo v, fabricante f WHERE v.idfabricante = f.id AND v.id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        
        Veiculo v = null;
        
        while (rs.next()){
            v = new Veiculo();
            
            v.setId(rs.getLong(1));
            v.setPlaca(rs.getString("placa"));
            v.setModelo(rs.getString("modelo"));
            v.setChassi(rs.getString("chassi"));
            v.getFabricante().setId(rs.getLong("idfabricante"));
            v.getFabricante().setNome(rs.getString("nome"));
            v.getFabricante().setCnpj(rs.getInt("cnpj"));
        }
        
        con.close();
        
        return v;
            
    }
    
    public void remover(Veiculo v) throws SQLException {
        
        con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM veiculo WHERE id = ?;";

        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, v.getId());

        st.executeUpdate();
        
        FabricanteDAO fabricanteDAO = new FabricanteDAO(con);
        fabricanteDAO.remover(v.getFabricante());

        con.close();
    }
    
    public List<Veiculo> listar() throws SQLException {

        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM veiculo v, fabricante f WHERE v.idfabricante = f.id;";

        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        List<Veiculo> lista = new ArrayList<Veiculo>();
        Veiculo v;
        
        while (rs.next()) {
            v = new Veiculo();
            
            v.setId(rs.getLong(1));
            v.setPlaca(rs.getString("placa"));
            v.setModelo(rs.getString("modelo"));
            v.setChassi(rs.getString("chassi"));
            v.getFabricante().setNome(rs.getString("nome"));
            v.getFabricante().setCnpj(rs.getInt("cnpj"));
            
            lista.add(v);
        }

        con.close();
        return lista;
    }
    
}
