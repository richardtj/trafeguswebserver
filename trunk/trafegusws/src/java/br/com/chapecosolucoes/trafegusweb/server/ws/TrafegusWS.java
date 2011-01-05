/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
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
        System.out.print(sb.toString());
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
        System.out.println(sb.toString());

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
        System.out.print(sb.toString());
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
        System.out.println(sb.toString());
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
    public String solicitaListaVeiculos(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "offset") Integer offset) throws Exception {
        StringBuilder sb = new StringBuilder();
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
        sb.append(" ORDER BY VEIC_Veiculo.VEIC_Placa");
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        System.out.println(sb.toString());

        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaRotas")
    public String solicitaListaRotas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
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
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGrid")
    public String solicitaDadosGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
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
        sb.append("    LIMIT 20 OFFSET ").append(offset);
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SolicitaHistoricoPosicoes")
    public String SolicitaHistoricoPosicoes(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa,
            @WebParam(name = "placaVeiculo") String placaVeiculo,
            @WebParam(name = "offset") String offset,
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
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosGridEmViagem")
    public String solicitaDadosGridEmViagem(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
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
        sb.append("  ORDER BY VEIC_Placa");
        sb.append("  LIMIT 20 OFFSET ").append(offset);
        System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaMotoristas")
    public String solicitaListaMotoristas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
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
        sb.append("    LIMIT 20 OFFSET ").append(offset);
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaEmbarcadores")
    public String solicitaListaEmbarcadores(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
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
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        System.out.print(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaLocais")
    public String solicitaListaLocais(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
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
        sb.append("  LIMIT 20 OFFSET ").append(offset);
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaTransportadores")
    public String solicitaListaTransportadores(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "offset") String offset) throws Exception {
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
        sb.append(" LIMIT 20 OFFSET ").append(offset);
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
    public String solicitaListaTipoTransporte(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "offset") String offset) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT TTRA_Codigo,");
        sb.append("         TTRA_Descricao");
        sb.append(" FROM TTRA_Tipo_Transporte");
        sb.append(" ORDER BY TTRA_Codigo");
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosLocal")
    public String solicitaDadosLocal(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codLocal") String codLocal) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT REFE_Referencia.REFE_Codigo, REFE_Referencia.REFE_Descricao, REFE_Referencia.REFE_Latitude,");
        sb.append("      REFE_Referencia.REFE_Longitude, CREF_Classe_Referencia.CREF_Codigo, CREF_Classe_Referencia.CREF_Descricao,");
        sb.append("      REFE_Referencia.REFE_Raio, REFE_Referencia.REFE_KM, REFE_Referencia.REFE_Bandeira,");
        sb.append("      REFE_Referencia.REFE_Utilizado_Sistema");
        sb.append("      FROM TRAN_Transportador JOIN TLOC_Transportador_Local ON (TLOC_TRAN_PESS_ORAS_Codigo = TRAN_PESS_ORAS_Codigo)");
        sb.append("      JOIN REFE_Referencia ON (REFE_Codigo = TLOC_REFE_Codigo)");
        sb.append("      JOIN CREF_Classe_Referencia ON (CREF_Codigo = REFE_CREF_Codigo)");
        sb.append("      JOIN TLOC_Tipo_Local ON (TLOC_Tipo_Local.TLOC_Codigo = TLOC_Transportador_Local.TLOC_TLOC_Codigo)");
        sb.append("  WHERE (CREF_Classe_Referencia.cref_pess_oras_codigo is null or CREF_Classe_Referencia.cref_pess_oras_codigo = TRAN_Transportador.tran_pess_oras_codigo)");
        sb.append("      AND TRAN_Transportador.tran_pess_oras_codigo = ").append(codLocal);

        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaCarretasDisponiveis")
    public String solicitaListaCarretasDisponiveis(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT VEIC_Veiculo.VEIC_COR AS TVEI_DESCRICAO,");
        sb.append("     VEIC_VEICULO.VEIC_PLACA");
        sb.append("     FROM VEIC_Veiculo");
        sb.append("     JOIN VTRA_Veiculo_Transportador ON (VTRA_VEIC_ORAS_Codigo = VEIC_ORAS_Codigo)");
        sb.append("     JOIN TRAN_Transportador ON (TRAN_PESS_ORAS_Codigo = VTRA_TRAN_PESS_ORAS_Codigo AND TRAN_PESS_ORAS_Codigo = ").append(codEmpresa).append(")");
        sb.append("    JOIN vcar_veiculo_carreta ON (VEIC_ORAS_Codigo = VCAR_VEIC_ORAS_Codigo)");
        sb.append(" ORDER BY VEIC_Veiculo.VEIC_Placa");
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaPGR")
    public String solicitaListaPGR(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "offset") String offset) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT PGPG_CODIGO,");
        sb.append(" PGPG_DESCRICAO,");
        sb.append(" PGPG_DATA_CADASTRO");
        sb.append(" FROM PGPG_PG");
        sb.append(" WHERE PGPG_ESTATUS = 'A'");
        sb.append(" ORDER BY PGPG_DESCRICAO");
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        System.out.println(sb.toString());
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
    public String solicitaListaViagemPai(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "offset") String offset) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ");
        sb.append("     VIAG_CODIGO,");
        sb.append("     VIAG_PREVISAO_INICIO,");
        sb.append("     VIAG_PREVISAO_FIM");
        sb.append(" FROM VIAG_VIAGEM");
        sb.append(" JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = VIAG_TRAN_PESS_ORAS_CODIGO AND VIAG_TRAN_PESS_ORAS_CODIGO = ").append(codEmpresa).append(") ");
        sb.append(" ORDER BY VIAG_CODIGO ");
        sb.append(" LIMIT 20 OFFSET ").append(offset);
        System.out.print(sb.toString());
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
        sb.append("   ORTE_Objeto_Rastreado_Termina.ORTE_Sequencia");
        sb.append(" FROM ORAS_Objeto_Rastreado");
        sb.append(" JOIN VEIC_Veiculo ON (VEIC_ORAS_Codigo = ORAS_Codigo AND TRIM(REPLACE(REPLACE(REPLACE(REPLACE(VEIC_Placa,'.',''),'/',''),'\\\\',''),'-','')) = TRIM(REPLACE(REPLACE(REPLACE(REPLACE('").append(placa).append("','.',''),'/',''),'\\\\',''),'-','')))");
        sb.append(" JOIN ORTE_Objeto_Rastreado_Termina ON (ORTE_ORAS_Codigo = VEIC_ORAS_CODIGO)");
        sb.append(" JOIN TERM_Terminal ON (TERM_Codigo = ORTE_TERM_Codigo)");
        System.out.println(sb.toString());
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
        System.out.println(sb.toString());
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
        System.out.println(sb.toString());
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
        System.out.println(sb.toString());
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
        System.out.print(sb.toString());
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
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaPGR")
    public String solicitaTotalListaPGR(@WebParam(name = "idSessao") String idSessao) throws Exception {
        //TODO write your implementation code here:
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) AS TOTAL FROM ( ");
        sb.append(" SELECT PGPG_CODIGO,");
        sb.append(" PGPG_DESCRICAO,");
        sb.append(" PGPG_DATA_CADASTRO");
        sb.append(" FROM PGPG_PG");
        sb.append(" WHERE PGPG_ESTATUS = 'A'");
        sb.append(" ) AS XXX ");
        System.out.println(sb.toString());
        return Conexao.getInstance().queryToXML(sb.toString(), idSessao);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaTotalListaRotas")
    public String solicitaTotalListaRotas(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "codEmpresa") String codEmpresa) throws Exception {
        //TODO write your implementation code here:
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
        sb.append(" WHERE ROTA_PESS_ORAS_CODIGO_DONO = ").append(codEmpresa.toString());
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
        System.out.println(sb.toString());
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
        System.out.print(sb.toString());
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
        System.out.println(sb.toString());
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
        System.out.print(sb.toString());
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
    public String gravaConfigGrid(@WebParam(name = "idSessao") String idSessao, @WebParam(name = "usuario") String usuario, String tela, String grid) throws Exception {
        StringBuilder sb = new StringBuilder();

        String sreg_sessao = "TRAFEGUS_WEB_GRID_" + tela.toUpperCase() + "_" + grid.toUpperCase();

        return "";
    }

}
