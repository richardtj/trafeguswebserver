/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Emerson
 */
public class WSServletContextListener implements ServletContextListener {

    private ServletContext context = null;

    public ServletContext getContext() {
        return this.context;
    }

    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }

    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();

    }
}
