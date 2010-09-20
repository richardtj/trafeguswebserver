/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emerson
 */
public class JPAController {

    private EntityManagerFactory emf = null;
    private static JPAController instance = null;

    private JPAController() {
        emf = Persistence.createEntityManagerFactory("TrafegusWebServerPU");
    }

    public static JPAController getInstance() {
        if (instance == null) {
            instance = new JPAController();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }
}
