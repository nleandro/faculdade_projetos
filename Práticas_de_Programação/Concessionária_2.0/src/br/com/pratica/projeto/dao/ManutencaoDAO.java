/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Manutencao;
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
public class ManutencaoDAO {
    
    private Connection con = null;
    
    public void inserir(Manutencao m) {
        try {
            con = ConnectionFactory.getConnection();
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_INSERT_MANUTENCAO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, m.getModelo());
            st.setDate(2, DateUtil.parseSql(m.getUltimaRevisao()));
            st.setDate(3, DateUtil.parseSql(m.getProximaRevisao()));

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
    
    public void editar(Manutencao m) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_UPDATE_MANUTENCAO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, m.getModelo());
            st.setDate(2, DateUtil.parseSql(m.getUltimaRevisao()));
            st.setDate(3, DateUtil.parseSql(m.getProximaRevisao()));
            st.setLong(4, m.getId());
            
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
    
    public void remover(Manutencao m) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_DELETE_MANUTENCAO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, m.getId());
            
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
    
    public List<Manutencao> lista() {
        try {
            con = ConnectionFactory.getConnection();
        
            List<Manutencao> lista = new ArrayList<Manutencao>();
            Manutencao m;
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_SELECT_MANUTENCAO);
        
            PreparedStatement st = con.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
        
            while(rs.next()) {
                long id = rs.getLong("id");
                String modelo = rs.getString("modelo");
                Date date1 = DateUtil.parseUtil(rs.getDate("ultimarevisao"));
                Date date2 = DateUtil.parseUtil(rs.getDate("proximarevisao"));
                
                m = new Manutencao(id, modelo, date1, date2);
                lista.add(m);
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