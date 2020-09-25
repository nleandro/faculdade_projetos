/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Allyson
 */
public class JPAUtil {
    
    private static EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("ProjetoWeb2PU");
    
    private static EntityManager em;
    
    public static EntityManager createEntityManager(){
        em = emf.createEntityManager();
        return em;
    }
    
    public static void closeEntityManager(){
        em.close();
    }
}
