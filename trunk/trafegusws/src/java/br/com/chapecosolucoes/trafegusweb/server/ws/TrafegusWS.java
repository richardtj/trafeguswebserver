/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.conexao.Conexao;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Emerson
 */
@WebService()
public class TrafegusWS {

    private String solicitaDadosGridCarretas(String placaCavalo) throws Exception {
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select ");
        sb.append("     CARRETA.VEIC_Placa, ");
        sb.append("     VCCA_Sequencia");
        sb.append(" from VEIC_Veiculo ");
        sb.append("     JOIN VCAV_Veiculo_Cavalo ON (vcav_veic_oras_codigo = VEIC_ORAS_Codigo)");
        sb.append("     JOIN VCCA_Veiculo_Cavalo_Carreta ON (vcca_vcav_veic_oras_codigo = VEIC_ORAS_Codigo)");
        sb.append("     JOIN VCAR_Veiculo_Carreta ON (VCAR_VEIC_ORAS_Codigo = vcca_vcar_veic_oras_codigo)");
        sb.append("     JOIN VEIC_Veiculo AS CARRETA ON (CARRETA.VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo)");
        sb.append(" where");
        sb.append("     VEIC_Veiculo.VEIC_Placa ='").append(placaCavalo).append("'");
        sb.append(" ORDER BY VCCA_Sequencia");

        rs = Conexao.getInstance().executeQuery(placaCavalo);

        sb.delete(0, sb.length() - 1);

        sb.append("<carretas>/n");
        while (rs.next()) {
            sb.append("<carreta>").append(rs.getString("")).append("</carreta>/n");
        }
        sb.append("</carretas>/n");

        return sb.toString();
    }

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
        System.out.println(sb.toString());

        return Conexao.getInstance().queryToXML(sb.toString());

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaRefencias")
    public String solicitaRefencias(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codClasseReferencia") Integer codClasseReferencia) throws Exception {
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
        return Conexao.getInstance().queryToXML(sb.toString());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosVeiculo")
    public String solicitaDadosVeiculo(@WebParam(name = "placaVeiculo") String placaVeiculo) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ORAS_Objeto_Rastreado.ORAS_Codigo,");
        sb.append("         ORAS_Objeto_Rastreado.ORAS_Data_Cadastro,");
        sb.append("         VEIC_Veiculo.*,");
        sb.append("         TVEI_Tipo_Veiculo.*,");
        sb.append("         vcar_veiculo_carreta.VCAR_VEIC_ORAS_Codigo,");
        sb.append("         vcav_veiculo_cavalo.VCAV_VEIC_ORAS_Codigo,");
        sb.append("         vmot_veiculo_moto.VMOT_VEIC_ORAS_Codigo,");
        sb.append("         vtru_veiculo_truck.VTRU_VEIC_ORAS_Codigo,");
        sb.append("         vuca_veiculo_utilitario_carga.VUCA_VEIC_ORAS_Codigo,");
        sb.append("         vupa_veiculo_utilitario_passe.VUPA_VEIC_ORAS_Codigo");
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
        sb.append("    TRIM(VEIC_Veiculo.VEIC_Placa) = '").append(placaVeiculo.trim()).append("'");
        return Conexao.getInstance().queryToXML(sb.toString());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosTransportador")
    public String solicitaDadosTransportador(@WebParam(name = "codTransportador") String codTransportador) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT TRAN_Transportador.TRAN_PESS_ORAS_Codigo,");
        sb.append("         TEST_Tipo_Estabelecimento.*,");
        sb.append("         PESS_Pessoa.PESS_Nome,");
        sb.append("         PFIS_Pessoa_Fisica.PFIS_RG,");
        sb.append("         PFIS_Pessoa_Fisica.PFIS_CPF,          ");
        sb.append("         PFIS_Pessoa_Fisica.PFIS_Data_Nascimento,          ");
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
        return Conexao.getInstance().queryToXML(sb.toString());
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

        return sb.toString();
        /*
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
        
         */
        //return Conexao.getInstance().queryToXML(sb.toString());

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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGrid")
    public String solicitaDadosGrid(@WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT VEIC_Placa as placa,");
        sb.append("      URPE_Valor as ignicao,");
        sb.append("      UPOS_Descricao_Sistema AS posicao,");
        sb.append("      UPOS_Longitude AS gpslatitude,");
        sb.append("      UPOS_Latitude AS gpslongitude,");
        sb.append("      VTEC_Descricao as versaoTecnologia,");
        sb.append("      TERM_Numero_Terminal as numeroTerminal,");
        sb.append("      EMBA.PESS_Nome as embarcador,");
        sb.append("      TERM_Ativo,");
        sb.append("      CASE");
        sb.append("         WHEN (VUPA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE PASSEIO'");
        sb.append("         WHEN (VUCA_VEIC_ORAS_Codigo IS NOT NULL) THEN 'UTILITARIO DE CARGA'");
        sb.append("         WHEN (VTRU_VEIC_ORAS_Codigo IS NOT NULL) THEN 'TRUCK'");
        sb.append("         WHEN (VMOT_VEIC_ORAS_Codigo IS NOT NULL) THEN 'MOTO'");
        sb.append("         ELSE 'CAVALO'");
        sb.append("      END AS tipoVeiculo,");
        sb.append("      CASE");
        sb.append("         WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NULL) AND (VIAG_Data_Fim IS NULL)  THEN 'AGENDADO'");
        sb.append("         WHEN (VIAG_Previsao_Inicio IS NOT NULL) AND (VIAG_Previsao_Fim IS NOT NULL) AND (VIAG_Data_Inicio IS NOT NULL) AND (VIAG_Data_Fim IS NULL) THEN 'EM VIAGEM'");
        sb.append("         ELSE 'SEM VIAGEM'");
        sb.append("      END AS statusViagem,");
        sb.append("      0 as statusAtraso,");
        sb.append("      COALESCE(MOTO2.PESS_Nome, MOTO1.PESS_Nome) AS NomeMotorista,");
        sb.append("      COALESCE(MO2.PFIS_CPF, MO1.PFIS_CPF) AS CpfMotorista");
        sb.append(" FROM UPOS_Ultima_Posicao ");
        sb.append(" JOIN TERM_Terminal ON (TERM_Numero_Terminal = UPOS_TERM_Numero_Terminal AND TERM_VTEC_Codigo = UPOS_VTEC_Codigo AND TERM_Ativo_WS = 'S')");
        sb.append(" JOIN VTEC_Versao_Tecnologia ON (VTEC_Codigo = TERM_VTEC_Codigo)");
        sb.append(" JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_TERM_Codigo = TERM_Codigo AND ORTE_Sequencia = 'P')");
        sb.append(" JOIN ORAS_Objeto_Rastreado ON (ORAS_Codigo = ORTE_ORAS_Codigo)");
        sb.append(" JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo)");
        sb.append(" JOIN MOTO_Motorista AS M1 ON (M1.MOTO_PFIS_PESS_ORAS_Codigo = VEIC_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append(" JOIN PFIS_Pessoa_Fisica MO1 ON (MO1.PFIS_PESS_ORAS_Codigo = M1.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append(" JOIN PESS_Pessoa AS MOTO1 ON (MOTO1.PESS_ORAS_Codigo = MO1.PFIS_PESS_ORAS_Codigo)");
        sb.append(" JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo AND VTRA_TRAN_PESS_ORAS_Codigo = ");
        sb.append(codEmpresa).append(")");
        sb.append(" LEFT JOIN urpe_ultimo_rec_periferico ON (URPE_TERM_Numero_terminal = UPOS_TERM_Numero_Terminal AND URPE_VTEC_Codigo = UPOS_VTEC_codigo AND urpe_eppa_codigo = 30)");
        sb.append(" LEFT JOIN vupa_veiculo_utilitario_passe ON (VUPA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vuca_veiculo_utilitario_carga ON (VUCA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vtru_veiculo_truck ON (VTRU_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vmot_veiculo_moto ON (VMOT_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN vcav_veiculo_cavalo ON (VCAV_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append(" LEFT JOIN VTER_Viagem_Terminal ON (VTER_TERM_Codigo = TERM_Codigo AND VTER_Ativo = 'S' AND VTER_Precedencia = '1')");
        sb.append(" LEFT JOIN VIAG_Viagem ON (VIAG_Codigo = VTER_VIAG_Codigo)");
        sb.append(" LEFT JOIN VVEI_Viagem_Veiculo ON (VVEI_VIAG_Codigo = VIAG_Codigo)");
        sb.append(" LEFT JOIN MOTO_Motorista AS M2 ON (M2.MOTO_PFIS_PESS_ORAS_Codigo = VVEI_MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PFIS_Pessoa_Fisica AS MO2 ON (MO2.PFIS_PESS_ORAS_Codigo = M2.MOTO_PFIS_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PESS_Pessoa AS MOTO2 ON (MOTO2.PESS_ORAS_Codigo = MO2.PFIS_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN EMBA_Embarcador ON (EMBA_PJUR_PESS_ORAS_Codigo = VIAG_EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" LEFT JOIN PESS_Pessoa AS EMBA ON (EMBA.PESS_ORAS_Codigo = EMBA_PJUR_PESS_ORAS_Codigo)");
        sb.append(" ORDER BY VEIC_Placa");

        ResultSet rs = Conexao.getInstance().executeQuery(sb.toString());
        ResultSetMetaData rsmd = rs.getMetaData();

        sb.delete(0, sb.length() - 1);

        sb.append("<results>/n");
        int colCount = rsmd.getColumnCount();
        while (rs.next()) {
            sb.append("<row>/n");
            for (int ii = 1; ii <= colCount; ii++) {
                String columnName = rsmd.getColumnLabel(ii);
                Object value = rs.getObject(ii);
                sb.append("<").append(columnName.toLowerCase()).append(">").append("</").append(columnName.toLowerCase()).append(">/n");
            }
            sb.append(solicitaDadosGridCarretas(rs.getString("placa")));
            sb.append("</row>/n");
        }
        sb.append("</results>");
        return sb.toString();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SolicitaHistoricoPosicoes")
    public String SolicitaHistoricoPosicoes(@WebParam(name = "codEmpresa") String codEmpresa,
            @WebParam(name = "placaVeiculo") String placaVeiculo,
            @WebParam(name = "posInicial") Integer posInicial,
            @WebParam(name = "qtdRegistros") Integer qtdRegistros,
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
        sb.append("        RPOS_Data_Cadastro,");
        sb.append("        RPOS_Data_Computador_Bordo");
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
        return Conexao.getInstance().queryToXML(sb.toString());
    }
}
