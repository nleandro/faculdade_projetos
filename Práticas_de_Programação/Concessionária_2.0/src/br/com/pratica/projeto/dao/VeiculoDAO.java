/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Veiculo;
import br.com.pratica.projeto.util.ConfigUtil;
import br.com.pratica.projeto.util.ConnectionFactory;
import br.com.pratica.projeto.util.DateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nellson
 */
public class VeiculoDAO {
    
    private Connection con = null;
    
    public void inserir(Veiculo v) {
        try {
            con = ConnectionFactory.getConnection();
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_INSERT_VEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, v.getPlaca());
            st.setString(2, v.getModelo());
            st.setString(3, v.getFabricante());
            st.setDate(4, DateUtil.parseSql(v.getAno()));

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
    
    public void editar(Veiculo v) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_UPDATE_VEICULO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, v.getPlaca());
            st.setString(2, v.getModelo());
            st.setString(3, v.getFabricante());
            st.setDate(4, DateUtil.parseSql(v.getAno()));
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
    
    public void remover(Veiculo v) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_DELETE_VEICULO);
            
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
    
    public List<Veiculo> lista() {
        try {
            con = ConnectionFactory.getConnection();
        
            List<Veiculo> lista = new ArrayList<Veiculo>();
            Veiculo v;
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_SELECT_VEICULO);
        
            PreparedStatement st = con.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
        
            while(rs.next()) {
                long id = rs.getLong("id");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                String fabricante = rs.getString("fabricante");
                Date date = DateUtil.parseUtil(rs.getDate("ano"));
                
                v = new Veiculo(id, placa, modelo, fabricante, date);
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