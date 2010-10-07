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
        Query q = em.createQuery("SELECT c FROM CrefClasseReferencia c WHERE c.cref_pess_oras_codigo = :cref_pess_oras_codigo");
        q.setParameter("cref_pess_oras_codigo", codEmrpesa);

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
    public String solicitaListaVeiculos(@WebParam(name = "codEmpresa")
    String codEmpresa, @WebParam(name = "usuario")
    String usuario, @WebParam(name = "senha")
    String senha) {
        //TODO write your implementation code here:
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createNativeQuery(
            " SELECT " +
                " ORAS_Objeto_Rastreado.ORAS_Codigo, " +
                " ORAS_Objeto_Rastreado.ORAS_Data_Cadastro, " +
                " VEIC_Veiculo.*, " +
                " TVEI_Tipo_Veiculo.*, " +
                " vcar_veiculo_carreta.VCAR_VEIC_ORAS_Codigo, " +
                " vcav_veiculo_cavalo.VCAV_VEIC_ORAS_Codigo, " +
                " vmot_veiculo_moto.VMOT_VEIC_ORAS_Codigo, " +
                " vtru_veiculo_truck.VTRU_VEIC_ORAS_Codigo, " +
                " vuca_veiculo_utilitario_carga.VUCA_VEIC_ORAS_Codigo, " +
                " vupa_veiculo_utilitario_passe.VUPA_VEIC_ORAS_Codigo " +
            " FROM VEIC_Veiculo " +
                " JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = VEIC_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1) " +
                " JOIN TVEI_Tipo_Veiculo ON (VEIC_TVEI_Codigo = TVEI_Codigo) " +
                " JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo) " +
                " JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo " +
                " AND TRAN_PESS_ORAS_Codigo = :param01) " +
                " LEFT JOIN vcar_veiculo_carreta ON (VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo) " +
                " LEFT JOIN vcav_veiculo_cavalo ON (VEIC_ORAS_Codigo = VCAV_VEIC_ORAS_Codigo) " +
                " LEFT JOIN vmot_veiculo_moto ON (VEIC_ORAS_Codigo = VMOT_VEIC_ORAS_Codigo) " +
                " LEFT JOIN vtru_veiculo_truck ON (VEIC_ORAS_Codigo = VTRU_VEIC_ORAS_Codigo) " +
                " LEFT JOIN vuca_veiculo_utilitario_carga ON (VEIC_ORAS_Codigo = VUCA_VEIC_ORAS_Codigo) " +
                " LEFT JOIN vupa_veiculo_utilitario_passe ON (VEIC_ORAS_Codigo = VUPA_VEIC_ORAS_Codigo) " +
            " ORDER BY VEIC_Veiculo.VEIC_Placa ");
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
}
