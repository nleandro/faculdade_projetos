/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Manutencao;
import br.com.pratica.projeto.util.ConnectionFactory;
import br.com.pratica.projeto.util.DateUtil;
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
public class ManutencaoDAO {
    
    private Connection con;
    
    public long inserir(Manutencao m) throws SQLException {
        
        con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO manutencao(placa, ultimarevisao, proximarevisao) "
                + "VALUES(?, ?, ?);";

        PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        st.setString(1, m.getPlaca());
        st.setDate(2, DateUtil.parseSql(m.getUltimaRevisao()));
        st.setDate(3, DateUtil.parseSql(m.getProximaRevisao()));

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        long idManutencao = 0;
        
        if (rs.next())
            idManutencao = rs.getLong(1);
        
        con.close();
        
        return idManutencao;
    }
    
    public void editar(Manutencao m) throws SQLException {
        
        con = ConnectionFactory.getConnection();

        String sql = "UPDATE manutencao SET placa = ?, ultimarevisao = ?, proximarevisao = ? WHERE id = ?;";

        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, m.getPlaca());
        st.setDate(2, DateUtil.parseSql(m.getUltimaRevisao()));
        st.setDate(3, DateUtil.parseSql(m.getProximaRevisao()));
        st.setLong(4, m.getId());

        st.executeUpdate();

        con.close();
    }
    
    public Manutencao buscar(long id) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM manutencao WHERE id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        Manutencao m = null;
        
        if (rs.next()) {
            m = new Manutencao();
            
            m.setId(rs.getLong("id"));
            m.setPlaca(rs.getString("placa"));
            m.setUltimaRevisao(DateUtil.parseUtil(rs.getDate("ultimarevisao")));
            m.setProximaRevisao(DateUtil.parseUtil(rs.getDate("proximarevisao")));
        }
        
        con.close();
        
        return m;
        
    }
    
    public void remover(Manutencao m) throws SQLException {
        
        con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM manutencao WHERE id = ?;";

        PreparedStatement st = con.prepareStatement(sql);

        st.setLong(1, m.getId());

        st.executeUpdate();

        con.close();
        
    }
    
    public List<Manutencao> lista() throws SQLException {
        
        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM manutencao";

        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        List<Manutencao> lista = new ArrayList<Manutencao>();
        Manutencao m;

        while (rs.next()) {
            m = new Manutencao();

            m.setId(rs.getLong("id"));
            m.setPlaca(rs.getString("placa"));
            m.setUltimaRevisao(DateUtil.parseUtil(rs.getDate("ultimarevisao")));
            m.setProximaRevisao(DateUtil.parseUtil(rs.getDate("proximarevisao")));

            lista.add(m);
        }

        con.close();

        return lista;
    }   
}