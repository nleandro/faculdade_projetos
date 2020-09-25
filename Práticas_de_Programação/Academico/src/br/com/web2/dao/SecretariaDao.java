/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web2.dao;

import br.com.web2.model.Professor;
import br.com.web2.model.Secretaria;
import br.com.web2.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author EDUARDA
 */
public class SecretariaDao {

    private EntityManager em;

    public void inserir(Secretaria s) throws Exception {
        try {

            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(Secretaria s) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(s);
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

    public Secretaria getPorId(String cpf) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            return em.find(Secretaria.class, cpf);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Secretaria s) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            s = em.find(Secretaria.class, s.getCpf());
            em.remove(s);
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

    public List<Secretaria> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();

            Query query = em.createQuery("SELECT s FROM Secretaria s");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
