/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.dao;

import br.com.pratica.projeto.model.Funcionario;
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
public class FuncionarioDAO {
    
    private Connection con;
    
    public long inserir(Funcionario f) throws SQLException {
        
        con = ConnectionFactory.getConnection();
            
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        long idEndereco = enderecoDAO.inserir(f.getEndereco());
        
        String sql = "INSERT INTO funcionario(nome, salario, dtnascimento, idendereco) " 
                + "VALUES(?, ?, ?, ?);";
        
        PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
        st.setString(1, f.getNome());
        st.setDouble(2, f.getSalario());
        st.setDate(3, DateUtil.parseSql(f.getDtNascimento()));
        st.setLong(4, idEndereco);

        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        long idCliente = 0;
        
        if (rs.next())
            idCliente = rs.getLong(1);
        
        con.close();
        
        return idCliente;
           
    }
    
    public void editar(Funcionario f) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        enderecoDAO.editar(f.getEndereco());
                
        String sql = "UPDATE funcionario SET nome = ?, salario = ?, dtnascimento = ? WHERE id = ?;";
            
        PreparedStatement st = con.prepareStatement(sql);
            
        st.setString(1, f.getNome());
        st.setDouble(2, f.getSalario());
        st.setDate(3, DateUtil.parseSql(f.getDtNascimento()));
        st.setLong(4, f.getId());
            
        st.executeUpdate();
        
        con.close();
    }
    
    public Funcionario buscar(long id) throws SQLException {
        
        con = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM funcionario f, endereco e WHERE f.idendereco = e.id AND f.id = ?;";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        
        Funcionario f = null;
        
        while (rs.next()){
            f = new Funcionario();
            
            f.setId(rs.getLong(1));
            f.setNome(rs.getString("nome"));
            f.setSalario(rs.getDouble("salario"));
            f.setDtNascimento(DateUtil.parseUtil(rs.getDate("dtnascimento")));
            f.getEndereco().setId(rs.getLong("idendereco"));
            f.getEndereco().setRua(rs.getString("rua"));
            f.getEndereco().setBairro(rs.getString("bairro"));
            f.getEndereco().setNumero(rs.getInt("numero"));
            f.getEndereco().setCidade(rs.getString("cidade"));
            f.getEndereco().setEstado(rs.getString("estado"));
        }
        
        con.close();
        
        return f;
            
    }
    
    public void remover(Funcionario f) throws SQLException {
        
        con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM funcionario WHERE id = ?;";

        PreparedStatement st = con.prepareStatement(sql);
        
        st.setLong(1, f.getId());

        st.executeUpdate();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        enderecoDAO.remover(f.getEndereco());

        con.close();
    }
    
    public List<Funcionario> listar() throws SQLException {

        con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM funcionario f, endereco e WHERE f.idendereco = e.id;";

        PreparedStatement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        List<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario f;
        
        while (rs.next()) {
            f = new Funcionario();
            
            f.setId(rs.getLong(1));
            f.setNome(rs.getString("nome"));
            f.setSalario(rs.getDouble("salario"));
            f.setDtNascimento(DateUtil.parseUtil(rs.getDate("dtnascimento")));
            f.getEndereco().setRua(rs.getString("rua"));
            f.getEndereco().setBairro(rs.getString("bairro"));
            f.getEndereco().setNumero(rs.getInt("numero"));
            f.getEndereco().setCidade(rs.getString("cidade"));
            f.getEndereco().setEstado(rs.getString("estado"));
            
            lista.add(f);
        }

        con.close();
        return lista;
    }
}