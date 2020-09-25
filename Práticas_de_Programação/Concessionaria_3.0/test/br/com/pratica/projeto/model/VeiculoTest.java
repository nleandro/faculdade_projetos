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
public class VeiculoTest {
    
    private ConcessionariaFacade facade = new ConcessionariaFacade();
    private Veiculo v = null;
    
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
    
    private Veiculo inicializarVeiculo(Veiculo veiculo) {
        veiculo = new Veiculo();
        
        veiculo.setPlaca("Test");
        veiculo.setModelo("Test");
        veiculo.setChassi("Test");
        veiculo.getFabricante().setNome("Test");
        veiculo.getFabricante().setCnpj(123456789);
        
        return veiculo;
    }
    
    @Test
    public void testInserir() throws SQLException {
        
        int qtdAnterior = facade.listarVeiculo().size() + 1;
        
        v = inicializarVeiculo(v);
        long id = facade.inserirVeiculo(v);
        
        assertEquals(qtdAnterior, facade.listarVeiculo().size());
        
        v = facade.buscarVeiculo(id);
        facade.removerVeiculo(v);
        
    }
    
    @Test
    public void testEditar() throws SQLException {
        
        v = inicializarVeiculo(v);
        long id = facade.inserirVeiculo(v);
        v = facade.buscarVeiculo(id);
        
        v.setPlaca("TestEditar");
        v.setModelo("TestEditar");
        v.setChassi("TestEditar");
        v.getFabricante().setNome("TestEditar");
        v.getFabricante().setCnpj(987654321);
        
        facade.editarVeiculo(v);
        
        Veiculo v2 = facade.buscarVeiculo(id);
        
        assertEquals(v.toString(), v2.toString());
        
        facade.removerVeiculo(v);
        
    }
    
    @Test
    public void testRemover() throws SQLException {
        
        v = inicializarVeiculo(v);
        long id = facade.inserirVeiculo(v);
        
        int qtdAnterior = facade.listarVeiculo().size() - 1;
        
        v = facade.buscarVeiculo(id);
        facade.removerVeiculo(v);
        
        assertEquals(qtdAnterior, facade.listarVeiculo().size());
        
    }
    
}
