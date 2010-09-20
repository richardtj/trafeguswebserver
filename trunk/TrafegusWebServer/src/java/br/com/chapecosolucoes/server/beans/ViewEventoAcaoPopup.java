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
@Table(name = "view_evento_acao_popup", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewEventoAcaoPopup.findAll", query = "SELECT v FROM ViewEventoAcaoPopup v"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByErasCodigo", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByIdentificador", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByTermNumeroTerminal", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByEsisCodigo", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByEsisTermCodigo", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.esisTermCodigo = :esisTermCodigo"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByEsisDescricao", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByPgaiCodigo", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.pgaiCodigo = :pgaiCodigo"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByOrasCodigo", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.orasCodigo = :orasCodigo"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByApopAltura", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.apopAltura = :apopAltura"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByApopLargura", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.apopLargura = :apopLargura"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByApopTitulo", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.apopTitulo = :apopTitulo"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByApopCor", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.apopCor = :apopCor"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByEsisDataCadastro", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.esisDataCadastro = :esisDataCadastro"),
    @NamedQuery(name = "ViewEventoAcaoPopup.findByEsisDataInicio", query = "SELECT v FROM ViewEventoAcaoPopup v WHERE v.esisDataInicio = :esisDataInicio")})
public class ViewEventoAcaoPopup implements Serializable {
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
    @Column(name = "apop_altura")
    private Integer apopAltura;
    @Column(name = "apop_largura")
    private Integer apopLargura;
    @Column(name = "apop_titulo", length = 250)
    private String apopTitulo;
    @Column(name = "apop_cor")
    private Integer apopCor;
    @Column(name = "esis_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataCadastro;
    @Column(name = "esis_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataInicio;

    public ViewEventoAcaoPopup() {
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

    public Integer getApopAltura() {
        return apopAltura;
    }

    public void setApopAltura(Integer apopAltura) {
        this.apopAltura = apopAltura;
    }

    public Integer getApopLargura() {
        return apopLargura;
    }

    public void setApopLargura(Integer apopLargura) {
        this.apopLargura = apopLargura;
    }

    public String getApopTitulo() {
        return apopTitulo;
    }

    public void setApopTitulo(String apopTitulo) {
        this.apopTitulo = apopTitulo;
    }

    public Integer getApopCor() {
        return apopCor;
    }

    public void setApopCor(Integer apopCor) {
        this.apopCor = apopCor;
    }

    public Date getEsisDataCadastro() {
        return esisDataCadastro;
    }

    public void setEsisDataCadastro(Date esisDataCadastro) {
        this.esisDataCadastro = esisDataCadastro;
    }

    public Date getEsisDataInicio() {
        return esisDataInicio;
    }

    public void setEsisDataInicio(Date esisDataInicio) {
        this.esisDataInicio = esisDataInicio;
    }

}
