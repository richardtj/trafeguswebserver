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
import br.com.chapecosolucoes.trafegusweb.server.vo.SolicitaAcessoVO;
import br.com.chapecosolucoes.trafegusweb.server.xml.XMLUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author Emerson
 */
@WebService()
public class TrafegusWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaAcesso")
    public String solicitaAcesso(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT u FROM UsuaUsuario u WHERE u.usuaLogin = :usuaLogin AND u.usuaSenha = :usuaSenha");
        q.setParameter("usuaLogin", usuario);
        q.setParameter("usuaSenha", senha);
        UsuaUsuario usuaUsuario = null;

        try {
            usuaUsuario = (UsuaUsuario) q.getSingleResult();
        } catch (Exception e) {
            usuaUsuario = new UsuaUsuario();
        }

        SolicitaAcessoVO solicitaAcessoVO = new SolicitaAcessoVO();
        solicitaAcessoVO.setCodigo(usuaUsuario.getUsuaPfisPessOrasCodigo());
        solicitaAcessoVO.setLogin(usuaUsuario.getUsuaLogin());
        solicitaAcessoVO.setNome(usuaUsuario.getPessPessoa().getPessNome());
        solicitaAcessoVO.setCodPessoa(usuaUsuario.getPessPessoa().getPessOrasCodigo());

        String result = XMLUtil.getIntance().toXML("SolicitaAcesso", solicitaAcessoVO);

        usuaUsuario = null;
        solicitaAcessoVO = null;

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaClassesReferencias")
    public String solicitaClassesReferencias(@WebParam(name = "codEmrpesa") String codEmrpesa) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT c FROM CrefClasseReferencia c WHERE c.pessPessoa.pessOrasCodigo = :pessOrasCodigo");
        q.setParameter("pessOrasCodigo", codEmrpesa);

        ArrayList<CrefClasseReferencia> result = null;
        try {
            result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<CrefClasseReferencia>();
        }
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosMotorista")
    public String solicitaDadosMotorista(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "cpfMotorista") String cpfMotorista) {
        MotoMotorista result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT m FROM MotoMotorista m WHERE m.pfisPessoaFisica.pfisCpf = :cpfMotorista");
        q.setParameter("cpfMotorista", cpfMotorista);
        try {
            result = (MotoMotorista) q.getSingleResult();
        } catch (Exception e) {
            result = new MotoMotorista();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaRefencias")
    public String solicitaRefencias(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codClasseReferencia") Integer codClasseReferencia) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT c FROM CrefClasseReferencia c ");
        sb.append(" WHERE ");
        sb.append(" (c.crefCodigo = :crefCodigo)");

        Query q = em.createQuery(sb.toString());
        q.setParameter("crefCodigo", codClasseReferencia);

        ArrayList<CrefClasseReferencia> result = null;
        try {
            result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<CrefClasseReferencia>();
        }
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosVeiculo")
    public String solicitaDadosVeiculo(@WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "placaVeiculo") String placaVeiculo) {
        VeicVeiculo result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT v FROM VeicVeiculo v WHERE v.veicPlaca = :veicPlaca");
        q.setParameter("veicPlaca", placaVeiculo);
        try {
            result = (VeicVeiculo) q.getSingleResult();
        } catch (Exception e) {
            result = new VeicVeiculo();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosTransportador")
    public String solicitaDadosTransportador(@WebParam(name = "codTransportador") String codTransportador) {
        TranTransportador result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT t FROM TranTransportador t WHERE t.tranPessOrasCodigo = :tranPessOrasCodigo");
        q.setParameter("tranPessOrasCodigo", codTransportador);
        try {
            result = (TranTransportador) q.getSingleResult();
        } catch (Exception e) {
            result = new TranTransportador();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosRota")
    public String solicitaDadosRota(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codRota") Integer codRota) {
        RotaRota result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT r FROM RotaRota r WHERE r.rotaCodigo = :rotaCodigo");
        q.setParameter("rotaCodigo", codRota);

        try {
            result = (RotaRota) q.getSingleResult();
        } catch (Exception e) {
            result = new RotaRota();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaVeiculos")
    public String solicitaListaVeiculos(@WebParam(name = "codEmpresa") Integer codEmpresa) {
        //TODO write your implementation code here:
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT veic, veicTran, trans FROM VeicVeiculo veic ");
        sb.append(" left join fetch veic.vtraVeiculoTransportadorCollection as veicTran ");
        sb.append("");
        Query q = em.createQuery("SELECT v FROM VeicVeiculo v WHERE v.vtraVeiculoTransportadorCollection.tranTransportador.tranPessOrasCodigo = :tranPessOrasCodigo");
        q.setParameter(1, codEmpresa);
        ArrayList<VeicVeiculo> result = null;
        try {
            result = (ArrayList<VeicVeiculo>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<VeicVeiculo>();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);

    }
}
