/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "view_estacao_objeto_rastreavel")
@NamedQueries({
    @NamedQuery(name = "ViewEstacaoObjetoRastreavel.findAll", query = "SELECT v FROM ViewEstacaoObjetoRastreavel v")})
public class ViewEstacaoObjetoRastreavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "oras_tipo", length = 2147483647)
    private String orasTipo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "tipo_operacao", length = 2147483647)
    private String tipoOperacao;

    public ViewEstacaoObjetoRastreavel() {
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public String getOrasTipo() {
        return orasTipo;
    }

    public void setOrasTipo(String orasTipo) {
        this.orasTipo = orasTipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

}
