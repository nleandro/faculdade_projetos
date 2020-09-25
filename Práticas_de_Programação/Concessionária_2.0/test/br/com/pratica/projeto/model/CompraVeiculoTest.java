/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.CompraVeiculoFacade;
import br.com.pratica.projeto.util.ConfigUtil;
import br.com.pratica.projeto.util.TestUtil;
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
public class CompraVeiculoTest {
    
    private final CompraVeiculoFacade facade = new CompraVeiculoFacade();
    private CompraVeiculo c;
    
    public CompraVeiculoTest() {
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
        c = new CompraVeiculo("FabricanteTest", "ModeloTest", 50000);
        int qtdAnterior = facade.listaCompraVeiculo().size();
        
        facade.inserirCompraVeiculo(c);
        
        assertEquals(qtdAnterior + 1, facade.listaCompraVeiculo().size());
    }
    
    @Test
    public void testEditar() {
        c = new CompraVeiculo(TestUtil.getLastIdTest("compraveiculo"), "TestFabricante", "TestModelo", 10000);
        int qtdAnterior = facade.listaCompraVeiculo().size();
        
        facade.editarCompraVeiculo(c);
        
        assertEquals(qtdAnterior, facade.listaCompraVeiculo().size());
    }
    
    @Test
    public void testRemover() {
        c = new CompraVeiculo(TestUtil.getLastIdTest("compraveiculo"));
        int qtdAnterior = facade.listaCompraVeiculo().size();
        
        facade.removerCompraVeiculo(c);
        
        assertEquals(qtdAnterior - 1, facade.listaCompraVeiculo().size());
    }
    
    @Test
    public void testListar() {
        assertTrue(facade.listaCompraVeiculo().size() > 0);
    }
}
