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
    public String solicitaDadosMotorista(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "cpfMotorista") String cpfMotorista) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_OBJETO_RASTREADO.ORAS_CODIGO,");
        sb.append("              ORAS_OBJETO_RASTREADO.ORAS_DATA_CADASTRO,");
        sb.append("              PESS_PESSOA.PESS_NOME,");
        sb.append("              PFIS_PESSOA_FISICA.PFIS_RG,");
        sb.append("              PFIS_PESSOA_FISICA.PFIS_CPF,");
        sb.append("              PFIS_PESSOA_FISICA.PFIS_SEXO,");
        sb.append("              MOTO_MOTORISTA.MOTO_EPMO_CODIGO,");
        sb.append("              MOTO_MOTORISTA.MOTO_NUMERO_CNH,");
        sb.append("              MOTO_MOTORISTA.MOTO_CATEGORIA_CNH,");
        sb.append("              MOTO_MOTORISTA.MOTO_VALIDADE_CNH,");
        sb.append("              MOTO_MOTORISTA.MOTO_SENHA,");
        sb.append("              MOTO_MOTORISTA.MOTO_TREINADO,");
        sb.append("              MOTO_MOTORISTA.MOTO_ULTIMO_TREINAMENTO,");
        sb.append("              MOTO_MOTORISTA.MOTO_VALIDADE_PESQUISA");
        sb.append(" FROM MOTO_MOTORISTA");
        sb.append("   JOIN PFIS_PESSOA_FISICA ON (PFIS_PESS_ORAS_CODIGO = MOTO_PFIS_PESS_ORAS_CODIGO AND PFIS_CPF = '").append(cpfMotorista).append("')");
        sb.append("   JOIN PESS_PESSOA ON (PESS_ORAS_CODIGO = PFIS_PESS_ORAS_CODIGO)");
        sb.append("   JOIN ORAS_OBJETO_RASTREADO ON (ORAS_CODIGO = PESS_ORAS_CODIGO AND ORAS_EOBJ_CODIGO = 1)");
        sb.append("   JOIN MTRA_MOTORISTA_TRANSPORTADOR ON (MTRA_MOTO_PFIS_PESS_ORAS_CODIGO = ORAS_CODIGO)");
        sb.append("   JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = MTRA_TRAN_PESS_ORAS_CODIGO)");
        sb.append(" ORDER BY PESS_PESSOA.PESS_NOME");
        System.out.println(sb.toString());

        return Conexao.getInstance().queryToXML(sb.toString());

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
    public String solicitaDadosRota(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codRota") Integer codRota) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ROTA_CODIGO,");
        sb.append("	ROTA_DESCRICAO,");
        sb.append("     ROTA_DISTANCIA,");
        sb.append("     ROTA_COORDENADA,");
        sb.append("     ROTA_DATA_CADASTRO,");
        sb.append("     ROTA_COORDENADASPIPE");
        sb.append(" FROM ROTA_ROTA");
        sb.append(" WHERE ROTA_CODIGO = ").append(codRota.toString());
        sb.append(" ORDER BY ROTA_DESCRICAO");
        return Conexao.getInstance().queryToXML(sb.toString());
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaRotas")
    public String solicitaListaRotas(@WebParam(name = "codEmpresa") Integer codEmpresa) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append("    ROTA_CODIGO,");
        sb.append("    ROTA_DESCRICAO,");
        sb.append("    ROTA_DISTANCIA,");
        sb.append("    ROTA_COORDENADA,");
        sb.append("    ROTA_DATA_CADASTRO,");
        sb.append("    ROTA_COORDENADASPIPE");
        sb.append(" FROM ROTA_ROTA");
        sb.append(" WHERE ROTA_PESS_ORAS_CODIGO_DONO = ").append(codEmpresa.toString());
        sb.append(" ORDER BY ROTA_DESCRICAO");
        return Conexao.getInstance().queryToXML(sb.toString());
    }
}
