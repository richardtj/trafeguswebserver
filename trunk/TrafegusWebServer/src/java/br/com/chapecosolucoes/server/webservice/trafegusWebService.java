/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.webservice;

import br.com.chapecosolucoes.server.controller.JPAController;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Emerson
 */
@WebService()
public class trafegusWebService {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "user") String user, @WebParam(name = "pwd") String pwd) {
        EntityManager entityManager = JPAController.getInstance().getEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM UsuaUsuario u");
        query.getResultList();

        return "ok";
    }
}
