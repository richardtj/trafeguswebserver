/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Emerson
 */
@WebService()
public class trafegusWebService {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "teste")
    public String teste(@WebParam(name = "value")
    String value) {
        //TODO write your implementation code here:
        return null;
    }

}
