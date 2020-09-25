/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.ConcessionariaFacade;
import br.com.pratica.projeto.util.DateUtil;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nellson
 */
public class FuncionarioTest {
    
    private ConcessionariaFacade facade = new ConcessionariaFacade();
    private Funcionario f = null;
    
    public FuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    private Funcionario inicializarFuncionario(Funcionario funcionario) {
        funcionario = new Funcionario();
        
        funcionario.setNome("Test");
        funcionario.setSalario(1234);
        funcionario.setDtNascimento(DateUtil.stringToDate("01/01/2018"));
        funcionario.getEndereco().setRua("Test");
        funcionario.getEndereco().setBairro("Test");
        funcionario.getEndereco().setNumero(123);
        funcionario.getEndereco().setCidade("Test");
        funcionario.getEndereco().setEstado("Test");
        
        return funcionario;
    }
    
    @Test
    public void testInserir() throws SQLException {
        
        int qtdAnterior = facade.listarFuncionario().size() + 1;
        
        f = inicializarFuncionario(f);
        long id = facade.inserirFuncionario(f);
        
        assertEquals(qtdAnterior, facade.listarFuncionario().size());
        
        f = facade.buscarFuncionario(id);
        facade.removerFuncionario(f);
        
    }
    
    @Test
    public void testEditar() throws SQLException {
        
        f = inicializarFuncionario(f);
        long id = facade.inserirFuncionario(f);
        f = facade.buscarFuncionario(id);
        
        f.setNome("TestEditar");
        f.setSalario(4321);
        f.setDtNascimento(DateUtil.stringToDate("31/12/2028"));
        f.getEndereco().setRua("TestEditar");
        f.getEndereco().setBairro("TestEditar");
        f.getEndereco().setNumero(456);
        f.getEndereco().setCidade("TestEditar");
        f.getEndereco().setEstado("TestEditar");
        
        facade.editarFuncionario(f);
        
        Funcionario f2 = facade.buscarFuncionario(id);
        
        assertEquals(f.toString(), f2.toString());
        
        facade.removerFuncionario(f);
        
    }
    
    @Test
    public void testRemover() throws SQLException {
        
        f = inicializarFuncionario(f);
        long id = facade.inserirFuncionario(f);
        
        int qtdAnterior = facade.listarFuncionario().size() - 1;
        
        f = facade.buscarFuncionario(id);
        facade.removerFuncionario(f);
        
        assertEquals(qtdAnterior, facade.listarFuncionario().size());
        
    }
    
}
