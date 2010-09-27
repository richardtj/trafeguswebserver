/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.beans.CrefClasseReferencia;
import br.com.chapecosolucoes.trafegusweb.server.beans.UsuaUsuario;
import br.com.chapecosolucoes.trafegusweb.server.jpa.JPAUtil;
import java.util.ArrayList;
import java.util.List;
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
public class TrafegusWS {

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "solicitaAcesso")
    public UsuaUsuario solicitaAcesso(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createNamedQuery("UsuaUsuario.findByUsuaLoginSenha");
        q.setParameter("usuaLogin", usuario);
        q.setParameter("usuaSenha", senha);
        UsuaUsuario result = null;
        try {
            result = (UsuaUsuario) q.getSingleResult();
        } catch (Exception e) {
            result = new UsuaUsuario();
        }
        return result;
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "solicitaClassesReferencias")
    public ArrayList<CrefClasseReferencia> solicitaClassesReferencias(@WebParam(name = "codEmrpesa") Integer codEmrpesa) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT c FROM CrefClasseReferencia c WHERE c.cref_pess_oras_codigo = :cref_pess_oras_codigo");
        q.setParameter("cref_pess_oras_codigo", codEmrpesa);

        ArrayList<CrefClasseReferencia> result = null;
        try {
            result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<CrefClasseReferencia>();
        }
        return result;
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "solicitaReferencias")
    public ArrayList<CrefClasseReferencia> solicitaReferencias(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codClasseReferencia") Integer codClasseReferencia) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT c FROM CrefClasseReferencia c WHERE (c.cref_pess_oras_codigo = null or c.cref_pess_oras_codigo = :cref_pess_oras_codigo) and (c.crefCodigo = :crefCodigo)");
        q.setParameter("cref_pess_oras_codigo", codEmpresa);
        q.setParameter("crefCodigo", codClasseReferencia);

        ArrayList<CrefClasseReferencia> result = null;
        try {
            result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<CrefClasseReferencia>();
        }
        return result;
    }
}
