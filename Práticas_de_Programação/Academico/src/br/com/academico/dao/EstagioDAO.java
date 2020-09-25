/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Estagio;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lucas
 */
public class EstagioDAO {
     private EntityManager em;

    public void inserir(Estagio es) throws Exception {
        try {
            // obter um EntityManager (Conexão)
            em = JPAUtil.createEntityManager();
            // inicar transação
            em.getTransaction().begin();
            // executar operação (salva o registro)
            em.persist(es);
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

    public void editar(Estagio es) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(es);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Estagio getPorId(int codigo) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // realiza a busca de 1 único registro com o id especficado
            return em.find(Estagio.class, codigo);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Estagio es) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            // remove o registro informado
            es = em.find(Estagio.class, es.getCodigo());
            em.remove(es);
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

    public List<Estagio> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            Query query = em.createQuery("SELECT e FROM Estagio e");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
