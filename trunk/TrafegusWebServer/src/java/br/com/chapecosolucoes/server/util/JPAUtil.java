/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emerson
 */
public class JPAUtil {

    private EntityManagerFactory emf = null;
    private static JPAUtil instance = null;

    private JPAUtil() {
        emf = Persistence.createEntityManagerFactory("TrafegusWebServerPU");
    }

    public static JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }
}
