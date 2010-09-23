/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.ws;

import br.com.chapecosolucoes.server.beans.CrefClasseReferencia;
import br.com.chapecosolucoes.server.operations.Operations;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author emerson
 */
@WebService()
public class TrafegusWS {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "SolicitaClassesReferencias")
    public List<CrefClasseReferencia> SolicitaClassesReferencias(@WebParam(name = "codEmpresa")
            final Integer codEmpresa) {
        return Operations.getIntance().solicitaClassesReferencias(codEmpresa);
    }
}
