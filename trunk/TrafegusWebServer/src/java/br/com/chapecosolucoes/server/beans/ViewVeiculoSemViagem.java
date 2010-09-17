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
@Table(name = "view_veiculo_sem_viagem")
@NamedQueries({
    @NamedQuery(name = "ViewVeiculoSemViagem.findAll", query = "SELECT v FROM ViewVeiculoSemViagem v")})
public class ViewVeiculoSemViagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "veic_oras_codigo")
    private Integer veicOrasCodigo;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "vtec_tipo_comunicacao", length = 10)
    private String vtecTipoComunicacao;
    @Column(name = "upos_data_comp_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uposDataCompBordo;
    @Column(name = "upos_descricao_sistema", length = 200)
    private String uposDescricaoSistema;
    @Column(name = "transportador", length = 50)
    private String transportador;
    @Column(name = "codtransportador")
    private Integer codtransportador;
    @Column(name = "ignicao", length = 50)
    private String ignicao;
    @Column(name = "vtec_tempo_satelital_padrao")
    private Integer vtecTempoSatelitalPadrao;
    @Column(name = "vtec_tempo_gprs_padrao")
    private Integer vtecTempoGprsPadrao;
    @Column(name = "tipo_operacao", length = 2147483647)
    private String tipoOperacao;
    @Column(name = "observacao", length = 5000)
    private String observacao;

    public ViewVeiculoSemViagem() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public Integer getVeicOrasCodigo() {
        return veicOrasCodigo;
    }

    public void setVeicOrasCodigo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
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

    public Date getUposDataCompBordo() {
        return uposDataCompBordo;
    }

    public void setUposDataCompBordo(Date uposDataCompBordo) {
        this.uposDataCompBordo = uposDataCompBordo;
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

    public Integer getCodtransportador() {
        return codtransportador;
    }

    public void setCodtransportador(Integer codtransportador) {
        this.codtransportador = codtransportador;
    }

    public String getIgnicao() {
        return ignicao;
    }

    public void setIgnicao(String ignicao) {
        this.ignicao = ignicao;
    }

    public Integer getVtecTempoSatelitalPadrao() {
        return vtecTempoSatelitalPadrao;
    }

    public void setVtecTempoSatelitalPadrao(Integer vtecTempoSatelitalPadrao) {
        this.vtecTempoSatelitalPadrao = vtecTempoSatelitalPadrao;
    }

    public Integer getVtecTempoGprsPadrao() {
        return vtecTempoGprsPadrao;
    }

    public void setVtecTempoGprsPadrao(Integer vtecTempoGprsPadrao) {
        this.vtecTempoGprsPadrao = vtecTempoGprsPadrao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
