/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academico.dao;

import br.com.academico.model.ProjetoDeExtensao;
import br.com.academico.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nellson
 */
public class ProjetoDeExtensaoDao {
    
    private EntityManager em;

    public void inserir(ProjetoDeExtensao p) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(ProjetoDeExtensao p) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao editar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public ProjetoDeExtensao getPorId(int id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            return em.find(ProjetoDeExtensao.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(ProjetoDeExtensao p) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            p = em.find(ProjetoDeExtensao.class, p.getId());
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao remover registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<ProjetoDeExtensao> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            Query query = em.createQuery("SELECT p FROM ProjetoDeExtensao p");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
