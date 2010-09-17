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
@Table(name = "view_terminal_nao_acossiado")
@NamedQueries({
    @NamedQuery(name = "ViewTerminalNaoAcossiado.findAll", query = "SELECT v FROM ViewTerminalNaoAcossiado v")})
public class ViewTerminalNaoAcossiado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "rece_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receDataComputadorBordo;
    @Column(name = "upos_descricao_sistema", length = 200)
    private String uposDescricaoSistema;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "vtec_descricao", length = 50)
    private String vtecDescricao;

    public ViewTerminalNaoAcossiado() {
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

    public Date getReceDataComputadorBordo() {
        return receDataComputadorBordo;
    }

    public void setReceDataComputadorBordo(Date receDataComputadorBordo) {
        this.receDataComputadorBordo = receDataComputadorBordo;
    }

    public String getUposDescricaoSistema() {
        return uposDescricaoSistema;
    }

    public void setUposDescricaoSistema(String uposDescricaoSistema) {
        this.uposDescricaoSistema = uposDescricaoSistema;
    }

    public String getTecnDescricao() {
        return tecnDescricao;
    }

    public void setTecnDescricao(String tecnDescricao) {
        this.tecnDescricao = tecnDescricao;
    }

    public String getVtecDescricao() {
        return vtecDescricao;
    }

    public void setVtecDescricao(String vtecDescricao) {
        this.vtecDescricao = vtecDescricao;
    }

}
