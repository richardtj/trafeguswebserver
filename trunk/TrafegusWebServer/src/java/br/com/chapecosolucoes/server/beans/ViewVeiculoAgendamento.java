/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "view_veiculo_agendamento")
@NamedQueries({
    @NamedQuery(name = "ViewVeiculoAgendamento.findAll", query = "SELECT v FROM ViewVeiculoAgendamento v")})
public class ViewVeiculoAgendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "viag_codigo")
    private Integer viagCodigo;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "vcav_veic_oras_codigo")
    private Integer vcavVeicOrasCodigo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "vtec_tipo_comunicacao", length = 10)
    private String vtecTipoComunicacao;
    @Column(name = "rece_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receDataComputadorBordo;
    @Column(name = "upos_descricao_sistema", length = 200)
    private String uposDescricaoSistema;
    @Column(name = "transportador", length = 50)
    private String transportador;
    @Column(name = "embarcador", length = 50)
    private String embarcador;
    @Column(name = "transfrota", length = 10)
    private String transfrota;
    @Column(name = "obsobjeto", length = 5000)
    private String obsobjeto;
    @Column(name = "ignicao", length = 50)
    private String ignicao;
    @Column(name = "origem", length = 200)
    private String origem;
    @Column(name = "destino", length = 200)
    private String destino;
    @Column(name = "vter_tempo_satelital")
    private Integer vterTempoSatelital;
    @Column(name = "vter_tempo_gprs")
    private Integer vterTempoGprs;
    @Column(name = "viag_tran_pess_oras_codigo")
    private Integer viagTranPessOrasCodigo;
    @Column(name = "viag_emba_pjur_pess_oras_codigo")
    private Integer viagEmbaPjurPessOrasCodigo;
    @Column(name = "veic_oras_codigo")
    private Integer veicOrasCodigo;
    @Column(name = "viag_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagDataCadastro;
    @Column(name = "tope_descricao", length = 50)
    private String topeDescricao;
    @Column(name = "viag_previsao_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagPrevisaoInicio;
    @Column(name = "viag_previsao_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagPrevisaoFim;

    public ViewVeiculoAgendamento() {
    }

    public Integer getViagCodigo() {
        return viagCodigo;
    }

    public void setViagCodigo(Integer viagCodigo) {
        this.viagCodigo = viagCodigo;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public Integer getVcavVeicOrasCodigo() {
        return vcavVeicOrasCodigo;
    }

    public void setVcavVeicOrasCodigo(Integer vcavVeicOrasCodigo) {
        this.vcavVeicOrasCodigo = vcavVeicOrasCodigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getTermCodigo() {
        return termCodigo;
    }

    public void setTermCodigo(Integer termCodigo) {
        this.termCodigo = termCodigo;
    }

    public String getTermNumeroTerminal() {
        return termNumeroTerminal;
    }

    public void setTermNumeroTerminal(String termNumeroTerminal) {
        this.termNumeroTerminal = termNumeroTerminal;
    }

    public String getTecnDescricao() {
        return tecnDescricao;
    }

    public void setTecnDescricao(String tecnDescricao) {
        this.tecnDescricao = tecnDescricao;
    }

    public String getVtecTipoComunicacao() {
        return vtecTipoComunicacao;
    }

    public void setVtecTipoComunicacao(String vtecTipoComunicacao) {
        this.vtecTipoComunicacao = vtecTipoComunicacao;
    }

    public Date getReceDataComputadorBordo() {
        return receDataComputadorBordo;
    }

    public void setReceDataComputadorBordo(Date receDataComputadorBordo) {
        this.receDataComputadorBordo = receDataComputadorBordo;
    }

    public String getUposDescricaoSistema() {
        return uposDescricaoSistema;
    }

    public void setUposDescricaoSistema(String uposDescricaoSistema) {
        this.uposDescricaoSistema = uposDescricaoSistema;
    }

    public String getTransportador() {
        return transportador;
    }

    public void setTransportador(String transportador) {
        this.transportador = transportador;
    }

    public String getEmbarcador() {
        return embarcador;
    }

    public void setEmbarcador(String embarcador) {
        this.embarcador = embarcador;
    }

    public String getTransfrota() {
        return transfrota;
    }

    public void setTransfrota(String transfrota) {
        this.transfrota = transfrota;
    }

    public String getObsobjeto() {
        return obsobjeto;
    }

    public void setObsobjeto(String obsobjeto) {
        this.obsobjeto = obsobjeto;
    }

    public String getIgnicao() {
        return ignicao;
    }

    public void setIgnicao(String ignicao) {
        this.ignicao = ignicao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getVterTempoSatelital() {
        return vterTempoSatelital;
    }

    public void setVterTempoSatelital(Integer vterTempoSatelital) {
        this.vterTempoSatelital = vterTempoSatelital;
    }

    public Integer getVterTempoGprs() {
        return vterTempoGprs;
    }

    public void setVterTempoGprs(Integer vterTempoGprs) {
        this.vterTempoGprs = vterTempoGprs;
    }

    public Integer getViagTranPessOrasCodigo() {
        return viagTranPessOrasCodigo;
    }

    public void setViagTranPessOrasCodigo(Integer viagTranPessOrasCodigo) {
        this.viagTranPessOrasCodigo = viagTranPessOrasCodigo;
    }

    public Integer getViagEmbaPjurPessOrasCodigo() {
        return viagEmbaPjurPessOrasCodigo;
    }

    public void setViagEmbaPjurPessOrasCodigo(Integer viagEmbaPjurPessOrasCodigo) {
        this.viagEmbaPjurPessOrasCodigo = viagEmbaPjurPessOrasCodigo;
    }

    public Integer getVeicOrasCodigo() {
        return veicOrasCodigo;
    }

    public void setVeicOrasCodigo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
    }

    public Date getViagDataCadastro() {
        return viagDataCadastro;
    }

    public void setViagDataCadastro(Date viagDataCadastro) {
        this.viagDataCadastro = viagDataCadastro;
    }

    public String getTopeDescricao() {
        return topeDescricao;
    }

    public void setTopeDescricao(String topeDescricao) {
        this.topeDescricao = topeDescricao;
    }

    public Date getViagPrevisaoInicio() {
        return viagPrevisaoInicio;
    }

    public void setViagPrevisaoInicio(Date viagPrevisaoInicio) {
        this.viagPrevisaoInicio = viagPrevisaoInicio;
    }

    public Date getViagPrevisaoFim() {
        return viagPrevisaoFim;
    }

    public void setViagPrevisaoFim(Date viagPrevisaoFim) {
        this.viagPrevisaoFim = viagPrevisaoFim;
    }

}
