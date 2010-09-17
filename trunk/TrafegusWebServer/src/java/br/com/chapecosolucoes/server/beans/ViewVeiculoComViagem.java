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
@Table(name = "view_veiculo_com_viagem")
@NamedQueries({
    @NamedQuery(name = "ViewVeiculoComViagem.findAll", query = "SELECT v FROM ViewVeiculoComViagem v")})
public class ViewVeiculoComViagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "viag_codigo")
    private Integer viagCodigo;
    @Column(name = "viag_tran_pess_oras_codigo")
    private Integer viagTranPessOrasCodigo;
    @Column(name = "viag_emba_pjur_pess_oras_codigo")
    private Integer viagEmbaPjurPessOrasCodigo;
    @Column(name = "vter_tempo_satelital")
    private Integer vterTempoSatelital;
    @Column(name = "vter_tempo_gprs")
    private Integer vterTempoGprs;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "vtec_tipo_comunicacao", length = 10)
    private String vtecTipoComunicacao;
    @Column(name = "veic_oras_codigo")
    private Integer veicOrasCodigo;
    @Column(name = "transfrota", length = 10)
    private String transfrota;
    @Column(name = "ignicao", length = 50)
    private String ignicao;
    @Column(name = "origem", length = 200)
    private String origem;
    @Column(name = "destino", length = 200)
    private String destino;
    @Column(name = "upos_descricao_sistema", length = 200)
    private String uposDescricaoSistema;
    @Column(name = "upos_data_comp_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uposDataCompBordo;
    @Column(name = "tope_descricao", length = 50)
    private String topeDescricao;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "transportador", length = 50)
    private String transportador;
    @Column(name = "embarcador", length = 50)
    private String embarcador;
    @Column(name = "observacao", length = 5000)
    private String observacao;

    public ViewVeiculoComViagem() {
    }

    public Integer getViagCodigo() {
        return viagCodigo;
    }

    public void setViagCodigo(Integer viagCodigo) {
        this.viagCodigo = viagCodigo;
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

    public Integer getVeicOrasCodigo() {
        return veicOrasCodigo;
    }

    public void setVeicOrasCodigo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
    }

    public String getTransfrota() {
        return transfrota;
    }

    public void setTransfrota(String transfrota) {
        this.transfrota = transfrota;
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

    public String getUposDescricaoSistema() {
        return uposDescricaoSistema;
    }

    public void setUposDescricaoSistema(String uposDescricaoSistema) {
        this.uposDescricaoSistema = uposDescricaoSistema;
    }

    public Date getUposDataCompBordo() {
        return uposDataCompBordo;
    }

    public void setUposDataCompBordo(Date uposDataCompBordo) {
        this.uposDataCompBordo = uposDataCompBordo;
    }

    public String getTopeDescricao() {
        return topeDescricao;
    }

    public void setTopeDescricao(String topeDescricao) {
        this.topeDescricao = topeDescricao;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
