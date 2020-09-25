/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Matricula;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nellson
 */
public class MatriculaDao {
    
    private EntityManager em;

    public void inserir(Matricula m) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(Matricula m) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao editar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public Matricula getPorId(int id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            return em.find(Matricula.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Matricula m) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            m = em.find(Matricula.class, m.getId());
            em.remove(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao remover registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Matricula> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            Query query = em.createQuery("SELECT m FROM Matricula m");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
