/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.sessionlistener;

import br.com.chapecosolucoes.trafegusweb.server.jpa.JPAUtil;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Emerson
 */
public class TrafegusSessionListener implements HttpSessionListener {

    private EntityManager em = null;

    public void sessionCreated(HttpSessionEvent se) {
        em = JPAUtil.getInstance().getEntityManager();
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        em.close();
    }
}
