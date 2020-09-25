/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.FuncionarioFacade;
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
public class FuncionarioTest {
    
    private final FuncionarioFacade facade = new FuncionarioFacade();
    private Funcionario f;
    
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

    @Test
    public void testInserir() {
        String dateStr = "01/01/2010";
        Date date = DateUtil.stringToDate(dateStr);
        
        f = new Funcionario("NomeTest", "EndereçoTest", 123, date, 2000);
        int qtdAnterior = facade.listaFuncionario().size();
        
        facade.inserirFuncionario(f);
        
        assertEquals(qtdAnterior + 1, facade.listaFuncionario().size());
    }
    
    @Test
    public void testEditar() {
        String dateStr = "01/01/2018";
        Date date = DateUtil.stringToDate(dateStr);
        
        f = new Funcionario(TestUtil.getLastIdTest("funcionario"), "TestNome", "TestEndereço", 456, date, 1000);
        int qtdAnterior = facade.listaFuncionario().size();
        
        facade.editarFuncionario(f);
        
        assertEquals(qtdAnterior, facade.listaFuncionario().size());
    }
    
    @Test
    public void testRemover() {
        f = new Funcionario(TestUtil.getLastIdTest("funcionario"));
        int qtdAnterior = facade.listaFuncionario().size();
        
        facade.removerFuncionario(f);
        
        assertEquals(qtdAnterior - 1, facade.listaFuncionario().size());
    }
    
    @Test
    public void testListar() {
        assertTrue(facade.listaFuncionario().size() > 0);
    }
}
