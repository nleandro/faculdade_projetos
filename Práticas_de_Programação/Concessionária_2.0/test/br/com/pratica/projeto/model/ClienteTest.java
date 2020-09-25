/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.ClienteFacade;
import br.com.pratica.projeto.util.ConfigUtil;
import br.com.pratica.projeto.util.DateUtil;
import br.com.pratica.projeto.util.TestUtil;
import java.util.Date;
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
    
    private final ClienteFacade facade = new ClienteFacade();
    private Cliente c;
    
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

    @Test
    public void testInserir() {
        String dateStr = "01/01/2010";
        Date date = DateUtil.stringToDate(dateStr);

        c = new Cliente("NomeTest", 123, "EndereçoTest", 123, date);
        int qtdAnterior = facade.listaCliente().size();
        
        facade.inserirCliente(c);
        
        assertEquals(qtdAnterior + 1, facade.listaCliente().size());
    }

    @Test
    public void testEditar() {
        String dateStr = "01/01/2018";
        Date date = DateUtil.stringToDate(dateStr);
        
        c = new Cliente(TestUtil.getLastIdTest("Cliente"), "TestNome", 456, "TestEndereço", 456, date);
        int qtdAnterior = facade.listaCliente().size();
        
        facade.editarCliente(c);
        
        assertEquals(qtdAnterior, facade.listaCliente().size());
    }

    @Test
    public void testRemover() {
        c = new Cliente(TestUtil.getLastIdTest("Cliente"));
        int qtdAnterior = facade.listaCliente().size();
        
        facade.removerCliente(c);
        
        assertEquals(qtdAnterior - 1, facade.listaCliente().size());
    }

    @Test
    public void testListar() {
        assertTrue(facade.listaCliente().size() > 0);
    }
}
