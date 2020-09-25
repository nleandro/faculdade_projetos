/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.VeiculoFacade;
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
public class VeiculoTest {
    
    private final VeiculoFacade facade = new VeiculoFacade();
    private Veiculo v;
    
    public VeiculoTest() {
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
        
        v = new Veiculo("PlacaTest", "ModeloTest", "FabricanteTest", date);
        int qtdAnterior = facade.listaVeiculo().size();
        
        facade.inserirVeiculo(v);
        
        assertEquals(qtdAnterior + 1, facade.listaVeiculo().size());
    }

    @Test
    public void testEditar() {
        String dateStr = "01/01/2018";
        Date date = DateUtil.stringToDate(dateStr);
        
        v = new Veiculo(TestUtil.getLastIdTest("veiculo"), "TestPlaca", "TestModelo", "TestFabricante", date);
        int qtdAnterior = facade.listaVeiculo().size();
        
        facade.editarVeiculo(v);
        
        assertEquals(qtdAnterior, facade.listaVeiculo().size());
    }

    @Test
    public void testRemover() {
        v = new Veiculo(TestUtil.getLastIdTest("veiculo"));
        int qtdAnterior = facade.listaVeiculo().size();
        
        facade.removerVeiculo(v);
        
        assertEquals(qtdAnterior - 1, facade.listaVeiculo().size());
    }

    @Test
    public void testListar() {
        assertTrue(facade.listaVeiculo().size() > 0);
    }
}
