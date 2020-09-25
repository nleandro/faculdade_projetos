/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.VendaVeiculo;
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
public class VendaVeiculoDAO {
    
    private Connection con = null;
    
    public void inserir(VendaVeiculo v) {
        try {
            con = ConnectionFactory.getConnection();
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_INSERT_VENDAVEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, v.getModelo());
            st.setInt(2, v.getPreco());
            st.setString(3, v.getComprador());
            st.setString(4, v.getFormaPagamento());

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
    
    public void editar(VendaVeiculo v) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_UPDATE_VENDAVEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, v.getModelo());
            st.setInt(2, v.getPreco());
            st.setString(3, v.getComprador());
            st.setString(4, v.getFormaPagamento());
            st.setLong(5, v.getId());
            
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
    
    public void remover(VendaVeiculo v) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_DELETE_VENDAVEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, v.getId());
            
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
    
    public List<VendaVeiculo> lista() {
        try {
            con = ConnectionFactory.getConnection();
        
            List<VendaVeiculo> lista = new ArrayList<VendaVeiculo>();
            VendaVeiculo v;
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_SELECT_VENDAVEICULO);
        
            PreparedStatement st = con.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
        
            while(rs.next()) {
                long id = rs.getLong("id");
                String modelo = rs.getString("modelo");
                int preco = rs.getInt("preco");
                String comprador = rs.getString("comprador");
                String formaPagamento = rs.getString("formapagamento");
                
                v = new VendaVeiculo(id, modelo, preco, comprador, formaPagamento);
                lista.add(v);
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