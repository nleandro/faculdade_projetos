/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.ConcessionariaFacade;
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
public class EnderecoTest {
    
    private ConcessionariaFacade facade = new ConcessionariaFacade();
    private Endereco e = null;
    
    public EnderecoTest() {
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
    
    private Endereco inicializarEndereco(Endereco endereco) {
        endereco = new Endereco();
        
        endereco.setRua("Test");
        endereco.setBairro("Test");
        endereco.setNumero(123);
        endereco.setCidade("Test");
        endereco.setEstado("Test");
        
        return endereco;
    }
    
    @Test
    public void testInserir() throws SQLException {
        
        int qtdAnterior = facade.listarEndereco().size() + 1;
        
        e = inicializarEndereco(e);
        long id = facade.inserirEndereco(e);
        
        assertEquals(qtdAnterior, facade.listarEndereco().size());
        
        e = facade.buscarEndereco(id);
        facade.removerEndereco(e);
    }
    
    @Test
    public void testEditar() throws SQLException {
        
        e = inicializarEndereco(e);
        long id = facade.inserirEndereco(e);
        e = facade.buscarEndereco(id);
        
        e.setRua("TestEditar");
        e.setBairro("TestEditar");
        e.setNumero(456);
        e.setCidade("TestEditar");
        e.setEstado("TestEditar");
        
        facade.editarEndereco(e);
        
        Endereco e2 = facade.buscarEndereco(id);
        
        assertEquals(e.toString(), e2.toString());
        
        facade.removerEndereco(e);
    }
    
    @Test
    public void testRemover() throws SQLException {
    
        e = inicializarEndereco(e);
        long id = facade.inserirEndereco(e);
                
        int qtdAnterior = facade.listarEndereco().size() - 1;
        
        e = facade.buscarEndereco(id);
        facade.removerEndereco(e);
        
        assertEquals(qtdAnterior, facade.listarEndereco().size());
    }
    
}
