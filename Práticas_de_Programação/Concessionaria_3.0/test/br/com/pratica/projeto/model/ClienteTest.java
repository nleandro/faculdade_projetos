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
public class ClienteTest {
    
    private ConcessionariaFacade facade = new ConcessionariaFacade();
    private Cliente c = null;
    
    public ClienteTest() {
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
    
    private Cliente inicializarCliente(Cliente cliente) {
        cliente = new Cliente();
        
        cliente.setNome("Test");
        cliente.setCpf(123456789);
        cliente.setDtNascimento(DateUtil.stringToDate("01/01/2018"));
        cliente.getEndereco().setRua("Test");
        cliente.getEndereco().setBairro("Test");
        cliente.getEndereco().setNumero(123);
        cliente.getEndereco().setCidade("Test");
        cliente.getEndereco().setEstado("Test");
        
        return cliente;
    }
    
    @Test
    public void testInserir() throws SQLException {
        
        int qtdAnterior = facade.listarCliente().size() + 1;
        
        c = inicializarCliente(c);
        long id = facade.inserirCliente(c);
        
        assertEquals(qtdAnterior, facade.listarCliente().size());
        
        // Apagar o cliente criado
        c = facade.buscarCliente(id);
        facade.removerCliente(c);
    }
    
    @Test
    public void testEditar() throws SQLException {
        
        c = inicializarCliente(c);
        long id = facade.inserirCliente(c);
        c = facade.buscarCliente(id);
        
        c.setNome("TestEditar");
        c.setCpf(987654321);
        c.setDtNascimento(DateUtil.stringToDate("31/12/2028"));
        c.getEndereco().setRua("TestEditar");
        c.getEndereco().setBairro("TestEditar");
        c.getEndereco().setNumero(456);
        c.getEndereco().setCidade("TestEditar");
        c.getEndereco().setEstado("TestEditar");
        
        facade.editarCliente(c);
        
        Cliente c2 = facade.buscarCliente(id);
        
        assertEquals(c.toString(), c2.toString());
        
        facade.removerCliente(c);
    }
    
    @Test
    public void testRemover() throws SQLException {
    
        c = inicializarCliente(c);
        long id = facade.inserirCliente(c);
                
        int qtdAnterior = facade.listarCliente().size() - 1;
        
        c = facade.buscarCliente(id);
        facade.removerCliente(c);
        
        assertEquals(qtdAnterior, facade.listarCliente().size());
    }
    
}
