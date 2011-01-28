/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.conexao.Conexao;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

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
    public String solicitaAcesso(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) throws Exception {
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
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaClassesReferencias")
    public String solicitaClassesReferencias(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmrpesa") String codEmrpesa) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT cref_codigo,");
        sb.append("     cref_descricao,");
        sb.append("     cref_pess_oras_codigo,");
        sb.append("     cref_classe_sistema");
        sb.append(" FROM cref_classe_referencia");
        sb.append(" WHERE(cref_pess_oras_codigo IS NULL OR cref_pess_oras_codigo = '").append(codEmrpesa.toString()).append("')");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosMotorista")
    public String solicitaDadosMotorista(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "cpfMotorista") String cpfMotorista) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("     TO_CHAR(ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,'DD/MM/YYYY HH24:MI:SS') AS ORAS_Data_Cadastro,");
        sb.append("     PESS_Pessoa.PESS_Nome,");
        sb.append("     PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("     PFIS_Pessoa_Fisica.PFIS_CPF,");
        sb.append("     PFIS_Pessoa_Fisica.PFIS_Sexo,");
        sb.append("     MOTO_Motorista.MOTO_EPMO_Codigo,");
        sb.append("     MOTO_Motorista.MOTO_Numero_CNH,");
        sb.append("     MOTO_Motorista.MOTO_Categoria_CNH,");
        sb.append("     TO_CHAR(MOTO_Motorista.MOTO_Validade_CNH,'DD/MM/YYYY') AS MOTO_Validade_CNH,");
        sb.append("     MOTO_Motorista.MOTO_Senha,");
        sb.append("     MOTO_Motorista.MOTO_Treinado,");
        sb.append("     TO_CHAR(MOTO_Motorista.MOTO_Ultimo_Treinamento,'DD/MM/YYYY') AS MOTO_Ultimo_Treinamento,");
        sb.append("     TO_CHAR(MOTO_Motorista.MOTO_Validade_Pesquisa,'DD/MM/YYYY') AS MOTO_Validade_Pesquisa");
        sb.append(" FROM MOTO_Motorista");
        sb.append(" JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = MOTO_PFIS_PESS_ORAS_Codigo");
        sb.append(" AND  TRIM(REPLACE(REPLACE(REPLACE(REPLACE(PFIS_Pessoa_Fisica.PFIS_CPF,'.',''),'/',''),'\\\\',''),'-','')) =");
        sb.append("           TRIM(REPLACE(REPLACE(REPLACE(REPLACE('");
        sb.append(cpfMotorista).append("' ,'.',''),'/',''),'\\\\',''),'-',''))  )");
        sb.append(" JOIN PESS_Pessoa ON (PESS_ORAS_codigo = PFIS_PESS_ORAS_Codigo)");
        sb.append(" JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_codigo AND ORAS_EOBJ_Codigo = 1)");
        //System.out.println(sb.toString());

        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaRefencias")
    public String solicitaRefencias(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codClasseReferencia") Integer codClasseReferencia) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT CREF_CODIGO,");
        sb.append("        CREF_DESCRICAO,");
        sb.append("        CREF_PESS_ORAS_CODIGO,");
        sb.append("        CREF_CLASSE_SISTEMA,");
        sb.append("        CREF_DATA_CADASTRO,");
        sb.append("        REFE_CODIGO,");
        sb.append("        REFE_DESCRICAO,");
        sb.append("        REFE_LATITUDE,");
        sb.append("        REFE_LONGITUDE,");
        sb.append("        REFE_CREF_CODIGO,");
        sb.append("        REFE_RAIO,");
        sb.append("        REFE_KM,");
        sb.append("        REFE_BANDEIRA,");
        sb.append("        REFE_UTILIZADO_SISTEMA,");
        sb.append("        REFE_DATA_CADASTRO");
        sb.append(" FROM");
        sb.append("        CREF_CLASSE_REFERENCIA");
        sb.append(" JOIN REFE_REFERENCIA ON (REFE_CREF_CODIGO = CREF_CODIGO)");
        sb.append(" WHERE");
        sb.append("        (CREF_PESS_ORAS_CODIGO IS NULL OR CREF_PESS_ORAS_CODIGO = '").append(codEmpresa.toString()).append("')");
        if (!codClasseReferencia.equals(new Integer(0))) {
            sb.append("          AND CREF_CODIGO = '").append(codClasseReferencia.toString()).append("'");
        }
        sb.append(" ORDER BY REFE_DESCRICAO");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalRefencias")
    public String solicitaTotalRefencias(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT CREF_CODIGO,");
        sb.append("        CREF_DESCRICAO,");
        sb.append("        CREF_PESS_ORAS_CODIGO,");
        sb.append("        CREF_CLASSE_SISTEMA,");
        sb.append("        CREF_DATA_CADASTRO,");
        sb.append("        REFE_CODIGO,");
        sb.append("        REFE_DESCRICAO,");
        sb.append("        REFE_LATITUDE,");
        sb.append("        REFE_LONGITUDE,");
        sb.append("        REFE_CREF_CODIGO,");
        sb.append("        REFE_RAIO,");
        sb.append("        REFE_KM,");
        sb.append("        REFE_BANDEIRA,");
        sb.append("        REFE_UTILIZADO_SISTEMA,");
        sb.append("        REFE_DATA_CADASTRO");
        sb.append(" FROM");
        sb.append("        CREF_CLASSE_REFERENCIA");
        sb.append(" JOIN REFE_REFERENCIA ON (REFE_CREF_CODIGO = CREF_CODIGO)");
        sb.append(" WHERE");
        sb.append("        (CREF_PESS_ORAS_CODIGO IS NULL OR CREF_PESS_ORAS_CODIGO = '").append(codEmpresa.toString()).append("')");
        sb.append(" ) AS XXX");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaRefenciasZoom")
    public String solicitaRefenciasZoom(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "offset") Integer offset, @WebParam(name = "limit") Integer limit) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT CREF_CODIGO,");
        sb.append("        CREF_DESCRICAO,");
        sb.append("        CREF_PESS_ORAS_CODIGO,");
        sb.append("        CREF_CLASSE_SISTEMA,");
        sb.append("        CREF_DATA_CADASTRO,");
        sb.append("        REFE_CODIGO,");
        sb.append("        REFE_DESCRICAO,");
        sb.append("        REFE_LATITUDE,");
        sb.append("        REFE_LONGITUDE,");
        sb.append("        REFE_CREF_CODIGO,");
        sb.append("        REFE_RAIO,");
        sb.append("        REFE_KM,");
        sb.append("        REFE_BANDEIRA,");
        sb.append("        REFE_UTILIZADO_SISTEMA,");
        sb.append("        REFE_DATA_CADASTRO");
        sb.append(" FROM");
        sb.append("        CREF_CLASSE_REFERENCIA");
        sb.append(" JOIN REFE_REFERENCIA ON (REFE_CREF_CODIGO = CREF_CODIGO)");
        sb.append(" WHERE");
        sb.append("        (CREF_PESS_ORAS_CODIGO IS NULL OR CREF_PESS_ORAS_CODIGO = '").append(codEmpresa.toString()).append("')");
        sb.append(" ORDER BY CREF_CODIGO");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "procuraRefenciasZoom")
    public String procuraRefenciasZoom(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "refeDesc") String refeDesc, @WebParam(name = "grupoDesc") String grupoDesc) throws Exception {
        if (refeDesc.equalsIgnoreCase("")) {
            refeDesc = " = UPPER(REFE_DESCRICAO)";
        } else {
            refeDesc = " LIKE '%" + refeDesc.toUpperCase() + "%'";
        }
        if (grupoDesc.equalsIgnoreCase("")) {
            grupoDesc = " = UPPER(CREF_DESCRICAO)";
        } else {
            grupoDesc = " LIKE '%" + grupoDesc.toUpperCase() + "%'";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT CREF_CODIGO,");
        sb.append("        CREF_DESCRICAO,");
        sb.append("        CREF_PESS_ORAS_CODIGO,");
        sb.append("        CREF_CLASSE_SISTEMA,");
        sb.append("        CREF_DATA_CADASTRO,");
        sb.append("        REFE_CODIGO,");
        sb.append("        REFE_DESCRICAO,");
        sb.append("        REFE_LATITUDE,");
        sb.append("        REFE_LONGITUDE,");
        sb.append("        REFE_CREF_CODIGO,");
        sb.append("        REFE_RAIO,");
        sb.append("        REFE_KM,");
        sb.append("        REFE_BANDEIRA,");
        sb.append("        REFE_UTILIZADO_SISTEMA,");
        sb.append("        REFE_DATA_CADASTRO");
        sb.append(" FROM");
        sb.append("        CREF_CLASSE_REFERENCIA");
        sb.append(" JOIN REFE_REFERENCIA ON (REFE_CREF_CODIGO = CREF_CODIGO)");
        sb.append(" WHERE ");
        sb.append("        (CREF_PESS_ORAS_CODIGO IS NULL OR CREF_PESS_ORAS_CODIGO = '").append(codEmpresa.toString()).append("')");
        sb.append(" AND ");
        sb.append("         UPPER(REFE_DESCRICAO) ").append(refeDesc);
        sb.append(" AND ");
        sb.append("         UPPER(CREF_DESCRICAO) ").append(grupoDesc);
        sb.append(" ORDER BY REFE_DESCRICAO");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosVeiculo")
    public String solicitaDadosVeiculo(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "placaVeiculo") String placaVeiculo) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("         TO_CHAR(ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,'DD/MM/YYYY HH24:MI:SS') AS ORAS_Data_Cadastro,");
        sb.append("         VEIC_Veiculo.*,");
        sb.append("         TVEI_Tipo_Veiculo.*,");
        sb.append("         vcar_veiculo_carreta.VCAR_VEIC_ORAS_Codigo,");
        sb.append("         vcav_veiculo_cavalo.VCAV_VEIC_ORAS_Codigo,");
        sb.append("         vmot_veiculo_moto.VMOT_VEIC_ORAS_Codigo,");
        sb.append("         vtru_veiculo_truck.VTRU_VEIC_ORAS_Codigo,");
        sb.append("         vuca_veiculo_utilitario_carga.VUCA_VEIC_ORAS_Codigo,");
        sb.append("         vupa_veiculo_utilitario_passe.VUPA_VEIC_ORAS_Codigo         ");
        sb.append("    FROM VEIC_Veiculo");
        sb.append("    JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = VEIC_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("    JOIN TVEI_Tipo_Veiculo ON (VEIC_TVEI_Codigo = TVEI_Codigo)");
        sb.append("    JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcar_veiculo_carreta ON (VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcav_veiculo_cavalo ON (VEIC_ORAS_Codigo = VCAV_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vmot_veiculo_moto ON (VEIC_ORAS_Codigo = VMOT_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vtru_veiculo_truck ON (VEIC_ORAS_Codigo = VTRU_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vuca_veiculo_utilitario_carga ON (VEIC_ORAS_Codigo = VUCA_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vupa_veiculo_utilitario_passe ON (VEIC_ORAS_Codigo = VUPA_VEIC_ORAS_Codigo)");
        sb.append(" WHERE");
        sb.append("       TRIM(REPLACE(REPLACE(REPLACE(REPLACE(VEIC_Veiculo.VEIC_Placa,'.',''),'/',''),'\\\\',''),'-','')) =");
        sb.append("       TRIM(REPLACE(REPLACE(REPLACE(REPLACE('").append(placaVeiculo).append("' ,'.',''),'/',''),'\\\\',''),'-',''))");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosTransportador")
    public String solicitaDadosTransportador(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codTransportador") String codTransportador) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT TRAN_Transportador.TRAN_PESS_ORAS_Codigo,");
        //sb.append("         TEST_Tipo_Estabelecimento.*,");
        sb.append("         PESS_Pessoa.PESS_Nome,");
        sb.append("         PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("         PFIS_Pessoa_Fisica.PFIS_CPF,");
        sb.append("         TO_CHAR(PFIS_Pessoa_Fisica.PFIS_Data_Nascimento,'DD/MM/YYYY HH24:MI:SS') AS PFIS_DATA_NASCIMENTO,");
        sb.append("         PFIS_Pessoa_Fisica.PFIS_Sexo,");
        sb.append("         PJUR_Pessoa_juridica.PJUR_CNPJ,");
        sb.append("         PJUR_Pessoa_juridica.PJUR_Razao_Social,");
        sb.append("         PJUR_Pessoa_juridica.PJUR_Inscricao_Estadual,");
        sb.append("         PJUR_Pessoa_juridica.PJUR_Site");
        sb.append("    FROM TRAN_Transportador");
        sb.append("    JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = TRAN_PESS_ORAS_Codigo)");
        sb.append("    JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("    JOIN TEST_Tipo_Estabelecimento ON (TEST_Codigo = TRAN_TEST_codigo)");
        sb.append(" LEFT JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PJUR_Pessoa_juridica ON (PJUR_PESS_ORAS_Codigo = PESS_ORAS_Codigo)");
        sb.append(" WHERE TRAN_Transportador.TRAN_PESS_ORAS_Codigo = '").append(codTransportador).append("'");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosRota")
    public String solicitaDadosRota(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codRota") Integer codRota) throws Exception {
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
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaVeiculos")
    public String solicitaListaVeiculos(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "offset") Integer offset, @WebParam(name = "limit") Integer limit) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_OBJETO_RASTREADO.ORAS_CODIGO AS VEIC_ORAS_CODIGO,");
        sb.append("       VEIC_VEICULO.VEIC_PLACA,");
        sb.append("       VEIC_VEICULO.VEIC_MOTO_PFIS_PESS_ORAS_CODIGO,");
        sb.append("       TVEI_TIPO_VEICULO.TVEI_DESCRICAO");
        sb.append("    FROM VEIC_Veiculo");
        sb.append("    JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = VEIC_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("    JOIN TVEI_Tipo_Veiculo ON (VEIC_TVEI_Codigo = TVEI_Codigo)");
        sb.append("    JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo");
        sb.append("     AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append(" LEFT JOIN vcar_veiculo_carreta ON (VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcav_veiculo_cavalo ON (VEIC_ORAS_Codigo = VCAV_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vmot_veiculo_moto ON (VEIC_ORAS_Codigo = VMOT_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vtru_veiculo_truck ON (VEIC_ORAS_Codigo = VTRU_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vuca_veiculo_utilitario_carga ON (VEIC_ORAS_Codigo = VUCA_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vupa_veiculo_utilitario_passe ON (VEIC_ORAS_Codigo = VUPA_VEIC_ORAS_Codigo)");
        sb.append(" ORDER BY VEIC_Veiculo.VEIC_Placa");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
//        System.out.println(sb.toString());

        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaRotas")
    public String solicitaListaRotas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codEmbarcador") String codEmbarcador, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        if (codEmbarcador.equalsIgnoreCase("")) {
            codEmbarcador = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ");
        sb.append("          ROTA_CODIGO,");
        sb.append("          ROTA_DESCRICAO,");
        sb.append("          ROTA_DISTANCIA,");
        sb.append("          ROTA_COORDENADA,");
        sb.append("          ROTA_DATA_CADASTRO,");
        sb.append("          ROTA_COORDENADASPIPE,");
        sb.append("          ROTA_PESS_ORAS_CODIGO_DONO,");
        sb.append("          ORI.REFE_Codigo AS REFE_Codigo_origem,");
        sb.append("          ORI.REFE_Descricao AS REFE_Descricao_origem,");
        sb.append("          ORI.REFE_Latitude AS REFE_Latitude_origem,");
        sb.append("          ORI.REFE_Longitude AS REFE_Longitude_origem,");
        //sb.append("          ORI.CREF_Classe_Referencia.CREF_Codigo AS CREF_Codigo_origem,");
        //sb.append("          ORI.CREF_Classe_Referencia.CREF_Descricao AS CREF_Descricao_origem,");
        sb.append("          DES.REFE_Codigo AS REFE_Codigo_destino,");
        sb.append("          DES.REFE_Descricao AS REFE_Descricao_destino,");
        sb.append("          DES.REFE_Latitude AS REFE_Latitude_destino,");
        sb.append("          DES.REFE_Longitude AS REFE_Longitude_destino");
        //sb.append("          DES.CREF_Classe_Referencia.CREF_Codigo AS CREF_Codigo_destino,");
        //sb.append("          DES.CREF_Classe_Referencia.CREF_Descricao AS CREF_Descricao_destino");
        sb.append("     FROM ROTA_ROTA");
        sb.append("     JOIN RPON_Rota_Ponto AS RPONORI ON (RPONORI.RPON_ROTA_Codigo = ROTA_Codigo AND RPONORI.RPON_TPAR_Codigo = 4 /* ORIGEM */)");
        sb.append("     JOIN REFE_Referencia AS ORI ON (ORI.REFE_Codigo = RPONORI.RPON_REFE_Codigo)   ");
        sb.append("     JOIN RPON_Rota_Ponto AS RPONDEST ON (RPONDEST.RPON_ROTA_Codigo = ROTA_Codigo AND RPONDEST.RPON_TPAR_Codigo = 5 /* DESTINO */)");
        sb.append("     JOIN REFE_Referencia AS DES ON (DES.REFE_Codigo = RPONDEST.RPON_REFE_Codigo)   ");
        sb.append("    WHERE ROTA_PESS_ORAS_CODIGO_DONO IN (").append(codEmpresa.toString()).append(",").append(codEmbarcador).append(")");
        sb.append(" ORDER BY ROTA_DESCRICAO ");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGrid")
    public String solicitaDadosGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT");
        sb.append("             VEIC_ORAS_Codigo,");
        sb.append("             VEIC_Placa as placa,");
        sb.append("             URPE_Valor as ignicao,");
        sb.append("             UPOS_Descricao_Sistema AS posicao,");
        sb.append("             UPOS_Longitude,");
        sb.append("             UPOS_Latitude,");
        sb.append("             VTEC_Descricao as versaoTecnologia,");
        sb.append("             TERM_Numero_Terminal as numeroTerminal,");
        sb.append("             EMBA1.PESS_Nome AS embarcador,");
        sb.append("             TERM_Ativo,");
        sb.append("             CASE");
        sb.append("                WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("                WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("                WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("                WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("                ELSE 'CAVALO'");
        sb.append("             END AS tipoVeiculo,");
        sb.append("             CASE");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("                ELSE 'SEM VIAGEM'");
        sb.append("             END AS statusViagem,");
        sb.append("             0 as statusAtraso,");
        sb.append("             MOTO1.PESS_Nome AS NomeMotorista,");
        sb.append("             TO_CHAR(UPOS_Data_Comp_Bordo,'DD/MM/YYYY HH24:MI:SS') AS UPOS_Data_Comp_Bordo,");
        sb.append("             MO1.PFIS_CPF AS CpfMotorista");
        sb.append("        FROM UPOS_Ultima_Posicao    ");
        sb.append("        JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("        JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                     ");
        sb.append("        JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)    ");
        sb.append("        JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")"); /*parametros*/
        sb.append("    LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append("    LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN VVEI_Viagem_Veiculo ON (VVEI_VEIC_ORAS_Codigo = ORAS_Codigo AND VVEI_Precedencia = '1' AND VVEI_Ativo = 'S')");
        sb.append("    LEFT JOIN VIAG_Viagem ON (VIAG_Codigo = VVEI_VIAG_Codigo)");
        sb.append("    LEFT JOIN EMBA_Embarcador ON (EMBA_PJUR_PESS_ORAS_Codigo = VIAG_EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PESS_Pessoa AS EMBA1 ON (EMBA1.PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append("    ORDER BY VEIC_ORAS_Codigo");
        sb.append("    LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGridZoom")
    public String solicitaDadosGridZoom(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT");
        sb.append("             VEIC_ORAS_Codigo,");
        sb.append("             VEIC_Placa as placa,");
        sb.append("             URPE_Valor as ignicao,");
        sb.append("             UPOS_Descricao_Sistema AS posicao,");
        sb.append("             UPOS_Longitude,");
        sb.append("             UPOS_Latitude,");
        sb.append("             VTEC_Descricao as versaoTecnologia,");
        sb.append("             TERM_Numero_Terminal as numeroTerminal,");
        sb.append("             '' as embarcador,");
        sb.append("             TERM_Ativo,");
        sb.append("             CASE");
        sb.append("                WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("                WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("                WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("                WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("                ELSE 'CAVALO'");
        sb.append("             END AS tipoVeiculo,");
        sb.append("             CASE");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("                ELSE 'SEM VIAGEM'");
        sb.append("             END AS statusViagem,");
        sb.append("             0 as statusAtraso,");
        sb.append("             MOTO1.PESS_Nome AS NomeMotorista,");
        sb.append("             TO_CHAR(UPOS_Data_Comp_Bordo,'DD/MM/YYYY HH24:MI:SS') AS UPOS_Data_Comp_Bordo,");
        sb.append("             MO1.PFIS_CPF AS CpfMotorista");
        sb.append("        FROM UPOS_Ultima_Posicao    ");
        sb.append("        JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("        JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                     ");
        sb.append("        JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)    ");
        sb.append("        JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")"); /*parametros*/
        sb.append("    LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append("    LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN VVEI_Viagem_Veiculo ON (VVEI_VEIC_ORAS_Codigo = ORAS_Codigo AND VVEI_Precedencia = '1' AND VVEI_Ativo = 'S')");
        sb.append("    LEFT JOIN VIAG_Viagem ON (VIAG_Codigo = VVEI_VIAG_Codigo)");
        sb.append("    ORDER BY VEIC_ORAS_Codigo");
        sb.append("    LIMIT ").append(limit).append(" OFFSET ").append(offset);
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SolicitaHistoricoPosicoes")
    public String SolicitaHistoricoPosicoes(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa,
            @WebParam(name = "placaVeiculo") String placaVeiculo,
            @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit,
            @WebParam(name = "somenteTerminalPrincipal") boolean somenteTerminalPrincipal) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT VEIC_ORAS_Codigo,");
        sb.append("        VEIC_Placa,");
        sb.append("        VEIC_Ano_Fabricacao,");
        sb.append("        VEIC_Ano_Modelo,");
        sb.append("        VEIC_Renavam,");
        sb.append("        VEIC_Chassi,");
        sb.append("        VEIC_Cor,");
        sb.append("        VEIC_Frota,");
        sb.append("        RPOS_RECE_Codigo,");
        sb.append("        RECE_VTEC_Codigo,");
        sb.append("        RECE_TERM_Numero_Terminal,");
        sb.append("        RPOS_Descricao_Integrada,");
        sb.append("        RPOS_Descricao_Sistema,");
        sb.append("        RPOS_Latitude,");
        sb.append("        RPOS_Longitude,");
        sb.append("        TO_CHAR(RPOS_Data_Cadastro,'DD/MM/YYYY HH24:MI:SS') AS RPOS_Data_Cadastro,");
        sb.append("        TO_CHAR(RPOS_Data_Computador_Bordo,'DD/MM/YYYY HH24:MI:SS') AS RPOS_Data_Computador_Bordo");
        sb.append("   FROM RPOS_Recebimento_Posicao");
        sb.append("   JOIN RECE_Recebimento ON (RECE_Codigo = RPOS_RECE_Codigo)");
        sb.append("   JOIN TERM_Terminal ON (TERM_Numero_Terminal = RECE_TERM_Numero_Terminal AND TERM_VTEC_Codigo = RECE_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("   JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("   JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)");
        sb.append("   JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo AND VEIC_Placa = '").append(placaVeiculo).append("')");
        sb.append("   JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("   JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(" /*CodEmpresa*/)");
        sb.append(" ORDER BY VEIC_Placa,");
        sb.append("         RPOS_Data_Computador_Bordo");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGridEmViagem")
    public String solicitaDadosGridEmViagem(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT");
        sb.append("           VEIC_ORAS_Codigo,");
        sb.append("           VEIC_Placa as placa,");
        sb.append("           URPE_Valor as ignicao,");
        sb.append("           UPOS_Descricao_Sistema AS posicao,");
        sb.append("           UPOS_Longitude,");
        sb.append("           UPOS_Latitude,");
        sb.append("           VTEC_Descricao as versaoTecnologia,");
        sb.append("           TERM_Numero_Terminal as numeroTerminal,");
        sb.append("           EMBA1.PESS_Nome as embarcador,");
        sb.append("           TERM_Ativo,");
        sb.append("           CASE");
        sb.append("              WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("              WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("              WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("              WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("              ELSE 'CAVALO'");
        sb.append("           END AS tipoVeiculo,");
        sb.append("           CASE");
        sb.append("                 WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("                 WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("                 ELSE 'SEM VIAGEM'");
        sb.append("           END AS statusViagem,");
        sb.append("           0 as statusAtraso,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Data_Inicio,'DD/MM/YYYY HH24:MI:SS') as VIAG_Data_Inicio,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Data_Fim,'DD/MM/YYYY HH24:MI:SS') as VIAG_Data_Fim,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Previsao_Inicio,'DD/MM/YYYY HH24:MI:SS') as VIAG_Previsao_Inicio,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Previsao_Fim,'DD/MM/YYYY HH24:MI:SS') as VIAG_Previsao_Fim,");
        sb.append("           ORIG.REFE_Descricao AS Origem,");
        sb.append("           DEST.REFE_Descricao AS Destino,");
        sb.append("           MOTO1.PESS_Nome AS NomeMotorista,");
        sb.append("           TO_CHAR(UPOS_Data_Comp_Bordo,'DD/MM/YYYY HH24:MI:SS') AS UPOS_Data_Comp_Bordo,");
        sb.append("           MO1.PFIS_CPF AS CpfMotorista,");
        sb.append("           '' AS ProximoDestino");
        sb.append("      FROM UPOS_Ultima_Posicao    ");
        sb.append("      JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("      JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                     ");
        sb.append("      JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("      JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)");
        sb.append("      JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("      JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append("      JOIN VTER_Viagem_Terminal ON (VTER_TERM_Codigo = TERM_Codigo AND VTER_Ativo = 'S' AND VTER_Precedencia = '1')");
        sb.append("      JOIN VIAG_Viagem ON (VIAG_Codigo = VTER_VIAG_Codigo AND VIAG_Data_Inicio IS NOT NULL AND VIAG_Data_Fim IS NULL)");
        sb.append("      JOIN VLOC_Viagem_Local AS O1 ON (O1.VLOC_VIAG_Codigo = VIAG_Codigo AND O1.VLOC_TPAR_Codigo = 4)");
        sb.append("      JOIN REFE_Referencia AS ORIG ON (ORIG.REFE_Codigo = O1.VLOC_REFE_Codigo)");
        sb.append("      JOIN VLOC_Viagem_Local AS O2 ON (O2.VLOC_VIAG_Codigo = VIAG_Codigo AND O2.VLOC_TPAR_Codigo = 5)");
        sb.append("      JOIN REFE_Referencia AS DEST ON (DEST.REFE_Codigo = O2.VLOC_REFE_Codigo)    ");
        sb.append(" LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append(" LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN EMBA_Embarcador ON (EMBA_PJUR_PESS_ORAS_Codigo = VIAG_EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PESS_Pessoa AS EMBA1 ON ( EMBA1.PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append(" ORDER BY VEIC_Placa");
        sb.append("  LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaMotoristas")
    public String solicitaListaMotoristas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append("      SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("           ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,");
        sb.append("           PESS_Pessoa.PESS_Nome,");
        sb.append("           PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("           PFIS_Pessoa_Fisica.PFIS_CPF,");
        sb.append("           PFIS_Pessoa_Fisica.PFIS_Sexo,");
        sb.append("           MOTO_Motorista.MOTO_EPMO_Codigo,");
        sb.append("           MOTO_Motorista.MOTO_Numero_CNH,");
        sb.append("           MOTO_Motorista.MOTO_Categoria_CNH,");
        sb.append("           MOTO_Motorista.MOTO_Validade_CNH,");
        sb.append("           MOTO_Motorista.MOTO_Senha,");
        sb.append("           MOTO_Motorista.MOTO_Treinado,");
        sb.append("           MOTO_Motorista.MOTO_Ultimo_Treinamento,");
        sb.append("           MOTO_Motorista.MOTO_Validade_Pesquisa");
        sb.append("       FROM MOTO_Motorista");
        sb.append("        JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("        JOIN PESS_Pessoa ON (PESS_ORAS_codigo = PFIS_PESS_ORAS_Codigo)");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("        JOIN MTRA_Motorista_Transportador ON (MTRA_MOTO_PFIS_PESS_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = MTRA_TRAN_PESS_ORAS_Codigo");
        sb.append("         AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append("    ORDER BY PESS_Pessoa.PESS_Nome");
        sb.append("    LIMIT ").append(limit).append(" OFFSET ").append(offset);
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaEmbarcadores")
    public String solicitaListaEmbarcadores(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("          ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,");
        sb.append("          PESS_Pessoa.PESS_Nome,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_CNPJ,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Inscricao_Estadual,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Site,");
        sb.append("          TEST_Tipo_Estabelecimento.TEST_Codigo,");
        sb.append("          TEST_Tipo_Estabelecimento.TEST_Descricao");
        sb.append("     FROM EMBA_Embarcador    ");
        sb.append("     JOIN PJUR_Pessoa_Juridica ON (PJUR_PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append("     JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = PJUR_PESS_ORAS_Codigo)");
        sb.append("     JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("     JOIN TEST_Tipo_Estabelecimento ON (TEST_Codigo = EMBA_TEST_Codigo)");
        sb.append(" ORDER BY ORAS_Codigo");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaLocais")
    public String solicitaListaLocais(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT REFE_Referencia.REFE_Codigo,");
        sb.append("        REFE_Referencia.REFE_Descricao,");
        sb.append("        REFE_Referencia.REFE_Latitude,");
        sb.append("        REFE_Referencia.REFE_Longitude,");
        sb.append("        CREF_Classe_Referencia.CREF_Codigo,");
        sb.append("        CREF_Classe_Referencia.CREF_Descricao");
        sb.append("          FROM REFE_Referencia");
        sb.append("      JOIN CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)");
        sb.append("     WHERE CREF_PESS_ORAS_Codigo IS NULL OR CREF_PESS_ORAS_Codigo = ").append(codEmpresa);
        sb.append("    ORDER BY REFE_Codigo");
        sb.append("  LIMIT ").append(limit).append(" OFFSET ").append(offset);
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaTransportadores")
    public String solicitaListaTransportadores(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("       TO_CHAR(ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,'DD/MM/YYYY HH24:MI:SS') as oras_data_cadastro,");
        sb.append("          PESS_Pessoa.PESS_Nome,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_CNPJ,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Inscricao_Estadual,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Site,");
        sb.append("          PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("          PFIS_Pessoa_Fisica.PFIS_CPF");
        sb.append("     FROM TRAN_Transportador");
        sb.append("     JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = TRAN_PESS_ORAS_Codigo)");
        sb.append("     JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append(" LEFT JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PJUR_Pessoa_Juridica ON (PJUR_PESS_ORAS_Codigo = PESS_ORAS_Codigo)");
        sb.append(" ORDER BY PESS_Nome");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosEmbarcador")
    public String solicitaDadosEmbarcador(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmbarcador") String codEmbarcador) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT EMBA_PJUR_PESS_ORAS_Codigo,");
        sb.append("      PESS_Pessoa.PESS_Nome,");
        sb.append("      PJUR_Pessoa_juridica.PJUR_CNPJ,");
        sb.append("      PJUR_Pessoa_juridica.PJUR_Razao_Social,");
        sb.append("      PJUR_Pessoa_juridica.PJUR_Inscricao_Estadual,");
        sb.append("      PJUR_Pessoa_juridica.PJUR_Site");
        sb.append(" FROM EMBA_Embarcador");
        sb.append(" JOIN PJUR_Pessoa_Juridica ON (PJUR_PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = PJUR_PESS_ORAS_Codigo)");
        sb.append(" JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append(" WHERE EMBA_Embarcador.EMBA_PJUR_PESS_ORAS_Codigo = ").append(codEmbarcador);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaTipoTransporte")
    public String solicitaListaTipoTransporte(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT TTRA_Codigo,");
        sb.append("         TTRA_Descricao");
        sb.append(" FROM TTRA_Tipo_Transporte");
        sb.append(" ORDER BY TTRA_Codigo");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosLocal")
    public String solicitaDadosLocal(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codLocal") String codLocal) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ");
        sb.append("	REFE_Referencia.REFE_Codigo, ");
        sb.append("	REFE_Referencia.REFE_Descricao, ");
        sb.append("	REFE_Referencia.REFE_Latitude,      ");
        sb.append("	REFE_Referencia.REFE_Longitude, ");
        sb.append("	CREF_Classe_Referencia.CREF_Codigo, ");
        sb.append("	CREF_Classe_Referencia.CREF_Descricao,      ");
        sb.append("	REFE_Referencia.REFE_Raio, ");
        sb.append("	REFE_Referencia.REFE_KM, ");
        sb.append("	REFE_Referencia.REFE_Bandeira,      ");
        sb.append("	REFE_Referencia.REFE_Utilizado_Sistema      ");
        sb.append(" FROM ");
        sb.append("	REFE_Referencia");
        sb.append(" JOIN ");
        sb.append("	CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)      ");
        sb.append("  WHERE REFE_Referencia.REFE_Codigo = ").append(codLocal);

//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaCarretasDisponiveis")
    public String solicitaListaCarretasDisponiveis(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT VEIC_ORAS_Codigo,");
        sb.append("     VEIC_Veiculo.VEIC_COR,");
        sb.append("     VEIC_VEICULO.VEIC_MOTO_PFIS_PESS_ORAS_CODIGO,");
        sb.append("     TVEI_TIPO_VEICULO.TVEI_DESCRICAO,");
        sb.append("     VEIC_VEICULO.VEIC_PLACA");
        sb.append("     FROM VEIC_Veiculo");
        sb.append("     JOIN TVEI_Tipo_Veiculo ON (VEIC_TVEI_Codigo = TVEI_Codigo)");
        sb.append("     JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("     JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append("    JOIN vcar_veiculo_carreta ON (VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo)");
        sb.append(" ORDER BY VEIC_Veiculo.VEIC_Placa");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaPGR")
    public String solicitaListaPGR(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codEmbarcador") String codEmbarcador, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        if (codEmbarcador.equalsIgnoreCase("")) {
            codEmbarcador = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT PGPG_CODIGO,");
        sb.append(" PGPG_DESCRICAO,");
        sb.append(" PGPG_DATA_CADASTRO");
        sb.append(" FROM PGPG_Pg");
        sb.append("     JOIN TSPG_Transp_Segur_Plano_Geren ON (PGPG_Codigo = TSPG_PGPG_Codigo");
        sb.append("     AND TSPG_PESS_ORAS_Codigo = ").append(codEmpresa).append(" /* aqui passa o codigo da empresa - transportador*/)");
        sb.append(" WHERE PGPG_ESTATUS = 'A'");
        sb.append(" UNION");
        sb.append(" SELECT PGPG_CODIGO,");
        sb.append(" PGPG_DESCRICAO,");
        sb.append(" PGPG_DATA_CADASTRO");
        sb.append("   FROM PGPG_Pg");
        sb.append("   JOIN ESPG_Embarc_Segur_Plano_Geren ON (PGPG_Codigo = ESPG_PGPG_Codigo and ESPG_EMBA_PJUR_PESS_ORAS_Codigo = ").append(codEmbarcador).append(" /* aqui passa o codigo do embarcador, quando houver */)");
        sb.append(" WHERE PGPG_ESTATUS = 'A'");
        sb.append(" ORDER BY PGPG_DESCRICAO");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosPGR")
    public String solicitaDadosPGR(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codigo") String codigo) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ");
        sb.append("         PGPG_Codigo,");
        sb.append("         PGPG_Descricao,");
        sb.append("         PGPG_Data_Cadastro,");
        sb.append("         pite_codigo,");
        sb.append("         pite_descricao");
        sb.append(" FROM PGPG_pg");
        sb.append("         JOIN pgai_pg_associa_item ON (pgai_pgpg_codigo = pgpg_codigo)");
        sb.append("         JOIN PITE_pg_item ON (pite_codigo = pgai_pite_codigo)");
        sb.append(" WHERE PGPG_Estatus = 'A'");
        sb.append("         AND pgpg_codigo = ").append(codigo);
        sb.append(" ORDER BY pite_descricao");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaViagemPai")
    public String solicitaListaViagemPai(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ");
        sb.append("     VIAG_CODIGO,");
        sb.append("     VIAG_PREVISAO_INICIO,");
        sb.append("     VIAG_PREVISAO_FIM");
        sb.append(" FROM VIAG_VIAGEM");
        sb.append(" JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = VIAG_TRAN_PESS_ORAS_CODIGO AND VIAG_TRAN_PESS_ORAS_CODIGO = ").append(codEmpresa).append(") ");
        sb.append(" ORDER BY VIAG_CODIGO ");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaTerminais")
    public String solicitaListaTerminais(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "placa") String placa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT TERM_Terminal.term_codigo,");
        sb.append("   TERM_Terminal.term_numero_terminal,");
        sb.append("   TERM_Terminal.term_vtec_codigo,");
        sb.append("   TERM_Terminal.term_ativo,");
        sb.append("   TERM_Terminal.term_ativo_ws,");
        sb.append("   TERM_Terminal.term_tempo_satelital_padrao,");
        sb.append("   TERM_Terminal.term_tempo_gprs_padrao,");
        sb.append("   TERM_Terminal.term_usuario_adicionou,");
        sb.append("   TERM_Terminal.term_usuario_alterou,");
        sb.append("   TERM_Terminal.term_data_cadastro,");
        sb.append("   ORTE_Objeto_Rastreado_Termina.ORTE_Sequencia");
        sb.append(" FROM ORAS_Objeto_Rastreado");
        sb.append(" JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo AND TRIM(REPLACE(REPLACE(REPLACE(REPLACE(VEIC_Placa,'.',''),'/',''),'\\\\',''),'-','')) = TRIM(REPLACE(REPLACE(REPLACE(REPLACE('").append(placa).append("','.',''),'/',''),'\\\\',''),'-','')))");
        sb.append(" JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_ORAS_Codigo = VEIC_ORAS_CODIGO)");
        sb.append(" JOIN TERM_Terminal ON (TERM_Codigo = ORTE_TERM_Codigo)");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosTerminalDefeituoso")
    public String solicitaDadosTerminalDefeituoso(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codTerminal") String codTerminal) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" select ppad_periferico_padrao.ppad_codigo,");
        sb.append("     ppad_periferico_padrao.ppad_descricao,");
        sb.append("     PPER_Problema_Periferico.pper_data_inicio_problema,");
        sb.append("     PPER_Problema_Periferico.pper_descricao");
        sb.append(" from TERM_Terminal");
        sb.append(" join PPIN_Periferico_Padrao_Instal ON (PPIN_TERM_Codigo = TERM_Codigo)");
        sb.append(" join ppad_periferico_padrao on (ppad_codigo = ppin_ppad_codigo)");
        sb.append(" join PPER_Problema_Periferico ON (PPER_PPIN_Codigo = PPIN_Codigo");
        sb.append(" and PPER_Problema_Periferico.pper_data_inicio_problema is not null");
        sb.append(" and PPER_Problema_Periferico.pper_data_inicio_problema is null)");
        sb.append(" where TERM_Codigo IN (").append(codTerminal).append(")");
        sb.append(" order by ppad_periferico_padrao.ppad_descricao,");
        sb.append(" PPER_Problema_Periferico.pper_descricao");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalDadosGrid")
    public String solicitaTotalDadosGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(*) AS TOTAL FROM (");
        sb.append(" SELECT DISTINCT");
        sb.append("             VEIC_ORAS_Codigo,");
        sb.append("             VEIC_Placa as placa,");
        sb.append("             URPE_Valor as ignicao,");
        sb.append("             UPOS_Descricao_Sistema AS posicao,");
        sb.append("             UPOS_Longitude AS gpslatitude,");
        sb.append("             UPOS_Latitude AS gpslongitude,");
        sb.append("             VTEC_Descricao as versaoTecnologia,");
        sb.append("             TERM_Numero_Terminal as numeroTerminal,");
        sb.append("             '' as embarcador,");
        sb.append("             TERM_Ativo,");
        sb.append("             CASE");
        sb.append("                WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("                WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("                WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("                WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("                ELSE 'CAVALO'");
        sb.append("             END AS tipoVeiculo,");
        sb.append("             CASE");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("                ELSE 'SEM VIAGEM'");
        sb.append("             END AS statusViagem,");
        sb.append("             0 as statusAtraso,");
        sb.append("             MOTO1.PESS_Nome AS NomeMotorista,");
        sb.append("             MO1.PFIS_CPF AS CpfMotorista");
        sb.append("        FROM UPOS_Ultima_Posicao    ");
        sb.append("        JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("        JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                     ");
        sb.append("        JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)    ");
        sb.append("        JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")"); /*parametros*/
        sb.append("    LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append("    LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN VVEI_Viagem_Veiculo ON (VVEI_VEIC_ORAS_Codigo = ORAS_Codigo AND VVEI_Precedencia = '1' AND VVEI_Ativo = 'S')");
        sb.append("    LEFT JOIN VIAG_Viagem ON (VIAG_Codigo = VVEI_VIAG_Codigo)");
        sb.append(" ) AS XXX");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaLocais")
    public String solicitaTotalListaLocais(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT REFE_Referencia.REFE_Codigo,");
        sb.append("        REFE_Referencia.REFE_Descricao,");
        sb.append("        REFE_Referencia.REFE_Latitude,");
        sb.append("        REFE_Referencia.REFE_Longitude,");
        sb.append("        CREF_Classe_Referencia.CREF_Codigo,");
        sb.append("        CREF_Classe_Referencia.CREF_Descricao");
        sb.append("          FROM REFE_Referencia");
        sb.append("      JOIN CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)");
        sb.append("     WHERE CREF_PESS_ORAS_Codigo IS NULL OR CREF_PESS_ORAS_Codigo = ").append(codEmpresa);
        sb.append(" ) AS XXX");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaEmbarcadores")
    public String solicitaTotalListaEmbarcadores(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("          ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,");
        sb.append("          PESS_Pessoa.PESS_Nome,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_CNPJ,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Inscricao_Estadual,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Site,");
        sb.append("          TEST_Tipo_Estabelecimento.TEST_Codigo,");
        sb.append("          TEST_Tipo_Estabelecimento.TEST_Descricao");
        sb.append("     FROM EMBA_Embarcador    ");
        sb.append("     JOIN PJUR_Pessoa_Juridica ON (PJUR_PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append("     JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = PJUR_PESS_ORAS_Codigo)");
        sb.append("     JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("     JOIN TEST_Tipo_Estabelecimento ON (TEST_Codigo = EMBA_TEST_Codigo)");
        sb.append(" ) AS XXX");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaMotoristas")
    public String solicitaTotalListaMotoristas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append("      SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append("      SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("           ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,");
        sb.append("           PESS_Pessoa.PESS_Nome,");
        sb.append("           PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("           PFIS_Pessoa_Fisica.PFIS_CPF,");
        sb.append("           PFIS_Pessoa_Fisica.PFIS_Sexo,");
        sb.append("           MOTO_Motorista.MOTO_EPMO_Codigo,");
        sb.append("           MOTO_Motorista.MOTO_Numero_CNH,");
        sb.append("           MOTO_Motorista.MOTO_Categoria_CNH,");
        sb.append("           MOTO_Motorista.MOTO_Validade_CNH,");
        sb.append("           MOTO_Motorista.MOTO_Senha,");
        sb.append("           MOTO_Motorista.MOTO_Treinado,");
        sb.append("           MOTO_Motorista.MOTO_Ultimo_Treinamento,");
        sb.append("           MOTO_Motorista.MOTO_Validade_Pesquisa");
        sb.append("       FROM MOTO_Motorista");
        sb.append("        JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("        JOIN PESS_Pessoa ON (PESS_ORAS_codigo = PFIS_PESS_ORAS_Codigo)");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("        JOIN MTRA_Motorista_Transportador ON (MTRA_MOTO_PFIS_PESS_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = MTRA_TRAN_PESS_ORAS_Codigo");
        sb.append("         AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append(" ) AS XXX");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaPGR")
    public String solicitaTotalListaPGR(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codEmbarcador") String codEmbarcador) throws Exception {
        //TODO write your implementation code here:
        if (codEmbarcador.equalsIgnoreCase("")) {
            codEmbarcador = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT PGPG_CODIGO,");
        sb.append(" PGPG_DESCRICAO,");
        sb.append(" PGPG_DATA_CADASTRO");
        sb.append(" FROM PGPG_Pg");
        sb.append("     JOIN TSPG_Transp_Segur_Plano_Geren ON (PGPG_Codigo = TSPG_PGPG_Codigo");
        sb.append("     AND TSPG_PESS_ORAS_Codigo = ").append(codEmpresa).append(" /* aqui passa o codigo da empresa - transportador*/)");
        sb.append(" WHERE PGPG_ESTATUS = 'A'");
        sb.append(" UNION");
        sb.append(" SELECT PGPG_CODIGO,");
        sb.append(" PGPG_DESCRICAO,");
        sb.append(" PGPG_DATA_CADASTRO");
        sb.append("   FROM PGPG_Pg");
        sb.append("   JOIN ESPG_Embarc_Segur_Plano_Geren ON (PGPG_Codigo = ESPG_PGPG_Codigo and ESPG_EMBA_PJUR_PESS_ORAS_Codigo = ").append(codEmbarcador).append(" /* aqui passa o codigo do embarcador, quando houver */)");
        sb.append(" WHERE PGPG_ESTATUS = 'A'");
        sb.append(" ) AS XXX ");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaRotas")
    public String solicitaTotalListaRotas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codEmbarcador") String codEmbarcador) throws Exception {
        //TODO write your implementation code here:
        if (codEmbarcador.equalsIgnoreCase("")) {
            codEmbarcador = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT");
        sb.append("    ROTA_CODIGO,");
        sb.append("    ROTA_DESCRICAO,");
        sb.append("    ROTA_DISTANCIA,");
        sb.append("    ROTA_COORDENADA,");
        sb.append("    ROTA_DATA_CADASTRO,");
        sb.append("    ROTA_COORDENADASPIPE");
        sb.append(" FROM ROTA_ROTA");
        sb.append(" WHERE ROTA_PESS_ORAS_CODIGO_DONO IN (").append(codEmpresa.toString()).append(",").append(codEmbarcador).append(")");
        sb.append(" ) AS XXX");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaTipoTransporte")
    public String solicitaTotalListaTipoTransporte(@WebParam(name = "idSessao") String idSessao) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT TTRA_Codigo,");
        sb.append("         TTRA_Descricao");
        sb.append(" FROM TTRA_Tipo_Transporte");
        sb.append(" ) AS XXX");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaTransportadores")
    public String solicitaTotalListaTransportadores(@WebParam(name = "idSessao") String idSessao) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("       TO_CHAR(ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,'DD/MM/YYYY HH24:MI:SS') as oras_data_cadastro,");
        sb.append("          PESS_Pessoa.PESS_Nome,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_CNPJ,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Inscricao_Estadual,");
        sb.append("          PJUR_Pessoa_Juridica.PJUR_Site,");
        sb.append("          PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("          PFIS_Pessoa_Fisica.PFIS_CPF");
        sb.append("     FROM TRAN_Transportador");
        sb.append("     JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = TRAN_PESS_ORAS_Codigo)");
        sb.append("     JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append(" LEFT JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PJUR_Pessoa_Juridica ON (PJUR_PESS_ORAS_Codigo = PESS_ORAS_Codigo)");
        sb.append(" ) AS XXX ");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaVeiculos")
    public String solicitaTotalListaVeiculos(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT ORAS_OBJETO_RASTREADO.ORAS_CODIGO,");
        sb.append("       VEIC_VEICULO.VEIC_PLACA,");
        sb.append("       TVEI_TIPO_VEICULO.TVEI_DESCRICAO");
        sb.append("    FROM VEIC_Veiculo");
        sb.append("    JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = VEIC_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("    JOIN TVEI_Tipo_Veiculo ON (VEIC_TVEI_Codigo = TVEI_Codigo)");
        sb.append("    JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo");
        sb.append("     AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append(" LEFT JOIN vcar_veiculo_carreta ON (VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcav_veiculo_cavalo ON (VEIC_ORAS_Codigo = VCAV_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vmot_veiculo_moto ON (VEIC_ORAS_Codigo = VMOT_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vtru_veiculo_truck ON (VEIC_ORAS_Codigo = VTRU_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vuca_veiculo_utilitario_carga ON (VEIC_ORAS_Codigo = VUCA_VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vupa_veiculo_utilitario_passe ON (VEIC_ORAS_Codigo = VUPA_VEIC_ORAS_Codigo)");
        sb.append(" ) AS XXX ");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaViagemPai")
    public String solicitaTotalListaViagemPai(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT ");
        sb.append("     VIAG_CODIGO,");
        sb.append("     VIAG_PREVISAO_INICIO,");
        sb.append("     VIAG_PREVISAO_FIM");
        sb.append(" FROM VIAG_VIAGEM");
        sb.append(" JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = VIAG_TRAN_PESS_ORAS_CODIGO AND VIAG_TRAN_PESS_ORAS_CODIGO = ").append(codEmpresa).append(") ");
        sb.append(" ) AS XXX ");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalHistoricoPosicoes")
    public String solicitaTotalHistoricoPosicoes(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "placa") String placa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT VEIC_ORAS_Codigo,");
        sb.append("        VEIC_Placa,");
        sb.append("        VEIC_Ano_Fabricacao,");
        sb.append("        VEIC_Ano_Modelo,");
        sb.append("        VEIC_Renavam,");
        sb.append("        VEIC_Chassi,");
        sb.append("        VEIC_Cor,");
        sb.append("        VEIC_Frota,");
        sb.append("        RPOS_RECE_Codigo,");
        sb.append("        RECE_VTEC_Codigo,");
        sb.append("        RECE_TERM_Numero_Terminal,");
        sb.append("        RPOS_Descricao_Integrada,");
        sb.append("        RPOS_Descricao_Sistema,");
        sb.append("        RPOS_Latitude,");
        sb.append("        RPOS_Longitude,");
        sb.append("        TO_CHAR(RPOS_Data_Cadastro,'DD/MM/YYYY HH24:MI:SS') AS RPOS_Data_Cadastro,");
        sb.append("        TO_CHAR(RPOS_Data_Computador_Bordo,'DD/MM/YYYY HH24:MI:SS') AS RPOS_Data_Computador_Bordo");
        sb.append("   FROM RPOS_Recebimento_Posicao");
        sb.append("   JOIN RECE_Recebimento ON (RECE_Codigo = RPOS_RECE_Codigo)");
        sb.append("   JOIN TERM_Terminal ON (TERM_Numero_Terminal = RECE_TERM_Numero_Terminal AND TERM_VTEC_Codigo = RECE_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("   JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("   JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)");
        sb.append("   JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo AND VEIC_Placa = '").append(placa).append("')");
        sb.append("   JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("   JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(" /*CodEmpresa*/)");
        sb.append(" ) AS XXX ");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalDadosGridEmViagem")
    public String solicitaTotalDadosGridEmViagem(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT VEIC_Placa as placa,");
        sb.append("           URPE_Valor as ignicao,");
        sb.append("           UPOS_Descricao_Sistema AS posicao,");
        sb.append("           VTEC_Descricao as versaoTecnologia,");
        sb.append("           TERM_Numero_Terminal as numeroTerminal,");
        sb.append("           PESS_Nome as embarcador,");
        sb.append("           CASE");
        sb.append("              WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("              WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("              WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("              WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("              ELSE 'CAVALO'");
        sb.append("           END AS tipoVeiculo,");
        sb.append("           CASE");
        sb.append("              WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("              WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("              ELSE 'SEM VIAGEM'            ");
        sb.append("           END AS statusViagem,");
        sb.append("           0 as statusAtraso,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Data_Inicio,'DD/MM/YYYY HH24:MI:SS') AS VIAG_Data_Inicio,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Data_Fim,'DD/MM/YYYY HH24:MI:SS') AS VIAG_Data_Fim,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Previsao_Inicio,'DD/MM/YYYY HH24:MI:SS') AS VIAG_Previsao_Inicio,");
        sb.append("           TO_CHAR(VIAG_Viagem.VIAG_Previsao_Fim,'DD/MM/YYYY HH24:MI:SS') AS VIAG_Previsao_Fim,");
        sb.append("           ORIG.REFE_Descricao AS Origem,");
        sb.append("           DEST.REFE_Descricao AS Destino,");
        sb.append("           '' AS ProximoDestino");
        sb.append("      FROM UPOS_Ultima_Posicao   ");
        sb.append("      JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("      JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                    ");
        sb.append("      JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("      JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)");
        sb.append("      JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("      JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append("      JOIN VTER_Viagem_Terminal ON (VTER_TERM_Codigo = TERM_Codigo AND VTER_Ativo = 'S' AND VTER_Precedencia = '1')");
        sb.append("      JOIN VIAG_Viagem ON (VIAG_Codigo = VTER_VIAG_Codigo AND ((VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL))");
        sb.append("                                                           OR ((VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL)))");
        sb.append("      JOIN VLOC_Viagem_Local AS O1 ON (O1.VLOC_VIAG_Codigo = VIAG_Codigo AND O1.VLOC_TPAR_Codigo = 4)");
        sb.append("      JOIN REFE_Referencia AS ORIG ON (ORIG.REFE_Codigo = O1.VLOC_REFE_Codigo)");
        sb.append("      JOIN VLOC_Viagem_Local AS O2 ON (O2.VLOC_VIAG_Codigo = VIAG_Codigo AND O2.VLOC_TPAR_Codigo = 5)");
        sb.append("      JOIN REFE_Referencia AS DEST ON (DEST.REFE_Codigo = O2.VLOC_REFE_Codigo)   ");
        sb.append(" LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append(" LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN EMBA_Embarcador ON (EMBA_PJUR_PESS_ORAS_Codigo = VIAG_EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" ) AS XXX");
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    private void excluirPosicoesTela(String usuario, Connection con) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE FROM sreg_sistema_registro");
        sb.append(" WHERE sreg_sessao = '").append("TRAFEGUS_WEB_POSICAO").append("'");
        sb.append(" AND sreg_usuario_adicionou = '").append(usuario).append("'");

        String sql = sb.toString();

        sb = null;
        con.createStatement().execute(sql);
    }

    private void gravaPosicaoTela(String chave, String valor, String usuario, Connection con) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO sreg_sistema_registro");
        sb.append("    (sreg_sessao, sreg_chave, sreg_valor, sreg_usuario_adicionou)");
        sb.append(" VALUES ('").append("TRAFEGUS_WEB_POSICAO").append("','").append(chave).append("','").append(valor).append("','").append(usuario).append("')");
        String sql = sb.toString();
        sb = null;
        con.createStatement().execute(sql);
    }

    private void gravarItensPorPagina(String chave, String valor, String usuario, Connection con) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO sreg_sistema_registro");
        sb.append("    (sreg_sessao, sreg_chave, sreg_valor, sreg_usuario_adicionou)");
        sb.append(" VALUES ('").append("TRAFEGUS_WEB_ITENS_POR_PAGINA").append("','").append(chave).append("','").append(valor).append("','").append(usuario).append("')");
        String sql = sb.toString();
        sb = null;
        con.createStatement().execute(sql);
    }

    @WebMethod(operationName = "salvarPosicaoTelas")
    public String salvarPosicaoTelas(
            @WebParam(name = "idSessao") String idSessao,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "gridVeiculosX") String gridVeiculosX,
            @WebParam(name = "gridVeiculosY") String gridVeiculosY,
            @WebParam(name = "gridVeiculosPercentWidth") String gridVeiculosPercentWidth,
            @WebParam(name = "gridVeiculosPercentHeight") String gridVeiculosPercentHeight,
            @WebParam(name = "mapaGoogleX") String mapaGoogleX,
            @WebParam(name = "mapaGoogleY") String mapaGoogleY,
            @WebParam(name = "mapaGooglePercentWidth") String mapaGooglePercentWidth,
            @WebParam(name = "mapaGooglePercentHeight") String mapaGooglePercentHeight,
            @WebParam(name = "gridDetalheX") String gridDetalheX,
            @WebParam(name = "gridDetalheY") String gridDetalheY,
            @WebParam(name = "gridDetalhePercentWidth") String gridDetalhePercentWidth,
            @WebParam(name = "gridDetalhePercentHeight") String gridDetalhePercentHeight) throws Exception {

        Connection con = Conexao.getInstance().getConnection(idSessao);

        excluirPosicoesTela(usuario, con);

        gravaPosicaoTela("gridVeiculosX", gridVeiculosX, usuario, con);
        gravaPosicaoTela("gridVeiculosY", gridVeiculosY, usuario, con);
        gravaPosicaoTela("gridVeiculosPercentWidth", gridVeiculosPercentWidth, usuario, con);
        gravaPosicaoTela("gridVeiculosPercentHeight", gridVeiculosPercentHeight, usuario, con);
        gravaPosicaoTela("mapaGoogleX", mapaGoogleX, usuario, con);
        gravaPosicaoTela("mapaGoogleY", mapaGoogleY, usuario, con);
        gravaPosicaoTela("mapaGooglePercentWidth", mapaGooglePercentWidth, usuario, con);
        gravaPosicaoTela("mapaGooglePercentHeight", mapaGooglePercentHeight, usuario, con);
        gravaPosicaoTela("gridDetalheX", gridDetalheX, usuario, con);
        gravaPosicaoTela("gridDetalheY", gridDetalheY, usuario, con);
        gravaPosicaoTela("gridDetalhePercentWidth", gridDetalhePercentWidth, usuario, con);
        gravaPosicaoTela("gridDetalhePercentHeight", gridDetalhePercentHeight, usuario, con);
        con.close();

        return "<registro>OK</registro>";
    }

    @WebMethod(operationName = "lerPosicaoTelas")
    public String lerPosicaoTelas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "usuario") String usuario) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT ");
        sb.append("  sreg_chave, ");
        sb.append("  sreg_valor ");
        sb.append(" FROM ");
        sb.append(" sreg_sistema_registro ");
        sb.append(" WHERE ");
        sb.append("  sreg_sessao = 'TRAFEGUS_WEB_POSICAO' ");
        sb.append(" AND	sreg_usuario_adicionou = '").append(usuario).append("'");

        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);

    }

    @WebMethod(operationName = "logout")
    public String logout(@WebParam(name = "idSessao") String idSessao) throws Exception {
        Conexao.getInstance().logout(idSessao);
        return "<results><row>OK</row></results>";
    }

    private void excluirConfigGrid(String usuario, String tela, String grid, Connection con) throws Exception {
        String sreg_sessao = "TRAFEGUS_WEB_GRID_" + tela.toUpperCase() + "_" + grid.toUpperCase();

        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE FROM sreg_sistema_registro");
        sb.append(" WHERE sreg_sessao = '").append(sreg_sessao).append("' AND sreg_usuario_adicionou = '").append(usuario).append("'");

        String sql = sb.toString();

        sb = null;
        con.createStatement().execute(sql);
    }

    @WebMethod(operationName = "lerConfigGrid")
    public String lerConfigGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "usuario") String usuario, String tela, String grid) throws Exception {
        StringBuilder sb = new StringBuilder();

        String sreg_sessao = "TRAFEGUS_WEB_GRID_" + tela.toUpperCase() + "_" + grid.toUpperCase();

        sb.append(" SELECT ");
        sb.append("     sreg_chave, ");
        sb.append("     sreg_valor ");
        sb.append(" FROM ");
        sb.append("     sreg_sistema_registro ");
        sb.append(" WHERE ");
        sb.append("     sreg_sessao = '").append(sreg_sessao).append("' ");
        sb.append(" AND	sreg_usuario_adicionou = '").append(usuario).append("'");

        String sql = sb.toString();
        sb = null;

        String result = "";

        ResultSet rs = Conexao.getInstance().executeQuery(sql, idSessao);

        result += "<results><row>";

        while (rs.next()) {
            result += "<" + rs.getString("sreg_chave").trim() + ">";
            result += rs.getString("sreg_valor");
            result += "</" + rs.getString("sreg_chave").trim() + ">";
        }

        result += "</row></results>";

        rs.close();
        return result;
    }

    @WebMethod(operationName = "gravaConfigGrid")
    public String gravaConfigGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "usuario") String usuario, @WebParam(name = "tela") String tela, @WebParam(name = "grid") String grid, @WebParam(name = "xml") String xml) throws Exception {
        StringBuilder sb = new StringBuilder();

        String sreg_sessao = "TRAFEGUS_WEB_GRID_" + tela.toUpperCase() + "_" + grid.toUpperCase();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));

        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("row");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);

        }
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoTipoTransporte")
    public String solicitaDescricaoTipoTransporte(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codTipoTransporte") String codTipoTransporte) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT TTRA_Codigo,");
        sb.append("         TTRA_Descricao");
        sb.append(" FROM TTRA_Tipo_Transporte");
        sb.append(" WHERE TTRA_Codigo = ").append(codTipoTransporte);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoViagemPai")
    public String solicitaDescricaoViagemPai(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codViagemPai") String codViagemPai) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("     VIAG_CODIGO,");
        sb.append("     VIAG_PREVISAO_INICIO,");
        sb.append("     VIAG_PREVISAO_FIM");
        sb.append(" FROM VIAG_VIAGEM");
        sb.append(" JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = VIAG_TRAN_PESS_ORAS_CODIGO AND VIAG_TRAN_PESS_ORAS_CODIGO = ").append(codEmpresa).append(") ");
        sb.append(" WHERE VIAG_CODIGO = ").append(codViagemPai);
        //System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoTransportador")
    public String solicitaDescricaoTransportador(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codTransportador") String codTransportador) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT TRAN_Transportador.TRAN_PESS_ORAS_Codigo,");
        //sb.append("       TEST_Tipo_Estabelecimento.*,");
        sb.append("         PESS_Pessoa.PESS_Nome");
        sb.append(" FROM TRAN_Transportador");
        sb.append(" JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = TRAN_PESS_ORAS_Codigo)");
        sb.append(" WHERE TRAN_Transportador.TRAN_PESS_ORAS_Codigo = '").append(codTransportador).append("'");
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoEmbarcador")
    public String solicitaDescricaoEmbarcador(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmbarcador") String codEmbarcador) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT EMBA_PJUR_PESS_ORAS_Codigo,");
        sb.append("      PESS_Pessoa.PESS_Nome");
        sb.append(" FROM EMBA_Embarcador");
        sb.append(" JOIN PJUR_Pessoa_Juridica ON (PJUR_PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" JOIN PESS_Pessoa ON (PESS_ORAS_Codigo = PJUR_PESS_ORAS_Codigo)");
        sb.append(" JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_Codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append(" WHERE EMBA_Embarcador.EMBA_PJUR_PESS_ORAS_Codigo = ").append(codEmbarcador);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoVeiculo")
    public String solicitaDescricaoVeiculo(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codVeic") String codVeic) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("             VEIC_ORAS_Codigo,");
        sb.append("             VEIC_Placa as placa,");
        sb.append("             URPE_Valor as ignicao,");
        sb.append("             UPOS_Descricao_Sistema AS posicao,");
        sb.append("             UPOS_Longitude,");
        sb.append("             UPOS_Latitude,");
        sb.append("             VTEC_Descricao as versaoTecnologia,");
        sb.append("             TERM_Numero_Terminal as numeroTerminal,");
        sb.append("             '' as embarcador,");
        sb.append("             TERM_Ativo,");
        sb.append("             CASE");
        sb.append("                WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("                WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("                WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("                WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("                ELSE 'CAVALO'");
        sb.append("             END AS tipoVeiculo,");
        sb.append("             CASE");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("                ELSE 'SEM VIAGEM'");
        sb.append("             END AS statusViagem,");
        sb.append("             0 as statusAtraso,");
        sb.append("             MOTO1.PESS_Nome AS NomeMotorista,");
        sb.append("             TO_CHAR(UPOS_Data_Comp_Bordo,'DD/MM/YYYY HH24:MI:SS') AS UPOS_Data_Comp_Bordo,");
        sb.append("             MO1.PFIS_CPF AS CpfMotorista");
        sb.append("        FROM UPOS_Ultima_Posicao    ");
        sb.append("        JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("        JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                     ");
        sb.append("        JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)    ");
        sb.append("        JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")"); /*parametros*/
        sb.append("    LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append("    LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN VVEI_Viagem_Veiculo ON (VVEI_VEIC_ORAS_Codigo = ORAS_Codigo AND VVEI_Precedencia = '1' AND VVEI_Ativo = 'S')");
        sb.append("    LEFT JOIN VIAG_Viagem ON (VIAG_Codigo = VVEI_VIAG_Codigo)");
        sb.append(" WHERE VEIC_ORAS_Codigo = ").append(codVeic);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoMotorista")
    public String solicitaDescricaoMotorista(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codMotorista") String codMotorista) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append("      SELECT DISTINCT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("           PESS_Pessoa.PESS_Nome");
        sb.append("       FROM MOTO_Motorista");
        sb.append("        JOIN PFIS_Pessoa_Fisica ON (PFIS_PESS_ORAS_Codigo = MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("        JOIN PESS_Pessoa ON (PESS_ORAS_codigo = PFIS_PESS_ORAS_Codigo)");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = PESS_ORAS_codigo AND ORAS_EOBJ_Codigo = 1)");
        sb.append("        JOIN MTRA_Motorista_Transportador ON (MTRA_MOTO_PFIS_PESS_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = MTRA_TRAN_PESS_ORAS_Codigo");
        sb.append("         AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append("    WHERE ORAS_Objeto_Rastreado.ORAS_Codigo = ").append(codMotorista);
//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoPGR")
    public String solicitaDescricaoPGR(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codPGR") String codPGR) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT");
        sb.append("         PGPG_Codigo,");
        sb.append("         PGPG_Descricao");
        sb.append(" FROM PGPG_pg");
        sb.append("         JOIN pgai_pg_associa_item ON (pgai_pgpg_codigo = pgpg_codigo)");
        sb.append("         JOIN PITE_pg_item ON (pite_codigo = pgai_pite_codigo)");
        sb.append(" WHERE PGPG_Estatus = 'A'");
        sb.append("         AND pgpg_codigo = ").append(codPGR);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoRota")
    public String solicitaDescricaoRota(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codEmbarcador") String codEmbarcador, @WebParam(name = "codRota") String codRota) throws Exception {
        //TODO write your implementation code here:
        if (codEmbarcador.equalsIgnoreCase("")) {
            codEmbarcador = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ");
        sb.append("          ROTA_CODIGO,");
        sb.append("          ROTA_DESCRICAO,");
        sb.append("          ROTA_DISTANCIA,");
        sb.append("          ROTA_COORDENADA,");
        sb.append("          ROTA_DATA_CADASTRO,");
        sb.append("          ROTA_COORDENADASPIPE,");
        sb.append("          ROTA_PESS_ORAS_CODIGO_DONO,");
        sb.append("          ORI.REFE_Codigo AS REFE_Codigo_origem,");
        sb.append("          ORI.REFE_Descricao AS REFE_Descricao_origem,");
        sb.append("          ORI.REFE_Latitude AS REFE_Latitude_origem,");
        sb.append("          ORI.REFE_Longitude AS REFE_Longitude_origem,");
        //sb.append("          ORI.CREF_Classe_Referencia.CREF_Codigo AS CREF_Codigo_origem,");
        //sb.append("          ORI.CREF_Classe_Referencia.CREF_Descricao AS CREF_Descricao_origem,");
        sb.append("          DES.REFE_Codigo AS REFE_Codigo_destino,");
        sb.append("          DES.REFE_Descricao AS REFE_Descricao_destino,");
        sb.append("          DES.REFE_Latitude AS REFE_Latitude_destino,");
        sb.append("          DES.REFE_Longitude AS REFE_Longitude_destino");
        //sb.append("          DES.CREF_Classe_Referencia.CREF_Codigo AS CREF_Codigo_destino,");
        //sb.append("          DES.CREF_Classe_Referencia.CREF_Descricao AS CREF_Descricao_destino");
        sb.append("     FROM ROTA_ROTA");
        sb.append("     JOIN RPON_Rota_Ponto AS RPONORI ON (RPONORI.RPON_ROTA_Codigo = ROTA_Codigo AND RPONORI.RPON_TPAR_Codigo = 4 /* ORIGEM */)");
        sb.append("     JOIN REFE_Referencia AS ORI ON (ORI.REFE_Codigo = RPONORI.RPON_REFE_Codigo)   ");
        sb.append("     JOIN RPON_Rota_Ponto AS RPONDEST ON (RPONDEST.RPON_ROTA_Codigo = ROTA_Codigo AND RPONDEST.RPON_TPAR_Codigo = 5 /* DESTINO */)");
        sb.append("     JOIN REFE_Referencia AS DES ON (DES.REFE_Codigo = RPONDEST.RPON_REFE_Codigo)   ");
        sb.append("    WHERE ROTA_PESS_ORAS_CODIGO_DONO IN (").append(codEmpresa.toString()).append(",").append(codEmbarcador).append(")");
        sb.append("    AND ROTA_CODIGO = ").append(codRota.toString());
        sb.append("    AND ROTA_PESS_ORAS_CODIGO_DONO = ").append(codEmpresa.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoLocalOrigem")
    public String solicitaDescricaoLocalOrigem(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codLocal") String codLocal) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("	REFE_Referencia.REFE_Codigo, ");
        sb.append("	REFE_Referencia.REFE_Descricao ");
        sb.append(" FROM ");
        sb.append("	REFE_Referencia");
        sb.append(" JOIN ");
        sb.append("	CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)      ");
        sb.append("  WHERE REFE_Referencia.REFE_Codigo = ").append(codLocal);

//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDescricaoLocalDestino")
    public String solicitaDescricaoLocalDestino(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codLocal") String codLocal) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("	REFE_Referencia.REFE_Codigo, ");
        sb.append("	REFE_Referencia.REFE_Descricao ");
        sb.append(" FROM ");
        sb.append("	REFE_Referencia");
        sb.append(" JOIN ");
        sb.append("	CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)      ");
        sb.append("  WHERE REFE_Referencia.REFE_Codigo = ").append(codLocal);

//        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaSMVeiculo")
    public String solicitaSMVeiculo(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "placaVeiculo") String placaVeiculo, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append("  SELECT VEIC_ORAS_Codigo,");
        sb.append("         VEIC_Placa,");
        sb.append("         Term_numero_terminal,");
        sb.append("         MOTO1.PESS_ORAS_Codigo AS Codigo_Motorista,");
        sb.append("         MOTO1.PESS_Nome AS Nome_Motorista,");
        sb.append("         Transp.Pess_oras_codigo AS Codigo_Transportador,");
        sb.append("         Transp.Pess_nome AS Nome_Transportador,");
        sb.append("         Emba.Pess_oras_codigo AS Codigo_Embarcador,");
        sb.append("         Emba.Pess_nome AS Nome_Embarcador,");
        sb.append("         O.VLOC_codigo AS Vloc_Codigo_Origem,");
        sb.append("         O.VLOC_sequencia AS Vloc_Sequencia_Origem,");
        sb.append("         O.VLOC_Tpar_codigo AS Vloc_Tpar_codigo_Origem,");
        sb.append("         O.VLOC_Raio AS Vloc_Raio_Origem,");
        sb.append("         O.VLOC_Data_cadastro AS Vloc_Data_Cadastro_Origem,");
        sb.append("         O.VLOC_Usuario_Adicionou AS Vloc_Usuario_Adicionou_Origem,");
        sb.append("         O.VLOC_Usuario_Alterou AS Vloc_Usuario_Alterou_Origem,");
        sb.append("         Ori.Refe_codigo as refe_codigo_origem,");
        sb.append("         Ori.refe_descricao AS refe_descricao_origem,");
        sb.append("         D.VLOC_codigo AS Vloc_Codigo_Destino,");
        sb.append("         D.VLOC_sequencia AS Vloc_Sequencia_Destino,");
        sb.append("         D.VLOC_Tpar_codigo AS Vloc_Tpar_codigo_Destino,");
        sb.append("         D.VLOC_Raio AS Vloc_Raio_Destino,");
        sb.append("         D.VLOC_Data_cadastro AS Vloc_Data_Cadastro_Destino,");
        sb.append("         D.VLOC_Usuario_Adicionou AS Vloc_Usuario_Adicionou_Destino,");
        sb.append("         D.VLOC_Usuario_Alterou AS Vloc_Usuario_Alterou_Destino,");
        sb.append("         Dest.refe_codigo AS refe_codigo_destino,");
        sb.append("         Dest.refe_descricao AS refe_descricao_destino,");
        sb.append("         VIAG_Viagem.viag_codigo,");
        sb.append("         VIAG_Viagem.viag_tope_codigo,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_data_cadastro,'DD/MM/YYYY') AS viag_data_cadastro,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_inicio,'DD/MM/YYYY') AS viag_previsao_inicio,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_inicio,'HH24:MI:SS') AS viag_previsao_hora_inicio,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_fim,'DD/MM/YYYY') AS viag_previsao_fim,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_fim,'HH24:MI:SS') AS viag_previsao_hora_fim,");
        sb.append("         TTRA_Tipo_Transporte.TTRA_Codigo,");
        sb.append("         TTRA_Tipo_Transporte.TTRA_Descricao,");
        sb.append("         ROTA_CODIGO,");
        sb.append("         ROTA_DESCRICAO,");
        sb.append("         PGPG_PG.PGPG_CODIGO,");
        sb.append("         PGPG_PG.PGPG_Descricao,");
        sb.append("         Viag_Codigo_pai,");
        sb.append("         VIAG_Distancia,");
        sb.append("         VIAG_Valor_Carga,");
        sb.append("         TO_CHAR(VIAG_Data_Inicio,'DD/MM/YYYY') AS VIAG_Data_Inicio,");
        sb.append("         TO_CHAR(VIAG_Data_Inicio,'HH24:MI:SS') AS VIAG_Hora_Inicio,");
        sb.append("         VTEM_Valor_Minimo,");
        sb.append("         VTEM_Valor_Maximo,");
        sb.append("         VROT_Viagem_rota.vrot_codigo,");
        sb.append("         VROT_Viagem_rota.vrot_usuario_adicionou,");
        sb.append("         VROT_Viagem_rota.vrot_usuario_alterou,");
        sb.append("         VROT_Viagem_rota.vrot_data_cadastro");
        sb.append("   FROM VIAG_Viagem   ");
        sb.append("   JOIN VVEI_Viagem_Veiculo ON (VVEI_VIAG_Codigo = VIAG_Codigo) ");
        sb.append("   JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = VVEI_VEIC_ORAS_Codigo AND VEIC_Placa = '").append(placaVeiculo).append("')");
        sb.append("   JOIN VTER_VIAGEM_Terminal ON (VTER_Viag_Codigo = Viag_codigo AND VTer_Precedencia = '1' AND Vter_Ativo = 'S')  ");
        sb.append("   JOIN Term_Terminal ON (Term_codigo = Vter_term_codigo)  ");
        sb.append("   JOIN Pess_pessoa AS Transp ON (Transp.Pess_oras_codigo = Viag_Tran_Pess_oras_codigo)");
        sb.append("   JOIN VLOC_Viagem_local AS O ON (O.VLOC_Viag_codigo = Viag_codigo AND O.VLOC_Tpar_codigo = 4)");
        sb.append("   JOIN Refe_Referencia AS Ori ON (Ori.Refe_codigo = O.VLoc_Refe_codigo)   ");
        sb.append("   JOIN VLOC_Viagem_local AS D ON (D.VLOC_Viag_codigo = Viag_codigo AND D.VLOC_Tpar_codigo = 5)");
        sb.append("   JOIN Refe_Referencia AS Dest ON (Dest.Refe_codigo = D.VLoc_Refe_codigo)");
        sb.append("   JOIN TTRA_Tipo_Transporte ON (TTRA_Tipo_Transporte.TTRA_Codigo = VIAG_Viagem.Viag_Ttra_Codigo) ");
        sb.append("   LEFT JOIN VROT_Viagem_rota ON (Viag_Viagem.Viag_codigo = VROT_Viagem_rota.VROT_VIAG_Codigo)");
        sb.append("   LEFT JOIN ROTA_ROTA ON (VROT_Viagem_rota.VROT_ROTA_Codigo = ROTA_ROTA.ROTA_Codigo) ");
        sb.append("   LEFT Join Pess_pessoa AS Emba ON (Emba.Pess_oras_codigo = Viag_Emba_PJUR_Pess_oras_codigo)");
        sb.append("   JOIN PGPG_PG ON (PGPG_PG.PGPG_CODIGO = Viag_pgpg_codigo)");
        sb.append("   LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("   LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("   LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("   LEFT JOIN VTEM_Viagem_Temperatura ON (VTEM_VIAG_Codigo = VIAG_Codigo)");
        sb.append("   WHERE VIAG_Data_Inicio IS NOT NULL  ");
        sb.append("   AND VIAG_Data_Fim IS NOT NULL");
        sb.append("   ORDER BY VIAG_Previsao_Inicio ");
        sb.append("   LIMIT ").append(limit).append(" OFFSET ").append(offset);
        System.out.println("\n" + sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    private Boolean existeConfiguracaoColuna(String idSessao,
            String codUsuario,
            String tela,
            String grid,
            String coluna) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" select");
        sb.append("    count(*)");
        sb.append(" from");
        sb.append("    cgsi_configuracao_grid_site");
        sb.append(" where");
        sb.append("    cgsi_usua_pfis_pess_oras_codigo = ").append(codUsuario);
        sb.append(" and cgsi_tela = '").append(tela).append("'");
        sb.append(" and	cgsi_grid = '").append(grid).append("'");
        sb.append(" and	cgsi_coluna = '").append(coluna).append("'");

        String sql = sb.toString();
        sb = null;

        ResultSet rs = Conexao.getInstance().executeQuery(sql, idSessao);
        rs.next();

        int result = rs.getInt(1);
        rs.close();

        return (result > 0 ? true : false);
    }

    @WebMethod(operationName = "gravaTamanhoPosicaoColuna")
    public String gravaTamanhoPosicaoColuna(@WebParam(name = "idSessao") String idSessao,
            @WebParam(name = "codUsuario") String codUsuario,
            @WebParam(name = "tela") String tela,
            @WebParam(name = "grid") String grid,
            @WebParam(name = "coluna") String coluna,
            @WebParam(name = "tamanho") String tamanho,
            @WebParam(name = "posicao") String posicao,
            @WebParam(name = "visible") String visible) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();

        if (existeConfiguracaoColuna(idSessao, codUsuario, tela, grid, coluna)) {
            sb.append(" UPDATE cgsi_configuracao_grid_site");
            sb.append(" SET");
            sb.append("     cgsi_posicao = '").append(posicao).append("',");
            sb.append("     cgsi_visivel = '").append(visible).append("',");
            sb.append("     cgsi_tamanho = '").append(tamanho).append("'");
            sb.append(" WHERE");
            sb.append("	    cgsi_usua_pfis_pess_oras_codigo = ").append(codUsuario);
            sb.append(" and cgsi_tela = '").append(tela).append("'");
            sb.append(" and cgsi_grid = '").append(grid).append("'");
            sb.append(" and cgsi_coluna = '").append(coluna).append("'");
        } else {
            sb.append(" INSERT INTO cgsi_configuracao_grid_site(");
            sb.append("     cgsi_codigo, cgsi_usua_pfis_pess_oras_codigo, cgsi_tela, cgsi_grid, cgsi_coluna, cgsi_posicao, cgsi_visivel, cgsi_tamanho)");
            sb.append(" VALUES (nextval('s_cgsi_configuracao_grid_site'), '").append(codUsuario).append("', '").append(tela).append("', '").append(grid).append("', '").append(coluna).append("', '").append(posicao).append("', '").append(visible).append("', '").append(tamanho).append("')");
        }
        String sql = sb.toString();
        //System.out.println(sql);
        sb = null;
        Conexao.getInstance().getConnection(idSessao).createStatement().execute(sql);
        return "<results><row><result>OK</result></row></results>";
    }

    @WebMethod(operationName = "gravaVisibilidadeColuna")
    public String gravaVisibilidadeColuna(@WebParam(name = "idSessao") String idSessao,
            @WebParam(name = "codUsuario") String codUsuario,
            @WebParam(name = "tela") String tela,
            @WebParam(name = "grid") String grid,
            @WebParam(name = "coluna") String coluna,
            @WebParam(name = "visible") String visible) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();

        if (existeConfiguracaoColuna(idSessao, codUsuario, tela, grid, coluna)) {
            sb.append(" UPDATE cgsi_configuracao_grid_site");
            sb.append(" SET");
            sb.append("     cgsi_visivel = '").append(visible).append("'");
            sb.append(" WHERE");
            sb.append("	    cgsi_usua_pfis_pess_oras_codigo = ").append(codUsuario);
            sb.append(" and cgsi_tela = '").append(tela).append("'");
            sb.append(" and cgsi_grid = '").append(grid).append("'");
            sb.append(" and cgsi_coluna = '").append(coluna).append("'");
        } else {
            sb.append(" INSERT INTO cgsi_configuracao_grid_site(");
            sb.append("     cgsi_codigo, cgsi_usua_pfis_pess_oras_codigo, cgsi_tela, cgsi_grid, cgsi_coluna, cgsi_visivel)");
            sb.append(" VALUES (nextval('s_cgsi_configuracao_grid_site'), '").append(codUsuario).append("', '").append(tela).append("', '").append(grid).append("', '").append(coluna).append("', '").append(visible).append("')");
        }
        String sql = sb.toString();
        //System.out.println(sql);
        sb = null;
        Conexao.getInstance().getConnection(idSessao).createStatement().execute(sql);
        return "<results><row><result>OK</result></row></results>";
    }

    @WebMethod(operationName = "leConfiguracaoGrid")
    public String leConfiguracaoGrid(
            @WebParam(name = "idSessao") String idSessao,
            @WebParam(name = "codUsuario") String codUsuario,
            @WebParam(name = "tela") String tela,
            @WebParam(name = "grid") String grid) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT");
        sb.append("     cgsi_coluna,");
        sb.append("     cgsi_posicao,");
        sb.append("     cgsi_visivel,");
        sb.append("     cgsi_tamanho");
        sb.append(" FROM ");
        sb.append("     cgsi_configuracao_grid_site");
        sb.append(" WHERE");
        sb.append("	    cgsi_usua_pfis_pess_oras_codigo = ").append(codUsuario);
        sb.append(" and cgsi_tela = '").append(tela).append("'");
        sb.append(" and cgsi_grid = '").append(grid).append("'");
        sb.append(" ORDER BY cgsi_posicao");
        String sql = sb.toString();
        //System.out.println(sql);
        sb = null;
        return Conexao.getInstance().queryToXML(sql, codUsuario);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "procuraDadosGrid")
    public String procuraDadosGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "placa") String placa, @WebParam(name = "gpsDesc") String gpsDesc) throws Exception {
        //TODO write your implementation code here:
        if (placa.equalsIgnoreCase("")) {
            placa = "VEIC_Veiculo.VEIC_Placa";
        } else {
            placa = "'" + placa + "'";
        }
        if (gpsDesc.equalsIgnoreCase("")) {
            gpsDesc = " = UPPER(UPOS_Descricao_Sistema)";
        } else {
            gpsDesc = " LIKE '%" + gpsDesc.toUpperCase() + "%'";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT");
        sb.append("             VEIC_ORAS_Codigo,");
        sb.append("             VEIC_Placa as placa,");
        sb.append("             URPE_Valor as ignicao,");
        sb.append("             UPOS_Descricao_Sistema AS posicao,");
        sb.append("             UPOS_Longitude,");
        sb.append("             UPOS_Latitude,");
        sb.append("             VTEC_Descricao as versaoTecnologia,");
        sb.append("             TERM_Numero_Terminal as numeroTerminal,");
        sb.append("             '' as embarcador,");
        sb.append("             TERM_Ativo,");
        sb.append("             CASE");
        sb.append("                WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("                WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("                WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("                WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("                ELSE 'CAVALO'");
        sb.append("             END AS tipoVeiculo,");
        sb.append("             CASE");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("                WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("                ELSE 'SEM VIAGEM'");
        sb.append("             END AS statusViagem,");
        sb.append("             0 as statusAtraso,");
        sb.append("             MOTO1.PESS_Nome AS NomeMotorista,");
        sb.append("             TO_CHAR(UPOS_Data_Comp_Bordo,'DD/MM/YYYY HH24:MI:SS') AS UPOS_Data_Comp_Bordo,");
        sb.append("             MO1.PFIS_CPF AS CpfMotorista");
        sb.append("        FROM UPOS_Ultima_Posicao    ");
        sb.append("        JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append("        JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)                                     ");
        sb.append("        JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append("        JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)    ");
        sb.append("        JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append("        JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")"); /*parametros*/
        sb.append("    LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("    LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append("    LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("    LEFT JOIN VVEI_Viagem_Veiculo ON (VVEI_VEIC_ORAS_Codigo = ORAS_Codigo AND VVEI_Precedencia = '1' AND VVEI_Ativo = 'S')");
        sb.append("    LEFT JOIN VIAG_Viagem ON (VIAG_Codigo = VVEI_VIAG_Codigo)");
        sb.append(" WHERE");
        sb.append("       TRIM(REPLACE(REPLACE(REPLACE(REPLACE(UPPER(VEIC_Veiculo.VEIC_Placa),'.',''),'/',''),'\\\\',''),'-','')) =");
        sb.append("       TRIM(REPLACE(REPLACE(REPLACE(REPLACE(UPPER(").append(placa).append(") ,'.',''),'/',''),'\\\\',''),'-',''))");
        sb.append(" AND ");
        sb.append("       UPPER(UPOS_Descricao_Sistema) ").append(gpsDesc);
        sb.append("    ORDER BY VEIC_ORAS_Codigo");
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalDadosGridZoom")
    public String solicitaTotalDadosGridZoom(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        return this.solicitaTotalDadosGrid(idSessao, codEmpresa);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaTipoParada")
    public String solicitaListaTipoParada(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "offset") String offset, @WebParam(name = "limit") String limit) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT tpar_codigo,tpar_descricao FROM tpar_tipo_parada ");
        sb.append(" ORDER BY tpar_codigo");
        sb.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaTipoParada")
    public String solicitaTotalListaTipoParada(@WebParam(name = "idSessao") String idSessao) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) AS TOTAL FROM ( SELECT tpar_codigo,tpar_descricao FROM tpar_tipo_parada ) AS XXX ");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalSMVeiculo")
    public String solicitaTotalSMVeiculo(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "placaVeiculo") String placaVeiculo) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append("  SELECT VEIC_ORAS_Codigo,");
        sb.append("         VEIC_ORAS_Codigo AS Codigo_veiculo,");
        sb.append("         VEIC_Placa AS Placa_Veiculo,");
        sb.append("         Term_numero_terminal,");
        sb.append("         MOTO1.PESS_ORAS_Codigo AS Codigo_Motorista,");
        sb.append("         MOTO1.PESS_Nome AS Nome_Motorista,");
        sb.append("         Transp.Pess_oras_codigo AS Codigo_Transportador,");
        sb.append("         Transp.Pess_nome AS Nome_Transportador,");
        sb.append("         Emba.Pess_oras_codigo AS Codigo_Embarcador,");
        sb.append("         Emba.Pess_nome AS Nome_Embarcador,");
        sb.append("         Ori.Refe_codigo as Codigo_Origem,");
        sb.append("         Ori.refe_descricao AS Descricao_Origem,");
        sb.append("         Dest.refe_codigo AS Codigo_Destino,");
        sb.append("         Dest.refe_descricao AS Descricao_Destino,");
        sb.append("         VIAG_Viagem.viag_codigo,");
        sb.append("         VIAG_Viagem.viag_tope_codigo,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_data_cadastro,'DD/MM/YYYY') AS viag_data_cadastro,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_inicio,'DD/MM/YYYY') AS viag_previsao_inicio,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_inicio,'HH24:MI:SS') AS viag_previsao_hora_inicio,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_fim,'DD/MM/YYYY') AS viag_previsao_fim,");
        sb.append("         TO_CHAR(VIAG_Viagem.viag_previsao_fim,'HH24:MI:SS') AS viag_previsao_hora_fim,");
        sb.append("         TTRA_Tipo_Transporte.TTRA_Codigo,");
        sb.append("         TTRA_Tipo_Transporte.TTRA_Descricao,");
        sb.append("         ROTA_CODIGO,");
        sb.append("         ROTA_DESCRICAO,");
        sb.append("         PGPG_PG.PGPG_CODIGO,");
        sb.append("         PGPG_PG.PGPG_Descricao,");
        sb.append("         Viag_Codigo_pai,");
        sb.append("         VIAG_Distancia,");
        sb.append("         VIAG_Valor_Carga,");
        sb.append("         TO_CHAR(VIAG_Data_Inicio,'DD/MM/YYYY') AS VIAG_Data_Inicio,");
        sb.append("         TO_CHAR(VIAG_Data_Inicio,'HH24:MI:SS') AS VIAG_Hora_Inicio,");
        sb.append("         VTEM_Valor_Minimo,");
        sb.append("         VTEM_Valor_Maximo");
        sb.append("   FROM VIAG_Viagem   ");
        sb.append("   JOIN VVEI_Viagem_Veiculo ON (VVEI_VIAG_Codigo = VIAG_Codigo) ");
        sb.append("   JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = VVEI_VEIC_ORAS_Codigo AND VEIC_Placa = '").append(placaVeiculo).append("')");
        sb.append("   JOIN VTER_VIAGEM_Terminal ON (VTER_Viag_Codigo = Viag_codigo AND VTer_Precedencia = '1' AND Vter_Ativo = 'S')  ");
        sb.append("   JOIN Term_Terminal ON (Term_codigo = Vter_term_codigo)  ");
        sb.append("   JOIN Pess_pessoa AS Transp ON (Transp.Pess_oras_codigo = Viag_Tran_Pess_oras_codigo)");
        sb.append("   JOIN VLOC_Viagem_local AS O ON (O.VLOC_Viag_codigo = Viag_codigo AND O.VLOC_Tpar_codigo = 4)");
        sb.append("   JOIN Refe_Referencia AS Ori ON (Ori.Refe_codigo = O.VLoc_Refe_codigo)   ");
        sb.append("   JOIN VLOC_Viagem_local AS D ON (D.VLOC_Viag_codigo = Viag_codigo AND D.VLOC_Tpar_codigo = 5)");
        sb.append("   JOIN Refe_Referencia AS Dest ON (Dest.Refe_codigo = D.VLoc_Refe_codigo)");
        sb.append("   JOIN TTRA_Tipo_Transporte ON (TTRA_Tipo_Transporte.TTRA_Codigo = VIAG_Viagem.Viag_Ttra_Codigo) ");
        sb.append("   LEFT JOIN VROT_Viagem_rota ON (Viag_Viagem.Viag_codigo = VROT_Viagem_rota.VROT_VIAG_Codigo)");
        sb.append("   LEFT JOIN ROTA_ROTA ON (VROT_Viagem_rota.VROT_ROTA_Codigo = ROTA_ROTA.ROTA_Codigo) ");
        sb.append("   LEFT Join Pess_pessoa AS Emba ON (Emba.Pess_oras_codigo = Viag_Emba_PJUR_Pess_oras_codigo)");
        sb.append("   JOIN PGPG_PG ON (PGPG_PG.PGPG_CODIGO = Viag_pgpg_codigo)");
        sb.append("   LEFT JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("   LEFT JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append("   LEFT JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append("   LEFT JOIN VTEM_Viagem_Temperatura ON (VTEM_VIAG_Codigo = VIAG_Codigo)");
        sb.append("   WHERE VIAG_Data_Inicio IS NOT NULL  ");
        sb.append("   AND VIAG_Data_Fim IS NOT NULL");
        sb.append(" ) AS XXX ");
        //System.out.println("\n" + sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvarItensPorPagina")
    public String salvarItensPorPagina(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codUsuario") String codUsuario, @WebParam(name = "itensPorPagina") String itensPorPagina) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        gravarItensPorPagina("itensPorPagina", itensPorPagina, codUsuario, con);
        return "<registro>OK</registro>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "lerItensPorPagina")
    public String lerItensPorPagina(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "codUsuario") String codUsuario) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT ");
        sb.append("  sreg_chave, ");
        sb.append("  sreg_valor ");
        sb.append(" FROM ");
        sb.append(" sreg_sistema_registro ");
        sb.append(" WHERE ");
        sb.append("  sreg_sessao = 'TRAFEGUS_WEB_ITENS_POR_PAGINA' ");
        sb.append(" AND	sreg_usuario_adicionou = '").append(codUsuario).append("'");

        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGridCarretas")
    public String solicitaDadosGridCarretas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "numeroViagem") String numeroViagem) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT VEIC_Placa,");
        sb.append("        VVEI_codigo,");
        sb.append("        VVEI_Sequencia,");
        sb.append("        VVEI_Precedencia,");
        sb.append("        VVEI_evca_codigo,");
        sb.append("        VVEI_moto_pfis_pess_oras_codigo,");
        sb.append("        VVEI_usuario_adicionou,");
        sb.append("        VVEI_usuario_alterou,");
        sb.append("        VEIC_ORAS_Codigo,");
        sb.append("        VEIC_Veiculo.VEIC_COR,");
        sb.append("        TVEI_DESCRICAO,");
        sb.append("        VVEI_Viag_Codigo");
        sb.append(" FROM VVEI_Viagem_Veiculo");
        sb.append(" JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = VVEI_VEIC_ORAS_Codigo)");
        sb.append(" JOIN VCAR_Veiculo_Carreta ON (VCAR_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" JOIN TVEI_Tipo_Veiculo ON (VEIC_TVEI_Codigo = TVEI_Codigo)");
        sb.append(" WHERE VVEI_Viag_Codigo = ").append(numeroViagem);
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaParadasSM")
    public String solicitaParadasSM(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codViagem") String codViagem) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT VLOC_Codigo,");
        sb.append("           VLOC_Sequencia,");
        sb.append("           VLOC_VIAG_Codigo,");
        sb.append("           VLOC_Descricao,");
        sb.append("           VLOC_REFE_Codigo,");
        sb.append("           REFE_Codigo,");
        sb.append("           REFE_Descricao,");
        sb.append("           REFE_Latitude,");
        sb.append("           REFE_Longitude,");
        sb.append("           TPAR_Codigo,");
        sb.append("           TPAR_Descricao,");
        sb.append("           VLOC_Data_Cadastro,");
        sb.append("           CREF_Codigo,");
        sb.append("           CREF_Descricao");
        sb.append("      FROM VLOC_Viagem_Local");
        sb.append("      JOIN TPAR_Tipo_Parada ON (TPAR_Codigo = VLOC_TPAR_Codigo)");
        sb.append(" LEFT JOIN REFE_Referencia ON (REFE_Codigo = VLOC_REFE_Codigo)");
        sb.append(" LEFT JOIN CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)");
        sb.append("     WHERE VLOC_VIAG_Codigo = ").append(codViagem);
        sb.append(" ORDER BY VLOC_Sequencia");
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaViagViagem")
    public String salvaViagViagem(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "viag_codigo") String viag_codigo, @WebParam(name = "viag_data_cadastro") String viag_data_cadastro, @WebParam(name = "viag_ttra_codigo") String viag_ttra_codigo, @WebParam(name = "viag_tran_pess_oras_codigo") String viag_tran_pess_oras_codigo, @WebParam(name = "viag_emba_pjur_pess_oras_codigo") String viag_emba_pjur_pess_oras_codigo, @WebParam(name = "viag_pgpg_codigo") String viag_pgpg_codigo, @WebParam(name = "viag_valor_carga") String viag_valor_carga, @WebParam(name = "viag_previsao_inicio") String viag_previsao_inicio, @WebParam(name = "viag_previsao_fim") String viag_previsao_fim, @WebParam(name = "viag_data_inicio") String viag_data_inicio, @WebParam(name = "viag_data_fim") String viag_data_fim, @WebParam(name = "viag_distancia") String viag_distancia, @WebParam(name = "viag_hpmo_codigo") String viag_hpmo_codigo, @WebParam(name = "viag_tempo_term_fora_area_risco") String viag_tempo_term_fora_area_risco, @WebParam(name = "viag_tempo_term_em_area_risco") String viag_tempo_term_em_area_risco, @WebParam(name = "viag_tempo_term_fim_viagem") String viag_tempo_term_fim_viagem, @WebParam(name = "viag_codigo_pai") String viag_codigo_pai, @WebParam(name = "viag_codigo_gr") String viag_codigo_gr, @WebParam(name = "viag_importado") String viag_importado, @WebParam(name = "viag_tope_codigo") String viag_tope_codigo, @WebParam(name = "viag_usuario_adicionou") String viag_usuario_adicionou, @WebParam(name = "viag_usuario_alterou") String viag_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO viag_viagem(viag_codigo, viag_data_cadastro, viag_ttra_codigo, viag_tran_pess_oras_codigo, viag_emba_pjur_pess_oras_codigo, viag_pgpg_codigo, viag_valor_carga,");
        sb.append("viag_previsao_inicio, viag_previsao_fim, viag_data_inicio, viag_data_fim, viag_distancia, viag_hpmo_codigo, viag_tempo_term_fora_area_risco,");
        sb.append("viag_tempo_term_em_area_risco, viag_tempo_term_fim_viagem, viag_codigo_pai, viag_codigo_gr, viag_importado, viag_tope_codigo, viag_usuario_adicionou,");
        sb.append("viag_usuario_alterou) VALUES (");
        sb.append(viag_codigo).append(",");
        sb.append(viag_data_cadastro).append(",");
        sb.append(viag_ttra_codigo).append(",");
        sb.append(viag_tran_pess_oras_codigo).append(",");
        sb.append(viag_emba_pjur_pess_oras_codigo).append(",");
        sb.append(viag_pgpg_codigo).append(",");
        sb.append(viag_valor_carga).append(",");
        sb.append(viag_previsao_inicio).append(",");
        sb.append(viag_previsao_fim).append(",");
        sb.append(viag_data_inicio).append(",");
        sb.append(viag_data_fim).append(",");
        sb.append(viag_distancia).append(",");
        sb.append(viag_hpmo_codigo).append(",");
        sb.append(viag_tempo_term_fora_area_risco).append(",");
        sb.append(viag_tempo_term_em_area_risco).append(",");
        sb.append(viag_tempo_term_fim_viagem).append(",");
        sb.append(viag_codigo_pai).append(",");
        sb.append(viag_codigo_gr).append(",");
        sb.append(viag_importado).append(",");
        sb.append(viag_tope_codigo).append(",");
        sb.append(viag_usuario_adicionou).append(",");
        sb.append(viag_usuario_alterou).append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "necessitaValidarPesquisaMotorista")
    public String necessitaValidarPesquisaMotorista(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codPGR") String codPGR) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT 'SIM' AS NecessarioConsultaMotorista");
        sb.append("   FROM PGPG_Pg");
        sb.append("   JOIN PGAI_Pg_Associa_Item ON (PGAI_PGPG_Codigo = PGPG_Codigo)");
        sb.append("   JOIN PITE_Pg_Item ON (PITE_Codigo = PGAI_PITE_Codigo AND PITE_Codigo = 47)");
        sb.append("  WHERE PGPG_Codigo = ").append(codPGR);
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarPesquisaMotorista")
    public String validarPesquisaMotorista(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codVeiculo") String codVeiculo, @WebParam(name = "codMotorista") String codMotorista) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT HPMO_EPMO_Codigo, HPMO_Mensagem, HPMO_Prazo_Validade ");
        sb.append(" FROM HPMO_Historico_Pesquisa_Motor hpmo ");
        sb.append(" WHERE HPMO_MOTO_PFIS_PESS_ORAS_Codigo = ").append(codMotorista);
        sb.append(" AND HPMO_VEIC_ORAS_Codigo = ").append(codVeiculo);
        sb.append(" AND HPMO_Prazo_Validade >= TO_TIMESTAMP((TO_CHAR(CURRENT_DATE,'YYYY-MM-DD') || ' 00:00:00'),'YYYY-MM-DD HH24:MI:SS')");
        //System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaVveiViagemVeiculo")
    public String salvaVveiViagemVeiculo(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "vvei_codigo") String vvei_codigo, @WebParam(name = "vvei_precedencia") String vvei_precedencia, @WebParam(name = "vvei_viag_codigo") String vvei_viag_codigo, @WebParam(name = "vvei_veic_oras_codigo") String vvei_veic_oras_codigo, @WebParam(name = "vvei_moto_pfis_pess_oras_codigo") String vvei_moto_pfis_pess_oras_codigo, @WebParam(name = "vvei_evca_codigo") String vvei_evca_codigo, @WebParam(name = "vvei_comb_codigo") String vvei_comb_codigo, @WebParam(name = "vvei_data_inicio_comboio") String vvei_data_inicio_comboio, @WebParam(name = "vvei_data_fim_comboio") String vvei_data_fim_comboio, @WebParam(name = "vvei_ativo") String vvei_ativo, @WebParam(name = "vvei_sequencia") String vvei_sequencia, @WebParam(name = "vvei_data_cadastro") String vvei_data_cadastro, @WebParam(name = "vvei_codigo_gr") String vvei_codigo_gr, @WebParam(name = "vvei_importado") String vvei_importado, @WebParam(name = "vvei_usuario_adicionou") String vvei_usuario_adicionou, @WebParam(name = "vvei_usuario_alterou") String vvei_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO vvei_viagem_veiculo(vvei_codigo, vvei_precedencia, vvei_viag_codigo, vvei_veic_oras_codigo, vvei_moto_pfis_pess_oras_codigo, vvei_evca_codigo, vvei_comb_codigo,");
        sb.append(" vvei_data_inicio_comboio, vvei_data_fim_comboio, vvei_ativo, vvei_sequencia, vvei_data_cadastro, vvei_codigo_gr, vvei_importado, vvei_usuario_adicionou,");
        sb.append(" vvei_usuario_alterou) VALUES (");
        sb.append(vvei_codigo).append(",");
        sb.append(vvei_precedencia).append(",");
        sb.append(vvei_viag_codigo).append(",");
        sb.append(vvei_veic_oras_codigo).append(",");
        sb.append(vvei_moto_pfis_pess_oras_codigo).append(",");
        sb.append(vvei_evca_codigo).append(",");
        sb.append(vvei_comb_codigo).append(",");
        sb.append(vvei_data_inicio_comboio).append(",");
        sb.append(vvei_data_fim_comboio).append(",");
        sb.append(vvei_ativo).append(",");
        sb.append(vvei_sequencia).append(",");
        sb.append(vvei_data_cadastro).append(",");
        sb.append(vvei_codigo_gr).append(",");
        sb.append(vvei_importado).append(",");
        sb.append(vvei_usuario_adicionou).append(",");
        sb.append(vvei_usuario_alterou).append(",");
        sb.append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaVterViagemTerminal")
    public String salvaVterViagemTerminal(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "vter_codigo") String vter_codigo, @WebParam(name = "vter_viag_codigo") String vter_viag_codigo, @WebParam(name = "vter_term_codigo") String vter_term_codigo, @WebParam(name = "vter_precedencia") String vter_precedencia, @WebParam(name = "vter_tempo_satelital") String vter_tempo_satelital, @WebParam(name = "vter_tempo_gprs") String vter_tempo_gprs, @WebParam(name = "vter_usua_pfis_pess_oras_codigo") String vter_usua_pfis_pess_oras_codigo, @WebParam(name = "vter_data_cadastro") String vter_data_cadastro, @WebParam(name = "vter_codigo_gr") String vter_codigo_gr, @WebParam(name = "vter_importado") String vter_importado, @WebParam(name = "vter_ativo") String vter_ativo, @WebParam(name = "vter_usuario_adicionou") String vter_usuario_adicionou, @WebParam(name = "vter_usuario_alterou") String vter_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO vter_viagem_terminal(vter_codigo, vter_viag_codigo, vter_term_codigo, vter_precedencia, vter_tempo_satelital, vter_tempo_gprs, vter_usua_pfis_pess_oras_codigo, vter_data_cadastro,");
        sb.append("vter_codigo_gr, vter_importado, vter_ativo, vter_usuario_adicionou, vter_usuario_alterou) VALUES (");
        //?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
        sb.append(vter_codigo).append(",");
        sb.append(vter_viag_codigo).append(",");
        sb.append(vter_term_codigo).append(",");
        sb.append(vter_precedencia).append(",");
        sb.append(vter_tempo_satelital).append(",");
        sb.append(vter_tempo_gprs).append(",");
        sb.append(vter_usua_pfis_pess_oras_codigo).append(",");
        sb.append(vter_data_cadastro).append(",");
        sb.append(vter_codigo_gr).append(",");
        sb.append(vter_importado).append(",");
        sb.append(vter_ativo).append(",");
        sb.append(vter_usuario_adicionou).append(",");
        sb.append(vter_usuario_alterou).append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaVtemViagemTemperatura")
    public String salvaVtemViagemTemperatura(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "vtem_codigo") String vtem_codigo, @WebParam(name = "vtem_viag_codigo") String vtem_viag_codigo, @WebParam(name = "vtem_valor_minimo") String vtem_valor_minimo, @WebParam(name = "vtem_valor_maximo") String vtem_valor_maximo, @WebParam(name = "vtem_ativo") String vtem_ativo, @WebParam(name = "vtem_data_cadastro") String vtem_data_cadastro, @WebParam(name = "vtem_importado") String vtem_importado, @WebParam(name = "vtem_codigo_gr") String vtem_codigo_gr, @WebParam(name = "vtem_usuario_adicionou") String vtem_usuario_adicionou, @WebParam(name = "vtem_usuario_alterou") String vtem_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO vtem_viagem_temperatura(vtem_codigo, vtem_viag_codigo, vtem_valor_minimo, vtem_valor_maximo, vtem_ativo, vtem_data_cadastro, vtem_importado, vtem_codigo_gr,");
        sb.append("vtem_usuario_adicionou, vtem_usuario_alterou) VALUES (");
        //?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
        sb.append(vtem_codigo).append(",");
        sb.append(vtem_viag_codigo).append(",");
        sb.append(vtem_valor_minimo).append(",");
        sb.append(vtem_valor_maximo).append(",");
        sb.append(vtem_ativo).append(",");
        sb.append(vtem_data_cadastro).append(",");
        sb.append(vtem_importado).append(",");
        sb.append(vtem_codigo_gr).append(",");
        sb.append(vtem_usuario_adicionou).append(",");
        sb.append(vtem_usuario_alterou).append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaVrotViagemRota")
    public String salvaVrotViagemRota(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "vrot_codigo") String vrot_codigo, @WebParam(name = "vrot_viag_codigo") String vrot_viag_codigo, @WebParam(name = "vrot_rota_codigo") String vrot_rota_codigo, @WebParam(name = "vrot_data_cadastro") String vrot_data_cadastro, @WebParam(name = "vrot_codigo_gr") String vrot_codigo_gr, @WebParam(name = "vrot_importado") String vrot_importado, @WebParam(name = "vrot_ativo") String vrot_ativo, @WebParam(name = "vrot_usuario_adicionou") String vrot_usuario_adicionou, @WebParam(name = "vrot_usuario_alterou") String vrot_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO vrot_viagem_rota(vrot_codigo, vrot_viag_codigo, vrot_rota_codigo, vrot_data_cadastro, vrot_codigo_gr, vrot_importado, vrot_ativo, vrot_usuario_adicionou, vrot_usuario_alterou)");
        sb.append(" VALUES (");
        //?, ?, ?, ?, ?, ?, ?, ?, ?
        sb.append(vrot_codigo).append(",");
        sb.append(vrot_viag_codigo).append(",");
        sb.append(vrot_rota_codigo).append(",");
        sb.append(vrot_data_cadastro).append(",");
        sb.append(vrot_codigo_gr).append(",");
        sb.append(vrot_importado).append(",");
        sb.append(vrot_ativo).append(",");
        sb.append(vrot_usuario_adicionou).append(",");
        sb.append(vrot_usuario_alterou).append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaVlocViagemLocal")
    public String salvaVlocViagemLocal(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "vloc_codigo") String vloc_codigo, @WebParam(name = "vloc_sequencia") String vloc_sequencia, @WebParam(name = "vloc_viag_codigo") String vloc_viag_codigo, @WebParam(name = "vloc_refe_codigo") String vloc_refe_codigo, @WebParam(name = "vloc_tpar_codigo") String vloc_tpar_codigo, @WebParam(name = "vloc_raio") String vloc_raio, @WebParam(name = "vloc_data_cadastro") String vloc_data_cadastro, @WebParam(name = "vloc_codigo_gr") String vloc_codigo_gr, @WebParam(name = "vloc_importado") String vloc_importado, @WebParam(name = "vloc_descricao") String vloc_descricao, @WebParam(name = "vloc_usuario_adicionou") String vloc_usuario_adicionou, @WebParam(name = "vloc_usuario_alterou") String vloc_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO vloc_viagem_local(vloc_codigo, vloc_sequencia, vloc_viag_codigo, vloc_refe_codigo, vloc_tpar_codigo, vloc_raio, vloc_data_cadastro, vloc_codigo_gr, vloc_importado, vloc_descricao,");
        sb.append("vloc_usuario_adicionou, vloc_usuario_alterou) VALUES (");
        //?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
        sb.append(vloc_codigo).append(",");
        sb.append(vloc_sequencia).append(",");
        sb.append(vloc_viag_codigo).append(",");
        sb.append(vloc_refe_codigo).append(",");
        sb.append(vloc_tpar_codigo).append(",");
        sb.append(vloc_raio).append(",");
        sb.append(vloc_data_cadastro).append(",");
        sb.append(vloc_codigo_gr).append(",");
        sb.append(vloc_importado).append(",");
        sb.append(vloc_descricao).append(",");
        sb.append(vloc_usuario_adicionou).append(",");
        sb.append(vloc_usuario_alterou).append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "salvaVlevViagemLocalEvento")
    public String salvaVlevViagemLocalEvento(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "vlev_codigo") String vlev_codigo, @WebParam(name = "vlev_vloc_codigo") String vlev_vloc_codigo, @WebParam(name = "vlev_sequencia") String vlev_sequencia, @WebParam(name = "vlev_tlev_codigo") String vlev_tlev_codigo, @WebParam(name = "vlev_data_previsao") String vlev_data_previsao, @WebParam(name = "vlev_data") String vlev_data, @WebParam(name = "vlev_cpat_codigo") String vlev_cpat_codigo, @WebParam(name = "vlev_data_cadastro") String vlev_data_cadastro, @WebParam(name = "vlev_codigo_gr") String vlev_codigo_gr, @WebParam(name = "vlev_importado") String vlev_importado, @WebParam(name = "vlev_usuario_adicionou") String vlev_usuario_adicionou, @WebParam(name = "vlev_usuario_alterou") String vlev_usuario_alterou) throws Exception {
        //TODO write your implementation code here:
        Connection con = Conexao.getInstance().getConnection(idSessao);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO vlev_viagem_local_evento(vlev_codigo, vlev_vloc_codigo, vlev_sequencia, vlev_tlev_codigo, vlev_data_previsao, vlev_data, vlev_cpat_codigo, vlev_data_cadastro, vlev_codigo_gr,");
        sb.append("vlev_importado, vlev_usuario_adicionou, vlev_usuario_alterou) VALUES (");
        //?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
        sb.append(vlev_codigo).append(",");
        sb.append(vlev_vloc_codigo).append(",");
        sb.append(vlev_sequencia).append(",");
        sb.append(vlev_tlev_codigo).append(",");
        sb.append(vlev_data_previsao).append(",");
        sb.append(vlev_data).append(",");
        sb.append(vlev_cpat_codigo).append(",");
        sb.append(vlev_data_cadastro).append(",");
        sb.append(vlev_codigo_gr).append(",");
        sb.append(vlev_importado).append(",");
        sb.append(vlev_usuario_adicionou).append(",");
        sb.append(vlev_usuario_alterou).append(")");
        Statement s = con.createStatement();
        try {
            System.out.println(sb.toString());
            s.execute(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "<results><row><result>OK</result></row></results>";
    }

    @WebMethod(operationName = "procuraHistoricoPosicoes")
    public String procuraHistoricoPosicoes(@WebParam(name = "idSessao") String idSessao,
            @WebParam(name = "dataInicial") String dataInicial,
            @WebParam(name = "dataFinal") String dataFinal) {
        return "";
    }
}
