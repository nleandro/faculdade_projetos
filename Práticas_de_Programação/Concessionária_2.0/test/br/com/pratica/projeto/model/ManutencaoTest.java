/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.ManutencaoFacade;
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
public class ManutencaoTest {
    
    private final ManutencaoFacade facade = new ManutencaoFacade();
    private Manutencao m;
    
    public ManutencaoTest() {
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
        
        m = new Manutencao("ModeloTest", date, date);
        int qtdAnterior = facade.listaManutencao().size();
        
        facade.inserirManutencao(m);
        
        assertEquals(qtdAnterior + 1, facade.listaManutencao().size());
    }
    
    @Test
    public void testEditar() {
        String dateStr = "01/01/2018";
        Date date = DateUtil.stringToDate(dateStr);
        
        m = new Manutencao(TestUtil.getLastIdTest("manutencao"), "TestModelo", date, date);
        int qtdAnterior = facade.listaManutencao().size();
        
        facade.editarManutencao(m);
        
        assertEquals(qtdAnterior, facade.listaManutencao().size());
    }
    
    @Test
    public void testRemover() {
       m = new Manutencao(TestUtil.getLastIdTest("manutencao"));
        int qtdAnterior = facade.listaManutencao().size();
        
        facade.removerManutencao(m);
        
        assertEquals(qtdAnterior - 1, facade.listaManutencao().size());
    }
    
    @Test
    public void testListar() {
        assertTrue(facade.listaManutencao().size() > 0);
    }
}
