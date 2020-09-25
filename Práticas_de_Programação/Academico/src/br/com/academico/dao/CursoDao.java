/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Curso;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lucas
 */
public class CursoDao {

    private EntityManager em;

    public void inserir(Curso c) throws Exception {
        try {
            // obter um EntityManager (Conexão)
            em = JPAUtil.createEntityManager();
            // inicar transação
            em.getTransaction().begin();
            // executar operação (salva o registro)
            em.persist(c);
            // encerrar transação
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            // encerrar entity manager
            JPAUtil.closeEntityManager();
        }

    }

    public void editar(Curso c) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Curso c) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            // remove o registro informado
            c = em.find(Curso.class, c.getCodigo());
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Curso getPorId(int id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // realiza a busca de 1 único registro com o id especficado
            return em.find(Curso.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Curso> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            Query query = em.createQuery("SELECT c FROM Curso c");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
