/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratica.projeto.model;

import br.com.pratica.projeto.facade.VendaVeiculoFacade;
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
public class VendaVeiculoTest {
    
    private final VendaVeiculoFacade facade = new VendaVeiculoFacade();
    private VendaVeiculo v;
    
    public VendaVeiculoTest() {
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
        v = new VendaVeiculo("ModeloTest", 50000, "CompradorTest", "FormaPagamentoTest");
        int qtdAnterior = facade.listaVendaVeiculo().size();
        
        facade.inserirVendaVeiculo(v);
        
        assertEquals(qtdAnterior + 1, facade.listaVendaVeiculo().size());
    }

    @Test
    public void testEditar() {
        v = new VendaVeiculo(TestUtil.getLastIdTest("vendaveiculo"), "TestModelo", 10000, "TestComprador", "TestFormaPagamento");
        int qtdAnterior = facade.listaVendaVeiculo().size();
        
        facade.editarVendaVeiculo(v);
        
        assertEquals(qtdAnterior, facade.listaVendaVeiculo().size());
    }

    @Test
    public void testRemover() {
        v = new VendaVeiculo(TestUtil.getLastIdTest("vendaveiculo"));
        int qtdAnterior = facade.listaVendaVeiculo().size();
        
        facade.removerVendaVeiculo(v);
        
        assertEquals(qtdAnterior - 1, facade.listaVendaVeiculo().size());
    }

    @Test
    public void testListar() {
        assertTrue(facade.listaVendaVeiculo().size() > 0);
    }
}
