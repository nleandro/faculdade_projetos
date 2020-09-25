/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Instituicao;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author EDUARDA
 */
public class InstituicaoDao {

    private EntityManager em;

    public void inserir(Instituicao i) throws Exception {
        try {

            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir instituição!");
        } finally {
            // encerrar entity manager
            JPAUtil.closeEntityManager();
        }

    }

    public void editar(Instituicao i) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir instituição!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Instituicao i) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();

            i = em.find(Instituicao.class, i.getId());
            em.remove(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir instituição!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Instituicao getPorId(int id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();

            return em.find(Instituicao.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir instituição!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Instituicao> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();

            Query query = em.createQuery("SELECT i FROM Instituicao i");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir instituição!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
