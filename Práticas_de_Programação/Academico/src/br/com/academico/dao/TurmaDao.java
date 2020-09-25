/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Turma;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author EDUARDA
 */
public class TurmaDao {

    private EntityManager em;

    public void inserir(Turma t) throws Exception {
        try {

            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir Turma!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(Turma t) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir Turma!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Turma getPorId(int i) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            return em.find(Turma.class, i);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar turma!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Turma t) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            t = em.find(Turma.class, t.getId());
            em.remove(t);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir Turma!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Turma> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();

            Query query = em.createQuery("SELECT t FROM Turma t");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar Turma!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
