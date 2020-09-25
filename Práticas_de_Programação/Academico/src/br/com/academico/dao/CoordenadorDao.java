/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Coordenador;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nellson
 */
public class CoordenadorDao {

    private EntityManager em;

    public void inserir(Coordenador c) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(Coordenador c) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao editar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public Coordenador getPorId(String cpf) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            return em.find(Coordenador.class, cpf);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Coordenador c) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            c = em.find(Coordenador.class, c.getCpf());
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao remover registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Coordenador> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            Query query = em.createQuery("SELECT c FROM Coordenador c");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
