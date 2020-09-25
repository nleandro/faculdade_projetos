/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Cliente;
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
public class ClienteDAO {
    
    private Connection con = null;
    
    public void inserir(Cliente c) {
        try {
            con = ConnectionFactory.getConnection();
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_INSERT_CLIENTE);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setInt(2, c.getCpf());
            st.setString(3, c.getEndereco());
            st.setInt(4, c.getTelefone());
            st.setDate(5, DateUtil.parseSql(c.getDtNascimento()));

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
    
    public void editar(Cliente c) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_UPDATE_CLIENTE);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getNome());
            st.setInt(2, c.getCpf());
            st.setString(3, c.getEndereco());
            st.setInt(4, c.getTelefone());
            st.setDate(5, DateUtil.parseSql(c.getDtNascimento()));
            st.setLong(6, c.getId());
            
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
    
    public void remover(Cliente c) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_DELETE_CLIENTE);
            
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
    
    public List<Cliente> lista() {
        try {
            con = ConnectionFactory.getConnection();
        
            List<Cliente> lista = new ArrayList<Cliente>();
            Cliente c;
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_SELECT_CLIENTE);
        
            PreparedStatement st = con.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
        
            while(rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                int cpf = rs.getInt("cpf");
                String endereco = rs.getString("endereco");
                int telefone = rs.getInt("telefone");
                Date date = DateUtil.parseUtil(rs.getDate("dtnascimento"));
                
                c = new Cliente(id, nome, cpf, endereco, telefone, date);
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