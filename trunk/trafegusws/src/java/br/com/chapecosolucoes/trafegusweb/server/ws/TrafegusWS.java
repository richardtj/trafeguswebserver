/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.beans.CrefClasseReferencia;
import br.com.chapecosolucoes.trafegusweb.server.beans.MotoMotorista;
import br.com.chapecosolucoes.trafegusweb.server.beans.RotaRota;
import br.com.chapecosolucoes.trafegusweb.server.beans.TranTransportador;
import br.com.chapecosolucoes.trafegusweb.server.beans.UsuaUsuario;
import br.com.chapecosolucoes.trafegusweb.server.beans.VeicVeiculo;
import br.com.chapecosolucoes.trafegusweb.server.jpa.JPAUtil;
import br.com.chapecosolucoes.trafegusweb.server.sqlutils.SQLBuilder;
import java.util.ArrayList;
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
        SQLBuilder sql = new SQLBuilder();
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        sql.Add("SELECT c FROM CrefClasseReferencia c");
        sql.Add("WHERE");
        sql.Add("c.refeReferenciaCollection.pessPessoa.pessOrasCodigo = :pessOrasCodigo and (c.crefCodigo = :crefCodigo)");

        Query q = em.createQuery(sql.getText());
        q.setParameter("pessOrasCodigo", codEmpresa);
        q.setParameter("crefCodigo", codClasseReferencia);

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
    @WebMethod(operationName = "solicitaDadosMotorista")
    public MotoMotorista solicitaDadosMotorista(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "cpfMotorista") String cpfMotorista) {
        MotoMotorista result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT m FROM MotoMotorista m WHERE m.pfisPessoaFisica.pfisCpf = :cpfMotorista");
        q.setParameter(1, cpfMotorista);
        try {
            result = (MotoMotorista) q.getSingleResult();
        } catch (Exception e) {
            result = new MotoMotorista();
        }
        em.getTransaction().commit();
        return result;
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "solicitaDadosVeiculo")
    public VeicVeiculo solicitaDadosVeiculo(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "placaVeiculo") String placaVeiculo) {
        VeicVeiculo result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT v FROM VeicVeiculo v WHERE v.veicPlaca = :veicPlaca");
        q.setParameter(1, placaVeiculo);
        try {
            result = (VeicVeiculo) q.getSingleResult();
        } catch (Exception e) {
            result = new VeicVeiculo();
        }
        em.getTransaction().commit();
        return result;
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "solicitaDadosTransportador")
    public TranTransportador solicitaDadosTransportador(@WebParam(name = "codTransportador") Integer codTransportador) {
        TranTransportador result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createNamedQuery("TranTransportador.findByTranPessOrasCodigo");
        q.setParameter(1, codTransportador);
        try {
            result = (TranTransportador) q.getSingleResult();
        } catch (Exception e) {
            result = new TranTransportador();
        }
        em.getTransaction().commit();
        return result;
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "solicitaDadosRota")
    public RotaRota solicitaDadosRota(@WebParam(name = "CodEmpresa") String CodEmpresa, @WebParam(name = "codRota") String codRota) {
        //
        RotaRota result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT r FROM RotaRota r WHERE r.rotaCodigo = :rotaCodigo");
        q.setParameter(1, codRota);
        try {
            result = (RotaRota) q.getSingleResult();
        } catch (Exception e) {
            result = new RotaRota();
        }
        em.getTransaction().commit();
        return result;
    }
}
