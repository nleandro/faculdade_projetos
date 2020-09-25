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
public class FabricanteTest {
    
    private ConcessionariaFacade facade = new ConcessionariaFacade();
    private Fabricante f = null;
    
    public FabricanteTest() {
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
    
    private Fabricante inicializarFabricante(Fabricante fabricante) {
        fabricante = new Fabricante();
        
        fabricante.setNome("Test");
        fabricante.setCnpj(123456789);
                
        return fabricante;
    }
    
    @Test
    public void testInserir() throws SQLException {
        
        int qtdAnterior = facade.listarFabricante().size() + 1;
        
        f = inicializarFabricante(f);
        long id = facade.inserirFabricante(f);
        
        assertEquals(qtdAnterior, facade.listarFabricante().size());
        
        f = facade.buscarFabricante(id);
        facade.removerFabricante(f);
    }
    
    @Test
    public void testEditar() throws SQLException {
        
        f = inicializarFabricante(f);
        long id = facade.inserirFabricante(f);
        f = facade.buscarFabricante(id);
        
        f.setNome("TestEditar");
        f.setCnpj(987654321);
        
        facade.editarFabricante(f);
        
        Fabricante f2 = facade.buscarFabricante(id);
        
        assertEquals(f.toString(), f2.toString());
        
        facade.removerFabricante(f);
    }
    
    @Test
    public void testRemover() throws SQLException {
    
        f = inicializarFabricante(f);
        long id = facade.inserirFabricante(f);
                
        int qtdAnterior = facade.listarFabricante().size() - 1;
        
        f = facade.buscarFabricante(id);
        facade.removerFabricante(f);
        
        assertEquals(qtdAnterior, facade.listarFabricante().size());
    }
    
}
