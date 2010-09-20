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
@Table(name = "view_evento_acao_beep", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewEventoAcaoBeep.findAll", query = "SELECT v FROM ViewEventoAcaoBeep v"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByErasCodigo", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByIdentificador", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByTermNumeroTerminal", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByEsisCodigo", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByEsisTermCodigo", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.esisTermCodigo = :esisTermCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByEsisDescricao", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByPgaiCodigo", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.pgaiCodigo = :pgaiCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByOrasCodigo", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.orasCodigo = :orasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByAbbeFrequencia", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.abbeFrequencia = :abbeFrequencia"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByAbeeTempoBeep", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.abeeTempoBeep = :abeeTempoBeep"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByAbeeTempoEsperando", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.abeeTempoEsperando = :abeeTempoEsperando"),
    @NamedQuery(name = "ViewEventoAcaoBeep.findByEsisDataInicio", query = "SELECT v FROM ViewEventoAcaoBeep v WHERE v.esisDataInicio = :esisDataInicio")})
public class ViewEventoAcaoBeep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "esis_codigo")
    private Integer esisCodigo;
    @Column(name = "esis_term_codigo")
    private Integer esisTermCodigo;
    @Column(name = "esis_descricao", length = 100)
    private String esisDescricao;
    @Column(name = "pgai_codigo")
    private Integer pgaiCodigo;
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "abbe_frequencia")
    private Integer abbeFrequencia;
    @Column(name = "abee_tempo_beep")
    private Integer abeeTempoBeep;
    @Column(name = "abee_tempo_esperando")
    private Integer abeeTempoEsperando;
    @Column(name = "esis_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataInicio;

    public ViewEventoAcaoBeep() {
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

    public String getTermNumeroTerminal() {
        return termNumeroTerminal;
    }

    public void setTermNumeroTerminal(String termNumeroTerminal) {
        this.termNumeroTerminal = termNumeroTerminal;
    }

    public Integer getEsisCodigo() {
        return esisCodigo;
    }

    public void setEsisCodigo(Integer esisCodigo) {
        this.esisCodigo = esisCodigo;
    }

    public Integer getEsisTermCodigo() {
        return esisTermCodigo;
    }

    public void setEsisTermCodigo(Integer esisTermCodigo) {
        this.esisTermCodigo = esisTermCodigo;
    }

    public String getEsisDescricao() {
        return esisDescricao;
    }

    public void setEsisDescricao(String esisDescricao) {
        this.esisDescricao = esisDescricao;
    }

    public Integer getPgaiCodigo() {
        return pgaiCodigo;
    }

    public void setPgaiCodigo(Integer pgaiCodigo) {
        this.pgaiCodigo = pgaiCodigo;
    }

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public Integer getAbbeFrequencia() {
        return abbeFrequencia;
    }

    public void setAbbeFrequencia(Integer abbeFrequencia) {
        this.abbeFrequencia = abbeFrequencia;
    }

    public Integer getAbeeTempoBeep() {
        return abeeTempoBeep;
    }

    public void setAbeeTempoBeep(Integer abeeTempoBeep) {
        this.abeeTempoBeep = abeeTempoBeep;
    }

    public Integer getAbeeTempoEsperando() {
        return abeeTempoEsperando;
    }

    public void setAbeeTempoEsperando(Integer abeeTempoEsperando) {
        this.abeeTempoEsperando = abeeTempoEsperando;
    }

    public Date getEsisDataInicio() {
        return esisDataInicio;
    }

    public void setEsisDataInicio(Date esisDataInicio) {
        this.esisDataInicio = esisDataInicio;
    }

}
