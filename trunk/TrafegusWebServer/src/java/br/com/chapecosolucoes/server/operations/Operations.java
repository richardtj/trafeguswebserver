/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.operations;

import br.com.chapecosolucoes.server.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author emerson
 */
public class Operations {

    private static Operations instance;

    private Operations() {
    }

    public static Operations getIntance() {
        if (instance == null) {
            instance = new Operations();
        }
        return instance;
    }

    public Boolean findLogin(String user, String pwd) {
        Boolean result = false;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createNamedQuery("UsuaUsuario.findByUsuaLoginAndSenha");
        q.setParameter(1, user);
        q.setParameter(2, pwd);
        result = q.getSingleResult() != null;
        em.getTransaction().commit();
        return result;
    }
}
