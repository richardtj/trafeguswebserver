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
@Table(name = "view_detalhe_rece_mensagem_v2", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findAll", query = "SELECT v FROM ViewDetalheReceMensagemV2 v"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByReceCodigo", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.receCodigo = :receCodigo"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByErasCodigo", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByTermCodigo", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.termCodigo = :termCodigo"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByIdentificador", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByTermNumeroTerminal", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByReceDataComputadorBordo", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.receDataComputadorBordo = :receDataComputadorBordo"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByUsuaPfisPessOrasCodigo", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.usuaPfisPessOrasCodigo = :usuaPfisPessOrasCodigo"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByRposDescricaoSistema", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.rposDescricaoSistema = :rposDescricaoSistema"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByTransportador", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.transportador = :transportador"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByRmacNumero", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.rmacNumero = :rmacNumero"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByTecnDescricao", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.tecnDescricao = :tecnDescricao"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByUsuaDataLeitura", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.usuaDataLeitura = :usuaDataLeitura"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByUsuario", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.usuario = :usuario"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByTexto", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.texto = :texto"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByTipo", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "ViewDetalheReceMensagemV2.findByRmacMascara", query = "SELECT v FROM ViewDetalheReceMensagemV2 v WHERE v.rmacMascara = :rmacMascara")})
public class ViewDetalheReceMensagemV2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "rece_codigo")
    private Integer receCodigo;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "identificador", length = 10)
    private String identificador;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "rece_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receDataComputadorBordo;
    @Column(name = "usua_pfis_pess_oras_codigo")
    private Integer usuaPfisPessOrasCodigo;
    @Column(name = "rpos_descricao_sistema", length = 200)
    private String rposDescricaoSistema;
    @Column(name = "transportador", length = 50)
    private String transportador;
    @Column(name = "rmac_numero", length = 2147483647)
    private String rmacNumero;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "usua_data_leitura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuaDataLeitura;
    @Column(name = "usuario", length = 50)
    private String usuario;
    @Column(name = "texto", length = 2147483647)
    private String texto;
    @Column(name = "tipo", length = 2147483647)
    private String tipo;
    @Column(name = "rmac_mascara", length = 2147483647)
    private String rmacMascara;

    public ViewDetalheReceMensagemV2() {
    }

    public Integer getReceCodigo() {
        return receCodigo;
    }

    public void setReceCodigo(Integer receCodigo) {
        this.receCodigo = receCodigo;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public Integer getTermCodigo() {
        return termCodigo;
    }

    public void setTermCodigo(Integer termCodigo) {
        this.termCodigo = termCodigo;
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

    public Date getReceDataComputadorBordo() {
        return receDataComputadorBordo;
    }

    public void setReceDataComputadorBordo(Date receDataComputadorBordo) {
        this.receDataComputadorBordo = receDataComputadorBordo;
    }

    public Integer getUsuaPfisPessOrasCodigo() {
        return usuaPfisPessOrasCodigo;
    }

    public void setUsuaPfisPessOrasCodigo(Integer usuaPfisPessOrasCodigo) {
        this.usuaPfisPessOrasCodigo = usuaPfisPessOrasCodigo;
    }

    public String getRposDescricaoSistema() {
        return rposDescricaoSistema;
    }

    public void setRposDescricaoSistema(String rposDescricaoSistema) {
        this.rposDescricaoSistema = rposDescricaoSistema;
    }

    public String getTransportador() {
        return transportador;
    }

    public void setTransportador(String transportador) {
        this.transportador = transportador;
    }

    public String getRmacNumero() {
        return rmacNumero;
    }

    public void setRmacNumero(String rmacNumero) {
        this.rmacNumero = rmacNumero;
    }

    public String getTecnDescricao() {
        return tecnDescricao;
    }

    public void setTecnDescricao(String tecnDescricao) {
        this.tecnDescricao = tecnDescricao;
    }

    public Date getUsuaDataLeitura() {
        return usuaDataLeitura;
    }

    public void setUsuaDataLeitura(Date usuaDataLeitura) {
        this.usuaDataLeitura = usuaDataLeitura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRmacMascara() {
        return rmacMascara;
    }

    public void setRmacMascara(String rmacMascara) {
        this.rmacMascara = rmacMascara;
    }

}
