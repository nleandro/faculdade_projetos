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
public class ManutencaoTest {
    
    private ConcessionariaFacade facade = new ConcessionariaFacade();
    private Manutencao m = null;
    
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
    
    private Manutencao inicializarManutencao(Manutencao manutencao) {
        manutencao = new Manutencao();
        
        manutencao.setPlaca("Test");
        manutencao.setUltimaRevisao(DateUtil.stringToDate("01/01/2018"));
        manutencao.setProximaRevisao(DateUtil.stringToDate("01/01/2018"));
                
        return manutencao;
    }
    
    @Test
    public void testInserir() throws SQLException {
        
        int qtdAnterior = facade.listarManutencao().size() + 1;
        
        m = inicializarManutencao(m);
        long id = facade.inserirManutencao(m);
        
        assertEquals(qtdAnterior, facade.listarManutencao().size());
        
        m = facade.buscarManutencao(id);
        facade.removerManutencao(m);
        
    }
    
    @Test
    public void testEditar() throws SQLException {
        
        m = inicializarManutencao(m);
        long id = facade.inserirManutencao(m);
        m = facade.buscarManutencao(id);
        
        m.setPlaca("TestEditar");
        m.setUltimaRevisao(DateUtil.stringToDate("31/12/2028"));
        m.setProximaRevisao(DateUtil.stringToDate("31/12/2028"));
        
        facade.editarManutencao(m);
        
        Manutencao m2 = facade.buscarManutencao(id);
        
        assertEquals(m.toString(), m2.toString());
        
        facade.removerManutencao(m);
        
    }
    
    @Test
    public void testRemover() throws SQLException {
        
        m = inicializarManutencao(m);
        long id = facade.inserirManutencao(m);
        
        int qtdAnterior = facade.listarManutencao().size() - 1;
        
        m = facade.buscarManutencao(id);
        facade.removerManutencao(m);
        
        assertEquals(qtdAnterior, facade.listarManutencao().size());
        
    }
    
}
