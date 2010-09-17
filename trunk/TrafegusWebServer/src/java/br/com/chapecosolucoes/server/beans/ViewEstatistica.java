/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
@Table(name = "view_estatistica")
@NamedQueries({
    @NamedQuery(name = "ViewEstatistica.findAll", query = "SELECT v FROM ViewEstatistica v")})
public class ViewEstatistica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "processo")
    private Integer processo;
    @Lob
    @Column(name = "estacao")
    private Object estacao;
    @Column(name = "banco", length = 2147483647)
    private String banco;
    @Column(name = "tabela", length = 2147483647)
    private String tabela;
    @Column(name = "modo", length = 2147483647)
    private String modo;
    @Column(name = "status", length = 2147483647)
    private String status;
    @Column(name = "current_query", length = 2147483647)
    private String currentQuery;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Lob
    @Column(name = "duracao")
    private Object duracao;

    public ViewEstatistica() {
    }

    public Integer getProcesso() {
        return processo;
    }

    public void setProcesso(Integer processo) {
        this.processo = processo;
    }

    public Object getEstacao() {
        return estacao;
    }

    public void setEstacao(Object estacao) {
        this.estacao = estacao;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentQuery() {
        return currentQuery;
    }

    public void setCurrentQuery(String currentQuery) {
        this.currentQuery = currentQuery;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Object getDuracao() {
        return duracao;
    }

    public void setDuracao(Object duracao) {
        this.duracao = duracao;
    }

}
