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
@Table(name = "view_evento_acao_linha", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewEventoAcaoLinha.findAll", query = "SELECT v FROM ViewEventoAcaoLinha v"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByErasCodigo", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByIdentificador", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByTermNumeroTerminal", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByEsisCodigo", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByEsisTermCodigo", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.esisTermCodigo = :esisTermCodigo"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByEsisDescricao", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByPgaiCodigo", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.pgaiCodigo = :pgaiCodigo"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByOrasCodigo", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.orasCodigo = :orasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByAlinCorFundo", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.alinCorFundo = :alinCorFundo"),
    @NamedQuery(name = "ViewEventoAcaoLinha.findByEsisDataInicio", query = "SELECT v FROM ViewEventoAcaoLinha v WHERE v.esisDataInicio = :esisDataInicio")})
public class ViewEventoAcaoLinha implements Serializable {
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
    @Column(name = "alin_cor_fundo")
    private Integer alinCorFundo;
    @Column(name = "esis_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataInicio;

    public ViewEventoAcaoLinha() {
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

    public Integer getAlinCorFundo() {
        return alinCorFundo;
    }

    public void setAlinCorFundo(Integer alinCorFundo) {
        this.alinCorFundo = alinCorFundo;
    }

    public Date getEsisDataInicio() {
        return esisDataInicio;
    }

    public void setEsisDataInicio(Date esisDataInicio) {
        this.esisDataInicio = esisDataInicio;
    }

}
