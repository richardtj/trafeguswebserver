/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.conexao.Conexao;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
    public String solicitaAcesso(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT");
        sb.append("       USUA_PFIS_PESS_ORAS_CODIGO,");
        sb.append("       USUA_PESS_ORAS_CODIGO,");
        sb.append("       USUA_LOGIN,");
        sb.append("       USUA_PERF_CODIGO,");
        sb.append("       USUA.PESS_NOME AS NOMEUSUARIO,");
        sb.append("       TRAN.PESS_NOME AS NOMETRANSPORTADOR");
        sb.append("  FROM");
        sb.append("       USUA_USUARIO");
        sb.append("  JOIN PESS_PESSOA AS USUA ON (USUA.PESS_ORAS_CODIGO = USUA_PFIS_PESS_ORAS_CODIGO)");
        sb.append("  JOIN ORAS_OBJETO_RASTREADO AS ORAS1 ON (ORAS1.ORAS_CODIGO = USUA.PESS_ORAS_CODIGO AND ORAS1.ORAS_EOBJ_CODIGO = 1)");
        sb.append("  JOIN PESS_PESSOA AS TRAN ON (TRAN.PESS_ORAS_CODIGO = USUA_PESS_ORAS_CODIGO)");
        sb.append("  JOIN ORAS_OBJETO_RASTREADO AS ORAS2 ON (ORAS2.ORAS_CODIGO = TRAN.PESS_ORAS_CODIGO AND ORAS2.ORAS_EOBJ_CODIGO = 1)");
        sb.append(" WHERE");
        sb.append("       UPPER(USUA_LOGIN) = UPPER('").append(usuario).append("')");
        sb.append("   AND UPPER(USUA_SENHA) = UPPER('").append(senha).append("')");
        sb.append(" LIMIT 1        ");
        return Conexao.getInstance().queryToXML(sb.toString());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaClassesReferencias")
    public String solicitaClassesReferencias(@WebParam(name = "codEmrpesa") String codEmrpesa) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT cref_codigo,");
        sb.append("     cref_descricao,");
        sb.append("     cref_pess_oras_codigo,");
        sb.append("     cref_classe_sistema");
        sb.append(" FROM cref_classe_referencia");
        sb.append(" WHERE(cref_pess_oras_codigo IS NULL OR cref_pess_oras_codigo = '").append(codEmrpesa.toString()).append("')");

        return Conexao.getInstance().queryToXML(sb.toString());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosMotorista")
    public String solicitaDadosMotorista(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "cpfMotorista") String cpfMotorista) {
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaRefencias")
    public String solicitaRefencias(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codClasseReferencia") Integer codClasseReferencia) {
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosVeiculo")
    public String solicitaDadosVeiculo(@WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "placaVeiculo") String placaVeiculo) {
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosTransportador")
    public String solicitaDadosTransportador(@WebParam(name = "codTransportador") String codTransportador) {
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosRota")
    public String solicitaDadosRota(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codRota") Integer codRota) {
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaVeiculos")
    public String solicitaListaVeiculos(@WebParam(name = "codEmpresa") Integer codEmpresa) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT ORAS_OBJETO_RASTREADO.ORAS_CODIGO,");
        sb.append("       VEIC_VEICULO.VEIC_PLACA AS VEHICLEPLATE,");
        sb.append("       TVEI_TIPO_VEICULO.TVEI_DESCRICAO");
        sb.append(" FROM VEIC_VEICULO");
        sb.append("     JOIN ORAS_OBJETO_RASTREADO ON (ORAS_CODIGO = VEIC_ORAS_CODIGO AND");
        sb.append("     ORAS_EOBJ_CODIGO = 1)");
        sb.append("     JOIN TVEI_TIPO_VEICULO ON (VEIC_TVEI_CODIGO = TVEI_CODIGO)");
        sb.append("     JOIN VTRA_VEICULO_TRANSPORTADOR ON (VTRA_VEIC_ORAS_CODIGO = VEIC_ORAS_CODIGO)");
        sb.append("     JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = VTRA_TRAN_PESS_ORAS_CODIGO AND TRAN_PESS_ORAS_CODIGO = ").append(codEmpresa.toString()).append(")");
        sb.append("     LEFT JOIN VCAR_VEICULO_CARRETA ON (VEIC_ORAS_CODIGO = VCAR_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VCAV_VEICULO_CAVALO ON (VEIC_ORAS_CODIGO = VCAV_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VMOT_VEICULO_MOTO ON (VEIC_ORAS_CODIGO = VMOT_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VTRU_VEICULO_TRUCK ON (VEIC_ORAS_CODIGO = VTRU_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VUCA_VEICULO_UTILITARIO_CARGA ON (VEIC_ORAS_CODIGO = VUCA_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VUPA_VEICULO_UTILITARIO_PASSE ON (VEIC_ORAS_CODIGO = VUPA_VEIC_ORAS_CODIGO)");
        sb.append(" ORDER BY VEIC_VEICULO.VEIC_PLACA ");
        return Conexao.getInstance().queryToXML(sb.toString());

    }
}
