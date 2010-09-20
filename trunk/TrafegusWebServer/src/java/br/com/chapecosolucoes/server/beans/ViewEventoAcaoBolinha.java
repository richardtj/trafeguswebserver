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
@Table(name = "view_evento_acao_bolinha", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewEventoAcaoBolinha.findAll", query = "SELECT v FROM ViewEventoAcaoBolinha v"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByErasCodigo", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByIdentificador", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByTermNumeroTerminal", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByEsisCodigo", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByEsisTermCodigo", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.esisTermCodigo = :esisTermCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByEsisDescricao", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByPgaiCodigo", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.pgaiCodigo = :pgaiCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByOrasCodigo", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.orasCodigo = :orasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByAbolCor", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.abolCor = :abolCor"),
    @NamedQuery(name = "ViewEventoAcaoBolinha.findByEsisDataInicio", query = "SELECT v FROM ViewEventoAcaoBolinha v WHERE v.esisDataInicio = :esisDataInicio")})
public class ViewEventoAcaoBolinha implements Serializable {
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
    @Column(name = "abol_cor")
    private Integer abolCor;
    @Column(name = "esis_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataInicio;

    public ViewEventoAcaoBolinha() {
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

    public Integer getAbolCor() {
        return abolCor;
    }

    public void setAbolCor(Integer abolCor) {
        this.abolCor = abolCor;
    }

    public Date getEsisDataInicio() {
        return esisDataInicio;
    }

    public void setEsisDataInicio(Date esisDataInicio) {
        this.esisDataInicio = esisDataInicio;
    }

}
