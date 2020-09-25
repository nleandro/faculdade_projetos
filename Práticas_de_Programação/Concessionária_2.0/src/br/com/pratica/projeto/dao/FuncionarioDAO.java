/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Funcionario;
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
public class FuncionarioDAO {
    
    private Connection con = null;
    
    public void inserir(Funcionario f) {
        try {
            con = ConnectionFactory.getConnection();
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_INSERT_FUNCIONARIO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, f.getNome());
            st.setString(2, f.getEndereco());
            st.setInt(3, f.getTelefone());
            st.setDate(4, DateUtil.parseSql(f.getDtNascimento()));
            st.setInt(5, f.getSalario());

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
    
    public void editar(Funcionario f) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_UPDATE_FUNCIONARIO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, f.getNome());
            st.setString(2, f.getEndereco());
            st.setInt(3, f.getTelefone());
            st.setDate(4, DateUtil.parseSql(f.getDtNascimento()));
            st.setInt(5, f.getSalario());
            st.setLong(6, f.getId());
            
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
    
    public void remover(Funcionario f) {
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_DELETE_FUNCIONARIO);
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, f.getId());
            
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
    
    public List<Funcionario> lista() {
        try {
            con = ConnectionFactory.getConnection();
        
            List<Funcionario> lista = new ArrayList<Funcionario>();
            Funcionario f;
        
            String sql = ConfigUtil.getConfig(ConfigUtil.MYSQL_SELECT_FUNCIONARIO);
        
            PreparedStatement st = con.prepareStatement(sql);
        
            ResultSet rs = st.executeQuery();
        
            while(rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                int telefone = rs.getInt("telefone");
                Date date = DateUtil.parseUtil(rs.getDate("dtnascimento"));
                int salario = rs.getInt("salario");
                
                f = new Funcionario(id, nome, endereco, telefone, date, salario);
                lista.add(f);
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