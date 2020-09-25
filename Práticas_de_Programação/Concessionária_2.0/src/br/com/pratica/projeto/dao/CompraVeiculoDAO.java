/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.CompraVeiculo;
import br.com.pratica.projeto.util.ConfigUtil;
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
public class CompraVeiculoDAO {
    
    private Connection con = null;
    
    public void inserir(CompraVeiculo c) {
        try {
            con = ConnectionFactory.getConnection();
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_INSERT_COMPRAVEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getFabricante());
            st.setString(2, c.getModelo());
            st.setInt(3, c.getPreco());

            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    
    }
    
    public void editar(CompraVeiculo c) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_UPDATE_COMPRAVEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getFabricante());
            st.setString(2, c.getModelo());
            st.setInt(3, c.getPreco());
            st.setLong(4, c.getId());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }   
    }
    
    public void remover(CompraVeiculo c) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_DELETE_COMPRAVEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, c.getId());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    public List<CompraVeiculo> lista() {
        try {
            con = ConnectionFactory.getConnection();
        
            List<CompraVeiculo> lista = new ArrayList<CompraVeiculo>();
            CompraVeiculo c;
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_SELECT_COMPRAVEICULO);
        
            PreparedStatement st = con.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
        
            while(rs.next()) {
                long id = rs.getLong("id");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                int preco = rs.getInt("preco");
                
                c = new CompraVeiculo(id, fabricante, modelo, preco);
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }   
}