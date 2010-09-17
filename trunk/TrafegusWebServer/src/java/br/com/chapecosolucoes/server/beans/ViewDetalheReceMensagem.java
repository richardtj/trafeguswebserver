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
@Table(name = "view_detalhe_rece_mensagem")
@NamedQueries({
    @NamedQuery(name = "ViewDetalheReceMensagem.findAll", query = "SELECT v FROM ViewDetalheReceMensagem v")})
public class ViewDetalheReceMensagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "rece_codigo")
    private Integer receCodigo;
    @Column(name = "data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComputadorBordo;
    @Column(name = "rece_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receDataCadastro;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "rmac_numero", length = 2147483647)
    private String rmacNumero;
    @Column(name = "texto", length = 2147483647)
    private String texto;
    @Column(name = "tipo_rec", length = 2147483647)
    private String tipoRec;
    @Column(name = "estatus_ge", length = 100)
    private String estatusGe;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;

    public ViewDetalheReceMensagem() {
    }

    public Integer getReceCodigo() {
        return receCodigo;
    }

    public void setReceCodigo(Integer receCodigo) {
        this.receCodigo = receCodigo;
    }

    public Date getDataComputadorBordo() {
        return dataComputadorBordo;
    }

    public void setDataComputadorBordo(Date dataComputadorBordo) {
        this.dataComputadorBordo = dataComputadorBordo;
    }

    public Date getReceDataCadastro() {
        return receDataCadastro;
    }

    public void setReceDataCadastro(Date receDataCadastro) {
        this.receDataCadastro = receDataCadastro;
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

    public String getRmacNumero() {
        return rmacNumero;
    }

    public void setRmacNumero(String rmacNumero) {
        this.rmacNumero = rmacNumero;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipoRec() {
        return tipoRec;
    }

    public void setTipoRec(String tipoRec) {
        this.tipoRec = tipoRec;
    }

    public String getEstatusGe() {
        return estatusGe;
    }

    public void setEstatusGe(String estatusGe) {
        this.estatusGe = estatusGe;
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

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

}
