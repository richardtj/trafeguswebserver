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
@Table(name = "view_detalhe_envio_mensagem")
@NamedQueries({
    @NamedQuery(name = "ViewDetalheEnvioMensagem.findAll", query = "SELECT v FROM ViewDetalheEnvioMensagem v")})
public class ViewDetalheEnvioMensagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "envi_codigo")
    private Integer enviCodigo;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "envi_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enviDataCadastro;
    @Column(name = "envi_estatus", length = 10)
    private String enviEstatus;
    @Column(name = "envi_descricao_estatus", length = 250)
    private String enviDescricaoEstatus;
    @Column(name = "texto", length = 2147483647)
    private String texto;
    @Column(name = "tipoenvio", length = 2147483647)
    private String tipoenvio;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "oras_codigo")
    private Integer orasCodigo;

    public ViewDetalheEnvioMensagem() {
    }

    public Integer getEnviCodigo() {
        return enviCodigo;
    }

    public void setEnviCodigo(Integer enviCodigo) {
        this.enviCodigo = enviCodigo;
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

    public Date getEnviDataCadastro() {
        return enviDataCadastro;
    }

    public void setEnviDataCadastro(Date enviDataCadastro) {
        this.enviDataCadastro = enviDataCadastro;
    }

    public String getEnviEstatus() {
        return enviEstatus;
    }

    public void setEnviEstatus(String enviEstatus) {
        this.enviEstatus = enviEstatus;
    }

    public String getEnviDescricaoEstatus() {
        return enviDescricaoEstatus;
    }

    public void setEnviDescricaoEstatus(String enviDescricaoEstatus) {
        this.enviDescricaoEstatus = enviDescricaoEstatus;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipoenvio() {
        return tipoenvio;
    }

    public void setTipoenvio(String tipoenvio) {
        this.tipoenvio = tipoenvio;
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

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

}
