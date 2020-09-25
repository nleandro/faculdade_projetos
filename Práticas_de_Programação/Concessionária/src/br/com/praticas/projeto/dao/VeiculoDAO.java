/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.projeto.dao;

import br.com.praticas.projeto.model.Veiculo;
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
public class VeiculoDAO {
    private Connection con;
    
    public void salvar(Veiculo v) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "insert into veiculo (placa, marca, modelo, ano) "
                + "values (?,?,?,?);";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, v.getPlaca());
        st.setString(2, v.getMarca());
        st.setString(3, v.getModelo());
        Date anoSQL = new Date(v.getAno().getTime());
        st.setDate(4, anoSQL);
        
        st.executeUpdate();
        
        con.close();
    }
    
        public void editar(Veiculo v) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "update veiculo SET placa = ?, marca = ?, modelo = ?, "
                + "ano = ? WHERE id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, v.getPlaca());
        st.setString(2, v.getMarca());
        st.setString(3, v.getModelo());
        Date anoSQL = new Date(v.getAno().getTime());
        st.setDate(4, anoSQL);
        st.setLong(5, v.getId());
        
        st.executeUpdate();
        
        con.close();
    }

    public void excluir(Veiculo v) throws SQLException {
        con = ConnectionFactory.getConnection();
        
        String sql = "delete from veiculo where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setLong(1, v.getId());
        
        st.executeUpdate();
        
        con.close();
    }

    public List<Veiculo> listar() throws SQLException {
        con = ConnectionFactory.getConnection();
        
        ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
        Veiculo v;
        
        String sql = "select * from veiculo";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            long id = rs.getLong("id");
            String placa = rs.getString("placa");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            Date dataSQL = rs.getDate("ano");
            
            v = new Veiculo();
            v.setId(id);
            v.setPlaca(placa);
            v.setMarca(marca);
            v.setModelo(modelo);
            if(dataSQL != null)
                v.setAno(new java.util.Date(dataSQL.getTime()));
            lista.add(v);
        }
        
        con.close();
        return lista;
    }
}
