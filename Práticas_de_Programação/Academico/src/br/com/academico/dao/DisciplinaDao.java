/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.Disciplina;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lucas
 */
public class DisciplinaDao {

    private EntityManager em;

    public void inserir(Disciplina d) throws Exception {
        try {
            // obter um EntityManager (Conexão)
            em = JPAUtil.createEntityManager();
            // inicar transação
            em.getTransaction().begin();
            // executar operação (salva o registro)
            em.persist(d);
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

    public void editar(Disciplina d) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(d);
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

    public void excluir(Disciplina d) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            // remove o registro informado
            d = em.find(Disciplina.class, d.getCodigo());
            em.remove(d);
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

    public Disciplina getPorId(int id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // realiza a busca de 1 único registro com o id especficado
            return em.find(Disciplina.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Disciplina> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            Query query = em.createQuery("SELECT d FROM Disciplina d");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
