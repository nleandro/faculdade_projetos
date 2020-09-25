/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Aluno;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nellson
 */
public class AlunoDao {

    private EntityManager em;

    public void inserir(Aluno a) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(Aluno a) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao editar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public Aluno getPorId(int id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            return em.find(Aluno.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Aluno a) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            a = em.find(Aluno.class, a.getId());
            em.remove(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao remover registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Aluno> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            Query query = em.createQuery("SELECT a FROM Aluno a");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
